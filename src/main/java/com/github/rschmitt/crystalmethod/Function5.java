package com.github.rschmitt.crystalmethod;

@FunctionalInterface
public interface Function5<T1, T2, T3, T4, T5, R> {
    R apply(T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5);
}
