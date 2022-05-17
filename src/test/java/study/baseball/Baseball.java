package study.baseball;

public class Baseball {
    private final String ANSWER;

    public Baseball(String answer) {
        this.ANSWER = answer;
    }

    public String guess(String guess) {
        // iterate each character of guess
        int strikeCount = 0;
        
        for (int i = 0; i < guess.length(); i++) {
            char guessChar = guess.charAt(i);
            char answerChar = ANSWER.charAt(i);

            if (guessChar == answerChar) {
                strikeCount += 1;
            }
        }

        if (strikeCount > 0) return strikeCount + " Strike";

        return "nothing";
    }
}
