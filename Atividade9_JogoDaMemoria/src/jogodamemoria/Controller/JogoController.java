package jogodamemoria.Controller;

import Aplicacao.Aplicacao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

public class JogoController implements Initializable {

    @FXML
    private ToggleButton 
    btn00, btn01, btn02, btn03, btn04, btn05,
    btn10, btn11, btn12, btn13, btn14, btn15,
    btn20, btn21, btn22, btn23, btn24, btn25,
    btn30, btn31, btn32, btn33, btn34, btn35,
    btn40, btn41, btn42, btn43, btn44, btn45,
    btn50, btn51, btn52, btn53, btn54, btn55,
    btn60, btn61, btn62, btn63, btn64, btn65,
    btn70, btn71, btn72, btn73, btn74, btn75,
    btn80, btn81, btn82, btn83, btn84, btn85,
    btn90, btn91, btn92, btn93, btn94, btn95;

    private ToggleButton[][] tabuleiro;

    @FXML
    private Label lblPontos;

    private ToggleButton btn1;
    private ToggleButton btn2;
   
    Aplicacao aplicacao = new Aplicacao();
    
    
    @FXML
    void ToggleButtonClick(ActionEvent event) {
    ToggleButton btn = (ToggleButton) event.getSource();

    if (!btn.isSelected()) {
        return; // Se o botão não está selecionado, não faz nada
    }
    
    if (btn1 != null) {
        btn.setText("" + aplicacao.getNumerosBotoes().get(btn));
    }

    if (btn1 == null) {
        btn1 = btn;
        btn1.setText("" + aplicacao.getNumerosBotoes().get(btn1));
        return;
    }
   
    if (btn2 == null) {
        btn2 = btn;
       
        if (aplicacao.getNumerosBotoes().get(btn1).equals(aplicacao.getNumerosBotoes().get(btn2)) && btn1 != btn2) {
            
            
                btn1.setDisable(true);
                btn2.setDisable(true);
                aplicacao.somaPonto();
                lblPontos.setText("Pontos " + Integer.toString(aplicacao.getPontos()));

                if (aplicacao.getPontos() == 30) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Parabéns");
                    alert.setHeaderText(null);
                    alert.setContentText("Você ganhou!");
                    alert.showAndWait();
                    aplicacao.reiniciarJogo(tabuleiro, lblPontos);
                }
            
        } else {
            btn1.setSelected(false);
            btn2.setSelected(false);
            btn1.setText("?");
            btn2.setText("?");
        }
            
        btn1 = null;
        btn2 = null;
    }
}



    @FXML
    void btnNovoClick(ActionEvent event) { 
        aplicacao.iniciarJogo(tabuleiro, lblPontos);  
    }

    @FXML
    void btnSairClick(ActionEvent event) {
        System.exit(0);
    }
   
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabuleiro = new ToggleButton[][] {
            { btn00, btn01, btn02, btn03, btn04, btn05 },
            { btn10, btn11, btn12, btn13, btn14, btn15 },
            { btn20, btn21, btn22, btn23, btn24, btn25 },
            { btn30, btn31, btn32, btn33, btn34, btn35 },
            { btn40, btn41, btn42, btn43, btn44, btn45 },
            { btn50, btn51, btn52, btn53, btn54, btn55 },
            { btn60, btn61, btn62, btn63, btn64, btn65 },
            { btn70, btn71, btn72, btn73, btn74, btn75 },
            { btn80, btn81, btn82, btn83, btn84, btn85 },
            { btn90, btn91, btn92, btn93, btn94, btn95 }
        };
        aplicacao.iniciarJogo(tabuleiro, lblPontos);
        
    }
}
