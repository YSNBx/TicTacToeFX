module com.tictactoefx.tictactoefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.tictactoefx.tictactoefx to javafx.fxml;
    exports com.tictactoefx.tictactoefx;
}