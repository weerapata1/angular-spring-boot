package com.example.server.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data @Getter @Setter
@Table(name = "VehicleColor")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class VehicleColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "color_seq")
    private Long id;

    private String color;
}
