package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    @OneToMany (mappedBy = "exam", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<TestEgzamTrueAnswers> testEgzamTrueAnswers;
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<TestEgzamAnswers> testEgzamAnswers;
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Result> result;

    @Override
    public String toString() {
        return "Exam\n" +
                "id=" + id +
                "\nname='" + name +
                "\ntype='" + type;
    }

    public Exam(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
