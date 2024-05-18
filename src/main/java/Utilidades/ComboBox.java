package Utilidades;

import java.util.List;
import javax.swing.JComboBox;

public class ComboBox {

  /**
   * Llena un JComboBox con los elementos de una lista.
   *
   * @param <T> El tipo de los elementos en la lista y el JComboBox.
   * @param combo El JComboBox que se llenará con los elementos de la lista.
   * @param lista La lista de elementos que se agregarán al JComboBox.
   */
  public static <T> void llenar(JComboBox<T> combo, List<T> lista) {
    lista.forEach(item -> combo.addItem(item));
  }
}
