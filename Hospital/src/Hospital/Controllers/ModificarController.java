/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hospital.Controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static Hospital.Controllers.DefaultController.alterarPaciente;
import Hospital.Dominio.Paciente;
import Hospital.Principal.Aplicacao;
import javax.swing.JOptionPane;

/**
 * Controlador para a tela de modificação de pacientes
 */
public class ModificarController implements Initializable {

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnConsultar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltarExcluir;

    @FXML
    private TextField txtAltura;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPeso;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnSalvar.setOpacity(0);
        btnSalvar.setDisable(true);
    }

    @FXML
    void btnSalvarClick(ActionEvent event) {
        Paciente pacienteConsulta = new Paciente();
        int indice;
        for (Paciente paciente : DefaultController.pacientes) {
            if (paciente.getCodigo() == Integer.parseInt(txtCodigo.getText())) {
                indice = DefaultController.pacientes.indexOf(paciente);
                pacienteConsulta.setAltura(Double.parseDouble(txtAltura.getText()));
                pacienteConsulta.setPeso(Double.parseDouble(txtPeso.getText()));
                pacienteConsulta.setIdade(Integer.parseInt(txtIdade.getText()));
                pacienteConsulta.setCodigo(Integer.parseInt(txtCodigo.getText()));
                pacienteConsulta.setGenero(txtGenero.getText());
                pacienteConsulta.setNome(txtNome.getText());
                alterarPaciente(indice, pacienteConsulta);
                JOptionPane.showMessageDialog(null, "Paciente Alterado Com sucesso");
            }
        }

        btnSalvar.setOpacity(0);
        btnSalvar.setDisable(true);
        btnAlterar.setOpacity(1);
        btnAlterar.setDisable(false);
        limparCampos();

    }

    @FXML
    void btnAlterarPaciente(ActionEvent event) {

        desativarEditableCampos(true);
        desativarCampos(false);
        btnSalvar.setOpacity(1);
        btnSalvar.setDisable(false);
        btnAlterar.setOpacity(0);
        btnAlterar.setDisable(true);
    }

    @FXML
    void btnConsultarPaciente(ActionEvent event) {
        Paciente pacienteConsulta = new Paciente();
        int indice;
        for (Paciente paciente : DefaultController.pacientes) {
            if (paciente.getCodigo() == Integer.parseInt(txtCodigo.getText())) {
                indice = DefaultController.pacientes.indexOf(paciente);
                pacienteConsulta = DefaultController.pacientes.get(indice);
                txtNome.setText(pacienteConsulta.getNome());
                txtPeso.setText(String.valueOf(pacienteConsulta.getPeso()));
                txtIdade.setText(String.valueOf(pacienteConsulta.getIdade()));
                txtGenero.setText(pacienteConsulta.getGenero());
                txtAltura.setText(Double.toString(pacienteConsulta.getAltura()));
            }
        }

        desativarEditableCampos(false);
        desativarCampos(true);
    }

    @FXML
    void btnExcluirPaciente(ActionEvent event) {
        Paciente pacienteConsulta = new Paciente();
        int indice;
        for (Paciente paciente : DefaultController.pacientes) {
            if (paciente.getCodigo() == Integer.parseInt(txtCodigo.getText())) {
                indice = DefaultController.pacientes.indexOf(paciente);
                DefaultController.pacientes.remove(indice);
                JOptionPane.showMessageDialog(null, "Paciente Excluido Com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Nao foi possivel Excluir o Paciente!");
            }
        }

        limparCampos();

    }

    @FXML
    void btnVoltarClick(ActionEvent event) {
        Aplicacao.mudarTela(1);
        limparCampos();
    }

    private void limparCampos() {
        txtCodigo.clear();
        txtNome.clear();
        txtIdade.clear();
        txtAltura.clear();
        txtPeso.clear();
        txtGenero.clear();
    }

    private void desativarEditableCampos(boolean a) {
        txtNome.setEditable(a);
        txtIdade.setEditable(a);
        txtAltura.setEditable(a);
        txtPeso.setEditable(a);
        txtGenero.setEditable(a);
    }

    private void desativarCampos(boolean a) {
        txtNome.setDisable(a);
        txtIdade.setDisable(a);
        txtAltura.setDisable(a);
        txtPeso.setDisable(a);
        txtGenero.setDisable(a);
    }
}
