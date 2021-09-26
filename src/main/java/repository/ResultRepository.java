package repository;

import entity.Result;

public class ResultRepository extends AbstractRepository{
    public void createNewResult(Result result) {
        changeEntity(session -> session.save(result));
    }
    public Result getResult(Long studentId) {
        return getEntityInformation(session -> session.get(Result.class, studentId));
    }
    public void updateResult (Result result){changeEntity(session -> session.update(result));}

}
