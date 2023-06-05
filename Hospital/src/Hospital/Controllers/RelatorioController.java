/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hospital.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import Hospital.Dominio.Paciente;
import Hospital.Principal.Aplicacao;

public class RelatorioController implements Initializable {

 @FXML
 private Button btnRelatorio;
 @FXML
 private TextArea txtRelatorio;
 @FXML
 private Button btnVoltar;
 
 private int contarMulheresAlturaPeso() {
        int contadorMulheres = 0;
        List<Paciente> pacientes= DefaultController.pacientes;
        for (Paciente paciente : pacientes) {
            if (paciente.getGenero().equalsIgnoreCase("Feminino") && paciente.getAltura() >= 1.60 &&
                    paciente.getAltura() <= 1.70 && paciente.getPeso() > 70) {
                contadorMulheres++;
            }
        }

        return contadorMulheres;
    }
  private int contarPessoasIdade() {
        int contadorPessoasIdade = 0;
        List<Paciente> pacientes= DefaultController.pacientes;
        for (Paciente paciente : pacientes) {
            if (paciente.getIdade() >= 18 && paciente.getIdade() <= 25) {
                contadorPessoasIdade++;
            }
        }

        return contadorPessoasIdade;
    }



    private double calcularMediaIdadeHomens() {
        int somaIdadeHomens = 0;
        int contadorHomens = 0;
        List<Paciente> pacientes= DefaultController.pacientes;
        for (Paciente paciente : pacientes) {
            if (paciente.getGenero().equalsIgnoreCase("Masculino")) {
                somaIdadeHomens += paciente.getIdade();
                contadorHomens++;
            }
        }

        if (contadorHomens > 0) {
            return (double) somaIdadeHomens / contadorHomens;
        } else {
            return 0;
        }
    }
    private String encontrarPacienteMaisVelho() {
        List<Paciente> pacientes= DefaultController.pacientes;
        if (pacientes.isEmpty()) {
            return "";
        }

        Paciente pacienteMaisVelho = Collections.max(pacientes);
        return pacienteMaisVelho.getNome();
    }
    private String encontrarMulherMaisBaixa() {
        List<Paciente> pacientes= DefaultController.pacientes;
        if (pacientes.isEmpty()) {
            return "";
        }

        List<Paciente> mulheres = new ArrayList<>();
        for (Paciente paciente : pacientes) {
            if (paciente.getGenero().equalsIgnoreCase("Feminino")) {
                mulheres.add(paciente);
            }
        }

        if (mulheres.isEmpty()) {
            return "";
        }

        Paciente mulherMaisBaixa = Collections.min(mulheres);
        return mulherMaisBaixa.getNome();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    
    public void btnVoltarClick(ActionEvent e){
        Aplicacao.mudarTela(1);
        
        }
    public void btnGerarRelatorio(ActionEvent e){
        List<Paciente> pacientes= DefaultController.pacientes;
        if (pacientes.size() > 0){
            String maisVelho= encontrarPacienteMaisVelho();
            String mulherBaixa= encontrarMulherMaisBaixa();
            double mediaHomens = calcularMediaIdadeHomens();
            int pacientesTamanho = pacientes.size();
            int mulheresPeso = contarMulheresAlturaPeso();
            int contarPessoasIdade= contarPessoasIdade();
            Collections.sort(pacientes);
            String nomes = "";
        
            txtRelatorio.setText("\n");
            for(Paciente paciente : pacientes){
                nomes+= paciente.getNome()+ "\n";
        }
            txtRelatorio.setText( 
                "Mulher mais Baixa: " + mulherBaixa + "\n" + 
                "Paciente Mais velho: " + maisVelho + "\n" +
                "Pessoas com idade entre 18 e 25: " + contarPessoasIdade  + "\n" +
                "Mulheres com altura entre 1,60 e 1,70 e peso acima de 70kg: " + mulheresPeso + "\n"  +
                "Quantidade de Pacientes: "+ pacientesTamanho + "\n" +
                "Media de idade do genero Maculino: " + String.valueOf(mediaHomens) + "\n"  + 
                "Pacientes: \n" + nomes  );
       
        }else{
            txtRelatorio.setText("Nao existem pacientes cadastrados");
        }
        
         
    }
    
    
   
    
    
    
    
    
    
}
