import java.util.Random;

public class BowlingGame {

    private int[] allRolls = new int[21];
    private int currentRollIndex = 0;

    public void rollBall(int roll) {
        allRolls[currentRollIndex++] = roll;
    }

    public int score() {
        int score = 0;
        int firstBallInFrame = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(allRolls[firstBallInFrame])){
                score += 10 + nextTwoBallsForStrike(firstBallInFrame);
                firstBallInFrame++;
            } else if (isSpare(firstBallInFrame)) {
                score += 10 + nextBallsForSpare(firstBallInFrame);
                firstBallInFrame += 2;
            } else {
                score += twoNormalThrows(firstBallInFrame);
                firstBallInFrame += 2;
            }
        }
        return score;
    }

    private int twoNormalThrows(int firstBallInFrame) {
        return allRolls[firstBallInFrame] + allRolls[firstBallInFrame + 1];
    }

    private int nextBallsForSpare(int firstBallInFrame) {
        return allRolls[firstBallInFrame + 2];
    }

    private int nextTwoBallsForStrike(int firstBallInFrame) {
        return allRolls[firstBallInFrame + 1] + allRolls[firstBallInFrame + 2];
    }

    private boolean isStrike(int allRoll) {
        return allRoll == 10;
    }

    private boolean isSpare(int firstBallInFrame) {
        return allRolls[firstBallInFrame] + allRolls[firstBallInFrame + 1] == 10;
    }
}
