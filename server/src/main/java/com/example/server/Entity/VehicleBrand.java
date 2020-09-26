package com.example.server.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data @Setter @Getter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "VehicleBrand")
//@ToString
public class VehicleBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "carBrand_seq",sequenceName = "carBrand_seq")
    @Column(name = "brandID" ,unique = true ,nullable = false)
    private Long id;

    private String name;

    public VehicleBrand(String name){
        this.name = name;
    }
}
