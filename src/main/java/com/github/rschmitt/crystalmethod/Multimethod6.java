package com.github.rschmitt.crystalmethod;

import java.util.Map;
import java.util.function.Function;

public interface Multimethod6<D, R, T1, T2, T3, T4, T5, T6> {
    R invoke(T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6);

    default Map<D, Function6<T1, T2, T3, T4, T5, T6, R>> getDispatchMap() {
        return null;
    }

    default Function6<T1, T2, T3, T4, T5, T6, D> getDispatchFn() {
        return null;
    }
}
