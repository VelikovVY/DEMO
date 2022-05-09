package com.service.demo.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity//suzdava tablica v baza danni
@Table(name = "users")//promenq impeto na tablica v BD
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //suzdava autoincrement
    private Long id;

    @Column(unique = true, nullable = false)// suzdavane na kolona v tablicata -unique -not null-
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne // svurzva tablica user s rolite v Role
    private Role role;

}
