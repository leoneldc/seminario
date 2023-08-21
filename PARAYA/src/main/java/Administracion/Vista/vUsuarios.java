package Administracion.Vista;

import Administracion.Controlador.CodigoLimpio;
import Administracion.Controlador.cUsuarios;
import Administracion.Modelo.mUsuarios;
import Custom.Colors;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * @author laionel
 */
public class vUsuarios extends javax.swing.JInternalFrame {

    mUsuarios modeloUsuario = new mUsuarios();
    CodigoLimpio codigoLimpio = new CodigoLimpio();
    Colors colores = new Colors();

    /**
     * Creates new form Children
     */
    public vUsuarios() {
        initComponents();
        cargarDiseño();
        configurarTabla();
        cargarTabla();
        cargarComboBox();
        limpiar();
        nuevoID();
    }

    private void cargarDiseño() {
        this.setBackground(Color.WHITE);
        id.setLabelText("Identificador (ID)");
        id.setText("1");
        id.setEnabled(false);
        nombre.setLabelText("Nombre completo");
        username.setLabelText("Username");
        password.setLabelText("Contraseña");
        password.setShowAndHide(true);
        correo.setLabelText("Correo");
        confirmPassword.setLabelText("Confirmar Contraseña");
        confirmPassword.setShowAndHide(true);
        pregunta.setLabeText("Selecciona tú pregunta de seguridad...");
        respuestaPregunta.setLabelText("Respuesta de seguridad");
        respuestaPregunta.setShowAndHide(true);
        estado.setLabeText("Estado del usuario");
        guardar.setBackgroundHover(colores.azul);
        guardar.setBackgroundExited(colores.azulHover);
        actualizar.setBackgroundHover(colores.azul);
        actualizar.setBackgroundExited(colores.azulHover);
        eliminar.setBackgroundHover(colores.rojo);
        eliminar.setBackgroundExited(colores.rojoHover);
        cancelar.setBackgroundHover(colores.rojo);
        cancelar.setBackgroundExited(colores.rojoHover);
        reporte.setBackgroundHover(colores.naranja);
        reporte.setBackgroundExited(colores.naranjaHover);
        ayuda.setBackgroundHover(colores.naranja);
        ayuda.setBackgroundExited(colores.naranjaHover);
        setTitle("Mantenimiento de Usuarios");
        setFrameIcon(null);
    }

    private void configurarTabla() {
        tbl_usuario.fixTable(jScrollPane1);
        DefaultTableModel mode = (DefaultTableModel) tbl_usuario.getModel();
//      table1.setCellAlignment(0, JLabel.CENTER);
        mode.addColumn("ID");
        mode.addColumn("Nombre");
        mode.addColumn("Usuario");
        mode.addColumn("Estado");
        tbl_usuario.setColumnWidth(0, 40);
    }

    private void cargarTabla() {
        DefaultTableModel mode = (DefaultTableModel) tbl_usuario.getModel();
        mode.setRowCount(0);
        List<cUsuarios> usuariosList = modeloUsuario.obtenerTodosLosUsuarios();
        for (cUsuarios usuario : usuariosList) {
            mode.addRow(new Object[]{usuario.getId(), usuario.getNombre(), usuario.getUsuario(), usuario.getEstado()});
        }
    }

    private void cargarComboBox() {
        pregunta.removeAllItems();
        pregunta.addItem("Seleccione una pregunta");
        pregunta.addItem("jugador favorito?");
        pregunta.addItem("comida favorita?");
        pregunta.addItem("equipo favorito?");
        pregunta.setSelectedIndex(0);
        estado.removeAllItems();
        estado.addItem("Seleccione un estado");
        estado.addItem("activo");
        estado.addItem("inactivo");
        estado.addItem("otro");
        estado.setSelectedIndex(0);
    }

    private void limpiar() {
        nuevoID();
        nombre.setText("");
        username.setText("");
        password.setShowAndHide(true);
        password.setText("");
        correo.setText("");
        confirmPassword.setText("");
        pregunta.setSelectedIndex(0);
        respuestaPregunta.setText("");
        estado.setSelectedIndex(0);
    }

