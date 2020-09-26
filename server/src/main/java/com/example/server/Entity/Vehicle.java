package com.example.server.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data @Getter @Setter
@Table(name = "Vehicle")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vehicle {
    @Id
    @SequenceGenerator(name = "car_seq",sequenceName = "car_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carId",unique = true ,nullable = false)
    private Long id;

    private String year;
    private String serialNo;
    private LocalDate carIn;
    private String plateNo;
    private LocalDate  carOut;
    private Integer price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ImageVehicle_id",referencedColumnName = "id",insertable = true)
    private  ImageVehicle imageVehicle;

//    @ManyToOne(fetch = FetchType.LAZY,targetEntity = VehicleBrand.class)
//    @JoinColumn(name = "name" ,insertable = true)
//    private VehicleBrand brand;
//
//    @ManyToOne(fetch = FetchType.LAZY ,targetEntity = VehicleModel.class)
//    @JoinColumn(name = "modelID" ,insertable = true)
//    private VehicleModel model;
//
//    @ManyToOne(fetch = FetchType.LAZY ,targetEntity = StatusActive.class)
//    @JoinColumn(name = "id" ,insertable = true)
//    private StatusActive status;

}
