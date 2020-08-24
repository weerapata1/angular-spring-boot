package com.example.server.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data @Setter @Getter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Table(name = "ClientType")
public class ClientType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "clientType_seq")
    @SequenceGenerator(name = "clientType_seq", sequenceName = "clientType_seq")
    @Column(name = "typeID" , unique = true, nullable = false)
    @NotNull(message = "\t--> clientID is Null <--\t")
    private Long id;

    private String nameType;

    public ClientType(String nameType){
        this.nameType = nameType;
    }
}
