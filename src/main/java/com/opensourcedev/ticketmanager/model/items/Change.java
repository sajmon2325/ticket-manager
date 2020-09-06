package com.opensourcedev.ticketmanager.model.items;

import com.opensourcedev.ticketmanager.model.enums.ChangeType;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Change extends BaseItem{

    private String changeId;    // public ID set by user

    private ChangeType changeType;
    private String description;

}
