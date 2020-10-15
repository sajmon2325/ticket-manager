package com.opensourcedev.ticketmanager.mappers;

import com.opensourcedev.ticketmanager.dto.TicketDto;
import com.opensourcedev.ticketmanager.model.items.Ticket;
import org.mapstruct.Mapper;

@Mapper
public interface TicketMapper {

    TicketDto ticketToTicketDto(final Ticket ticket);
    Ticket ticketDtoToTicket(final TicketDto ticketDTO);
}
