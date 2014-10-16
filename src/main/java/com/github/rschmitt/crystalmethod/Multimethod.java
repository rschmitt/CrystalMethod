package com.github.rschmitt.crystalmethod;

import java.util.Map;
import java.util.function.Function;

public interface Multimethod<D, R, T1> {
    R invoke(T1 arg1);

    default Map<D, Function<T1, R>> getDispatchMap() {
        return null;
    }

    default Function<T1, D> getDispatchFn() {
        return null;
    }
}
