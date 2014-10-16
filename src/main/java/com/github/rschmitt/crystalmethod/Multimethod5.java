package com.github.rschmitt.crystalmethod;

import java.util.Map;

public interface Multimethod5<D, R, T1, T2, T3, T4, T5> {
    R invoke(T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5);

    default Map<D, Function5<T1, T2, T3, T4, T5, R>> getDispatchMap() {
        return null;
    }

    default Function5<T1, T2, T3, T4, T5, D> getDispatchFn() {
        return null;
    }
}
