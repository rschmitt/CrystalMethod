package com.github.rschmitt.crystalmethod;

@FunctionalInterface
public interface Function2<T1, T2, R> {
    R apply(T1 arg1, T2 arg2);
}
