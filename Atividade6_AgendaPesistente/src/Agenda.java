package agenda;

import java.util.HashMap;

public class Agenda {
private HashMap<String, Contato> contatos;
// Construtor
public Agenda() {
    this.contatos = new HashMap<>();
}

// Incluir contato
public void incluirContato(Contato contato) {
    contatos.put(contato.getNome(), contato);
}

// Alterar contato
public void alterarContato(String nome, Contato contato) throws ContatoInexistenteException {
    if (contatos.containsKey(nome)) {
        contatos.remove(nome);
        contatos.put(contato.getNome(), contato);
    } else {
        throw new ContatoInexistenteException();
    }
}

// Pesquisar contato
public Contato pesquisarContato(String nome) throws ContatoInexistenteException {
    if (contatos.containsKey(nome)) {
        return contatos.get(nome);
    } else {
        throw new ContatoInexistenteException();
    }
}

// Listar contatos
public void listarContatos() {
    System.out.println("Contatos na agenda:");
    for (Contato contato : contatos.values()) {
        System.out.println(contato.toString());
    }
}

// Getters e setters
public HashMap<String, Contato> getContatos() {
    return contatos;
}

public void setContatos(HashMap<String, Contato> contatos) {
    this.contatos = contatos;
}
}