package service;

import entity.TestEgzamAnswers;
import repository.TestEgzamAnswersRepository;

public class TestEgzamAnswersService {
    private final TestEgzamAnswersRepository testEgzamAnswersRepository;

    public TestEgzamAnswersService () {testEgzamAnswersRepository = new TestEgzamAnswersRepository();}

    public void createTestEgzamAnswers (TestEgzamAnswers testEgzamAnswers){testEgzamAnswersRepository.createNewTestEgzamAnswers(testEgzamAnswers);}

}
