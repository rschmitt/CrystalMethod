package com.github.rschmitt.crystalmethod;

import java.util.Map;
import java.util.function.Function;

@FunctionalInterface
public interface Multimethod8<D, T1, T2, T3, T4, T5, T6, T7, T8, R> extends Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> {
    default Map<D, Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>> getDispatchMap() {
        return null;
    }

    default Function8<T1, T2, T3, T4, T5, T6, T7, T8, D> getDispatchFn() {
        return null;
    }
}
