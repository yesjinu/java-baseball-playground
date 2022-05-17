package study.baseball;

public class Baseball {
    public static final int PITCH_NUM = 3;
    private final String ANSWER;

    public Baseball(String answer) {
        this.ANSWER = answer;
    }

    public String guess(String guess) {
        Integer strikeCount = countStrike(ANSWER, guess);
        Integer ballCount = countBall(ANSWER, guess);

        return printResult(strikeCount, ballCount);
    }

    private String printResult(Integer strikeCount, Integer ballCount) {
        if (strikeCount > 0 && ballCount > 0) {
            return strikeCount + " Strike " + ballCount + " Ball";
        }
        if (strikeCount > 0) {
            return strikeCount + " Strike";
        }
        if (ballCount > 0) {
            return ballCount + " Ball";
        }

        return "nothing";
    }

    private Integer countStrike(String answer, String guess) {
        Integer strikeCount = 0;
        for (int i = 0; i < PITCH_NUM; i++) {
            char guessChar = guess.charAt(i);
            strikeCount += strike(answer, i, guessChar);
        }

        return strikeCount;
    }

    private Integer countBall(String answer, String guess) {
        Integer ballCount = 0;
        for (int i = 0; i < PITCH_NUM; i++) {
            char guessChar = guess.charAt(i);
            ballCount += ball(answer, i, guessChar);
        }

        return ballCount;
    }

    private Integer strike(String answer, Integer idx, char guess) {
        if (answer.charAt(idx) == guess) {
            return 1;
        }

        return 0;
    }

    private Integer ball(String answer, Integer idx, char guess) {
        if (answer.indexOf(guess) != -1 && answer.charAt(idx) != guess) {
            return 1;
        }

        return 0;
    }
}
