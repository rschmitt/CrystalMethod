package com.github.rschmitt.crystalmethod;

import java.util.Map;

public interface Multimethod9<D, R, T1, T2, T3, T4, T5, T6, T7, T8, T9> {
    R invoke(T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6, T7 arg7, T8 arg8, T9 arg9);

    default Map<D, Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>> getDispatchMap() {
        return null;
    }

    default Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, D> getDispatchFn() {
        return null;
    }
}
