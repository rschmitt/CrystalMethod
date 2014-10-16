package com.github.rschmitt.crystalmethod;

import java.util.Map;
import java.util.function.Function;

public interface Multimethod3<D, R, T1, T2, T3> extends Function3<T1, T2, T3, R> {
    default Map<D, Function3<T1, T2, T3, R>> getDispatchMap() {
        return null;
    }

    default Function3<T1, T2, T3, D> getDispatchFn() {
        return null;
    }
}
