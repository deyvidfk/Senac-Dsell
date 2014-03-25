/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.jTable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Usuário
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Tabela {

    String Coluna();

    int Indice();
}
