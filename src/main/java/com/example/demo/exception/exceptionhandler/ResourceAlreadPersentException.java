package com.example.demo.exception.exceptionhandler;
@SuppressWarnings("serial")
public class ResourceAlreadPersentException  extends RuntimeException{

    public ResourceAlreadPersentException() {
        super("Resource Alread Persent Exception ");
    }

    public ResourceAlreadPersentException(String msg) {
        super(msg);
    }
}