package com.opensourcedev.ticketmanager.dto;

import com.opensourcedev.ticketmanager.model.enums.ChangeType;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeTicketDto extends BaseItemDto {

    private String changeId;    // public ID set by user

    private ChangeType changeType;
    private String description;
}
