package repository;

import entity.Result;

import java.util.List;

public class ResultRepository extends AbstractRepository{
    public void createNewResult(Result result) {
        changeEntity(session -> session.save(result));
    }

    public Result getResult(Long studentId) {
        return getEntityInformation(session -> session.get(Result.class, studentId));
    }

    public void updateResult (Result result){changeEntity(session -> session.update(result));}

    public List<Result> getResults (Long studentId){
        return getEntityInformation(session -> session.createQuery("from result r where r.student.id = " + studentId.toString(), Result.class).list());
    }
}
