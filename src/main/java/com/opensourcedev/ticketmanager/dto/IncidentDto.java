package com.opensourcedev.ticketmanager.dto;

import com.opensourcedev.ticketmanager.model.enums.IncidentType;

import com.opensourcedev.ticketmanager.model.enums.ItemStatus;
import com.opensourcedev.ticketmanager.model.users.IncidentSolver;
import com.opensourcedev.ticketmanager.model.users.User;
import lombok.*;

import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
public class IncidentDto extends BaseItemDto{

    @Builder
    public IncidentDto(ItemStatus itemStatus, Timestamp createdAt, Timestamp updatedAt, Timestamp closedAt,
                       IncidentSolver incidentSolver, User user, String incidentId, IncidentType incidentType) {
        super(itemStatus, createdAt, updatedAt, closedAt, incidentSolver, user);
        this.incidentId = incidentId;
        this.incidentType = incidentType;
    }

    private String incidentId; // public ID set by user
    private IncidentType incidentType;


}
