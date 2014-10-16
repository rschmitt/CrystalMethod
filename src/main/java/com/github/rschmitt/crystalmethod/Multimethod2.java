package com.github.rschmitt.crystalmethod;

public interface Multimethod2<D, R, T1, T2> {
    R invoke(T1 arg1, T2 arg2);
}
