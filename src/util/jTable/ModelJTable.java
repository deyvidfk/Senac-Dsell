/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.jTable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuário
 */
public class ModelJTable extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private final List<?> lista;
    private final Class<?> classe;

    public ModelJTable(List<?> lista) {
        if (lista.isEmpty()) {
            throw new NullPointerException("Lista vazia");
        } else {
            this.lista = lista;
            this.classe = lista.get(0).getClass();
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        int colunas = 0;
        for (Method metodo : classe.getDeclaredMethods()) {
            if (metodo.isAnnotationPresent(Tabela.class)) {
                colunas++;
            }
        }
        return colunas;
    }

    @Override
    public String getColumnName(int coluna) {
        for (Method metodo : classe.getDeclaredMethods()) {
            if (metodo.isAnnotationPresent(Tabela.class)) {
                Tabela anotacao = metodo.getAnnotation(Tabela.class);
                if (anotacao.Indice() == coluna) {
                    return anotacao.Coluna();
                }
            }
        }
        return "";
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        try {
            Object objeto = lista.get(linha);
            for (Method metodo : classe.getDeclaredMethods()) {
                if (metodo.isAnnotationPresent(Tabela.class)) {
                    Tabela anotacao = metodo.getAnnotation(Tabela.class);
                    if (anotacao.Indice() == coluna) {
                        return metodo.invoke(objeto);
                    }
                }
            }
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            return "Erro";
        }
        return "";
    }
    private static final Logger LOG = getLogger(ModelJTable.class.getName());
}
