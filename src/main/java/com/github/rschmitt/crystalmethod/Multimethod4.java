package com.github.rschmitt.crystalmethod;

import java.util.Map;
import java.util.function.Function;

@FunctionalInterface
public interface Multimethod4<D, R, T1, T2, T3, T4> extends Function4<T1, T2, T3, T4, R> {
    default Map<D, Function4<T1, T2, T3, T4, R>> getDispatchMap() {
        return null;
    }

    default Function4<T1, T2, T3, T4, D> getDispatchFn() {
        return null;
    }
}
