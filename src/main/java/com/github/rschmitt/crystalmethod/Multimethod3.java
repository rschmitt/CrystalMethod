package com.github.rschmitt.crystalmethod;

import java.util.Map;

public interface Multimethod3<D, R, T1, T2, T3> {
    R invoke(T1 arg1, T2 arg2, T3 arg3);

    default Map<D, Function3<T1, T2, T3, R>> getDispatchMap() {
        return null;
    }

    default Function3<T1, T2, T3, D> getDispatchFn() {
        return null;
    }
}
