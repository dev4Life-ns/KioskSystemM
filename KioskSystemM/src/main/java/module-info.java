module com.kmodern.kiosksystemm {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;

    requires java.sql;
    requires java.naming;
    requires transitive javafx.graphics;
    requires javafx.swing;
    requires transitive dbr;
    requires uk.co.caprica.vlcj;
    requires javafx.media;
    requires uk.co.caprica.vlcj.javafx;
    requires uk.co.caprica.vlcj.natives;
    requires com.sun.jna;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires com.sun.jna.platform;
    requires org.hibernate.commons.annotations;
    requires jakarta.persistence;


    opens com.kmodern.kiosksystemm to javafx.fxml;
    exports com.kmodern.kiosksystemm;
}