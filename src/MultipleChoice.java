import java.util.ArrayList;
import java.util.Scanner;

public class MultipleChoice extends Question{

    private ArrayList<String> answerSelection;
    private int correctAnswerIndex;

    public MultipleChoice(String questionText, int pointValue,
                          ArrayList<String> answerSelection,
                          int correctAnswerIndex) {
        super(questionText, pointValue);
        this.answerSelection = answerSelection;
        this.correctAnswerIndex = correctAnswerIndex;
        setPointValue(pointValue);
    }

    @Override
    public void displayAnswers() {
        for (int i = 0; i < answerSelection.size(); i++) {
            System.out.println(answerSelection.get(i));
        }
    }

    public boolean checkAnswer(int userAnswer) {
        if (userAnswer == correctAnswerIndex) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getScore() {
        Scanner answer = new Scanner(System.in);
        System.out.println("Please enter the number of the option you think is correct: ");
        String userInput = answer.nextLine();
        int result = Integer.parseInt(userInput);

        if (checkAnswer(result)) {
            return 1;
        } else {
            return 0;
        }
    }
}
