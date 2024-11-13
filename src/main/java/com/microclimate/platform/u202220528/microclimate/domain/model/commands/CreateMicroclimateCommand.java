package com.microclimate.platform.u202220528.microclimate.domain.model.commands;

/**
 * The create microclimate command
 */
public record CreateMicroclimateCommand(Long climateId, String registerEmailAddress, String climatePlace, String climateCountry, String  climateContinent, Long climateTemperature)
{
    /**
     * Constructor for CreateMicroclimateCommand
     *
     * @param climateId                                the unique identifier for the microclimate
     * @param registerEmailAddress   the owner's email address
     * @param climatePlace                         the location of the microclimate
     * @param climateCountry                  the country of the microclimate
     * @param climateContinent                  the continent of the microclimate
     * @param climateTemperature           the temperature of the microclimate
     */
    public CreateMicroclimateCommand {
        if (climateId == null || climateId < 0)
            throw new IllegalArgumentException("ClimateId cannot be null and must be greater than 0");

        if (registerEmailAddress == null || registerEmailAddress.isBlank())
            throw new IllegalArgumentException("Email cannot be null or empty");

        if (registerEmailAddress.length() > 50)
            throw new IllegalArgumentException("Email cannot exceed 50 characters");

        if (climatePlace == null)
            throw new IllegalArgumentException("Climate place cannot be null.");

        if (climateCountry == null || climateCountry.length() > 250)
            throw new IllegalArgumentException("Climate country cannot exceed 250 characters.");

        if (climateContinent == null)
            throw new IllegalArgumentException("Climate continent cannot be null.");

        if (climateTemperature == null || climateTemperature < -100 || climateTemperature > 100)
            throw new IllegalArgumentException("Climate temperature cannot be null and must be between -100 and 100");
    }
}
