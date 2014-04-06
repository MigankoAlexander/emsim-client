/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emsimclient;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author Администратор
 */
class MapViewer extends Region {
   
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
    MenuBar menuBar = new MenuBar();
    VBox parametrsPane = new VBox();
 
    public MapViewer() {       
   
        webEngine.load(getClass().getResource("/html/map.html").toExternalForm());
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        menuBar.getMenus().add(file);
        menuBar.getMenus().add(edit);
        
        parametrsPane.getChildren().add(new Label("Some data will be here..."));
//        Button b = new Button("Push");
//        b.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                //drawFigure(canvas.getGraphicsContext2D());
//                
//            }
//        });
//        parametrsPane.getChildren().add(b);
        parametrsPane.setMinWidth(200);
        
                
        getChildren().add(browser); 
        getChildren().add(menuBar); 
        getChildren().add(parametrsPane); 
    }
 
    @Override protected void layoutChildren() {

        double w = getWidth();
        double h = getHeight();
        double ppWidth = 200;
        double mmHeight = 22;
        layoutInArea(menuBar,0,0,w,mmHeight, 0, HPos.CENTER, VPos.CENTER);
        layoutInArea(parametrsPane,0,mmHeight, ppWidth, h,0,HPos.CENTER,VPos.CENTER);
        layoutInArea(browser,ppWidth,mmHeight,w,h,0, HPos.CENTER, VPos.CENTER);
        
    }
 
    @Override protected double computePrefWidth(double height) {
        return 800;
    }
 
    @Override protected double computePrefHeight(double width) {
        return 500;
    }
}
