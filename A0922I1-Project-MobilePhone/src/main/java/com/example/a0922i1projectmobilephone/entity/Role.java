package com.example.a0922i1projectmobilephone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName roleName;

    @JsonBackReference
    @ManyToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<User> user;

}
