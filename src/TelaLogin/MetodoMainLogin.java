/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TelaLogin;
import javax.swing.JFrame;
import DAO.JBDCConnect;
import TelaLogin.LoginTela;
/**
 *
 * @author dezinD
 */

public class MetodoMainLogin {
    public static void main(String[] args) {
        // Cria o JFrame principal
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1001, 536); // Ajuste o tamanho conforme necessário
        frame.setLocationRelativeTo(null); // Centraliza a janela

        // Adiciona o painel de login ao frame
        frame.add(new LoginTela());

        // Exibe o frame
        frame.setVisible(true);
    }
}