package se233.chapter5part2;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se233.chapter5part2.model.SpecialFood;

import static org.junit.jupiter.api.Assertions.*;

public class SpecialFoodTest {
    private SpecialFood specialFood;
    @BeforeEach
    public void setUp() {
        specialFood = new SpecialFood(new Point2D(0,0));
    }
    @Test
    public void respawn_shouldBeOnNewPosition() {
        specialFood.respawn();
        assertNotSame(specialFood.getPosition(), new Point2D(0,0));
    }

}
