package com.opensourcedev.ticketmanager.model.items;

import com.opensourcedev.ticketmanager.model.enums.ItemStatus;
import com.opensourcedev.ticketmanager.model.enums.TicketType;
import com.opensourcedev.ticketmanager.model.users.IncidentSolver;
import com.opensourcedev.ticketmanager.model.users.User;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket extends BaseItem{

    @Builder
    public Ticket(String id, @NotBlank ItemStatus itemStatus, Timestamp createdAt, Timestamp updatedAt,
                  Timestamp closedAt, IncidentSolver incidentSolver, User user, @NotBlank String ticketId,
                  @NotBlank TicketType ticketType, @Min(10) String description) {
        super(id, itemStatus, createdAt, updatedAt, closedAt, incidentSolver, user);
        this.ticketId = ticketId;
        this.ticketType = ticketType;
        this.description = description;
    }

    @NotBlank
    private String ticketId; // public ID set by user

    @Enumerated(value = EnumType.STRING)
    @NotNull
    private TicketType ticketType;

    @Column(length = 500)
    @Size(min = 15, max = 500)
    private String description;

}
