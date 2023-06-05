    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hospital.Dominio;

public class Paciente implements Comparable<Paciente> {
    private int codigo;
    private String nome;
    private double peso;
    private String genero;
    private int idade;
    private double altura;
// Define o construtor vazio
    public Paciente() {
        
        this.codigo = 0;
        this.nome = "";
        this.peso = 0.0;
        this.genero = "";
        this.idade = 0;
        this.altura = 0.0;
    }

    public Paciente(int codigo, String nome, double peso, String genero, int idade, double altura) {
        this.codigo = codigo;
        this.nome = nome;
        this.peso = peso;
        this.genero = genero;
        this.idade = idade;
        this.altura = altura;
    }

    // Getters and setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this. genero =  genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // Comparable implementation

    @Override
    public int compareTo(Paciente outro) {
        return Integer.compare(this.idade, outro.idade);
 
    }
    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Gênero: " + genero +
                ", Idade: " + idade + ", Altura: " + altura + ", Peso: " + peso;
    }
}
