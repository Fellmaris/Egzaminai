package repository;

import entity.Student;


import java.util.List;

public class StudentRepository extends AbstractRepository{

    public void createNewStudent(Student student) {
        changeEntity(session -> session.save(student));
    }

    public List<Student> getStudents() {
        return getEntityInformation(session -> session.createQuery("from Student", Student.class).list());
    }

    public Student getStudent(Long studentId){return getEntityInformation(session -> session.get(Student.class, studentId));}
}
