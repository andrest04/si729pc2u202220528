package com.microclimate.platform.u202220528.microclimate.domain.model.aggregates;

import com.microclimate.platform.u202220528.microclimate.domain.model.commands.CreateMicroclimateCommand;
import com.microclimate.platform.u202220528.microclimate.domain.model.valueobjects.ClimateContinent;
import com.microclimate.platform.u202220528.microclimate.domain.model.valueobjects.ClimateId;
import com.microclimate.platform.u202220528.microclimate.domain.model.valueobjects.RegisterEmailAddress;
import com.microclimate.platform.u202220528.shared.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * Microclimate aggregate root entity
 * @summary
 * This entity represents the microclimate aggregate root entity
 * It contains the climate id, register email address, climate place, climate country and climate continent.
 * @see ClimateId
 * @see RegisterEmailAddress
 * @see ClimateContinent
 * @see AuditableAbstractAggregateRoot
 * @since 1.0
 */
@Entity
@Getter
public class Microclimate extends AuditableAbstractAggregateRoot<Microclimate> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private ClimateId climateId;

    @Embedded
    private RegisterEmailAddress registerEmailAddress;

    @Column(nullable = false, length = 50)
    private String climatePlace;

    @Column(nullable = false, length = 250)
    private String climateCountry;

    @Enumerated(EnumType.STRING)
    private ClimateContinent climateContinent;

    @Column(nullable = false)
    private Long climateTemperature;

    public Microclimate() {
        //empty constructor JPA
    }

    /**
     * Constructor for Microclimate entity.
     *
     * @param climateId                                the unique identifier for the microclimate
     * @param registerEmailAddress   the owner's email address
     * @param climatePlace                         the location of the microclimate
     * @param climateCountry                  the country of the microclimate
     * @param climateContinent                  the continent of the microclimate
     * @param climateTemperature           the temperature of the microclimate
     */

    public Microclimate(ClimateId climateId, RegisterEmailAddress registerEmailAddress, String climatePlace, String climateCountry, ClimateContinent climateContinent, Long climateTemperature) {
        this.climateId = climateId;
        this.registerEmailAddress = registerEmailAddress;
        this.climatePlace = climatePlace;
        this.climateCountry = climateCountry;
        this.climateContinent = climateContinent;
        this.climateTemperature = climateTemperature;
    }

    public Microclimate(CreateMicroclimateCommand command) {
        this.climateId = new ClimateId(command.climateId());
        this.registerEmailAddress = new RegisterEmailAddress(command.registerEmailAddress());
        this.climatePlace = command.climatePlace();
        this.climateCountry = command.climateCountry();
        this.climateContinent = ClimateContinent.valueOf(command.climateContinent());
        this.climateTemperature = command.climateTemperature();

        if (this.climateId == null || this.climateId.getValue() == null) {
            throw new IllegalArgumentException("ClimateId cannot be null.");
        }
    }

}