    private void nuevoID() {
        int newId = modeloUsuario.obtenerMaxId();
        id.setText(String.valueOf(newId));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new Custom.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        id = new Custom.TextField();
        nombre = new Custom.TextField();
        username = new Custom.TextField();
        correo = new Custom.TextField();
        password = new Custom.PasswordField();
        confirmPassword = new Custom.PasswordField();
        pregunta = new Custom.Combobox();
        respuestaPregunta = new Custom.PasswordField();
        estado = new Custom.Combobox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_usuario = new Custom.Table.Table();
        panelRound2 = new Custom.PanelRound();
        guardar = new Custom.Buttom();
        actualizar = new Custom.Buttom();
        eliminar = new Custom.Buttom();
        reporte = new Custom.Buttom();
        ayuda = new Custom.Buttom();
        cancelar = new Custom.Buttom();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Información:");

        pregunta.setMaximumRowCount(8);

        estado.setMaximumRowCount(8);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(respuestaPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(respuestaPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_usuario.setAutoCreateRowSorter(true);
        tbl_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_usuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_usuario);

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        reporte.setText("Reporte");

        ayuda.setText("Ayuda");

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8))
        );

        guardar.getAccessibleContext().setAccessibleName("");
        actualizar.getAccessibleContext().setAccessibleName("");
        eliminar.getAccessibleContext().setAccessibleName("");
        reporte.getAccessibleContext().setAccessibleName("");
        ayuda.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usuarioMouseClicked
        if (evt.getClickCount() == 2) {
            int idUsuario = Integer.parseInt(tbl_usuario.getValueAt(tbl_usuario.getSelectedRow(), 0).toString());
            cUsuarios usuarioEncontrado = new cUsuarios();
            usuarioEncontrado = modeloUsuario.obtenerUsuarioPorId(idUsuario);
            List<String> propertiesToValidate = List.of("id", "nombre", "usuario", "password", "correo", "preguntaSeguridad", "respuestaSeguridad", "estado");

            try {
                if (codigoLimpio.validateNonNullProperties(usuarioEncontrado, propertiesToValidate)) {
                    id.setText(usuarioEncontrado.getId());
                    nombre.setText(usuarioEncontrado.getNombre());
                    username.setText(usuarioEncontrado.getUsuario());
                    password.setText(usuarioEncontrado.getPassword());
                    confirmPassword.setText(usuarioEncontrado.getPassword());
                    correo.setText(usuarioEncontrado.getCorreo());
                    pregunta.setSelectedItem(usuarioEncontrado.getPreguntaSeguridad());
                    respuestaPregunta.setText(usuarioEncontrado.getRespuestaSeguridad());
                    estado.setSelectedItem(usuarioEncontrado.getEstado());
                }
            } catch (IllegalAccessException ex) {
                System.out.println("error en validar propiedades de buscar en usuarios " + ex);
            }
        }
    }//GEN-LAST:event_tbl_usuarioMouseClicked

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        if (codigoLimpio.isEmpty(id, nombre, username, correo,
                password, confirmPassword, respuestaPregunta)) {
            if (codigoLimpio.isSelected(pregunta, estado)) {
                if (codigoLimpio.isEmail(correo.getText())) {
                    cUsuarios usuario = new cUsuarios();
                    usuario.setId(id.getText());
                    usuario.setNombre(nombre.getText());
                    usuario.setUsuario(username.getText());
                    usuario.setPassword(password.getText());
                    usuario.setCorreo(correo.getText());
                    usuario.setPreguntaSeguridad(pregunta.getSelectedItem().toString().toLowerCase());
                    usuario.setRespuestaSeguridad(respuestaPregunta.getText());
                    usuario.setEstado(estado.getSelectedItem().toString().toLowerCase());
                    modeloUsuario.agregarUsuario(usuario);
                    cargarTabla();
                    limpiar();
                    codigoLimpio.accionExitosa("¡AGREGADO CORRECTAMENTE!", "Se ah agregado el usuario correctamente");
                }
            }
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        if (codigoLimpio.isEmpty(id, nombre, username, correo,
                password, confirmPassword, respuestaPregunta)) {
            cUsuarios usuario = new cUsuarios();
            List<String> propertiesToValidate = List.of("id", "nombre", "usuario", "password", "correo", "preguntaSeguridad", "respuestaSeguridad", "estado");

            usuario = modeloUsuario.obtenerUsuarioPorId(Integer.parseInt(id.getText()));
            try {
                if (codigoLimpio.validateNonNullProperties(usuario, propertiesToValidate)) {
                    if (codigoLimpio.isSelected(pregunta, estado)) {
                        if (codigoLimpio.isEmail(correo.getText())) {
                            usuario.setId(id.getText());
                            usuario.setNombre(nombre.getText());
                            usuario.setUsuario(username.getText());
                            usuario.setPassword(password.getText());
                            usuario.setCorreo(correo.getText());
                            usuario.setPreguntaSeguridad(pregunta.getSelectedItem().toString().toLowerCase());
                            usuario.setRespuestaSeguridad(respuestaPregunta.getText());
                            usuario.setEstado(estado.getSelectedItem().toString().toLowerCase());
                            modeloUsuario.actualizarUsuario(usuario);
                            cargarTabla();
                            limpiar();
                            codigoLimpio.accionExitosa("¡MODIFICADO CORRECTAMENTE!", "Se ah modificado el usuario correctamente");
                        }
                    }
                }
            } catch (IllegalAccessException ex) {
                System.out.println("error en validar propiedades de actualizar en usuarios " + ex);
            }
        }
    }//GEN-LAST:event_actualizarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (codigoLimpio.isEmpty(id)) {
            cUsuarios usuario = new cUsuarios();
            List<String> propertiesToValidate = List.of("id", "nombre", "usuario", "password", "correo", "preguntaSeguridad", "respuestaSeguridad", "estado");
            usuario = modeloUsuario.obtenerUsuarioPorId(Integer.parseInt(id.getText()));

            try {
                if (codigoLimpio.validateNonNullProperties(usuario, propertiesToValidate)) {
                    if (codigoLimpio.validarAccion("Eliminar Usuario", "¿Desea eliminar el usuario: " + usuario.getNombre() + "?")) {
                        modeloUsuario.eliminarUsuarioPorId(Integer.parseInt(id.getText()));
                        cargarTabla();
                        limpiar();
                        codigoLimpio.accionExitosa("¡ELIMINADO CORRECTAMENTE!", "Se ah eliminado el usuario correctamente");
                    }
                }
            } catch (IllegalAccessException ex) {
                System.out.println("error en validar propiedades de eliminar en usuarios " + ex);
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_cancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.Buttom actualizar;
    private Custom.Buttom ayuda;
    private Custom.Buttom cancelar;
    private Custom.PasswordField confirmPassword;
    private Custom.TextField correo;
    private Custom.Buttom eliminar;
    private Custom.Combobox estado;
    private Custom.Buttom guardar;
    private Custom.TextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private Custom.TextField nombre;
    private Custom.PanelRound panelRound1;
    private Custom.PanelRound panelRound2;
    private Custom.PasswordField password;
    private Custom.Combobox pregunta;
    private Custom.Buttom reporte;
    private Custom.PasswordField respuestaPregunta;
    private Custom.Table.Table tbl_usuario;
    private Custom.TextField username;
    // End of variables declaration//GEN-END:variables
}
