package Utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    /**
     * Método que valida si un elemento coincide con una expresión regular.
     *
     * @param regex La expresión regular a utilizar para la validación.
     * @param elemento El elemento que se va a validar contra la expresión regular.
     * @return true si el elemento coincide con la expresión regular, false en caso contrario.
     */
    public static boolean validarRegex(String regex, String elemento) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(String.valueOf(elemento));
        return matcher.matches();
    }
}
