package com.example.server.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data @Setter @Getter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "carBrand")
//@ToString
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "carBrand_seq",sequenceName = "carBrand_seq")
    @Column(name = "brandID" ,unique = true ,nullable = false)
    private Long id;

    private String name;

    public CarBrand(String name){
        this.name = name;
    }
}
