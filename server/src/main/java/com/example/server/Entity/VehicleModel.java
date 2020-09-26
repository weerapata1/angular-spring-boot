package com.example.server.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data @Setter @Getter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "VehicleModel")
@ToString
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "carModel_seq", sequenceName = "carModel_seq")
    @Column(name = "modelID", unique = true, nullable = false)
    private Long id;

    @Column(name = "carModelName", unique = false, nullable = false)
    @NotNull(message = "\t--> carModelName is Null <--\t")
    private String name;

    @Column(name = "numCode")
    @NotNull(message = "\t--> numberCode is Null <--\t")
    private String numberCode;

    public VehicleModel(String name, String numberCode) {
        this.name = name;
        this.numberCode = numberCode;
    }
}

