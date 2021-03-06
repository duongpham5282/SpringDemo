package com.example.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@NamedEntityGraph(
        name = "employee-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("skills")
        }
)
public class Employee implements Serializable {
    @Id
    private Long id;


    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Skill> skills;

}
