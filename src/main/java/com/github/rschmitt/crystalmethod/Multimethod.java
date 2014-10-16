package com.github.rschmitt.crystalmethod;

import java.util.Map;
import java.util.function.Function;

@FunctionalInterface
public interface Multimethod<D, T1, R> extends Function<T1, R> {
    default Map<D, Function<T1, R>> getDispatchMap() {
        return null;
    }

    default Function<T1, D> getDispatchFn() {
        return null;
    }
}
