package service;

import entity.Exam;
import entity.Statistics;
import entity.Student;
import repository.StatisticRepository;

public class StatisticsService {

    private final StatisticRepository statisticRepository;

    public StatisticsService() {statisticRepository = new StatisticRepository();}

    public void createStatistics (Student student, Exam exam, Statistics statistics){
        Statistics statisticsNew = new Statistics();
        statisticsNew.setStudent(student);
        statisticsNew.setAmountOfEgzamsDone(statistics.getAmountOfEgzamsDone());
        statisticsNew.setTotalAmountOfCorrectAnswers(statistics.getTotalAmountOfCorrectAnswers());
        statisticsNew.setTotalAmountOfCorrectAnswersInTestExam(statistics.getTotalAmountOfCorrectAnswersInTestExam());
        statisticsNew.setAverageCorrectAnswersBetweenAllEgzams(statistics.getAverageCorrectAnswersBetweenAllEgzams());
        statisticsNew.setAmountOfAChoices(statistics.getAmountOfAChoices());
        statisticsNew.setAmountOfBChoices(statistics.getAmountOfBChoices());
        statisticsNew.setAmountOfCChoices(statistics.getAmountOfCChoices());
        statisticRepository.createNewStatistics(statisticsNew);
    }

    public Statistics getStatistics (Long studentId){return statisticRepository.getStatistics(studentId);}

    public void update (Student student, Exam exam, Statistics statistics){
        Statistics statisticsUpdate = statisticRepository.getStatistics(student.getId());

        if (statisticsUpdate == null) {
            System.out.println("Statistics do not exist");
        }

        statisticsUpdate.setStudent(student);
        statisticsUpdate.setAmountOfEgzamsDone(statistics.getAmountOfEgzamsDone());
        statisticsUpdate.setTotalAmountOfCorrectAnswers(statistics.getTotalAmountOfCorrectAnswers());
        statisticsUpdate.setTotalAmountOfCorrectAnswersInTestExam(statistics.getTotalAmountOfCorrectAnswersInTestExam());
        statisticsUpdate.setAverageCorrectAnswersBetweenAllEgzams(statistics.getAverageCorrectAnswersBetweenAllEgzams());
        statisticsUpdate.setAmountOfAChoices(statistics.getAmountOfAChoices());
        statisticsUpdate.setAmountOfBChoices(statistics.getAmountOfBChoices());
        statisticsUpdate.setAmountOfCChoices(statistics.getAmountOfCChoices());
        statisticRepository.updateStatistics(statisticsUpdate);
    }
}
