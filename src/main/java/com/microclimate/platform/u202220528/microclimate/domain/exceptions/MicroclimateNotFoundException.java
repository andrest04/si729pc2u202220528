package com.microclimate.platform.u202220528.microclimate.domain.exceptions;

public class MicroclimateNotFoundException extends RuntimeException {
    public MicroclimateNotFoundException(Long climateId) {
        super(String.format("microclimate with id %s not found", climateId));
    }
}
