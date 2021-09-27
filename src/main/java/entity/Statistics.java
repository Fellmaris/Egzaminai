package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Statistics {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private int amountOfEgzamsDone;
    private int totalAmountOfCorrectAnswers;
    private int totalAmountOfCorrectAnswersInTestExam;
    private double averageCorrectAnswersBetweenAllEgzams;
    private int amountOfAChoices;
    private int amountOfBChoices;
    private int amountOfCChoices;
    @OneToOne(mappedBy = "statistics", cascade = CascadeType.ALL)
    private Student student;


    @Override
    public String toString() {
        return  "Student: " + student.getId() + " " + student.getName() + " " + student.getSurname() +
                "\namountOfEgzamsDone=" + amountOfEgzamsDone +
                "\ntotalAmountOfCorrectAnswers=" + totalAmountOfCorrectAnswers +
                "\ntotalAmountOfCorrectAnswersInTestExam=" + totalAmountOfCorrectAnswersInTestExam +
                "\naverageCorrectAnswersBetweenAllEgzams=" + averageCorrectAnswersBetweenAllEgzams +
                "\namountOfAChoices=" + amountOfAChoices +
                "\namountOfBChoices=" + amountOfBChoices +
                "\namountOfCChoices=" + amountOfCChoices;
    }
}
