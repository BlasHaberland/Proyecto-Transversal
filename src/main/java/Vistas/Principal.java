package Vistas;

import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;

public class Principal extends javax.swing.JFrame {

  /**
   * Creates new form Escritorio
   */
  public Principal() {
    initComponents();

    // Agregamos al JMenu "menuSalir" un escuchador de eventos de mouse para
    // detectar cuando se haga click sobre él
    menuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        clickEnMenuSalir(evt);
      }
    });
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    escritorio = new javax.swing.JDesktopPane();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu2 = new javax.swing.JMenu();
    menuFormularioDeAlumno = new javax.swing.JMenuItem();
    jMenu1 = new javax.swing.JMenu();
    menuFormularioDeMateria = new javax.swing.JMenuItem();
    jMenu3 = new javax.swing.JMenu();
    menuManejoDeInscripciones = new javax.swing.JMenuItem();
    menuManipulacionDeNotas = new javax.swing.JMenuItem();
    jMenu4 = new javax.swing.JMenu();
    menuAlumnosPorMateria = new javax.swing.JMenuItem();
    menuSalir = new javax.swing.JMenu();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setResizable(false);

    javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
    escritorio.setLayout(escritorioLayout);
    escritorioLayout.setHorizontalGroup(
      escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 788, Short.MAX_VALUE)
    );
    escritorioLayout.setVerticalGroup(
      escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 565, Short.MAX_VALUE)
    );

    jMenu2.setText("Alumno");

    menuFormularioDeAlumno.setText("Formulario de Alumno");
    menuFormularioDeAlumno.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuFormularioDeAlumnoActionPerformed(evt);
      }
    });
    jMenu2.add(menuFormularioDeAlumno);

    jMenuBar1.add(jMenu2);

    jMenu1.setText("Materia");

    menuFormularioDeMateria.setText("Formulario de Materia");
    jMenu1.add(menuFormularioDeMateria);

    jMenuBar1.add(jMenu1);

    jMenu3.setText("Administración");

    menuManejoDeInscripciones.setText("Manejo de Inscripciones");
    menuManejoDeInscripciones.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuManejoDeInscripcionesActionPerformed(evt);
      }
    });
    jMenu3.add(menuManejoDeInscripciones);

    menuManipulacionDeNotas.setText("Manipulación de Notas");
    jMenu3.add(menuManipulacionDeNotas);

    jMenuBar1.add(jMenu3);

    jMenu4.setText("Consultas");

    menuAlumnosPorMateria.setText("Alumnos por Materia");
    menuAlumnosPorMateria.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        menuAlumnosPorMateriaActionPerformed(evt);
      }
    });
    jMenu4.add(menuAlumnosPorMateria);

    jMenuBar1.add(jMenu4);

    menuSalir.setText("Salir");
    jMenuBar1.add(menuSalir);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(escritorio)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(escritorio)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void menuFormularioDeAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFormularioDeAlumnoActionPerformed
    // TODO add your handling code here:
    VistaAlumno vista = new VistaAlumno();
    cargarVista(vista);
  }//GEN-LAST:event_menuFormularioDeAlumnoActionPerformed

  private void menuAlumnosPorMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAlumnosPorMateriaActionPerformed
    // TODO add your handling code here:
    VistaAlumnoPorMateria vista = new VistaAlumnoPorMateria();
    cargarVista(vista);
  }//GEN-LAST:event_menuAlumnosPorMateriaActionPerformed

  private void menuManejoDeInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuManejoDeInscripcionesActionPerformed
    // TODO add your handling code here:
    VistaInscripciones vista = new VistaInscripciones();
    cargarVista(vista);
  }//GEN-LAST:event_menuManejoDeInscripcionesActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Principal().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JDesktopPane escritorio;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenu jMenu3;
  private javax.swing.JMenu jMenu4;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem menuAlumnosPorMateria;
  private javax.swing.JMenuItem menuFormularioDeAlumno;
  private javax.swing.JMenuItem menuFormularioDeMateria;
  private javax.swing.JMenuItem menuManejoDeInscripciones;
  private javax.swing.JMenuItem menuManipulacionDeNotas;
  private javax.swing.JMenu menuSalir;
  // End of variables declaration//GEN-END:variables

  /**
   * Carga y muestra un JInternalFrame en el contenedor principal de la
   * aplicación. Si el JInternalFrame ya está visible, se trae al frente.
   *
   * @param vista El JInternalFrame que se cargará y mostrará.
   */
  private void cargarVista(JInternalFrame vista) {
    escritorio.removeAll();
    escritorio.repaint();
    vista.moveToFront();
    vista.setVisible(true);
    escritorio.add(vista);

    try {
      vista.setSelected(true);
    } catch (PropertyVetoException ex) {
      System.out.println(ex);
    }
  }

  /**
   * Maneja el evento de clic en el menú "Salir". Cierra la aplicación cuando el
   * menú "Salir" es clickeado.
   *
   * @param evt El evento de clic del ratón.
   */
  private void clickEnMenuSalir(java.awt.event.MouseEvent evt) {
    if (evt.getButton() == MouseEvent.BUTTON1) {
      System.exit(0);
    }
  }
}
