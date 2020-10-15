package com.opensourcedev.ticketmanager.mappers;

import com.opensourcedev.ticketmanager.dto.TicketDto;
import com.opensourcedev.ticketmanager.dto.TicketDto.TicketDtoBuilder;
import com.opensourcedev.ticketmanager.model.items.Ticket;
import com.opensourcedev.ticketmanager.model.items.Ticket.TicketBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-15T21:17:02+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
@Component
public class TicketMapperImpl implements TicketMapper {

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

        ticket.ticketId( ticketDTO.getTicketId() );
        ticket.ticketType( ticketDTO.getTicketType() );
        ticket.description( ticketDTO.getDescription() );

        return ticket.build();
    }
}
