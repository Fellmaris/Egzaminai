package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "student_id")
    private Student student;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "exam_id")
    private Exam exam;
    private double result;

    public Result(Student student, Exam exam, double result) {
        this.student = student;
        this.exam = exam;
        this.result = result;
    }
}
