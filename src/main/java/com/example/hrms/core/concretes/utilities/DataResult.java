package com.example.hrms.core.concretes.utilities;

//usage multiple data with generics
public class DataResult<T> extends Result{

    private T data;

    public DataResult(T data, boolean success, String message) {
        super(success, message); //base constructor
        this.data = data;
    }

    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
