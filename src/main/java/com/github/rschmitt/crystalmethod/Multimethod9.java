package com.github.rschmitt.crystalmethod;

import java.util.Map;
import java.util.function.Function;

@FunctionalInterface
public interface Multimethod9<D, R, T1, T2, T3, T4, T5, T6, T7, T8, T9> extends Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> {
    default Map<D, Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>> getDispatchMap() {
        return null;
    }

    default Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, D> getDispatchFn() {
        return null;
    }
}
