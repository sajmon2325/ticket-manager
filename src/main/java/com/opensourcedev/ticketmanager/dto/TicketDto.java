package com.opensourcedev.ticketmanager.dto;

import com.opensourcedev.ticketmanager.model.enums.ItemStatus;
import com.opensourcedev.ticketmanager.model.enums.TicketType;
import com.opensourcedev.ticketmanager.model.users.IncidentSolver;
import com.opensourcedev.ticketmanager.model.users.User;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto extends BaseItemDto{

    private String ticketId; // public ID set by user

    private TicketType ticketType;
    private String description;

}
