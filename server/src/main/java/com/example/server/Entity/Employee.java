package com.example.server.Entity;

import com.example.server.Repository.EmployeeTypeRepository;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Optional;

@Entity
@Data @Getter @Setter
@Table(name = "employee")
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_seq" ,sequenceName = "employee_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY ,generator = "employee_seq")
    @Column(unique = true ,name = "id" ,nullable = false)
    @NotNull(message = "\t--> employeeId is Null <--\t")
    private Long id;

    @Column(unique = false) @NotNull(message = "\t--> firstName is Null <--\t")
    @Size(max = 25)
    private String firstName;

    @Column(unique = false) @NotNull(message = "\t--> firstName is Null <--\t") @Size(max = 25)
    private String lastName;

    @Column(unique = true) @NotNull(message = "\t--> citizenID is Null <--\t")
    @Size(max = 13,min = 13 ,message = "\t--> Max or Min in citizenID<--\t")
    @Pattern(regexp = "\\d{13}")
    private String citizenID;

    @Column(unique = false) @NotNull(message = "\t-->phoneNum is Null<--\t") @Size(max = 10)
    private String phoneNum;

    @Column(unique = false) @NotNull(message = "\t--> emailID is Null <--\t") @Size(max = 45)
    @Pattern(regexp = "\\w{1,30}\\@\\w{1,10}(.\\w{3}|(.\\w{2}){2})")
    private String emailId;

    private String fileName;
    private String fileType;
    private byte[] data;

    @ManyToOne(fetch = FetchType.EAGER ,targetEntity = EmployeeType.class)
    @JoinColumn(name = "empTypeId")
    private EmployeeType employeeType;

    public Employee(String firstName ,String lastName ,String citizenID ,String phoneNum ,String emailId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.citizenID = citizenID;
        this.phoneNum = phoneNum;
        this.emailId = emailId;
    }
}
