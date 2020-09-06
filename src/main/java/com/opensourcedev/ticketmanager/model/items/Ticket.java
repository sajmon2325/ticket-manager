package com.opensourcedev.ticketmanager.model.items;

import com.opensourcedev.ticketmanager.model.enums.TicketType;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseItem{

    private String ticketId; // public ID set by user

    private TicketType ticketType;
    private String description;

}
