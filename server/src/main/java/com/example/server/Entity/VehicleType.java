package com.example.server.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data @Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name ="VehicleType")
public class VehicleType {
    @Id
    @GeneratedValue(generator ="VehicleType_seq",strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "VehicleType_seq",sequenceName = "VehicleType_seq")
    @NotNull(message = "\t--> VehicleTypeId is Null <--\t")
    private Long id;

    private String nameType;
}
