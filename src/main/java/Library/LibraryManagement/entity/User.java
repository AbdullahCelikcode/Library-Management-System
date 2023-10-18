package Library.LibraryManagement.entity;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surName")
    private String surName;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "user")
    private Issue issue;

}
