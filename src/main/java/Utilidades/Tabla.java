package Utilidades;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla {

  /**
   * Crea y establece las cabeceras de una JTable usando un DefaultTableModel.
   *
   * @param tabla La JTable que se configurará.
   * @param modelo El DefaultTableModel que se utilizará para la JTable.
   * @param cabeceras Un arreglo de cadenas que representa las cabeceras de la
   * @param anchos Un arreglo de enteros que representa los anchos de las
   * columnas de la tabla tabla.
   */
  public static void crearCabeceras(JTable tabla, DefaultTableModel modelo, String[] cabeceras, int[] anchos) {
    for (String cabecera : cabeceras) {
      modelo.addColumn(cabecera);
    }

    tabla.setModel(modelo);

    for (int i = 0; i < anchos.length; i++) {
      tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
  }

  /**
   * Elimina todas las filas de un DefaultTableModel.
   *
   * @param modelo El DefaultTableModel que se limpiará.
   * @throws IllegalArgumentException Si el modelo es null.
   */
  public static void limpiarTabla(DefaultTableModel modelo) {
    while (modelo.getRowCount() > 0) {
      modelo.removeRow(0);
    }
  }
}
