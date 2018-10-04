package com.at.test.curso.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ApiError implements Serializable {

    private static final long serialVersionUID = 1752068812305262500L;

    private Integer status;
    private String errorMessage;

    public ApiError(Integer status, String errorMessage) {
        super();
        this.status = status;
        this.errorMessage = errorMessage;
    }

}
