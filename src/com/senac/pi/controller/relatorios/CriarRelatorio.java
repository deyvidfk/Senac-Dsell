package com.senac.pi.controller.relatorios;

import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import net.sf.jasperreports.engine.JRException;
import static net.sf.jasperreports.engine.JasperCompileManager.compileReport;
import static net.sf.jasperreports.engine.JasperFillManager.fillReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 * A CLASSE CRIA RELATORIO ULTILIZANDO UMA THREAD.
 *
 */
public class CriarRelatorio implements Runnable {

    /**
     * LISTA DE DADOS
     */
    private final List<?> dados;
    /**
     * NOME DO TEMPLATE (ARQUIVO)
     */
    private final String fileName;
    /**
     * PARAMETROS DE TIPO HASHMAP
     */
    private final HashMap<String, Object> param;

    public CriarRelatorio(List list, String fileNameTemplate, HashMap param) {
        this.dados = list;
        this.fileName = fileNameTemplate;
        this.param = param;
    }

    /**
     * SOBRESCREVE O MÉTODO; INICIA A THREAD PARA CRIAR O RELATORIO.
     */
    @Override
    public void run() {
        try {
            sleep(2);
            newReport();
        } catch (JRException | SQLException | InterruptedException ex) {
            showMessageDialog(null, ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            getLogger(CriarRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void newReport() throws JRException, SQLException {

        JasperReport template = compileReport(this.getClass().getResourceAsStream(this.fileName)); // compilacao do JRXML

        // preenchimento do relatório. Note que o método recebe 3 parâmetros:
        // 1 - o relatório
        //
        // 2 - um Map, com parâmetros que são passados ao relatório.
        // no momento do preenchimento. No nosso caso é opcional.
        //
        // 3 - o dataSource. Note que não devemos passar a lista diretamente,
        // e sim "transformar" em um data source utilizando a classe
        // JRBeanCollectionDataSource
        JasperPrint print = fillReport(template, this.param, new JRBeanCollectionDataSource(this.dados));
        //exibe o resultado
        JasperViewer viewer = new JasperViewer(print, false);
        viewer.setVisible(true);

    }

    public class Templates {

        public static final String TMPL_FORNECEDOR_CADASTRO_RESUMIDO = "tpm_fornecedor_resumo.jrxml";
        public static final String TMPL_FORNECEDOR_CADASTRO_COMPLETO = "tpm_fornecedor_geral.jrxml";
        public static final String TMPL_VENDAS_GRAFICO = "tmp_venda.jrxml";

    }
    private static final Logger LOG = getLogger(CriarRelatorio.class.getName());
}
