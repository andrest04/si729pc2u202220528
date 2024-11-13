package com.microclimate.platform.u202220528.microclimate.rest.transform;

import com.microclimate.platform.u202220528.microclimate.domain.model.aggregates.Microclimate;
import com.microclimate.platform.u202220528.microclimate.rest.resources.MicroclimateResource;

/**
 * MicroclimateResourceFromEntityAssembler
 */
public class MicroclimateResourceFromEntityAssembler {
    public static MicroclimateResource toResourceFromEntity(Microclimate entity) {
        return new MicroclimateResource(
                entity.getId(),
                entity.getClimateId().getClimateId(),
                entity.getRegisterEmailAddress().toString(),
                entity.getClimatePlace(),
                entity.getClimateCountry(),
                entity.getClimateContinent().toString(),
                entity.getClimateTemperature()
        );
    }
}