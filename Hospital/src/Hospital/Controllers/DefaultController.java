package Hospital.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import Hospital.Principal.Aplicacao;
import Hospital.Dominio.Paciente;

public class DefaultController implements Initializable {
    private static int nextCodigoPaciente = 0; // Variável estática para controlar o próximo código de paciente
    protected static List<Paciente> pacientes = new ArrayList<>(); // Lista de pacientes
    
    // Declaração dos componentes de interface gráfica mapeados do arquivo FXML
    @FXML
    private ComboBox<String> boxGenero;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnConsultar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnNovo;

    @FXML
    private Button btnRelatorio;

    @FXML
    private Button btnSair;

    @FXML
    private TextField txtAltura;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPeso;
    
    @FXML
    private Button btnImprimir;

    @FXML
    private Button btnVoltar;

    @FXML
    private TextArea txtRelatorio;
    
    // Método de ação para os botões
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String faceBotao = ((Button) event.getSource()).getText();
        switch (faceBotao) {
            case "Sair":
                System.exit(0);
                break;
            case "Novo":
                trocarParaIncluir();     
                break;
            case "Incluir":
                adicionarPaciente();
                trocarParaNovo();
                break;
            case "Remover":;
                break;
            default:
                break;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       pacientes = new ArrayList<>(); 
       carregarComboBox();
    }
    
    private void trocarParaNovo(){
        btnNovo.setText("Novo");
    }
    
    private void trocarParaIncluir(){
        btnNovo.setText("Incluir");
        nextCodigoPaciente++;
        txtCodigo.setText(String.valueOf(nextCodigoPaciente));
    }
    
    // Método para alterar um paciente na lista
    protected static void alterarPaciente(int indice, Paciente paciente) {
        pacientes.set(indice, paciente);
    }
    
    private void adicionarPaciente() {
        int codigo = nextCodigoPaciente;
        String nome = txtNome.getText();
        String genero = boxGenero.getValue();
        int idade = Integer.parseInt(txtIdade.getText());
        double altura = Double.parseDouble(txtAltura.getText());
        double peso = Double.parseDouble(txtPeso.getText());

        Paciente paciente = new Paciente(codigo, nome, peso, genero, idade, altura);
        pacientes.add(paciente);

        limparCampos();
    }

    private List<Paciente> ordenarPacientesPorIdade() {
        List<Paciente> pacientesOrdenados = new ArrayList<>(pacientes);
        Collections.sort(pacientesOrdenados);
        return pacientesOrdenados;
    }

    private void limparCampos() {
        txtCodigo.clear();
        txtNome.clear();
        txtIdade.clear();
        txtAltura.clear();
        txtPeso.clear();
        
        boxGenero.setValue(null);
    }
    
    private void carregarComboBox(){
       ObservableList<String> generoList = FXCollections.observableArrayList();
       generoList.add("Masculino");
       generoList.add("Feminino");
       generoList.add("Nao Binario");
       boxGenero.setItems(generoList);    
    }
    
    // Método para mudar para a tela de relatório
    public void btnRelatorioClick(ActionEvent e){
        Aplicacao.mudarTela(2);
    }
    
    // Método para mudar para a tela de exclusão
    public void btnExcluirClick(ActionEvent e){
        Aplicacao.mudarTela(3);
    }
}
