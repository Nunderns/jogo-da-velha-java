import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JogoDaVelha extends JFrame implements ActionListener {
    private JButton[][] botoes = new JButton[3][3];
    private boolean jogadorX = true;

    public JogoDaVelha() {
        setTitle("Jogo da Velha");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j] = new JButton("");
                botoes[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                botoes[i][j].addActionListener(this);
                add(botoes[i][j]);
            }
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botaoClicado = (JButton) e.getSource();
        if (botaoClicado.getText().equals("")) {
            botaoClicado.setText(jogadorX ? "X" : "O");
            jogadorX = !jogadorX;
            verificarVencedor();
        }
    }

    private void verificarVencedor() {
        for (int i = 0; i < 3; i++) {
            if (!botoes[i][0].getText().equals("") &&
                botoes[i][0].getText().equals(botoes[i][1].getText()) &&
                botoes[i][1].getText().equals(botoes[i][2].getText())) {
                anunciarVencedor(botoes[i][0].getText());
            }

            if (!botoes[0][i].getText().equals("") &&
                botoes[0][i].getText().equals(botoes[1][i].getText()) &&
                botoes[1][i].getText().equals(botoes[2][i].getText())) {
                anunciarVencedor(botoes[0][i].getText());
            }
        }

        if (!botoes[0][0].getText().equals("") &&
            botoes[0][0].getText().equals(botoes[1][1].getText()) &&
            botoes[1][1].getText().equals(botoes[2][2].getText())) {
            anunciarVencedor(botoes[0][0].getText());
        }

        if (!botoes[0][2].getText().equals("") &&
            botoes[0][2].getText().equals(botoes[1][1].getText()) &&
            botoes[1][1].getText().equals(botoes[2][0].getText())) {
            anunciarVencedor(botoes[0][2].getText());
        }
    }

    private void anunciarVencedor(String vencedor) {
        JOptionPane.showMessageDialog(this, "Jogador " + vencedor + " venceu!");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j].setText("");
            }
        }
        jogadorX = true;
    }

    public static void main(String[] args) {
        new JogoDaVelha();
    }
}
