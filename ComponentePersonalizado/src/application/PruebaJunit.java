package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.layout.Pane;

public class PruebaJunit {

    private Controlador controlador;
    private Pane pane;

    @BeforeEach
    void setUp() {
        controlador = new Controlador();
        pane = new Pane();
        controlador.setCuadrado(pane);
    }

    @Test
    void testColorAleatorio() {
        String color = controlador.colorAleatorio();
        assertNotNull(color, "El color generado no debe ser nulo");
        assertEquals(6, color.length(), "El color generado debe tener una longitud de 6 caracteres");

        // Verificar que solo contiene caracteres hexadecimales
        assertTrue(color.matches("[0-9a-fA-F]{6}"), "El color debe contener solo caracteres hexadecimales");
    }

    @Test
    void testAnimacion() {
        controlador.animacion(null);

        // Verificar que el color del panel se ha cambiado
        String estilo = controlador.getCuadrado().getStyle();
        assertTrue(estilo.matches("-fx-background-color: #[0-9a-fA-F]{6};"), "El estilo debe contener un color hexadecimal");

        // Verificar que la transformación de rotación se ha añadido
        assertEquals(1, controlador.getCuadrado().getTransforms().size(), "Debe haber una transformación de rotación añadida");
    }
}
