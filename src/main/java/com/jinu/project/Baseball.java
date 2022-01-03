package com.jinu.project;

public class Baseball {
    private String answer;

    public Baseball(String input) {
        this.answer = input;
    }

    public String getAnswer() {
        return this.answer;
    }

    public int[] guess(String assumption) {
        int strikeCount = this.countStrike(assumption);
        int ballCount = this.countBall(assumption);

        return new int[] { strikeCount, ballCount };
    }
    
    private boolean isStrike(String answer, char candidate, int index) {
        return answer.charAt(index) == candidate;
    }

    private boolean isBall(String answer, char candidate, int index) {
        System.out.println(answer.indexOf(candidate));
        System.out.println(index);
        return (answer.indexOf(candidate) != -1) && (answer.indexOf(candidate) != index);
    }
    
    private int countStrike(String assumption) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (this.isStrike(answer, assumption.charAt(i), i)) {
                count++;
            }
        }

        return count;
    }

    private int countBall(String assumption) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (this.isBall(answer, assumption.charAt(i), i)) {
                count++;
            }
        }

        return count;
    }

}
