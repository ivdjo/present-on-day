module com.ivana.presensi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;

    opens com.ivana.presensi to javafx.fxml;
    exports com.ivana.presensi;
    opens com.ivana.presensi.model to javafx.base;
}
