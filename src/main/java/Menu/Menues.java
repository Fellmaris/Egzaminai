package Menu;

import entity.*;
import service.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Scanner;

public class Menues {
    public void mainMenu() {
        EgzamService egzamService = new EgzamService();
        Exam testOOP = new Exam("OOP", "Test");
        Exam testDB = new Exam("DB","Test");
        StudentService studentService = new StudentService();
        studentService.createStudent("Arturas", "Cerniauskas");
        egzamService.createEgzam(testOOP);
        egzamService.createEgzam(testDB);
        TestEgzamTrueAnswerService testEgzamTrueAnswerService = new TestEgzamTrueAnswerService();
        testEgzamTrueAnswerService.createTestEgzamAnswers(new TestEgzamTrueAnswers('A','A','A','A','A',"Hello1?","Hello2?","Hello3?","Hello4?","Hello5?", testOOP));
        testEgzamTrueAnswerService.createTestEgzamAnswers(new TestEgzamTrueAnswers('B','B','B','B','A',"Goodbye1?","Goodbye2?","Goodbye3?","Goodbye4?","Goodbye5?", testDB));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("------------------");
            System.out.println("1. Create User");
            System.out.println("2. LogIn");
            System.out.println("3. Update and exam");
            System.out.println("4. Show all users");
            System.out.println("5. Show all tests");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    logIn(scanner);
                    break;
                case 3:{
                    System.out.println("Enter password:");
                    if (passwordCheck(scanner.next()))
                    updateExam(scanner);
                    break;}
                case 4:
                    showUsers();
                    break;
                case 5:
                    showTests();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid action");
                    break;
            }
        }
    }

    private boolean passwordCheck(String enteredPassword) {

                String password = "123";
                String encryptedpassword = null;
                try {
                    MessageDigest m = MessageDigest.getInstance("MD5");
                    m.update(password.getBytes());
                    byte[] bytes = m.digest();
                    StringBuilder s = new StringBuilder();
                    for (int i = 0; i < bytes.length; i++) {
                        s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                    }
                    encryptedpassword = s.toString();

                    m.update(enteredPassword.getBytes());
                    bytes = m.digest();
                    s.delete(0,s.length());
                    for (int i = 0; i < bytes.length; i++) {
                        s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                    }
                    String encryptedEnteredPassword = s.toString();
                    if (encryptedEnteredPassword.equals(encryptedpassword)) {
                        return true;
                    }
                }
                catch (NoSuchAlgorithmException e)
                {
                    e.printStackTrace();
                }
        System.out.println("Wrong password");
                      return false;
            }



    private void showTests() {
        EgzamService egzamService = new EgzamService();

        if (egzamService.getExams() != null) {
            egzamService.getExams().forEach(exam -> System.out.println("------------------\nEgzam ID: " + exam.getId() + "\nEgzam type: " + exam.getType() + "" +
                    "\nEgzam name" + exam.getName()));
        }
    }

    private void showUsers() {
        StudentService service = new StudentService();
        if (service.getStudents() != null) {
            service.getStudents().forEach(student -> System.out.println("--------------------\nID: " + student.getId() + "\nName: " + student.getName() + "\nSurname: " + student.getSurname()));
        }
    }

    private void updateExam(Scanner scanner) {
        TestEgzamTrueAnswerService testEgzamTrueAnswerService = new TestEgzamTrueAnswerService();

        System.out.println("Enter ID of exam you want to update:");
        Long enteredExamID = scanner.nextLong();
        TestEgzamTrueAnswers testEgzamTrueAnswers = testEgzamTrueAnswerService.getTestEgzamTrueAnswers(enteredExamID);
        if((testEgzamTrueAnswers == null)){
            System.out.println("Such an exam, does not exist.");
            return;
        }
        System.out.println("1. Update first question and answer");
        System.out.println("2. Update second question and answer");
        System.out.println("3. Update third question and answer");
        System.out.println("4. Update fourth question and answer");
        System.out.println("5. Update fifth question and answer");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("Set first question:");
                testEgzamTrueAnswers.setFirstQuestion(scanner.next());
                System.out.println("Set correct answer to question one");
                testEgzamTrueAnswers.setFirstAnswer(scanner.next().charAt(0));
                testEgzamTrueAnswerService.update(testEgzamTrueAnswers);
                break;
            case 2:
                System.out.println("Set second question:");
                testEgzamTrueAnswers.setFirstQuestion(scanner.next());
                System.out.println("Set correct answer to question two");
                testEgzamTrueAnswers.setFirstAnswer(scanner.next().charAt(0));
                testEgzamTrueAnswerService.update(testEgzamTrueAnswers);
                break;
            case 3:
                System.out.println("Set third question:");
                testEgzamTrueAnswers.setFirstQuestion(scanner.next());
                System.out.println("Set correct answer to question three");
                testEgzamTrueAnswers.setFirstAnswer(scanner.next().charAt(0));
                testEgzamTrueAnswerService.update(testEgzamTrueAnswers);
                break;
            case 4:
                System.out.println("Set fourth question:");
                testEgzamTrueAnswers.setFirstQuestion(scanner.next());
                System.out.println("Set correct answer to question four");
                testEgzamTrueAnswers.setFirstAnswer(scanner.next().charAt(0));
                testEgzamTrueAnswerService.update(testEgzamTrueAnswers);
                break;
            case 5:
                System.out.println("Set fifth question:");
                testEgzamTrueAnswers.setFirstQuestion(scanner.next());
                System.out.println("Set correct answer to question five");
                testEgzamTrueAnswers.setFirstAnswer(scanner.next().charAt(0));
                testEgzamTrueAnswerService.update(testEgzamTrueAnswers);
                break;
            default:
                System.out.println("Invalid value... Returning to menu...");
                break;

        }
    }

    private void logIn(Scanner scanner) {
        System.out.println("Enter user ID:");
        Long studentId = scanner.nextLong();
        StudentService studentService = new StudentService();
        Student student = studentService.getStudent(studentId);
        studentMenu(student, scanner);
    }

    private void studentMenu(Student student, Scanner scanner) {
        while (true){
            System.out.println("1. Solve an exam");
            System.out.println("2. Check results");
            System.out.println("3. Check statistics");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    solveExam(student,scanner);
                    break;
                case 2:
                    checkExamResults (student);
                    break;
                case 3:
                    checkStatistics (student);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Entered an invalid value");
                    break;
            }

        }
    }

    private void checkStatistics(Student student) {
        StatisticsService statisticsService = new StatisticsService();
        Statistics statistics = statisticsService.getStatistics(student.getId());
        if (statistics == null){
            System.out.println("No statistics found");
            return;
        }
        System.out.println(statistics.toString());
    }

    private void checkExamResults(Student student) {
        ResultService resultService = new ResultService();
        Result result = resultService.getResult(student.getId());
        if (result == null){
            System.out.println("No results found");
            return;
        }
        System.out.println(result.getExam().toString() + "\n Result: " + result.getResult());
    }

    private void solveExam(Student student, Scanner scanner) {
        System.out.println("Pasirinkite egzamina pagal ID:");
        showTests();
        Long examID = scanner.nextLong();
        EgzamService egzamService = new EgzamService();
        Exam exam = egzamService.getExam(examID);
        TestEgzamTrueAnswerService testEgzamTrueAnswerService = new TestEgzamTrueAnswerService();
        TestEgzamTrueAnswers testEgzamTrueAnswers = testEgzamTrueAnswerService.getTestEgzamTrueAnswers(examID);
        System.out.println(testEgzamTrueAnswers.getFirstQuestion());
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        char firstAnswer;
        while (true) {
            firstAnswer = scanner.next().toUpperCase(Locale.ROOT).charAt(0);
                if (firstAnswer == 'A' || firstAnswer == 'B' || firstAnswer == 'C')
                    break;
            System.out.println("Wrong value entered");

        }
        System.out.println(testEgzamTrueAnswers.getSecondQuestion());
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        char secondAnswer;
        while (true) {
            secondAnswer = scanner.next().toUpperCase(Locale.ROOT).charAt(0);
            if (secondAnswer == 'A' || secondAnswer == 'B' || secondAnswer == 'C')
                break;
            System.out.println("Wrong value entered");

        }
        System.out.println(testEgzamTrueAnswers.getThirdQuestion());
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        char thirdAnswer;
        while (true) {
            thirdAnswer = scanner.next().toUpperCase(Locale.ROOT).charAt(0);
            if (thirdAnswer == 'A' || thirdAnswer == 'B' || thirdAnswer == 'C')
                break;
            System.out.println("Wrong value entered");

        }
        System.out.println(testEgzamTrueAnswers.getFourthQuestion());
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        char fourthAnswer;
        while (true) {
            fourthAnswer = scanner.next().toUpperCase(Locale.ROOT).charAt(0);
            if (fourthAnswer == 'A' || fourthAnswer == 'B' || fourthAnswer == 'C')
                break;
            System.out.println("Wrong value entered");
        }
        System.out.println(testEgzamTrueAnswers.getFifthQuestion());
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        char fifthAnswer;
        while (true) {
            fifthAnswer = scanner.next().toUpperCase(Locale.ROOT).charAt(0);
            if (fifthAnswer == 'A' || fifthAnswer == 'B' || fifthAnswer == 'C')
                break;
            System.out.println("Wrong value entered");

        }
        StatisticsService statisticsService = new StatisticsService();
        TestEgzamAnswersService testEgzamAnswersService = new TestEgzamAnswersService();
        TestEgzamAnswers testEgzamAnswers = new TestEgzamAnswers(firstAnswer,secondAnswer, thirdAnswer, fourthAnswer, fifthAnswer,exam, student);
        testEgzamAnswersService.createTestEgzamAnswers(testEgzamAnswers);
        ResultService resultService = new ResultService();
        Result result = resultService.getResult(student.getId());
        Statistics statistics = updateStatistics (testEgzamAnswers, student ,testEgzamTrueAnswers, exam, statisticsService);
        if (resultService.getResult(student.getId()) != null){
            resultService.update(exam,student, getResult(testEgzamAnswers,testEgzamTrueAnswers,exam,student).getResult(), student.getId());
        } else {
            resultService.createResult(student,exam,getResult(testEgzamAnswers,testEgzamTrueAnswers,exam,student).getResult());
        }
        if (statisticsService.getStatistics(student.getId()) != null){
            statisticsService.update(student,exam,statistics);
        } else {
            statisticsService.createStatistics(student,exam,statistics);
        }
    }

    private Statistics updateStatistics(TestEgzamAnswers testEgzamAnswers, Student student, TestEgzamTrueAnswers testEgzamTrueAnswers, Exam exam, StatisticsService statisticsService) {
        Statistics statistics;
        if (statisticsService.getStatistics(student.getId()) != null){
        statistics = statisticsService.getStatistics(student.getId());
        statistics = updateAnswerStatistics(statistics, testEgzamAnswers, testEgzamTrueAnswers);
        statisticsService.update(student,exam,statistics);
            return statistics;
    } else{
            Statistics statistics1 = new Statistics();
            statistics1 = updateAnswerStatistics(statistics1, testEgzamAnswers, testEgzamTrueAnswers);
            statisticsService.createStatistics(student,exam,statistics1);
            return statistics1;
        }

    }

    private Statistics updateAnswerStatistics(Statistics statistics, TestEgzamAnswers testEgzamAnswers, TestEgzamTrueAnswers testEgzamTrueAnswers) {
        statistics.setAmountOfEgzamsDone(statistics.getAmountOfEgzamsDone()+1);
        if (testEgzamAnswers.getFirstAnswer() == testEgzamTrueAnswers.getFirstAnswer()){
            statistics.setTotalAmountOfCorrectAnswersInTestExam(statistics.getTotalAmountOfCorrectAnswersInTestExam()+1);
            statistics.setTotalAmountOfCorrectAnswers(statistics.getTotalAmountOfCorrectAnswers()+1);
        }
        if (testEgzamAnswers.getSecondAnswer() == testEgzamTrueAnswers.getSecondAnswer()){
            statistics.setTotalAmountOfCorrectAnswersInTestExam(statistics.getTotalAmountOfCorrectAnswersInTestExam()+1);
            statistics.setTotalAmountOfCorrectAnswers(statistics.getTotalAmountOfCorrectAnswers()+1);
        }
        if (testEgzamAnswers.getThirdAnswer() == testEgzamTrueAnswers.getThirdAnswer()){
            statistics.setTotalAmountOfCorrectAnswersInTestExam(statistics.getTotalAmountOfCorrectAnswersInTestExam()+1);
            statistics.setTotalAmountOfCorrectAnswers(statistics.getTotalAmountOfCorrectAnswers()+1);
        }
        if (testEgzamAnswers.getFourthAnswer() == testEgzamTrueAnswers.getFourthAnswer()){
            statistics.setTotalAmountOfCorrectAnswersInTestExam(statistics.getTotalAmountOfCorrectAnswersInTestExam()+1);
            statistics.setTotalAmountOfCorrectAnswers(statistics.getTotalAmountOfCorrectAnswers()+1);
        }
        if (testEgzamAnswers.getFifthAnswer() == testEgzamTrueAnswers.getFifthAnswer()){
            statistics.setTotalAmountOfCorrectAnswersInTestExam(statistics.getTotalAmountOfCorrectAnswersInTestExam()+1);
            statistics.setTotalAmountOfCorrectAnswers(statistics.getTotalAmountOfCorrectAnswers()+1);
        }
        statistics.setAverageCorrectAnswersBetweenAllEgzams(statistics.getTotalAmountOfCorrectAnswers()/statistics.getAmountOfEgzamsDone());
        statistics = setAmountOfDifferentAnswers (statistics,testEgzamAnswers);
        return statistics;
    }

    private Statistics setAmountOfDifferentAnswers(Statistics statistics, TestEgzamAnswers testEgzamAnswers) {
        switch (testEgzamAnswers.getFirstAnswer()){
            case 'A':
                statistics.setAmountOfAChoices(statistics.getAmountOfAChoices() + 1);
                break;
            case 'B':
                statistics.setAmountOfBChoices(statistics.getAmountOfBChoices() + 1);
                break;
            case 'C':
                statistics.setAmountOfCChoices(statistics.getAmountOfCChoices() + 1);
                break;
        }
        switch (testEgzamAnswers.getSecondAnswer()){
            case 'A':
                statistics.setAmountOfAChoices(statistics.getAmountOfAChoices() + 1);
                break;
            case 'B':
                statistics.setAmountOfBChoices(statistics.getAmountOfBChoices() + 1);
                break;
            case 'C':
                statistics.setAmountOfCChoices(statistics.getAmountOfCChoices() + 1);
                break;
        }
        switch (testEgzamAnswers.getThirdAnswer()){
            case 'A':
                statistics.setAmountOfAChoices(statistics.getAmountOfAChoices() + 1);
                break;
            case 'B':
                statistics.setAmountOfBChoices(statistics.getAmountOfBChoices() + 1);
                break;
            case 'C':
                statistics.setAmountOfCChoices(statistics.getAmountOfCChoices() + 1);
                break;
        }
        switch (testEgzamAnswers.getFourthAnswer()){
            case 'A':
                statistics.setAmountOfAChoices(statistics.getAmountOfAChoices() + 1);
                break;
            case 'B':
                statistics.setAmountOfBChoices(statistics.getAmountOfBChoices() + 1);
                break;
            case 'C':
                statistics.setAmountOfCChoices(statistics.getAmountOfCChoices() + 1);
                break;
        }
        switch (testEgzamAnswers.getFifthAnswer()){
            case 'A':
                statistics.setAmountOfAChoices(statistics.getAmountOfAChoices() + 1);
                break;
            case 'B':
                statistics.setAmountOfBChoices(statistics.getAmountOfBChoices() + 1);
                break;
            case 'C':
                statistics.setAmountOfCChoices(statistics.getAmountOfCChoices() + 1);
                break;
        }
    return statistics;
    }

    private Result getResult (TestEgzamAnswers testEgzamAnswers, TestEgzamTrueAnswers testEgzamTrueAnswers, Exam exam, Student student){
        Result result = new Result();
        double examResult = 0;
        if (testEgzamAnswers.getFirstAnswer() == testEgzamTrueAnswers.getFirstAnswer()){
            examResult +=2;
        }
        if (testEgzamAnswers.getSecondAnswer() == testEgzamTrueAnswers.getSecondAnswer()){
            examResult += 2;
        }
        if (testEgzamAnswers.getThirdAnswer() == testEgzamTrueAnswers.getThirdAnswer()){
            examResult += 2;
        }
        if (testEgzamAnswers.getFourthAnswer() == testEgzamTrueAnswers.getFourthAnswer()){
            examResult += 2;
        }
        if (testEgzamAnswers.getFifthAnswer() == testEgzamTrueAnswers.getFifthAnswer()){
            examResult += 2;
        }
        result.setResult(examResult);
        result.setStudent(student);
        result.setExam(exam);
        return result;
    }

    private void createUser(Scanner scanner) {
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter surname");
        String surname = scanner.next();
        StudentService service = new StudentService();
        service.createStudent(name, surname);
    }
}
