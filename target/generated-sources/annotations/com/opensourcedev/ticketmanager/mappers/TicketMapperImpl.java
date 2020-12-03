package com.opensourcedev.ticketmanager.mappers;

import com.opensourcedev.ticketmanager.dto.BaseItemDto;
import com.opensourcedev.ticketmanager.dto.TicketDto;
import com.opensourcedev.ticketmanager.dto.TicketDto.TicketDtoBuilder;
import com.opensourcedev.ticketmanager.model.items.BaseItem;
import com.opensourcedev.ticketmanager.model.items.Ticket;
import com.opensourcedev.ticketmanager.model.items.Ticket.TicketBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-28T14:05:32+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
@Component
public class TicketMapperImpl implements TicketMapper {

    @Override
    public BaseItemDto baseItemToBaseItemDto(BaseItem baseItem) {
        if ( baseItem == null ) {
            return null;
        }

        BaseItemDto baseItemDto = new BaseItemDto();

        baseItemDto.setItemStatus( baseItem.getItemStatus() );
        baseItemDto.setCreatedAt( baseItem.getCreatedAt() );
        baseItemDto.setUpdatedAt( baseItem.getUpdatedAt() );
        baseItemDto.setClosedAt( baseItem.getClosedAt() );
        baseItemDto.setIncidentSolver( baseItem.getIncidentSolver() );
        baseItemDto.setUser( baseItem.getUser() );

        return baseItemDto;
    }

    @Override
    public BaseItem baseItemDtoToBaseItem(BaseItemDto baseItemDto) {
        if ( baseItemDto == null ) {
            return null;
        }

        BaseItem baseItem = new BaseItem();

        baseItem.setItemStatus( baseItemDto.getItemStatus() );
        baseItem.setCreatedAt( baseItemDto.getCreatedAt() );
        baseItem.setUpdatedAt( baseItemDto.getUpdatedAt() );
        baseItem.setClosedAt( baseItemDto.getClosedAt() );
        baseItem.setIncidentSolver( baseItemDto.getIncidentSolver() );
        baseItem.setUser( baseItemDto.getUser() );

        return baseItem;
    }

    @Override
    public TicketDto ticketToTicketDto(Ticket ticket) {
        if ( ticket == null ) {
            return null;
        }

        TicketDtoBuilder ticketDto = TicketDto.builder();

        ticketDto.ticketId( ticket.getTicketId() );
        ticketDto.ticketType( ticket.getTicketType() );
        ticketDto.description( ticket.getDescription() );

        return ticketDto.build();
    }

    @Override
    public Ticket ticketDtoToTicket(TicketDto ticketDTO) {
        if ( ticketDTO == null ) {
            return null;
        }

        TicketBuilder ticket = Ticket.builder();

        ticket.itemStatus( ticketDTO.getItemStatus() );
        ticket.createdAt( ticketDTO.getCreatedAt() );
        ticket.updatedAt( ticketDTO.getUpdatedAt() );
        ticket.closedAt( ticketDTO.getClosedAt() );
        ticket.incidentSolver( ticketDTO.getIncidentSolver() );
        ticket.user( ticketDTO.getUser() );
        ticket.ticketId( ticketDTO.getTicketId() );
        ticket.ticketType( ticketDTO.getTicketType() );
        ticket.description( ticketDTO.getDescription() );

        return ticket.build();
    }
}
