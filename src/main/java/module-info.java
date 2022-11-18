module ca.bcit.comp2522.termproject.teamkoko {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ca.bcit.comp2522.termproject.teamkoko to javafx.fxml;
    exports ca.bcit.comp2522.termproject.teamkoko;
}