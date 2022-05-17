package study.baseball;

public class Baseball {
    public static final int PITCH_NUM = 3;
    private final String ANSWER;

    public Baseball(String answer) {
        this.ANSWER = answer;
    }

    public String guess(String guess) {
        // iterate each character of guess
        int strikeCount = countStrike(ANSWER, guess);
        int ballCount = countBall(ANSWER, guess);

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

    private Integer countStrike(String answer, String guess) {
        Integer strikeCount = 0;
        for (int i = 0; i < PITCH_NUM; i++) {
            char guessChar = guess.charAt(i);
            if (isStrike(answer, i, guessChar)) {
                strikeCount += 1;
            }
        }

        return strikeCount;
    }

    private Integer countBall(String answer, String guess) {
        Integer ballCount = 0;
        for (int i = 0; i < PITCH_NUM; i++) {
            char guessChar = guess.charAt(i);
            if (isBall(answer, i, guessChar)) {
                ballCount += 1;
            }
        }

        return ballCount;
    }

    private Boolean isStrike(String answer, Integer idx, char guess) {
        return answer.charAt(idx) == guess;
    }

    private Boolean isBall(String answer, Integer idx, char guess) {
        return answer.indexOf(guess) != -1 && answer.charAt(idx) != guess;
    }
}
