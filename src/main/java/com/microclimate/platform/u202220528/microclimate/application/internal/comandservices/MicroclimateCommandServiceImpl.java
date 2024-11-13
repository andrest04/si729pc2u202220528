package com.microclimate.platform.u202220528.microclimate.application.internal.comandservices;

import com.microclimate.platform.u202220528.microclimate.domain.model.aggregates.Microclimate;
import com.microclimate.platform.u202220528.microclimate.domain.model.commands.CreateMicroclimateCommand;
import com.microclimate.platform.u202220528.microclimate.domain.model.valueobjects.ClimateContinent;
import com.microclimate.platform.u202220528.microclimate.domain.model.valueobjects.ClimateId;
import com.microclimate.platform.u202220528.microclimate.domain.services.MicroclimateCommandService;
import com.microclimate.platform.u202220528.microclimate.repositories.MicroclimateRepository;
import org.springframework.stereotype.Service;

/**
 * The microclimate command service implementation
 */
@Service
public class MicroclimateCommandServiceImpl implements MicroclimateCommandService {
    private final MicroclimateRepository microclimateRepository;

    public MicroclimateCommandServiceImpl(MicroclimateRepository microclimateRepository) {
        this.microclimateRepository = microclimateRepository;
    }

    /**
     * Handle a create microclimate command
     *
     * @param command The create microclimate command containing the microclimate details
     */
    @Override
    public Long handle(CreateMicroclimateCommand command) {
        // Crear el Value Object ClimateId
        var climateIdVO = new ClimateId(command.climateId());

        // Validar duplicados usando ClimateId
        if (microclimateRepository.existsByClimateIdAndClimatePlaceAndClimateCountryAndClimateContinent(
                climateIdVO,
                command.climatePlace(),
                command.climateCountry(),
                ClimateContinent.valueOf(command.climateContinent())
        )) {
            throw new IllegalArgumentException("Microclimate with place '%s' already exists.".formatted(command.climatePlace()));
        }

        // Crear la entidad Microclimate
        var microclimate = new Microclimate(command);

        try {
            // Guardar la entidad en el repositorio
            microclimateRepository.save(microclimate);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving microclimate: %s".formatted(e.getMessage()));
        }

        return microclimate.getId();
    }
}