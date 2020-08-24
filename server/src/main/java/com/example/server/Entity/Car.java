package com.example.server.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data @Getter @Setter
@Table(name = "Car")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Car {
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
    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;

//    @ManyToOne(fetch = FetchType.LAZY,targetEntity = CarBrand.class)
//    @JoinColumn(name = "name" ,insertable = true)
//    private CarBrand brand;
//
//    @ManyToOne(fetch = FetchType.LAZY ,targetEntity = CarModel.class)
//    @JoinColumn(name = "modelID" ,insertable = true)
//    private CarModel model;
//
//    @ManyToOne(fetch = FetchType.LAZY ,targetEntity = StatusActive.class)
//    @JoinColumn(name = "id" ,insertable = true)
//    private StatusActive status;

}
