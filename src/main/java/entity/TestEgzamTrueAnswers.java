package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class TestEgzamTrueAnswers {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private char firstAnswer;
    private char secondAnswer;
    private char thirdAnswer;
    private char fourthAnswer;
    private char fifthAnswer;
    private String firstQuestion;
    private String secondQuestion;
    private String thirdQuestion;
    private String fourthQuestion;
    private String fifthQuestion;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "exam_id")
    private Exam exam;

    public TestEgzamTrueAnswers(char firstAnswer, char secondAnswer, char thirdAnswer, char fourthAnswer, char fifthAnswer, String firstQuestion, String secondQuestion, String thirdQuestion, String fourthQuestion, String fifthQuestion, Exam exam) {
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.fourthAnswer = fourthAnswer;
        this.fifthAnswer = fifthAnswer;
        this.firstQuestion = firstQuestion;
        this.secondQuestion = secondQuestion;
        this.thirdQuestion = thirdQuestion;
        this.fourthQuestion = fourthQuestion;
        this.fifthQuestion = fifthQuestion;
        this.exam = exam;
    }
}
