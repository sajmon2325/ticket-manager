package com.opensourcedev.ticketmanager.model.items;

import com.opensourcedev.ticketmanager.model.enums.TicketType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket extends BaseItem{

    //@Column(name = "ticket_Id", unique = true)
    @NotBlank
    private String ticketId; // public ID set by user

    @Enumerated(value = EnumType.STRING)
    @NotBlank
    private TicketType ticketType;

    @Column(length = 500)
    @Min(10)
    private String description;

}
