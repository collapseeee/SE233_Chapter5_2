package se233.chapter5part2.model;

import javafx.geometry.Point2D;
import se233.chapter5part2.view.GameStage;

import java.util.Random;

public class SpecialFood {
    private Point2D position;
    private Random rn;
    private static final int SPECIAL_FOOD_SCORE = 5;

    public SpecialFood(Point2D position) {
        this.rn = new Random();
        this.position = position;
    }
    public SpecialFood() {
        this.rn = new Random();
        this.position = new Point2D(rn.nextInt(GameStage.WIDTH), rn.nextInt(GameStage.HEIGHT));
    }
    public void respawn() {
        Point2D prev_position = this.position;
        do {
            this.position = new Point2D(rn.nextInt(GameStage.WIDTH), rn.nextInt(GameStage.HEIGHT));
        } while (prev_position == this.position);
    }
    public Point2D getPosition() {
        return position;
    }
    public int getPoints() { return SPECIAL_FOOD_SCORE; }
}
