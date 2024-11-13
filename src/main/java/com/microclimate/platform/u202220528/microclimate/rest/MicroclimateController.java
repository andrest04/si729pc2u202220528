package com.microclimate.platform.u202220528.microclimate.rest;

import com.microclimate.platform.u202220528.microclimate.domain.model.queries.GetMicroclimateByIdQuery;
import com.microclimate.platform.u202220528.microclimate.domain.services.MicroclimateCommandService;
import com.microclimate.platform.u202220528.microclimate.domain.services.MicroclimatesQueryService;
import com.microclimate.platform.u202220528.microclimate.rest.resources.CreateMicroclimateResource;
import com.microclimate.platform.u202220528.microclimate.rest.resources.MicroclimateResource;
import com.microclimate.platform.u202220528.microclimate.rest.transform.CreateMicroclimateResourceFromResourceAssembler;
import com.microclimate.platform.u202220528.microclimate.rest.transform.MicroclimateResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Microclimate Controller
 */
@RestController
@RequestMapping(value = "/api/v1/microclimates", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Microclimates", description = "Available Microclimate Endpoints")
public class MicroclimateController {
    private final MicroclimatesQueryService microclimateQueryService;
    private final MicroclimateCommandService microclimateCommandService;

    /**
     * Constructor
     * @param microclimateQueryService The {@link MicroclimatesQueryService} instance
     */
    public MicroclimateController(MicroclimatesQueryService microclimateQueryService, MicroclimateCommandService microclimateCommandService) {
        this.microclimateQueryService = microclimateQueryService;
        this.microclimateCommandService = microclimateCommandService;
    }

    /**
     * Create a new microclimate
     * @param resource The {@link CreateMicroclimateResource} resource
     * @return The {@link MicroclimateResource} resource for the created microclimate
     */
    @PostMapping
    @Operation(summary = "Create a new microclimate", description = "Create a new microclimate")
    @ApiResponses( value =  {
            @ApiResponse(responseCode = "201", description = "Microclimate created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Microclimate not found")
    })
    public ResponseEntity<MicroclimateResource> createMicroclimate(@RequestBody CreateMicroclimateResource resource){
        var createMicroclimateCommand = CreateMicroclimateResourceFromResourceAssembler.toCommandFromResource(resource);
        var microclimateId = microclimateCommandService.handle(createMicroclimateCommand);
        var getMicroclimateByIdQuery = new GetMicroclimateByIdQuery(microclimateId);
        var microclimate = microclimateQueryService.handle(getMicroclimateByIdQuery);
        if(microclimate.isEmpty()) return ResponseEntity.notFound().build();
        var microclimateEntity = microclimate.get();
        var microclimateResource = MicroclimateResourceFromEntityAssembler.toResourceFromEntity(microclimateEntity);
        return new ResponseEntity<>(microclimateResource, HttpStatus.CREATED);
    }
}
