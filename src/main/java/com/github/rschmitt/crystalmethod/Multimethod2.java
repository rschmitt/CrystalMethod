package com.github.rschmitt.crystalmethod;

import java.util.Map;
import java.util.function.Function;

@FunctionalInterface
public interface Multimethod2<D, T1, T2, R> extends Function2<T1, T2, R> {
    default Map<D, Function2<T1, T2, R>> getDispatchMap() {
        return null;
    }

    default Function2<T1, T2, D> getDispatchFn() {
        return null;
    }
}
