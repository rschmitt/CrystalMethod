package com.github.rschmitt.crystalmethod;

import java.util.Map;
import java.util.function.Function;

@FunctionalInterface
public interface Multimethod3<D, T1, T2, T3, R> extends Function3<T1, T2, T3, R> {
    default Map<D, Function3<T1, T2, T3, R>> getDispatchMap() {
        return null;
    }

    default Function3<T1, T2, T3, D> getDispatchFn() {
        return null;
    }
}
