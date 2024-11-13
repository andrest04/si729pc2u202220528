package com.microclimate.platform.u202220528.microclimate.domain.model.queries;

/**
 * Query to get microclimate by id
 * @param microclimateId
 */
public record GetMicroclimateByIdQuery(Long microclimateId) {

    /**
     * Contructor
     * @param microclimateId microclimate id
     *                 Must be greater than 0
     *                 Must not be null
     * @throws IllegalArgumentException If the microclimate ID is invalid.
     */
    public GetMicroclimateByIdQuery {
        if (microclimateId == null || microclimateId <= 0)
            throw new IllegalArgumentException("Microclimate id is required");
    }
}
