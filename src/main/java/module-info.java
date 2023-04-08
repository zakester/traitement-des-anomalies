module com.p.traitementanomalies {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    requires com.jfoenix;

    requires org.apache.poi.poi;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;

    requires org.apache.commons.text;

    opens com.p.traitementanomalies to javafx.fxml;
    exports com.p.traitementanomalies;
}