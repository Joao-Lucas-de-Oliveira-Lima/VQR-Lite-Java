module br.com.ufc.vqrlite {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.com.ufc.vqrlite to javafx.fxml;
    exports br.com.ufc.vqrlite;
}