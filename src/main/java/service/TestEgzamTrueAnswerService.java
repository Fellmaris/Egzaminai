package service;

import entity.TestEgzamTrueAnswers;
import repository.TestEgzamTrueAnswersRepository;

public class TestEgzamTrueAnswerService {
    private final TestEgzamTrueAnswersRepository testEgzamTrueAnswersRepository;

    public TestEgzamTrueAnswerService (){testEgzamTrueAnswersRepository = new TestEgzamTrueAnswersRepository();}

    public void createTestEgzamAnswers (TestEgzamTrueAnswers testEgzamTrueAnswers){testEgzamTrueAnswersRepository.createNewTestEgzamTrueAnswers(testEgzamTrueAnswers);}

    public TestEgzamTrueAnswers getTestEgzamTrueAnswers(Long egzamId){return testEgzamTrueAnswersRepository.getTestEgzamTrueAnswers(egzamId);}

    public void update(TestEgzamTrueAnswers testEgzamTrueAnswers){
    if (testEgzamTrueAnswers == null){
        System.out.println("Test does not exist");
        return;
    }
    testEgzamTrueAnswersRepository.updateTestEgzamTrueAnswers(testEgzamTrueAnswers);
    }
}
