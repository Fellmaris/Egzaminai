package repository;

import entity.TestEgzamTrueAnswers;

public class TestEgzamTrueAnswersRepository extends AbstractRepository{
    public void createNewTestEgzamTrueAnswers(TestEgzamTrueAnswers testEgzamTrueAnswers) {
        changeEntity(session -> session.save(testEgzamTrueAnswers));
    }

    public void updateTestEgzamTrueAnswers(TestEgzamTrueAnswers testEgzamTrueAnswers) {
        changeEntity(session -> session.update(testEgzamTrueAnswers));
    }

    public TestEgzamTrueAnswers getTestEgzamTrueAnswers(Long egzamId) {
        return getEntityInformation(session -> session.get(TestEgzamTrueAnswers.class, egzamId));
    }
}
