package com.example.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="Skill")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "Id", nullable = false, updatable = false, insertable = true)
    private String Id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "Emp_Id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Employee employee;

}
