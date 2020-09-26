package com.example.server.Entity;

import lombok.*;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Client_seq")
    @SequenceGenerator(name = "Client_seq",sequenceName = "Client_seq")
    @Column(name = "id",unique = true ,nullable = false)
    @NotNull(message = "\t--> clientId is Null <--\t")
    private Long id;

    @Column(unique = false)
    @Size(max = 50, message = "\t--> firstNameClient over length <--\t" )
    @NotNull(message = "\t--> firstNameClient is Null <--\t")
    private String FName;

    @Column(unique = false)
    @Size(max = 50, message = "\t--> lastNameClient over length <--\t" )
    @NotNull(message = "\t--> lastNameClient is Null <--\t")
    private String LName;

    @Column(unique = false)
    @Pattern(regexp = "\\d{13}")
    @NotNull(message = "\t--> citizenIDClient is Null <--\t")
    private String citizenID;

    private String fileName;
    private String fileType;
    private byte[] data;
    @ManyToOne(fetch = FetchType.EAGER,targetEntity = ClientType.class)
    @JoinColumn(name = "typeID",insertable = true)
    private ClientType clientType;

    public Client(String FName, String LName, String citizenID,ClientType ClientType){
        this.FName = FName;
        this.LName = LName;
        this.citizenID = citizenID;
        this.clientType = ClientType;
    }

}
