import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * TDD-rules:
 * 1) write failing unit-test
 * 2) write no more than necessary for the test to fail (and not compiling is failing!)
 * 3) write no more methods and classes than necessary for the test to pass
 * <p>
 * rinse-and-repeat. Don't forget to refactor according to the clean-code principles!
 */
public class BowlingGameTest {

    private BowlingGame game;

    @BeforeEach
    public void setUp() {
        game = new BowlingGame();
    }

    @Test
    void canRollAllZeros() {
        rollBalls(20, 0);
        assertEquals(0, game.score(), "expected a game of all 0-rolls. Score should be 0");
    }

    @Test
    void canRollAllOnes() {
        rollBalls(20, 1);
        assertEquals(20, game.score(), "expected a game of all 1-rolls. Score should be 20");
    }

    @Test
    void canRollOneSpare() {
        rollSpare();
        game.rollBall(3);
        rollBalls(17, 0);
        assertEquals(16, game.score(), "expected a SPARE, followed by a roll of 3 and then all 0's. Score should be 16");
    }

    @Test
    void canRollStrike() {
        rollStrike();
        game.rollBall(3);
        game.rollBall(4);
        rollBalls(16, 0);
        assertEquals(24, game.score(), "expected a STRIKE, follewed by a roll of 3 and 4 and then all 0's. Score should be 24");
    }

    @Test
    void canRollAllStrikes() {
        rollBalls(12, 10);
        assertEquals(300, game.score(), "expected all STRIKES. Score should be 300");
    }

    private void rollStrike() {
        game.rollBall(10);
    }

    private void rollSpare() {
        game.rollBall(5);
        game.rollBall(5);
    }

    private void rollBalls(int ballsToRoleForEntireGame, int pinsToDownPerRoll) {
        for (int i = 0; i < ballsToRoleForEntireGame; i++) {
            game.rollBall(pinsToDownPerRoll);
        }
    }

}
