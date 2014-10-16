package com.github.rschmitt.crystalmethod;

import java.util.Map;
import java.util.function.Function;

@FunctionalInterface
public interface Multimethod5<D, R, T1, T2, T3, T4, T5> extends Function5<T1, T2, T3, T4, T5, R> {
    default Map<D, Function5<T1, T2, T3, T4, T5, R>> getDispatchMap() {
        return null;
    }

    default Function5<T1, T2, T3, T4, T5, D> getDispatchFn() {
        return null;
    }
}
