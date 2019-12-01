package com.laoxu.simplecontractmvpframework.utils;

public interface NetCallback {
    void success(String result);
    void failuree(Throwable error);
}
