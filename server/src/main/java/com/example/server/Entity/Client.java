package com.example.server.Entity;

import lombok.*;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Entity
@Data @Getter @Setter
@Table(name = "Client")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "Client_seq",sequenceName = "Client_seq")
    @Column(name = "clientId",unique = true ,nullable = false)
    private Long id;

    @Column(unique = false)
    @NotNull(message = "\t--> firstNameClient is Null <--\t")
    private String FName;

    @Column(unique = false)
    @NotNull(message = "\t--> lastNameClient is Null <--\t")
    private String LName;

    @Column(unique = false)
    @NotNull(message = "\t--> citizenIDClient is Null <--\t")
    private String citizenID;

    private String fileName;
    private String fileType;
    private byte[] data;
    @ManyToOne(fetch = FetchType.EAGER,targetEntity = ClientType.class)
    @JoinColumn(name = "typeID",insertable = true)
    private ClientType clientType;

    public Client(String FName, String LName, String citizenID){
        this.FName = FName;
        this.LName = LName;
        this.citizenID = citizenID;
    }

}
