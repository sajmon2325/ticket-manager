package com.opensourcedev.ticketmanager.model.items;

import com.opensourcedev.ticketmanager.model.enums.ChangeType;

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
public class ChangeTicket extends BaseItem{

    @NotBlank
    private String changeId;    // public ID set by user

    @NotBlank
    @Enumerated(value = EnumType.STRING)
    private ChangeType changeType;


    @NotBlank
    @Min(10)
    @Column(length = 500)
    private String description;

}
