package se233.chapter5part2.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import se233.chapter5part2.model.Food;
import se233.chapter5part2.model.Snake;
import se233.chapter5part2.model.SpecialFood;

public class GameStage extends Pane {
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    public static final int TILE_SIZE = 10;
    private Canvas canvas;
    private KeyCode key;

    public GameStage() {
        this.setHeight(TILE_SIZE*HEIGHT);
        this.setWidth(TILE_SIZE*WIDTH);
        canvas = new Canvas(TILE_SIZE*WIDTH, TILE_SIZE*HEIGHT);
        this.getChildren().add(canvas);
    }
    public void render (Snake snake, Food food) {
        render(snake,food,null);
    }
    public void render(Snake snake, Food food, SpecialFood specialFood) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,0,WIDTH*TILE_SIZE, HEIGHT*TILE_SIZE);
        gc.setFill(Color.BLUE);
        snake.getBody().forEach(p -> {
            gc.fillRect(p.getX()*TILE_SIZE, p.getY()*TILE_SIZE, TILE_SIZE, TILE_SIZE);
        });
        gc.setFill(Color.RED);
        gc.fillRect(food.getPosition().getX()*TILE_SIZE, food.getPosition().getY()*TILE_SIZE, TILE_SIZE, TILE_SIZE);

        if (specialFood!=null) {
            gc.setFill(Color.GREEN);
            gc.fillRect(specialFood.getPosition().getX() * TILE_SIZE, specialFood.getPosition().getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        gc.setFill(Color.BLACK);
        gc.setFont(Font.font(12));
        gc.fillText("Score: " + snake.getScore(), 5, 15);
    }
    public KeyCode getKey() { return key; }
    public void setKey(KeyCode key) { this.key = key; }
}
