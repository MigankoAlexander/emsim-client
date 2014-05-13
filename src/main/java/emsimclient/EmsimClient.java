/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emsimclient;

import java.io.File;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



/**
 *
 * @author Администратор
 */
public class EmsimClient extends Application {
    
    
    private Scene scene;
    
    @Override public void start(Stage stage) {
        
        stage.setTitle("    Курсовой проект по дисциплине АС. Миганько А.В., гр. 4803");
        scene = new Scene(new MapViewer(), 900, 600, Color.web("#666970"));
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args){
        launch(args);
    }
}
