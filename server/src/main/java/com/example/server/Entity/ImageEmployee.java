package com.example.server.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Table(name ="ImageEmployee")
public class ImageEmployee {
    @Id
    @GeneratedValue(generator = "ImageEmployee_seq",strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "ImageEmployee_seq",sequenceName = "ImageEmployee_seq")
    @Column(name = "id",unique = true,nullable = false)
    private Long id;

    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;

    @OneToOne(mappedBy = "imageEmployee" )
    private Employee employee;

}
