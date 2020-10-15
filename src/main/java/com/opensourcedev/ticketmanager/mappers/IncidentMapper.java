package com.opensourcedev.ticketmanager.mappers;

import com.opensourcedev.ticketmanager.dto.IncidentDto;
import com.opensourcedev.ticketmanager.model.items.Incident;
import org.mapstruct.Mapper;

@Mapper
public interface IncidentMapper {

    IncidentDto incidentToIncidentDto(final Incident incident);
    Incident incidentDtoToIncident(final IncidentDto incidentDTO);
}
