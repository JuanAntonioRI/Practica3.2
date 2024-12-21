package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controlador {

    @FXML
    private Pane cuadrado;

    private boolean animado = false;

    @FXML
    public void animacion(MouseEvent event) {
    	
        if (!animado) {
            animado = true;

            // Cambio el color del panel
            cuadrado.setStyle("-fx-background-color: #" + colorAleatorio() + ";");

            // Crear una nueva rotación de 45 grados
            Rotate rotate = new Rotate(45, cuadrado.getWidth() / 2, cuadrado.getHeight() / 2);
            cuadrado.getTransforms().add(rotate);

            // utilizo timeline para hacer una animacion de pausa 
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                animado = false;
                cuadrado.getTransforms().clear();
            }));
            
            timeline.setCycleCount(1);
            timeline.play();
        }
    }

    public String colorAleatorio() {
    	
        StringBuilder color = new StringBuilder();
        
        //paso los enteros a hexadecimal
        
        for (int i = 0; i < 6; i++) {
            color.append(Integer.toHexString((int) (Math.random() * 16)));
        }
        
        return color.toString();
    }
    
    public Pane getCuadrado(){
    	return this.cuadrado;
    }

    public void setCuadrado(Pane cuadrado) { 
    	
    	this.cuadrado = cuadrado; 
    	
    }
}
