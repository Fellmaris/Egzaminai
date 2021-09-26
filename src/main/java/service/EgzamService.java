package service;

import entity.Exam;
import entity.Student;
import repository.EgzamRepository;

import java.util.List;

public class EgzamService {

    private final EgzamRepository egzamRepository;

    public EgzamService(){egzamRepository = new EgzamRepository();}

    public List<Exam> getExams () {return egzamRepository.getEgzams();}

    public void createEgzam (Exam newExam){
       egzamRepository.createNewEgzam(newExam);
    }

    public Exam getExam(Long examID) {
      {return egzamRepository.getExam(examID);}
    }
}
