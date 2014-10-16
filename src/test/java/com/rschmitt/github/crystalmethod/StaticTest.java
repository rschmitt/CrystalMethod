package com.rschmitt.github.crystalmethod;

import com.github.rschmitt.crystalmethod.CrystalMethod;
import com.github.rschmitt.crystalmethod.Multimethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

import static org.testng.Assert.assertEquals;

public class StaticTest {
    private static final ConcurrentMap<Class, Multimethod> globalMultimethods = new ConcurrentHashMap<>();

    public static <T extends Multimethod<D, T1, R>, D, T1, R> void defMulti(
            Function<T1, D> dispatchFn,
            Class<T> type
    ) {
        Multimethod multimethod = CrystalMethod.buildMultimethod(dispatchFn, new HashMap(), type);
        globalMultimethods.putIfAbsent(type, multimethod);
    }

    public static <T extends Multimethod<D, T1, R>, D, T1, R> void addMethod(
            D dispatchVal,
            Function<T1, R> method,
            Class<T> type
    ) {
        globalMultimethods.compute(type, (t, m) -> {
            Map<D, Function<T1, R>> oldMap = m.getDispatchMap();
            Map<D, Function<T1, R>> newMap = new HashMap<>();
            newMap.putAll(oldMap);
            newMap.put(dispatchVal, method);
            return CrystalMethod.buildMultimethod(m.getDispatchFn(), newMap, type);
        });
    }

    public static <T extends Multimethod<D, T1, R>, D, T1, R> R invoke(Class<T> type, T1 arg) {
        return (R) globalMultimethods.get(type).apply(arg);
    }

    @Test
    public void test() {
        defMulti(this::dispatch, GlobalMethod.class);

        addMethod("2", this::m2, GlobalMethod.class);
        addMethod("3", this::m1, GlobalMethod.class);

        assertEquals(invoke(GlobalMethod.class, 3.1).intValue(), 1);
        assertEquals(invoke(GlobalMethod.class, 3.2).intValue(), 1);
        assertEquals(invoke(GlobalMethod.class, 2.7).intValue(), 2);

        addMethod("4", this::m1, GlobalMethod.class);

        assertEquals(invoke(GlobalMethod.class, 4.9).intValue(), 1);
    }

    private String dispatch(double d) {
        return String.valueOf((int) d);
    }

    private int m1(double d) {
        return 1;
    }

    private int m2(double d) {
        return 2;
    }

    interface GlobalMethod extends Multimethod<String, Double, Integer> {}
}
