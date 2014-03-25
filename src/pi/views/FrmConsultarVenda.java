package pi.views;

import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import static javax.swing.JOptionPane.showMessageDialog;
import net.sourceforge.openforecast.DataPoint;
import net.sourceforge.openforecast.DataSet;
import static net.sourceforge.openforecast.Forecaster.getBestForecast;
import net.sourceforge.openforecast.ForecastingModel;
import net.sourceforge.openforecast.Observation;
import static org.jfree.chart.ChartFactory.createBarChart3D;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import pi.controller.CadastrarVenda;
import static pi.controller.CadastrarVenda.getRendimentoVendaPorTrimestre;
import pi.controller.report.CreateReport;
import static pi.dao.DaoPessoaJuridica.getForInativos;
import static pi.dao.DaoPessoaJuridica.getFornecedor;
import static pi.dao.DaoPessoaJuridica.getFornecedorAtivo;
import static pi.dao.DaoVenda.getVENDAS;
import pi.model.ModelGrafico;

/**
 *
 * @author deyvid.fk
 */
public final class FrmConsultarVenda extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmConsultarVenda
     */
    public FrmConsultarVenda() {
        initComponents();
        popularGrafico();
        aviso.setText("A calculo de estimativa de lucro para o ano seguinte e baseado no lucro do ano anterior, sendo apenas uma estimativa e não um valor preciso podendo haver variações." + '\n');
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (getVENDAS().size() > 0) {
            criarGrafico(graficoList);
        }
    }
    private static final ArrayList<ModelGrafico> graficoList = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    private CategoryDataset createDataset(ArrayList<ModelGrafico> list) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (ModelGrafico modelGrafico : list) {

            dataset.addValue(modelGrafico.getValue(), modelGrafico.getLabel(), modelGrafico.getTitle());
        }
        return dataset;
    }

    public void criarGrafico(ArrayList<ModelGrafico> list) {
        CategoryDataset cds = createDataset(list);
        String titulo = "Vendas ";
        String eixoy = "Valores";
        String txt_legenda = "Ledenda:";
        boolean legenda = true;
        boolean tooltips = true;
        boolean urls = true;
        JFreeChart graf = createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
        ChartPanel myChartPanel = new ChartPanel(graf, true);
        myChartPanel.setSize(jPanel1.getWidth(), jPanel1.getHeight());
        myChartPanel.setVisible(true);
        jPanel1.removeAll();
        jPanel1.add(myChartPanel);
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cboAno = new javax.swing.JComboBox();
        aviso = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Vendas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1058, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        cboAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2013", "2012", "2011", "2010" }));

        aviso.setBackground(new java.awt.Color(255, 255, 255));
        aviso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton2.setText("Imprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Recalcular");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aviso, javax.swing.GroupLayout.DEFAULT_SIZE, 1113, Short.MAX_VALUE)
                        .addGap(87, 87, 87))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(cboAno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(cboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(aviso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (getVENDAS().size() > 0) {
            int ano = 2_013;
            if (cboAno.getSelectedIndex() == 0) {
                ano = 2_013;
            }

            if (cboAno.getSelectedIndex() == 1) {
                ano = 2_012;
            }

            if (cboAno.getSelectedIndex() == 2) {
                ano = 2_012;
            }

            if (cboAno.getSelectedIndex() == 3) {
                ano = 2_010;
            }

            HashMap<String, Object> parametros = new HashMap<>();
            DecimalFormat fmt = new DecimalFormat("#.##");
            DecimalFormat fmtDinDin = new DecimalFormat("R$ #,##0.00");
            double rentabilidade_1 = getRendimentoVendaPorTrimestre(1, 2, 3, ano);
            double rentabilidade_2 = getRendimentoVendaPorTrimestre(4, 5, 6, ano);
            double rentabilidade_3 = getRendimentoVendaPorTrimestre(7, 8, 9, ano);
            double rentabilidade_4 = getRendimentoVendaPorTrimestre(10, 11, 12, ano);

            double serie_1 = geraTextoscimoDaRentabilidade(rentabilidade_1, rentabilidade_2);
            double serie_2 = geraTextoscimoDaRentabilidade(rentabilidade_2, rentabilidade_3);
            double serie_3 = geraTextoscimoDaRentabilidade(rentabilidade_3, rentabilidade_4);

            parametros.put("LABEL_1", "Rentabilidade do 1 º trimestre de " + ano + " : " + fmtDinDin.format(rentabilidade_1));
            parametros.put("SERIE_1", rentabilidade_1);

            parametros.put("LABEL_2", "Rentabilidade do 2 º trimestre de " + ano + " : " + fmtDinDin.format(rentabilidade_2) + " com " + geraTexto(serie_1) + " de " + fmt.format(serie_1) + "% com base no trimestre anterior.");
            parametros.put("SERIE_2", rentabilidade_2);

            parametros.put("LABEL_3", "Rentabilidade do 3º trimestre de " + ano + " : " + fmtDinDin.format(rentabilidade_3) + " com " + geraTexto(serie_2) + " de " + fmt.format(serie_2) + "% com base no trimestre anterior.");
            parametros.put("SERIE_3", rentabilidade_3);

            parametros.put("LABEL_4", "Rentabilidade do 4º trimestre de " + ano + " : " + fmtDinDin.format(rentabilidade_4) + " com " + geraTexto(serie_3) + " de " + fmt.format(serie_3) + "% com base no trimestre anterior.");
            parametros.put("SERIE_4", rentabilidade_4);

            parametros.put("QUANT_FORNECEDORES_INATIVOS", getForInativos().size());
            parametros.put("QUANT_FORNECEDORES_ATIVOS", getFornecedorAtivo().size());
            parametros.put("TOTAL_REGISTRO", getFornecedor().size());
            ArrayList list = new ArrayList<>();
            list.add("");
            Thread relport = new Thread(new CreateReport(list, CreateReport.Templates.TMPL_VENDAS_GRAFICO, parametros), "Thread: Imprimir Fornecedor");
            relport.start();

            CadastrarVenda venda = new CadastrarVenda();
            /* Criar Observação de venda realizada no primeiro trimesmtre do ano. */
            Observation observacao1 = new Observation(serie_1);
            observacao1.setIndependentValue("serie", 1);

            /* Criar Observação de venda realizada no segundo trimesmtre do ano. */
            Observation observacao2 = new Observation(serie_2);
            observacao2.setIndependentValue("serie", 2);

            /* Criar Observação de venda realizada no terceiro trimesmtre do ano. */
            Observation observacao3 = new Observation(serie_3);
            observacao3.setIndependentValue("serie", 3);

            /* Criar Observação de venda realizada no quarto trimesmtre do ano. */
            Observation observacao4 = new Observation(0.0);
            observacao4.setIndependentValue("serie", 4);

            DataSet dataSet = new DataSet();

            /* Adicionar observações ao DataSet */
            dataSet.add(observacao1);
            dataSet.add(observacao2);
            dataSet.add(observacao3);
            dataSet.add(observacao4);

            /* Criar o modelo de previsão */
            ForecastingModel modelo = getBestForecast(dataSet);
            modelo.init(dataSet);

            /* Criar próximo ponto de previsão, o qual será previsto */
            DataPoint fcDataPoint = new Observation(0.0);
            fcDataPoint.setIndependentValue("serie", 5);

            /* Criar conjunto de dados de previsão e adicionar esses pontos de dados. */
            DataSet fcDataSet = new DataSet();
            fcDataSet.add(fcDataPoint);

            /* Gerar a previsão. */
            Iterator itt = fcDataSet.iterator();
            Double value;
            DataPoint dp = (DataPoint) itt.next();
            double forecastValue = dp.getDependentValue();
            value = forecastValue;
            modelo.forecast(fcDataPoint);
            parametros.put("LABEL_5", "Rentabilidade do 1º trimestre de " + (ano + 1) + "pode ter o " + geraTexto(serie_3) + " de " + fmt.format(fcDataPoint.getDependentValue()) + "% com base nos trimestres anteriores." + '\n');

        } else {
            showMessageDialog(null, "Não existem vendas realizadas no sistema.");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    public String geraTexto(double v1) {
        if (v1 > 0) {
            return "acréscimo";
        } else {
            return "decréscimo";
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (getVENDAS().size() > 0) {
            popularGrafico();
        } else {
            showMessageDialog(null, "Não existem vendas realizadas no sistema.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Calcula o acréscimo de rentabilidade em porcentagem de um trimestre para
     * outro.
     *
     * @param v1
     * @param v2
     * @return
     */
    public double geraTextoscimoDaRentabilidade(double v1, double v2) {
        // BigDecimal valor = new BigDecimal(();
        // valor.setScale(2, BigDecimal.ROUND_UP); //Seta o n° de casas decimais para 2 e o arredondamento para cima
        return (1 - (v1 / v2)) * 100;
    }

    public void popularGrafico() {

        int ano = 2_013;

        /* Obtém filtro (Ano) */
        if (cboAno.getSelectedIndex() == 0) {
            ano = 2_013;
        }

        if (cboAno.getSelectedIndex() == 1) {
            ano = 2_012;
        }

        if (cboAno.getSelectedIndex() == 2) {
            ano = 2_012;
        }

        if (cboAno.getSelectedIndex() == 3) {
            ano = 2_010;
        }

        /* End*/
        /**
         * Previsão *
         */
        /* Criar Observação de venda realizada no primeiro trimesmtre do ano. */
        Observation observacao1 = new Observation(getRendimentoVendaPorTrimestre(1, 2, 3, ano));
        observacao1.setIndependentValue("serie", 1);

        /* Criar Observação de venda realizada no segundo trimesmtre do ano. */
        Observation observacao2 = new Observation(getRendimentoVendaPorTrimestre(4, 5, 6, ano));
        observacao2.setIndependentValue("serie", 2);

        /* Criar Observação de venda realizada no terceiro trimesmtre do ano. */
        Observation observacao3 = new Observation(getRendimentoVendaPorTrimestre(7, 8, 9, ano));
        observacao3.setIndependentValue("serie", 3);

        /* Criar Observação de venda realizada no quarto trimesmtre do ano. */
        Observation observacao4 = new Observation(getRendimentoVendaPorTrimestre(10, 11, 12, ano));
        observacao4.setIndependentValue("serie", 4);

        DataSet dataSet = new DataSet();

        /* Adicionar observações ao DataSet */
        dataSet.add(observacao1);
        dataSet.add(observacao2);
        dataSet.add(observacao3);
        dataSet.add(observacao4);

        /* Criar o modelo de previsão */
        ForecastingModel modelo = getBestForecast(dataSet);
        modelo.init(dataSet);

        /* Criar próximo ponto de previsão, o qual será previsto */
        DataPoint fcDataPoint = new Observation(0.0);
        fcDataPoint.setIndependentValue("serie", 5);

        /* Criar conjunto de dados de previsão e adicionar esses pontos de dados. */
        DataSet fcDataSet = new DataSet();
        fcDataSet.add(fcDataPoint);

        /* Gerar a previsão. */
        Iterator itt = fcDataSet.iterator();
        Double value;
        DataPoint dp = (DataPoint) itt.next();
        double forecastValue = dp.getDependentValue();
        value = forecastValue;
        modelo.forecast(fcDataPoint);

        /**
         * End Previsão *
         */
        ModelGrafico grafico = new ModelGrafico();
        graficoList.clear();
        /* Formata o valor com duas casas decimais */
        DecimalFormat fmt = new DecimalFormat("#.##");
        /* Formata o valor para Real */
        DecimalFormat fmtDinDin = new DecimalFormat("R$ #,##0.00");

        /**
         * Rentabilidade por trimestre *
         */

        /* 1º Trimestre (Jan, Fev, Març) */
        double rentabilidade_1 = getRendimentoVendaPorTrimestre(1, 2, 3, ano);
        /* 2º Trimestre (Abri, Mai, Junh) */
        double rentabilidade_2 = getRendimentoVendaPorTrimestre(4, 5, 6, ano);
        /* 3º Trimestre (Julh, Agos, Set) */
        double rentabilidade_3 = getRendimentoVendaPorTrimestre(7, 8, 9, ano);
        /* 4º Trimestre (Out, Nov, Dez) */
        double rentabilidade_4 = getRendimentoVendaPorTrimestre(10, 11, 12, ano);

        /**
         * End *
         */
        /**
         * Obtém o acréscimo ou decréscimo da rentabilidade com base no
         * trimestre anterior *
         */
        /* 1º Trimestre / 2º Trimestre */
        double serie_1 = geraTextoscimoDaRentabilidade(rentabilidade_1, rentabilidade_2);
        /* 2º Trimestre / 3º Trimestre */
        double serie_2 = geraTextoscimoDaRentabilidade(rentabilidade_2, rentabilidade_3);
        /* 3º Trimestre / 4º Trimestre */
        double serie_3 = geraTextoscimoDaRentabilidade(rentabilidade_3, rentabilidade_4);

        /**
         * End *
         */
        /**
         * Setando os valores para o gráfico *
         */
        grafico.setValue(rentabilidade_1);
        grafico.setLabel("Rentabilidade do 1º trimestre de " + ano + " : " + fmtDinDin.format(rentabilidade_1) + "                                                                                       ");
        grafico.setTitle("1º Trimestre de " + ano);
        /* Adiciona os dados a lista.*/
        graficoList.add(grafico);
        grafico = new ModelGrafico();
        grafico.setValue(rentabilidade_2);
        grafico.setLabel("Rentabilidade do 2º trimestre de " + ano + " : " + fmtDinDin.format(rentabilidade_2) + " com " + geraTexto(serie_1) + " de " + fmt.format(serie_1) + "% com base no trimestre anterior.");
        grafico.setTitle("2º Trimestre de " + ano);
        /* Adiciona os dados a lista.*/
        graficoList.add(grafico);
        grafico = new ModelGrafico();
        grafico.setValue(rentabilidade_3);
        grafico.setLabel("Rentabilidade do 3º trimestre de " + ano + " : " + fmtDinDin.format(rentabilidade_3) + " com " + geraTexto(serie_2) + " de " + fmt.format(serie_2) + "% com base no trimestre anterior.");
        grafico.setTitle("3º Trimestre de " + ano);
        /* Adiciona os dados a lista.*/
        graficoList.add(grafico);
        grafico = new ModelGrafico();
        grafico.setValue(rentabilidade_4);
        grafico.setLabel("Rentabilidade do 4º trimestre de " + ano + " : " + fmtDinDin.format(rentabilidade_4) + " com " + geraTexto(serie_3) + " de " + fmt.format(serie_3) + "% com base no trimestre anterior.");
        grafico.setTitle("4º Trimestre de " + ano);
        /* Adiciona os dados a lista.*/
        graficoList.add(grafico);
        grafico = new ModelGrafico();
        grafico.setValue(fcDataPoint.getDependentValue());
        grafico.setLabel("Rentabilidade do 1º trimestre de " + (ano + 1) + " pode ter o " + geraTexto(serie_3) + " de " + fmt.format(fcDataPoint.getDependentValue()) + "% com base nos trimestres anteriores.");
        grafico.setTitle("Estimativa de vendas para o primeiro trimesmtre do seguinte " + (ano + 1));
        /* Adiciona os dados a lista.*/
        graficoList.add(grafico);

        /**
         * End *
         */
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aviso;
    private javax.swing.JComboBox cboAno;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOG = getLogger(FrmConsultarVenda.class.getName());
}
