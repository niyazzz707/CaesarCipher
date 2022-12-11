module com.example.cipher {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cipher to javafx.fxml;
    exports com.example.cipher;
}