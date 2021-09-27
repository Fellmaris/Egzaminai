package repository;

import entity.Statistics;

public class StatisticRepository extends AbstractRepository{
    public void createNewStatistics(Statistics statistics) {
        changeEntity(session -> session.save(statistics));
    }
    public Statistics getStatistics(Long studentId) {
        return getEntityInformation(session -> session.get(Statistics.class, studentId));
    }

    public void updateStatistics(Statistics statistics) {
        changeEntity(session -> session.update(statistics));
    }

}
