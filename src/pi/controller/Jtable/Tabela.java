package pi.controller.Jtable;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Tabela {

    String nomeColuna();

    int indiceColuna();
}
