package service;

import entity.Exam;
import entity.Result;
import entity.Student;
import repository.ResultRepository;

public class ResultService {

    private final ResultRepository resultRepository;

    public ResultService () {resultRepository = new ResultRepository();}

    public void createResult(Student student, Exam exam, double resultDouble){
        Result result = new Result();
        result.setExam(exam);
        result.setStudent(student);
        result.setResult(resultDouble);
        resultRepository.createNewResult(result);
    }

    public Result getResult(Long studentId){return resultRepository.getResult(studentId);}

    public void update (Exam exam, Student student, double resultDouble, Long studentId){
        Result result = resultRepository.getResult(studentId);

        if (result == null){
            System.out.println("Result does not exist");
            return;
        }
        result.setResult(resultDouble);
        resultRepository.updateResult(result);
    }
}
