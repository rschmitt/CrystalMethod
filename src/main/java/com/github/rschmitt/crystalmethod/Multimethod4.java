package com.github.rschmitt.crystalmethod;

import java.util.Map;
import java.util.function.Function;

public interface Multimethod4<D, R, T1, T2, T3, T4> {
    R invoke(T1 arg1, T2 arg2, T3 arg3, T4 arg4);

    default Map<D, Function4<T1, T2, T3, T4, R>> getDispatchMap() {
        return null;
    }

    default Function4<T1, T2, T3, T4, D> getDispatchFn() {
        return null;
    }
}
