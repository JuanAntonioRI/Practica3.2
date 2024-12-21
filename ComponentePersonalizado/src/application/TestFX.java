package application;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.api.annotation.Stable;

import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class TestFX extends org.testfx.framework.junit.ApplicationTest {

    private Controlador controlador;

    @Stable
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        controlador = loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @BeforeEach
    public void setUp() {
        controlador = new Controlador();
    }

    @Test
    public void testPaneExists() {
        // Crear un robot de TestFX
        FxRobot robot = new FxRobot();

        Object cuadrado;
		// Buscar el panel con ID #cuadrado
        boolean pane = robot.lookup("#cuadrado").equals(cuadrado);

        // Verificar que el panel no es nulo
        assertNotNull(pane, "El panel debería existir");
    }
}
