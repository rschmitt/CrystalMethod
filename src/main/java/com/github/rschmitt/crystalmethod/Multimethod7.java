package com.github.rschmitt.crystalmethod;

import java.util.Map;
import java.util.function.Function;

@FunctionalInterface
public interface Multimethod7<D, T1, T2, T3, T4, T5, T6, T7, R> extends Function7<T1, T2, T3, T4, T5, T6, T7, R> {
    default Map<D, Function7<T1, T2, T3, T4, T5, T6, T7, R>> getDispatchMap() {
        return null;
    }

    default Function7<T1, T2, T3, T4, T5, T6, T7, D> getDispatchFn() {
        return null;
    }
}
