package com.opensourcedev.ticketmanager.dto;

import com.opensourcedev.ticketmanager.model.enums.ChangeType;

import com.opensourcedev.ticketmanager.model.enums.ItemStatus;
import com.opensourcedev.ticketmanager.model.users.IncidentSolver;
import com.opensourcedev.ticketmanager.model.users.User;
import lombok.*;

import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
public class ChangeTicketDto extends BaseItemDto {

    @Builder
    public ChangeTicketDto(ItemStatus itemStatus, Timestamp createdAt, Timestamp updatedAt, Timestamp closedAt,
                           IncidentSolver incidentSolver, User user, String changeId, ChangeType changeType, String description) {
        super(itemStatus, createdAt, updatedAt, closedAt, incidentSolver, user);
        this.changeId = changeId;
        this.changeType = changeType;
        this.description = description;
    }

    private String changeId;    // public ID set by user

    private ChangeType changeType;
    private String description;
}
