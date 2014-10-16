package com.github.rschmitt.crystalmethod;

public interface Multimethod<D, R, T1> {
    R invoke(T1 arg1);
}
