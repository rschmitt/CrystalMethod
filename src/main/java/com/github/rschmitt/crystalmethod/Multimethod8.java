package com.github.rschmitt.crystalmethod;

import java.util.Map;

public interface Multimethod8<D, R, T1, T2, T3, T4, T5, T6, T7, T8> {
    R invoke(T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6, T7 arg7, T8 arg8);

    default Map<D, Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>> getDispatchMap() {
        return null;
    }

    default Function8<T1, T2, T3, T4, T5, T6, T7, T8, D> getDispatchFn() {
        return null;
    }
}
