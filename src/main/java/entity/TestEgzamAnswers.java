package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class TestEgzamAnswers {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private char firstAnswer;
    private char secondAnswer;
    private char thirdAnswer;
    private char fourthAnswer;
    private char fifthAnswer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "exam_id")
    private Exam exam;
    @OneToOne(mappedBy = "testEgzamAnswers", cascade = CascadeType.ALL)
    private Student student;

    public TestEgzamAnswers(char firstAnswer, char secondAnswer, char thirdAnswer, char fourthAnswer, char fifthAnswer, Exam exam, Student student) {
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.fourthAnswer = fourthAnswer;
        this.fifthAnswer = fifthAnswer;
        this.exam = exam;
        this.student = student;
    }
}
