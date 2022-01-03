package com.jinu.project;

public class Baseball {
    private String answer;

    Baseball(String input) {
        this.answer = input;
    }


    String getAnswer() {
        return this.answer;
    }

    
    int[] guess(String assumption) {
        int strikeCount = this.countStrike(assumption);
        int ballCount = this.countBall(assumption);

        return new int[] { strikeCount, ballCount };
    }
    

    private int strike(String answer, char candidate, int index) {
        if (sameValueOnSamePlace(answer, candidate, index)) {
            return 1;
        }

        return 0;
    }

    
    private int ball(String answer, char candidate, int index) {
        if (sameValueOnWrongPlace(answer, candidate, index)) {
            return 1;
        }
        
        return 0;
    }
    

    private boolean sameValueOnSamePlace(String answer, char candidate, int index) {
        return answer.charAt(index) == candidate;
    }


    private boolean sameValueOnWrongPlace(String answer, char candidate, int index) {
        return (answer.indexOf(candidate) != -1) && (answer.indexOf(candidate) != index);
    }


    private int countStrike(String assumption) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            count += this.strike(answer, assumption.charAt(i), i);
        }

        return count;
    }

    private int countBall(String assumption) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            count += this.ball(answer, assumption.charAt(i), i);
        }

        return count;
    }

}
