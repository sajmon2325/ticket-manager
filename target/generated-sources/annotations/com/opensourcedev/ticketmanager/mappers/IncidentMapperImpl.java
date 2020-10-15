package com.opensourcedev.ticketmanager.mappers;

import com.opensourcedev.ticketmanager.dto.IncidentDto;
import com.opensourcedev.ticketmanager.dto.IncidentDto.IncidentDtoBuilder;
import com.opensourcedev.ticketmanager.model.items.Incident;
import com.opensourcedev.ticketmanager.model.items.Incident.IncidentBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-15T21:17:02+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
@Component
public class IncidentMapperImpl implements IncidentMapper {

    @Override
    public IncidentDto incidentToIncidentDto(Incident incident) {
        if ( incident == null ) {
            return null;
        }

        IncidentDtoBuilder incidentDto = IncidentDto.builder();

        incidentDto.incidentId( incident.getIncidentId() );
        incidentDto.incidentType( incident.getIncidentType() );

        return incidentDto.build();
    }

    @Override
    public Incident incidentDtoToIncident(IncidentDto incidentDTO) {
        if ( incidentDTO == null ) {
            return null;
        }

        IncidentBuilder incident = Incident.builder();

        incident.incidentId( incidentDTO.getIncidentId() );
        incident.incidentType( incidentDTO.getIncidentType() );

        return incident.build();
    }
}
