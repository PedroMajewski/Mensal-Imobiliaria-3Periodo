/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package DashBoard;
import DAO.DashBoardConnect;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Map;

public class DashBoard extends javax.swing.JPanel {
    private DashBoardConnect banco;
    private javax.swing.JPanel graficoPanel; 

    public DashBoard() {
        initComponents(); 
    banco = new DashBoardConnect(); 
    banco.conectar();

    // Inicializa o graficoPanel antes de usá-lo
    graficoPanel = new javax.swing.JPanel();
    graficoPanel.setLayout(new GridLayout(1, 2, 10, 0)); // Uma linha, duas colunas, com espaço de 10px entre colunas
    
    // Inicializa os gráficos
    initPieChart();  // Adiciona o gráfico de pizza
    initBarChart();  // Adiciona o gráfico de barras

    // Define o layout do painel principal como BorderLayout
    setLayout(new BorderLayout());

    // Título do DashBoard
    JPanel titlePanel = new JPanel(); // Painel para o título
    titlePanel.setBackground(new java.awt.Color(11, 83, 182)); // Cor de fundo
    JLabel titleLabel = new JLabel("Dashboard de Imóveis", JLabel.CENTER);
    titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24)); // Tamanho da fonte
    titleLabel.setForeground(Color.WHITE); // Cor do texto
    titlePanel.add(titleLabel); // Adiciona o título no painel

    // Adiciona o título no topo do painel principal
    add(titlePanel, BorderLayout.NORTH);

    // Adiciona o painel com os gráficos no centro do painel principal
    add(graficoPanel, BorderLayout.CENTER);
    }

    private void initPieChart() {
         DefaultPieDataset dataset = new DefaultPieDataset();
Map<String, Integer> dadosImoveis = banco.buscarDadosImoveis();
for (Map.Entry<String, Integer> entry : dadosImoveis.entrySet()) {
    dataset.setValue(entry.getKey(), entry.getValue());
}

String titulo = "Distribuição dos Imóveis por Bairro - Total: " 
    + dadosImoveis.values().stream().mapToInt(Integer::intValue).sum();

JFreeChart chart = ChartFactory.createPieChart(titulo, dataset, true, true, false);

// Personalizações
PiePlot plot = (PiePlot) chart.getPlot();

// Define o gerador de rótulos com valor e porcentagem
plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
    "{0}: {1} ({2})", // Formato: Nome: Valor (Porcentagem)
    new DecimalFormat("0"), // Exibe o valor como inteiro
    new DecimalFormat("0.0%") // Exibe a porcentagem com uma casa decimal
));

plot.setLabelFont(new Font("Segoe UI", Font.PLAIN, 12));
plot.setSectionPaint("Bairro 1", new Color(93, 188, 210));
plot.setSectionPaint("Bairro 2", new Color(255, 203, 107));
plot.setSectionPaint("Bairro 3", new Color(244, 104, 128));

// Ajuste para o tamanho do gráfico
ChartPanel chartPanel = new ChartPanel(chart);
chartPanel.setPreferredSize(new Dimension(800, 500)); // Maior tamanho
graficoPanel.add(chartPanel); // Adiciona o gráfico no painel
graficoPanel.revalidate(); // Força a atualização do painel
    }
 private void initBarChart() {
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    Map<String, Integer> situacoesImoveis = banco.buscarSituacoesImoveis();

    // Adicionando dados ao dataset
    for (Map.Entry<String, Integer> entry : situacoesImoveis.entrySet()) {
        dataset.addValue(entry.getValue(), "Situações", entry.getKey());
    }

    JFreeChart barChart = ChartFactory.createBarChart(
        "Situação dos Imóveis", // Título
        "Situação", // Eixo X
        "Quantidade", // Eixo Y
        dataset,
        org.jfree.chart.plot.PlotOrientation.VERTICAL, // Barras verticais
        true, // Exibir legenda
        true, // Tooltips
        false // URLs
    );

    // Configurações do plot do gráfico
    CategoryPlot plot = barChart.getCategoryPlot();
    plot.setDomainGridlinesVisible(false); // Oculta as linhas de grade do eixo X
    plot.setRangeGridlinePaint(Color.GRAY); // Cor das linhas de grade do eixo Y
    plot.setBackgroundPaint(Color.WHITE); // Fundo branco

    // Configurando o eixo X
    CategoryAxis domainAxis = plot.getDomainAxis();
    domainAxis.setCategoryLabelPositions(
        org.jfree.chart.axis.CategoryLabelPositions.STANDARD // Posições padrão
    );
    domainAxis.setTickLabelFont(new Font("Segoe UI", Font.PLAIN, 12));
    domainAxis.setLabelFont(new Font("Segoe UI", Font.BOLD, 14));

    // Configurando o eixo Y
    ValueAxis rangeAxis = plot.getRangeAxis();
    rangeAxis.setTickLabelFont(new Font("Segoe UI", Font.PLAIN, 12));
    rangeAxis.setLabelFont(new Font("Segoe UI", Font.BOLD, 14));

    // Configurando o renderer para barras
    BarRenderer renderer = new BarRenderer();
    renderer.setBarPainter(new org.jfree.chart.renderer.category.StandardBarPainter()); // Render padrão
    renderer.setSeriesPaint(0, new Color(93, 188, 210)); // Cor para a série 1
    renderer.setSeriesPaint(1, new Color(255, 203, 107)); // Cor para a série 2
    renderer.setSeriesPaint(2, new Color(244, 104, 128)); // Cor para a série 3
    renderer.setDrawBarOutline(false); // Remove contornos das barras
    renderer.setMaximumBarWidth(0.15); // Define a largura máxima das barras

    plot.setRenderer(renderer);

    // Adiciona o gráfico ao painel
    ChartPanel chartPanel = new ChartPanel(barChart);
    chartPanel.setPreferredSize(new Dimension(400, 400)); // Tamanho do painel
    graficoPanel.add(chartPanel);
    graficoPanel.revalidate(); // Força a atualização do painel
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1137, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
