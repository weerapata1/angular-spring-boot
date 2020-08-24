package com.example.server.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data @Getter @Setter
@Table(name = "statusActive")
@NoArgsConstructor
@EqualsAndHashCode
public class StatusActive {
    @Id
    @SequenceGenerator(name = "act_seq",sequenceName = "act_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "act_seq")
    @Column(name = "id",unique = true ,nullable = false)
    private Long id;

    private String statusName;

    public StatusActive(String statusName){
        this.statusName = statusName;
    }
}
