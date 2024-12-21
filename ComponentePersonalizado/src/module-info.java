module ComponentePersonalizado {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires org.junit.jupiter.api;
	requires junit;
	requires java.base;
	requires jdk.javadoc;
	requires testfx.junit;
	requires testfx.core;
	requires org.junit.platform.engine;
	
	opens application to javafx.graphics, javafx.fxml;
}
