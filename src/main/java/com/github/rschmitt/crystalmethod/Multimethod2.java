package com.github.rschmitt.crystalmethod;

import java.util.Map;

public interface Multimethod2<D, R, T1, T2> {
    R invoke(T1 arg1, T2 arg2);

    default Map<D, Function2<T1, T2, R>> getDispatchMap() {
        return null;
    }

    default Function2<T1, T2, D> getDispatchFn() {
        return null;
    }
}
