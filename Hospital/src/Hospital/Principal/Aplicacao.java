    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package Hospital.Principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 *
 * @author gabri
 */
public class Aplicacao extends Application {
    private static Scene sceneJanelaPrincipal, sceneRelatorio,sceneModificar;
    private static Stage primaryStage;
    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader janelaprincipal = new FXMLLoader(getClass().getResource("/Hospital/GUI/JanelaPrincipal.fxml"));
        
        FXMLLoader relatorio = new FXMLLoader(getClass().getResource("/Hospital/GUI/Relatorio.fxml"));
        
        FXMLLoader modificar = new FXMLLoader(getClass().getResource("/Hospital/GUI/Modificar.fxml"));
        
        primaryStage = stage;
        
        primaryStage.setTitle("Hospital");
        Image icone = new Image("/Hospital/Icone.jpg");
        primaryStage.getIcons().add(icone);

        Parent parentJanelaPrincipal = janelaprincipal.load();
        Parent parentRelatorio= relatorio.load();   
        Parent parentModificar= modificar.load(); 
        sceneJanelaPrincipal = new Scene(parentJanelaPrincipal);
        
        sceneRelatorio = new Scene(parentRelatorio);
        
        sceneModificar= new Scene(parentModificar);
        
  
        stage.setScene(sceneJanelaPrincipal);
        stage.show();
        
    }
    
    public static void mudarTela(int opcao){
        switch(opcao){
            case 1:
                primaryStage.setScene(sceneJanelaPrincipal);
                break;
                        
            case 2:
                primaryStage.setScene(sceneRelatorio);
                break;
            case 3:
                primaryStage.setScene(sceneModificar);
                break;
        
        
        
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
