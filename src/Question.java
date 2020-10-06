import java.util.ArrayList;

public abstract class Question {

    private String prompt;
    protected ArrayList<String> options;

    public Question(String prompt) {
        this.prompt = prompt;
        this.options = new ArrayList<>();
    }

    public abstract boolean isCorrect(String answer);

    public void displayPromptAndOption() {
        System.out.println(prompt);
        int optionNumber = 1;
        for (String option : options) {
            System.out.println(optionNumber + ": " + option);
            optionNumber++;
        }
    }
}
