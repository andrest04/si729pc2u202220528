package com.microclimate.platform.u202220528.microclimate.rest.transform;

import com.microclimate.platform.u202220528.microclimate.domain.model.commands.CreateMicroclimateCommand;
import com.microclimate.platform.u202220528.microclimate.rest.resources.CreateMicroclimateResource;

public class CreateMicroclimateResourceFromResourceAssembler {

    public static CreateMicroclimateCommand toCommandFromResource(CreateMicroclimateResource resource) {
        return new CreateMicroclimateCommand(
                resource.climateId(),
                resource.registerEmailAddress(),
                resource.climatePlace(),
                resource.climateCountry(),
                resource.climateContinent(),
                resource.climateTemperature()
        );
    }
}
