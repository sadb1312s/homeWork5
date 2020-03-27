package com.company.sequences;

public interface Sequence<T> {
    boolean hasNext();
    T next();
}
