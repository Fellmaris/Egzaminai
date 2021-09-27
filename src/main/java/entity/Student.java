package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @OneToMany (mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Result> result;
    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private TestEgzamAnswers testEgzamAnswers;
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Statistics statistics;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
