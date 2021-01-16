package com.project.reservation.exception;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-09T19:06:38.954Z[GMT]")
public class NotFoundException extends ApiException {

    private int code;

    public NotFoundException(int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
