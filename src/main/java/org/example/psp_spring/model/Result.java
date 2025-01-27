package org.example.psp_spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;


public abstract class Result<T> {

    @Data
    @AllArgsConstructor
    public static class Success<T>{
        private T data;
    }

    @Data
    @AllArgsConstructor
    public static class Error{
        private String msg;
    }

}
