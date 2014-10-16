package com.github.rschmitt.crystalmethod;

import java.util.Map;
import java.util.function.Function;

public interface Multimethod7<D, R, T1, T2, T3, T4, T5, T6, T7> {
    R invoke(T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6, T7 arg7);

    default Map<D, Function7<T1, T2, T3, T4, T5, T6, T7, R>> getDispatchMap() {
        return null;
    }

    default Function7<T1, T2, T3, T4, T5, T6, T7, D> getDispatchFn() {
        return null;
    }
}
