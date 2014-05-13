/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emsimclient;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import jdk.nashorn.api.scripting.JSObject;

/**
 *
 * @author Администратор
 */
class MapViewer extends Region {

    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
    MenuBar menuBar = new MenuBar();
    VBox parametrsPane = new VBox();
    Button b = new Button("Push");
    String url = "";
    List<ObjectInstance> list = new ArrayList<>();

    private void addObject() {
        final Stage dialogStage = new Stage(StageStyle.UTILITY);
        dialogStage.setResizable(false);
        dialogStage.initModality(Modality.NONE);
        dialogStage.setTitle("Добавление потенциально опасного объекта");

        Button ok = new Button("Ok");
        Button cancel = new Button("Отмена");
        ok.setTranslateX(-40);
        cancel.setTranslateX(40);

        Label titleLabel = new Label("Название объекта");
        Label probLabel = new Label("Вероятность аварии (от 0 до 1)");
        Label radiusLabel = new Label("Радиус поражения, м");
        Label speedLabel = new Label("Скорость распространения, м/с");

        final TextField titleField = new TextField("Завод");
        final TextField probField = new TextField("0.01");
        final TextField radiusField = new TextField("1000");
        final TextField speedField = new TextField("20");

        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try {
                    String title = titleField.getText();
                    double prob = Double.parseDouble(probField.getText());
                    double radius = Double.parseDouble(radiusField.getText());
                    double speed = Double.parseDouble(speedField.getText());
                    ObjectInstance instance = new ObjectInstance(title, prob, radius, speed);
                    list.add(instance);

                    dialogStage.close();

                } catch (NumberFormatException ex) {
                }

            }
        });
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                dialogStage.close();
            }
        });

        dialogStage.setScene(new Scene(VBoxBuilder.create().
                prefHeight(200).prefWidth(320).
                children(titleLabel, titleField, probLabel, probField,
                radiusLabel, radiusField, speedLabel, speedField,
                HBoxBuilder.create().children(ok, cancel).alignment(Pos.CENTER).padding(new Insets(5)).build()).
                alignment(Pos.CENTER).padding(new Insets(5)).build()));
        dialogStage.show();
        
    }

    public MapViewer() {

        webEngine.load(getClass().getResource("/html/map.html").toExternalForm());
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        menuBar.getMenus().add(file);
        menuBar.getMenus().add(edit);

        browser.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent t) {
                addObject();
                try {
                    JSObject jsObject = (JSObject) webEngine.executeScript("addMarker(layer_markers, 30.32, 59.95,\"Incident 1\");");

                } catch (Exception ex) {
                }
                //jsObject.call("test", new ArrayList(1, 2, 3));

            }
        });



        b.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event t) {
               
            }
        });

        parametrsPane.getChildren().add(new Label("Some data will be here..."));

        b.setTranslateX(150);
        b.setTranslateY(500);
        parametrsPane.getChildren().add(b);
        parametrsPane.setMinWidth(200);


        getChildren().add(browser);
        getChildren().add(menuBar);
        getChildren().add(parametrsPane);
    }

    @Override
    protected void layoutChildren() {

        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //   incidents = ClientRequest.runRequest(url, null);
            }
        });

        double w = getWidth();
        double h = getHeight();
        double ppWidth = 200;
        double mmHeight = 22;
        layoutInArea(menuBar, 0, 0, w, mmHeight, 0, HPos.CENTER, VPos.CENTER);
        layoutInArea(parametrsPane, 0, mmHeight, ppWidth, h, 0, HPos.CENTER, VPos.CENTER);
        layoutInArea(browser, ppWidth, mmHeight, w, h, 0, HPos.CENTER, VPos.CENTER);

    }

    @Override
    protected double computePrefWidth(double height) {
        return 800;
    }

    @Override
    protected double computePrefHeight(double width) {
        return 500;
    }
}
