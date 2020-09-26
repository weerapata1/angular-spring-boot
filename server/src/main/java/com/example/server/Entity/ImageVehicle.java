package com.example.server.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "ImageVehicle")
@ToString
@Builder
public class ImageVehicle {
    @Id
    @SequenceGenerator(name = "ImageVehicle_seq",sequenceName = "ImageVehicle_seq")
    @GeneratedValue(generator = "ImageVehicle_seq",strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false)
    private Long id;

    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;

    @OneToOne(mappedBy = "imageVehicle")
    private Vehicle vehicle;

 }
