package se233.chapter5part2;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se233.chapter5part2.model.Direction;
import se233.chapter5part2.model.Snake;

import static org.junit.jupiter.api.Assertions.*;

public class MovementRestrictionTest {
    private Snake snake;
    @BeforeEach
    public void setUp() {
        snake = new Snake(new Point2D(0,0));
        snake.setDirection(null);
    }
    @Test
    public void canChangeDirection_fromUpToDown_shouldReturnFalse() {
        snake.setDirection(Direction.UP);
        assertFalse(snake.canChangeDirection(Direction.DOWN));
    }
    @Test
    public void canChangeDirection_fromDownToUp_shouldReturnFalse() {
        snake.setDirection(Direction.DOWN);
        assertFalse(snake.canChangeDirection(Direction.UP));
    }
    @Test
    public void canChangeDirection_fromLeftToRight_shouldReturnFalse() {
        snake.setDirection(Direction.LEFT);
        assertFalse(snake.canChangeDirection(Direction.RIGHT));
    }
    @Test
    public void canChangeDirection_fromRightToLeft_shouldReturnFalse() {
        snake.setDirection(Direction.RIGHT);
        assertFalse(snake.canChangeDirection(Direction.LEFT));
    }
    @Test
    public void canChangeDirection_fromUpToLeft_shouldReturnTrue() {
        snake.setDirection(Direction.UP);
        assertTrue(snake.canChangeDirection(Direction.LEFT));
    }
    @Test
    public void canChangeDirection_fromDownToRight_shouldReturnTrue() {
        snake.setDirection(Direction.DOWN);
        assertTrue(snake.canChangeDirection(Direction.RIGHT));
    }
    @Test
    public void canChangeDirection_fromUpToUp_shouldReturnTrue() {
        snake.setDirection(Direction.UP);
        assertTrue(snake.canChangeDirection(Direction.UP));
    }
    @Test
    public void setDirection_withInvalid_shouldNotChangeDirection() {
        snake.setDirection(Direction.UP);
        Direction oldDirection = snake.getDirection();
        snake.setDirection(Direction.DOWN);
        assertEquals(oldDirection, snake.getDirection());
    }
    @Test
    public void setDirection_withValid_shouldChange() {
        snake.setDirection(Direction.LEFT);
        snake.setDirection(Direction.DOWN);
        assertEquals(Direction.DOWN, snake.getDirection());
    }
}
