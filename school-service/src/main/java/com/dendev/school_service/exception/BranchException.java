package com.dendev.school_service.exception;

import jakarta.ws.rs.NotFoundException;

public class BranchException extends NotFoundException {
    public BranchException(String message) {
        super(message);
    }
}
