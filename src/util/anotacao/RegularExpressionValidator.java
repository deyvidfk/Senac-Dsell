/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.anotacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import util.Regex;

/**
 *
 * @author Usuário
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RegularExpressionValidator {

    Regex ValidationExpression();

    String Label();

    String RegexErrorMessage() default "Erro";

    boolean EnableErrorMessage() default true;
}
