package gui;

import dominio.JogoDaForca;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Janela extends JFrame {
    private JButton botaoNovo;
    private JButton botaoConferir;
    private JButton botaoSair;

    private JLabel textoAcima;
    private JLabel textoAbaixo;

    private JTextField[] letrasPalavra;
    private JButton[] letrasTeclado;

    private JogoDaForca jogo;

    public Janela() {
        super("Jogo da Forca");
        jogo = new JogoDaForca();
        instanciarComponentes();
        adicionarComponentes();
        registrarHandlerDeEvento();
    }

    private void instanciarComponentes() {
        botaoNovo = new JButton("Novo jogo");
        botaoConferir = new JButton("Conferir");
        botaoSair = new JButton("Sair");

        textoAcima = new JLabel("Adivinhe a palavra");
        textoAbaixo = new JLabel("Você tem " + jogo.getNumTentativas() + " tentativas");

        letrasPalavra = new JTextField[7];
        for (int i = 0; i < letrasPalavra.length; i++) {
            letrasPalavra[i] = new JTextField(" ");
            letrasPalavra[i].setEditable(false);
        }

        String[] auxiliar = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
                "A", "S", "D", "F", "G", "H", "J", "K", "L", "Ç",
                "Z", "X", "C", "V", "B", "N", "M"};

        letrasTeclado = new JButton[27];
        for (int i = 0; i < letrasTeclado.length; i++) {
            letrasTeclado[i] = new JButton(auxiliar[i]);
        }
    }

    private void adicionarComponentes() {
        setLayout(new BorderLayout());
        add(textoAcima, BorderLayout.NORTH);
        add(textoAbaixo, BorderLayout.SOUTH);

        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(3, 1));
        JPanel norte = new JPanel(new GridLayout(1, 7));
        JPanel teclado = new JPanel(new GridLayout(3, 1));
        JPanel sul = new JPanel(new GridLayout(1, 3));

        for (JTextField campo : letrasPalavra) {
            norte.add(campo);
        }

        for (int i = 0; i < 10; i++) {
            teclado.add(letrasTeclado[i]);
        }
        for (int i = 10; i < 20; i++) {
            teclado.add(letrasTeclado[i]);
        }
        for (int i = 20; i < 27; i++) {
            teclado.add(letrasTeclado[i]);
        }

        sul.add(botaoNovo);
        sul.add(botaoConferir);
        sul.add(botaoSair);

        centro.add(norte);
        centro.add(teclado);
        centro.add(sul);

        add(centro, BorderLayout.CENTER);
    }

    private void registrarHandlerDeEvento() {
        botaoNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogo.sorteiaPalavraJogo();
                reiniciarJogo();
            }
        });

        botaoConferir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPane, "A palavra é: " + jogo.getPalavra(), "Palavra", JOptionPane.PLAIN_MESSAGE);
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        for (JButton botao : letrasTeclado) {
            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!botao.isEnabled()) {
                        return;
                    }
                    botao.setEnabled(false);
                    jogo.setNumTentativas(jogo.getNumTentativas() - 1);
                    char letra = botao.getText().charAt(0);
                    textoAbaixo.setText("Você tem " + jogo.getNumTentativas() + " tentativas");
                    ArrayList<Integer> posicoes = jogo.verificaLetra(letra);
                    atualizarLetrasPalavra(posicoes);
                    if (jogo.isVenceu()) {
                        finalizarJogo(true);
                    } else if (jogo.getNumTentativas() <= 0) {
                        finalizarJogo(false);
                    }
                }
            });
        }
    }

    private void atualizarLetrasPalavra(ArrayList<Integer> posicoes) {
        for (int i = 0; i < letrasPalavra.length; i++) {
            if (posicoes.contains(i)) {
                letrasPalavra[i].setText(String.valueOf(jogo.getPalavra().charAt(i)));

            } else if (!letrasPalavra[i].getText().equals(" ")) {
                // Mantém as letras previamente acertadas no JTextField
                letrasPalavra[i].setText(Character.toString(letrasPalavra[i].getText().charAt(0)));
            }
        }
    }
    

    private void reiniciarJogo() {
        for (JButton botao : letrasTeclado) {
            botao.setEnabled(true);
        }
        for (JTextField campo : letrasPalavra) {
            campo.setText(" ");
        }
        jogo.setNumTentativas(15);
        textoAbaixo.setText("Você tem 15 tentativas");
    }

    private void finalizarJogo(boolean venceu) {
        for (JButton botao : letrasTeclado) {
            botao.setEnabled(false);
        }
        if (venceu) {
            textoAcima.setText("Parabéns! Você venceu!");
        } else {
            textoAcima.setText("Você perdeu! A palavra era: " + jogo.getPalavra());
        }
    }

    public static void main(String[] args) {
        Janela janela = new Janela();
        janela.setSize(500, 450);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
