package com.github.rschmitt.crystalmethod;

@FunctionalInterface
public interface Function3<T1, T2, T3, R> {
    R apply(T1 arg1, T2 arg2, T3 arg3);
}
