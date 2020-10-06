public class TrueFalse extends Question {

    private boolean correctAnswer;

    public TrueFalse(String prompt, boolean correctAnswer) {
        super(prompt);
        this.options.add("True");
        this.options.add("False");
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean isCorrect(String answer) {
        int answerOption = Integer.parseInt(answer);
        String givenAnswer = options.get(answerOption - 1);
        return givenAnswer.toLowerCase().equals("true") == correctAnswer;
    }
}
