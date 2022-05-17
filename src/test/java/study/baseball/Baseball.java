package study.baseball;

public class Baseball {
    private final String ANSWER;

    public Baseball(String answer) {
        this.ANSWER = answer;
    }

    public String guess(String guess) {
        // iterate each character of guess
        int strikeCount = 0;
        int ballCount = 0;
        
        for (int i = 0; i < 3; i++) {
            char guessChar = guess.charAt(i);
            for (int j = 0; j < 3; j++) {
                char answerChar = ANSWER.charAt(j);

                if (guessChar == answerChar && i == j) {
                    strikeCount += 1;
                    break;
                } else if (guessChar == answerChar) {
                    ballCount += 1;
                    break;
                }
            }
        }

        String result = "";
        if (strikeCount > 0) {
            result = result + strikeCount + " Strike";
        }

        if (ballCount > 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result = result + ballCount + " Ball";
        }

        if (strikeCount == 0 && ballCount == 0) {
            return "nothing";
        }

        return result;
    }
}
