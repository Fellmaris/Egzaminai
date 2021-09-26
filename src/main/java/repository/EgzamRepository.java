package repository;

import entity.Exam;
import entity.Student;

import java.util.List;

public class EgzamRepository extends AbstractRepository{

    public List<Exam> getEgzams (){
        return getEntityInformation(session -> session.createQuery("from Exam", Exam.class).list());
    }

    public void createNewEgzam(Exam exam) {
        changeEntity(session -> session.save(exam));
    }

    public Exam getExam(Long examId){return getEntityInformation(session -> session.get(Exam.class, examId));}
}
