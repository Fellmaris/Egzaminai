package repository;

import entity.TestEgzamAnswers;

public class TestEgzamAnswersRepository extends AbstractRepository{
    public void createNewTestEgzamAnswers(TestEgzamAnswers testEgzamAnswers) {
        changeEntity(session -> session.save(testEgzamAnswers));
    }
    public TestEgzamAnswers getTestEgzamAnswers(Long studentId) {
        return getEntityInformation(session -> session.get(TestEgzamAnswers.class, studentId));
    }
}
