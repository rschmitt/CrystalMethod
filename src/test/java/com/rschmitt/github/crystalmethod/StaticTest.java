package com.rschmitt.github.crystalmethod;

import com.github.rschmitt.crystalmethod.CrystalMethod;
import com.github.rschmitt.crystalmethod.Multimethod;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

public class StaticTest {
    private static final ConcurrentMap<Class, Multimethod> globalMultimethods = new ConcurrentHashMap<>();

    public static <T extends Multimethod<D, R, T1>, D, R, T1> void defMulti(
            Function<T1, D> dispatchFn,
            Class<T> type
    ) {
        Multimethod multimethod = CrystalMethod.buildMultimethod(dispatchFn, new HashMap(), type);
        globalMultimethods.putIfAbsent(type, multimethod);
    }

    public static <T extends Multimethod<D, R, T1>, D, R, T1> void addMethod(
            R dispatchVal,
            Function<T1, R> method,
            Class<T> type
    ) {
        Multimethod multimethod = globalMultimethods.get(type);
        // lol race conditions
        // lol the old dict is in a closure somewhere. use a WeakMap of instances i guess?
    }

    public static <T extends Multimethod<D, R, T1>, D, R, T1> R invoke(T type, T1 arg) {
        return (R) globalMultimethods.get(type).invoke(arg);
    }
}
