package com.github.rschmitt.crystalmethod;

import java.util.Map;
import java.util.function.Function;

@FunctionalInterface
public interface Multimethod6<D, R, T1, T2, T3, T4, T5, T6> extends Function6<T1, T2, T3, T4, T5, T6, R> {
    default Map<D, Function6<T1, T2, T3, T4, T5, T6, R>> getDispatchMap() {
        return null;
    }

    default Function6<T1, T2, T3, T4, T5, T6, D> getDispatchFn() {
        return null;
    }
}
