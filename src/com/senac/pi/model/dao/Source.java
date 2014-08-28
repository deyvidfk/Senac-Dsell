package com.senac.pi.model.dao;

import com.thoughtworks.xstream.XStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import static java.net.URLDecoder.decode;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;
import static javax.swing.JOptionPane.showMessageDialog;

public class Source {

    private static String relativePath;
    private static final XStream XSTREAM = new XStream();

    /**
     * @return the XSTREAM
     */
    public static XStream getXSTREAM() {
        return XSTREAM;
    }

    /**
     * PROTECTED O MODIFICADOR PROTECTED DEIXARÁ VISÍVEL O ATRIBUTO PARA TODAS
     * AS OUTRAS CLASSES E SUBCLASSES QUE PERTENCEM AO MESMO PACOTE. A PRINCIPAL
     * DIFERENÇA É QUE APENAS AS CLASSES DO MESMO PACOTE TEM ACESSO AO MEMBRO. O
     * PACOTE DA SUBCLASSE NÃO TEM ACESSO AO MEMBRO.
     */
    protected Source() {

        String path = Source.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        try {
            relativePath = decode(path, "UTF-8");
            int lastSlash = relativePath.lastIndexOf('/');
            relativePath = relativePath.substring(0, lastSlash + 1);
        } catch (UnsupportedEncodingException ex) {
            showMessageDialog(null, ex.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * O MÉTODO ABAIXO LER O ARQUIVO.
     *
     * @param filename CAMINHO RELATIVO DO ARQUIVO XML.
     * @return
     */
    protected File readXml(String filename) {
        File file = new File(relativePath + filename);
        if (!file.isFile()) {
            try {
                FileWriter fw = new FileWriter(relativePath + filename);
                try (BufferedWriter w = new BufferedWriter(fw)) {
                    w.write("<list></list>");
                }
                file = new File(relativePath + filename);
                return file;

            } catch (IOException ex) {
                getLogger(Resource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return file;
    }

    /**
     * O MÉTODO ABAIXO ESCREVE NO ARQUIVO.
     *
     * @param nomeArquivo
     * @param dados
     */
    protected void insertXml(String nomeArquivo, List<?> dados) {
        try {
            try (FileWriter fw = new FileWriter(relativePath + nomeArquivo);
                    BufferedWriter w = new BufferedWriter(fw)) {
                w.write(getXSTREAM().toXML(dados));
            }
        } catch (IOException e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    private static final Logger LOG = getLogger(Source.class.getName());
}
