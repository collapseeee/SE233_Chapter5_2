package se233.chapter5part2;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se233.chapter5part2.model.Food;
import se233.chapter5part2.model.Snake;
import se233.chapter5part2.model.SpecialFood;

import static org.junit.jupiter.api.Assertions.*;

public class ScoringTest {
    private Snake snake;
    private Food food;
    private SpecialFood specialFood;
    @BeforeEach
    public void setUp() {
        snake = new Snake(new Point2D(0,0));
        food = new Food();
        specialFood = new SpecialFood();
    }
    @Test
    public void initialScore_shouldBeZero() {
        assertEquals(0, snake.getScore());
    }
    @Test
    public void collided_withRegularFood_shouldIncreaseScoreByOne() {
        int initialScore = snake.getScore();
        snake.collidedRegularFood();
        assertEquals(initialScore+1, snake.getScore(), "Snake eats regular food should increase score by 1");
    }
    @Test
    public void collided_withSpecialFood_shouldIncreaseScoreByFive() {
        int initialScore = snake.getScore();
        snake.collidedSpecialFood();
        assertEquals(initialScore+5, snake.getScore(), "Snake eats regular food should increase score by 1");
    }
    @Test
    public void collided_withMultipleFoods_shouldIncreaseScoreCorrectly() {
        int initailScore = snake.getScore();
        snake.collidedRegularFood();
        snake.collidedSpecialFood();
        snake.collidedSpecialFood();
        snake.collidedRegularFood();
        assertEquals(12, snake.getScore(), "Snake eats Regular food, Special food, Special food, and Regular food should have score of 12");
    }
}
