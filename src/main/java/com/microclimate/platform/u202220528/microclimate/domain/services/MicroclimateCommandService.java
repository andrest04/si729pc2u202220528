package com.microclimate.platform.u202220528.microclimate.domain.services;

import com.microclimate.platform.u202220528.microclimate.domain.model.commands.CreateMicroclimateCommand;

/**
 * The microclimate command service interface
 */
public interface MicroclimateCommandService {
    /**
     * Handle a create microclimate command
     * @param command The create microclimate command containing the microclimate details
     */
    Long handle(CreateMicroclimateCommand command);
}
