import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

    private ArrayList<Question> questions;
    private ArrayList<String> givenAnswers;
    private int numberCorrect;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.numberCorrect = 0;
        this.givenAnswers = new ArrayList<>();
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void takeQuiz() {
        Scanner in = new Scanner(System.in);
        for (Question q : questions) {
            q.displayPromptAndOption();
            System.out.println("Please enter your answer: ");
            String givenAnswer = in.nextLine();
            givenAnswers.add(givenAnswer);
        }
    }

    public void gradeQuiz() {
        int qNumber = 1;
        for (Question q : questions) {
            System.out.println("Question #" + qNumber);
            System.out.println("Your answer: " + givenAnswers.get(qNumber - 1));
            boolean correct = q.isCorrect(givenAnswers.get(qNumber - 1));
            if (correct) {
                numberCorrect++;
            }
            System.out.println("Correct: " + correct);
            qNumber++;
        }
    }

    public static void main(String[] args) {

        TrueFalse tf = new TrueFalse("True or false: John is cool?", true);
        MultipleChoice mc = new MultipleChoice("Which of these people is cool?", "John");
        mc.addOption("Luc");
        mc.addOption("John");
        mc.addOption("You");
        Checkbox cb = new Checkbox("Select all options that describe why John is cool.");

        cb.addAnswer("He knows how to code");
        cb.addAnswer("He plays guitar");

        cb.addOption("He knows how to code");
        cb.addOption("He can do a backflip");
        cb.addOption("He plays guitar");

        Quiz q = new Quiz();
        q.addQuestion(tf);
        q.addQuestion(mc);
        q.addQuestion(cb);
        q.takeQuiz();
        q.gradeQuiz();
    }
}
