package se233.chapter5part2;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.Test;
import se233.chapter5part2.model.Snake;

import static org.junit.jupiter.api.Assertions.*;

public class BoundaryCollisionTest {
    private Snake snake;

    @Test
    public void checkDead_atWidthBoundary_shouldReturnTrue() {
        snake = new Snake(new Point2D(30,0));
        assertTrue(snake.checkDead(), "Snake at x=30 should be dead");
    }
    @Test
    public void checkDead_atHeightBoundary_shouldReturnTrue() {
        snake = new Snake(new Point2D(0,30));
        assertTrue(snake.checkDead(), "Snake at y=30 should be dead");
    }
    @Test
    public void checkDead_atValidBoundary_shouldReturnFalse() {
        snake = new Snake(new Point2D(29,29));
        assertFalse(snake.checkDead(), "Snake at x=29 and y=29 should be alive");
    }
}
