import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChessBoard extends Application {

    final int size = 8; // size of the board

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane(); // create a grid pane
        Rectangle[][] squares = new Rectangle[size][size]; // create a two dimensional array of rectangles
        for (int row = 0; row < size; row++) { // loop through rows
            for (int col = 0; col < size; col++) { // loop through columns
                squares[row][col] = new Rectangle(); // create a rectangle and store it in the array
                Color color; // declare a color variable
                if ((row + col) % 2 == 0) { // if row and column are both even or odd
                    color = Color.WHITE; // set color to white
                } else {
                    color = Color.BLACK; // set color to black
                }
                squares[row][col].setFill(color); // fill the rectangle with color
                root.add(squares[row][col], col, row); // add the rectangle to the grid pane at col and row position
                squares[row][col].widthProperty().bind(root.widthProperty().divide(size)); // bind width to grid pane
                                                                                           // width divided by size
                squares[row][col].heightProperty().bind(root.heightProperty().divide(size)); // bind height to grid pane
                                                                                             // height divided by size
            }
        }

        Scene scene = new Scene(root, 400, 400); // create a scene with root as root node and 400x400 pixels

        primaryStage.setTitle("Chess Board"); // set title of stage
        primaryStage.setScene(scene); // set scene of stage
        primaryStage.show(); // show stage

    }

    public static void main(String[] args) {
        launch(args); // launch application
    }
}