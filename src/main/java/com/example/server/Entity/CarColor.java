package com.example.server.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data @Getter @Setter
@Table(name = "carColor")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CarColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "color_seq")
    private Long id;

    private String color;
}
