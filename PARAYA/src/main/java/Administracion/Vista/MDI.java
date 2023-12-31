package Administracion.Vista;

import Administracion.Controlador.CodigoLimpio;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Dimension;

/**
 *
 * @author laionel
 */
public class MDI extends javax.swing.JFrame {

    CodigoLimpio codigoLimpio = new CodigoLimpio();

    /**
     * Creates new form MDI
     */
    public MDI() {
        initComponents();
        cargarDiseño();
    }

    private void cargarDiseño() {

        setTitle("Leonel Dominguez     |     " + codigoLimpio.getFechaActual("gt") + "     |     PARAYA!");
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jdp_contenedor = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        administrador = new javax.swing.JMenu();
        adm_mantenimientos = new javax.swing.JMenu();
        usuarios = new javax.swing.JMenuItem();
        adm_procesos = new javax.swing.JMenu();
        pilotos = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout Jdp_contenedorLayout = new javax.swing.GroupLayout(Jdp_contenedor);
        Jdp_contenedor.setLayout(Jdp_contenedorLayout);
        Jdp_contenedorLayout.setHorizontalGroup(
            Jdp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        Jdp_contenedorLayout.setVerticalGroup(
            Jdp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        administrador.setText("Administrador");

        adm_mantenimientos.setText("Mantenimientos");

        usuarios.setText("Usuarios");
        usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosActionPerformed(evt);
            }
        });
        adm_mantenimientos.add(usuarios);

        administrador.add(adm_mantenimientos);

        adm_procesos.setText("Procesos");
        administrador.add(adm_procesos);

        jMenuBar1.add(administrador);

        pilotos.setText("Pilotos");
        jMenuBar1.add(pilotos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jdp_contenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jdp_contenedor)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosActionPerformed
        vUsuarios children = new vUsuarios();

        Jdp_contenedor.add(children);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = children.getSize();
        children.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        children.setVisible(true);
        children.toFront();
    }//GEN-LAST:event_usuariosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatLightLaf.setup();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Jdp_contenedor;
    private javax.swing.JMenu adm_mantenimientos;
    private javax.swing.JMenu adm_procesos;
    private javax.swing.JMenu administrador;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu pilotos;
    private javax.swing.JMenuItem usuarios;
    // End of variables declaration//GEN-END:variables
}
