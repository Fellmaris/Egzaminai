package service;

import entity.Student;
import repository.StudentRepository;

import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(){studentRepository= new StudentRepository();}

    public void createStudent (String name, String surname){
        Student student = new Student(name, surname);
        studentRepository.createNewStudent(student);
    }

    public Student getStudent(Long studentId){return studentRepository.getStudent(studentId);}

    public List<Student> getStudents (){return studentRepository.getStudents();}
}
