package com.project.reservation.exception;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-09T19:06:38.954Z[GMT]")
public class ApiException extends Exception {

    private int code;

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
