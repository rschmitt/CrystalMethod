import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.rangeClosed;

public class Generator {
    public static void main(String[] args) {
        rangeClosed(2, 9).forEachOrdered(arity -> {
            String functionalInterface = generateFunctionalInterface(arity);
            String filename = format("Function%s.java", arity);
            writeFile(filename, functionalInterface);
        });

        rangeClosed(1, 9).forEachOrdered(arity -> {
            String multiFnInterface = generateMultimethodInterface(arity);
            String filename = format("Multimethod%s.java", suffix(arity));
            writeFile(filename, multiFnInterface);
        });

        String builderMethods = rangeClosed(1, 9).mapToObj(Generator::generateBuilder).collect(joining("\n"));

        String builderClass = String.format(
                "import java.lang.reflect.Method;%n" +
                "import java.lang.reflect.Proxy;%n" +
                "import java.util.Map;%n" +
                "import java.util.function.Function;%n" +
                "%n" +
                "public class CrystalMethod {%n" +
                "%s%n" +
                "}%n",
                builderMethods
        );
        writeFile("CrystalMethod.java", builderClass);
    }

    private static void writeFile(String filename, String content) {
        Path path = Paths.get("src", "main", "java", "com", "github", "rschmitt", "crystalmethod", filename);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path.toFile());
            fileOutputStream.write(format("package com.github.rschmitt.crystalmethod;%n%n").getBytes());
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static String generateBuilder(int argCount) {
        String template =
                "    @SuppressWarnings(\"unchecked\")%n" +
                "    public static <T extends Multimethod%s<D, R, %s>, D, R, %s> T buildMultimethod(%n" +
                "            Function%s<%s, D> dispatchFn,%n" +
                "            Map<D, Function%s<%s, R>> methods,%n" +
                "            Class<T> type%n" +
                "    ) {%n" +
                "        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),%n" +
                "                new Class<?>[]{type},%n" +
                "                (Object proxy, Method method, Object[] args) -> {%n" +
                "                    D dispatchVal = dispatchFn.apply(%s);%n" +
                "                    return methods.get(dispatchVal).apply(%s);%n" +
                "                });%n" +
                "    }%n";
        String types = getTypeVariables(argCount);
        String args = getArgs(argCount);
        String count = suffix(argCount);
        return format(template, count, types, types, count, types, count, types, args, args);
    }

    private static String getArgs(int count) {
        return rangeClosed(1, count)
                .mapToObj(x -> format("(T%s) args[%s]", x, x - 1))
                .collect(joining(", "));
    }

    private static String generateMultimethodInterface(int count) {
        String template =
                "public interface Multimethod%s<D, R, %s> {%n" +
                "    R invoke(%s);%n" +
                "}%n";

        return format(template, suffix(count), getTypeVariables(count), getParameterList(count));
    }

    private static String generateFunctionalInterface(int count) {
        String template =
                "@FunctionalInterface%n" +
                "public interface Function%s<%s, R> {%n" +
                "    R apply(%s);%n" +
                "}%n";

        return format(template, suffix(count), getTypeVariables(count), getParameterList(count));
    }

    private static String suffix (int i) {
        return i == 1 ? "" : String.valueOf(i);
    }

    private static String getTypeVariables(int count) {
        return rangeClosed(1, count)
                .mapToObj(x -> format("T%d", x))
                .collect(joining(", "));
    }

    private static String getParameterList(int count) {
        return rangeClosed(1, count)
                .mapToObj(x -> format("T%d arg%d", x, x))
                .collect(joining(", "));
    }
}
