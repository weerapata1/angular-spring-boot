package com.example.server.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data @Setter @Getter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Table(name = "employeeType")
public class EmployeeType {
    @Id
    @SequenceGenerator(name = "empType_seq",sequenceName = "empType_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "empType_seq")
    @Column(name = "empTypeId" ,unique = true, nullable = false)
    @NotNull(message = "\t--> empTypeId is Null <--\t")
    private Long id;

    @Column(name = "empTypeName",nullable = false , unique = true)
    @NotNull(message = "\t--> empTypeName is Null <--\t")
    private String nameType;

    public EmployeeType(String nameType){
        this.nameType = nameType;
    }
}
