package com.opensourcedev.ticketmanager.model.users;

import com.opensourcedev.ticketmanager.model.enums.UserType;
import com.opensourcedev.ticketmanager.model.items.ChangeTicket;
import com.opensourcedev.ticketmanager.model.items.Incident;
import com.opensourcedev.ticketmanager.model.items.Ticket;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {     // This entity represents user who is reporting an item

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;      // Secret ID generated by DB

    @NotBlank
    private String userId;

    @Enumerated(value = EnumType.STRING)
    @NotBlank
    private UserType userType;

    @NotBlank
    @Min(5)
    @Max(25)
    @Column(unique = true, nullable = false)
    private String userName;

    @Min(5)
    @Max(25)
    @Column(unique = true, nullable = false)
    private String password;

    @OneToOne(mappedBy = "user")
    private ChangeTicket changeTicket;

    @OneToOne(mappedBy = "user")
    private Incident incident;

    @OneToOne(mappedBy = "user")
    private Ticket ticket;

}

