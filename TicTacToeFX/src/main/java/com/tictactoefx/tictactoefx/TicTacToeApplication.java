package com.tictactoefx.tictactoefx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TicTacToeApplication extends Application {
    private ArrayList<Button> buttons;
    private boolean xTurn;
    private boolean finished;
    private Label turn;

    public TicTacToeApplication() {
        this.xTurn = true;
        this.finished = false;
        this.turn = new Label("Turn: X");
        this.turn.setFont(new Font(30.0));
        this.buttons = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            Button button = new Button(" ");
            button.setPrefSize(100, 100);
            button.setFont(Font.font("Monospaced", 30));
            buttons.add(button);

        }
    }
    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        layout.setPrefSize(200, 300);

        this.turn.setFont(new Font(30.0));

        GridPane buttonGrid = new GridPane();
        buttonGrid.setPrefSize(10, 20);
        buttonGrid.setHgap(10);
        buttonGrid.setVgap(10);
        addButtonsToGrid(buttonGrid);

        layout.setTop(this.turn);
        layout.setCenter(buttonGrid);

        for (Button b : this.buttons) {
            b.setOnAction((event) -> {
                if (this.xTurn) {
                    b.setText("X");
                    b.setDisable(true);
                    if (checkGameStateForX()) {
                        for (Button bb : this.buttons) {
                            bb.setDisable(true);
                        }
                        this.turn.setText("X wins!");
                    } else {
                        this.turn.setText("Turn: O");
                        this.xTurn = false;
                    }
                } else {
                    b.setText("O");
                    b.setDisable(true);
                    if (checkGameStateForO()) {
                        for (Button bb : this.buttons) {
                            bb.setDisable(true);
                        }
                        this.turn.setText("O Wins!");
                    } else {
                        this.turn.setText("Turn: X");
                        this.xTurn = true;
                    }
                }
            });
        }

        Scene view = new Scene(layout, 200, 300);
        window.setScene(view);
        window.show();
    }

    public void addButtonsToGrid(GridPane buttonGrid) {
        buttonGrid.add(buttons.get(0), 0, 0);
        buttonGrid.add(buttons.get(1), 0, 1);
        buttonGrid.add(buttons.get(2), 0, 2);
        buttonGrid.add(buttons.get(3), 1, 0);
        buttonGrid.add(buttons.get(4), 1, 1);
        buttonGrid.add(buttons.get(5), 1, 2);
        buttonGrid.add(buttons.get(6), 2, 0);
        buttonGrid.add(buttons.get(7), 2, 1);
        buttonGrid.add(buttons.get(8), 2, 2);
    }

    public boolean checkGameStateForX() {
        if (this.buttons.get(0).getText().equals("X") && this.buttons.get(1).getText().equals("X") && this.buttons.get(2).getText().equals("X")) {
            return true;
        }

        if (this.buttons.get(3).getText().equals("X") && this.buttons.get(4).getText().equals("X") && this.buttons.get(5).getText().equals("X")) {
            return true;
        }

        if (this.buttons.get(6).getText().equals("X") && this.buttons.get(7).getText().equals("X") && this.buttons.get(8).getText().equals("X")) {
            return true;
        }

        if (this.buttons.get(0).getText().equals("X") && this.buttons.get(3).getText().equals("X") && this.buttons.get(6).getText().equals("X")) {
            return true;
        }

        if (this.buttons.get(1).getText().equals("X") && this.buttons.get(4).getText().equals("X") && this.buttons.get(7).getText().equals("X")) {
            return true;
        }

        if (this.buttons.get(2).getText().equals("X") && this.buttons.get(5).getText().equals("X") && this.buttons.get(8).getText().equals("X")) {
            return true;
        }

        if (this.buttons.get(0).getText().equals("X") && this.buttons.get(4).getText().equals("X") && this.buttons.get(8).getText().equals("X")) {
            return true;
        }

        if (this.buttons.get(2).getText().equals("X") && this.buttons.get(4).getText().equals("X") && this.buttons.get(6).getText().equals("X")) {
            return true;
        }
        return false;
    }

    public boolean checkGameStateForO() {
        if (this.buttons.get(0).getText().equals("O") && this.buttons.get(1).getText().equals("O") && this.buttons.get(2).getText().equals("O")) {
            return true;
        }

        if (this.buttons.get(3).getText().equals("O") && this.buttons.get(4).getText().equals("O") && this.buttons.get(5).getText().equals("O")) {
            return true;
        }

        if (this.buttons.get(6).getText().equals("O") && this.buttons.get(7).getText().equals("O") && this.buttons.get(8).getText().equals("O")) {
            return true;
        }

        if (this.buttons.get(0).getText().equals("O") && this.buttons.get(3).getText().equals("O") && this.buttons.get(6).getText().equals("O")) {
            return true;
        }

        if (this.buttons.get(1).getText().equals("O") && this.buttons.get(4).getText().equals("O") && this.buttons.get(7).getText().equals("O")) {
            return true;
        }

        if (this.buttons.get(2).getText().equals("O") && this.buttons.get(5).getText().equals("O") && this.buttons.get(8).getText().equals("O")) {
            return true;
        }

        if (this.buttons.get(0).getText().equals("O") && this.buttons.get(4).getText().equals("O") && this.buttons.get(8).getText().equals("O")) {
            return true;
        }

        if (this.buttons.get(2).getText().equals("O") && this.buttons.get(4).getText().equals("O") && this.buttons.get(6).getText().equals("O")) {
            return true;
        }
        return false;
    }
}
