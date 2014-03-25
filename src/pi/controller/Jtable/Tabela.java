/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.controller.Jtable;

import java.lang.annotation.*;

/**
 *
 * @author Usuário
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Tabela {

    String nomeColuna();

    int indiceColuna();
}
