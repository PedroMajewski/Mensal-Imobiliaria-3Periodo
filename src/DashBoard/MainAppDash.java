/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DashBoard;
import javax.swing.*;

public class MainAppDash {
    public static void main(String[] args) {
        // Criar uma instância do seu JPanel (DashBoard)
        DashBoard panel = new DashBoard(); 

        // Criar um JFrame para exibir o JPanel
        JFrame frame = new JFrame("Meu Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800); // Ajuste o tamanho para acomodar o gráfico
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela
        frame.add(panel); // Adiciona o JPanel ao JFrame
        frame.setVisible(true); // Torna a janela visível

        // Melhor prática: Garanta que a interface gráfica seja criada e manipulada no Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);  // Mostra a janela na thread de interface
            }
        });
    }
}
