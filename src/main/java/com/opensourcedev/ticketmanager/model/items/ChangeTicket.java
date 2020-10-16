package com.opensourcedev.ticketmanager.model.items;

import com.opensourcedev.ticketmanager.model.enums.ChangeType;

import com.opensourcedev.ticketmanager.model.enums.ItemStatus;
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
public class ChangeTicket extends BaseItem{

    @Builder
    public ChangeTicket(String id, @NotBlank ItemStatus itemStatus, Timestamp createdAt, Timestamp updatedAt,
                        Timestamp closedAt, IncidentSolver incidentSolver, User user, @NotBlank String changeId,
                        @NotBlank ChangeType changeType, @NotBlank @Min(10) String description) {
        super(id, itemStatus, createdAt, updatedAt, closedAt, incidentSolver, user);
        this.changeId = changeId;
        this.changeType = changeType;
        this.description = description;
    }

    @NotBlank
    private String changeId;    // public ID set by user

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private ChangeType changeType;


    @NotBlank
    @Size(min = 15, max = 500)
    @Column(length = 500)
    private String description;

}
