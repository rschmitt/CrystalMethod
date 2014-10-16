package com.github.rschmitt.crystalmethod;

@FunctionalInterface
public interface Function4<T1, T2, T3, T4, R> {
    R apply(T1 arg1, T2 arg2, T3 arg3, T4 arg4);
}
