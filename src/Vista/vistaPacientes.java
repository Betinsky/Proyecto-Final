/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.controladorBD;
import Vista.vistaControlDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**  betinsky / bolivar
 *
 * 
 */
public class vistaPacientes extends javax.swing.JFrame {

    /**
     * Creates new form loginInMedico
     */
    public String columna[];
    controladorBD cb = new controladorBD();
    DefaultTableModel modeloPacientes;
    public vistaPacientes() {
        
        modeloPacientes = new DefaultTableModel(null, getColumnas());
        setFilas();
        initComponents();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable1.rowAtPoint(evt.getPoint());
                int col = 0;
                if (row >= 0 && col >= 0) {
                    String valor = jTable1.getModel().getValueAt(row, col).toString(); //Tomo el valor de el modelo de la tabla
                    idPaciente.setText(valor); //Obtengo el valor del textfield
                }

            }
        });
        
    }
    

    
    /*Obtienes las Columnas*/
    String[] getColumnas(){ //Columnas
        columna = new String[] {"IDPACIENTE","NOMBRE","APELLIDOPAT","APELLIDOMAT","CURP","IDUNIDADMEDICA"};
        //{"CI","USUARIOS","NOMBRES","APELLIDOS","GRUPO","MONTOSOLICITADO","SOL","CALIFICACION","FECHASOLICITUD","STATUS"};
        return columna;
    }
    void setFilas(){
        try{
            String Sql = "";
            
                 Sql = 
                 //   "SELECT ci_pago,usuario,fecha_pago,total,saldoActual FROM tabla_pagos";
            "SELECT id_paciente,pac_nombres,pac_apellidopaterno,pac_apellidomaterno,pac_curp,pac_idunidadmedica FROM bdconsultorio.tabla_pacientes";
                 /*
                
                 */

             System.out.println("Contenido: "+Sql);
            
//            SELECT ci_datos, nombres, apellidos,fecha_nac, telefonocel, tabla_grupo.id_grupo, 
//            tabla_grupo.nombre_encargado  FROM tabla_datosusuarios LEFT JOIN tabla_grupo ON tabla_datosusuarios.grupo = tabla_grupo.id_grupo where tabla_datosusuarios.grupo = '3'
//           
//    
            PreparedStatement us = cb.openConnection().prepareStatement(Sql);
            ResultSet res = us.executeQuery();
            Object objDatos[] = new Object[columna.length]; //Siempre debe cconexoincidir con el numero de columnas!
            
            while(res.next()){
                for (int i = 0; i<columna.length; i++){
                    objDatos[i] = res.getObject(i+1);
                    //System.out.println(objDatos[i]);
                }
                modeloPacientes.addRow(objDatos);
            }
        }
        catch(SQLException ex){
        
        }
    
    }
    
    void setFilas(String busquedaFiltroSF){
        try{
            String Sql = "";
            
                 Sql = 
                 //   "SELECT ci_pago,usuario,fecha_pago,total,saldoActual FROM tabla_pagos";
                "SELECT id_paciente,pac_nombres,pac_apellidopaterno,pac_apellidomaterno,pac_curp,pac_idunidadmedica FROM bdconsultorio.tabla_pacientes where pac_nombres = '"+busquedaFiltroSF+"' or id_paciente = '"+busquedaFiltroSF+"'";
                 /*
                
                 */

             System.out.println("Contenido: "+Sql);
            
//            SELECT ci_datos, nombres, apellidos,fecha_nac, telefonocel, tabla_grupo.id_grupo, 
//            tabla_grupo.nombre_encargado  FROM tabla_datosusuarios LEFT JOIN tabla_grupo ON tabla_datosusuarios.grupo = tabla_grupo.id_grupo where tabla_datosusuarios.grupo = '3'
//           
//    
            PreparedStatement us = cb.openConnection().prepareStatement(Sql);
            ResultSet res = us.executeQuery();
            Object objDatos[] = new Object[columna.length]; //Siempre debe cconexoincidir con el numero de columnas!
            
            while(res.next()){
                for (int i = 0; i<columna.length; i++){
                    objDatos[i] = res.getObject(i+1);
                    //System.out.println(objDatos[i]);
                }
                modeloPacientes.addRow(objDatos);
            }
        }
        catch(SQLException ex){
        
        }
    
    }
    
    private void actualizarTablaPacientes() {
    // Limpiar el modelo de la tabla
    modeloPacientes.setRowCount(0);
    // Llenar de nuevo el modelo con los datos actuales
    setFilas();
    // Notificar al modelo que los datos han cambiado
    modeloPacientes.fireTableDataChanged();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        busquedaFiltroTXT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        idPaciente = new javax.swing.JTextField();
        botonVerDatos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textoError = new javax.swing.JLabel();
        EliminarPaciente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Instituto Médico - Paciente");
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(500, 100));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 700));

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        busquedaFiltroTXT.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        busquedaFiltroTXT.setText("0");

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Para filtrar inserta un idpaciente o el nombre, después presióna el botón buscar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(376, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(busquedaFiltroTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(48, 48, 48))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(busquedaFiltroTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTable1.setBackground(new java.awt.Color(230, 230, 255));
        jTable1.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jTable1.setModel(modeloPacientes);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        idPaciente.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        idPaciente.setText("0");

        botonVerDatos.setBackground(new java.awt.Color(204, 255, 255));
        botonVerDatos.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        botonVerDatos.setText("Ver Datos");
        botonVerDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerDatosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID_Paciente:");

        jButton3.setBackground(new java.awt.Color(255, 204, 204));
        jButton3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonVerDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(idPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(botonVerDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel1.setText("Error:");

        textoError.setText("_________________________________________________________________________________________________________________________");

        EliminarPaciente.setBackground(new java.awt.Color(255, 102, 102));
        EliminarPaciente.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        EliminarPaciente.setText("Eliminar");
        EliminarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(textoError, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EliminarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EliminarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoError))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String bqf = "";
        bqf = busquedaFiltroTXT.getText();
        
        this.modeloPacientes = new DefaultTableModel(null, getColumnas());
        if("".equals(bqf)|| bqf.isEmpty()){
            textoError.setText("No Selecionaste ningun ID Valido");
            this.setFilas();}
        else{
            textoError.setText(" Selecionaste ID Valido = "+bqf);
            this.setFilas(bqf);}
        
        jTable1.setModel(modeloPacientes);
        modeloPacientes.fireTableDataChanged();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonVerDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerDatosActionPerformed
        // Mensaje indicando que la conexión con la BD está cerrada
    textoError.setText(" Conexión con BD Cerrada");
    cb.closeConnection();

    int bqf;
    
    try {
        bqf = Integer.parseInt(idPaciente.getText());
        System.out.println(bqf);
        
        cb.openConnection();
        bqf = cb.validarDatosPaciente(bqf);
        cb.closeConnection();
    } catch (NumberFormatException e) {
        textoError.setText("ID de paciente inválido.");
        return;
    } catch (SQLException ex) {
        Logger.getLogger(vistaPacientes.class.getName()).log(Level.SEVERE, null, ex);
        textoError.setText("Error en la conexión con la base de datos.");
        return;
    }
    System.out.println(bqf);
    
    if (bqf == 1) {
        vistaControlDatos vcd = new vistaControlDatos(idPaciente.getText(), 1);
        vcd.setVisible(true); // Asegúrate de usar setVisible(true)
        this.dispose();
    } else {
        textoError.setText(" Seleccionaste ID inválido = " + idPaciente.getText());
    }
            
    }//GEN-LAST:event_botonVerDatosActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void EliminarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarPacienteActionPerformed
   int pacienteId = -1;
    
    try {
        pacienteId = Integer.parseInt(idPaciente.getText());
        System.out.println("ID del paciente a eliminar: " + pacienteId);
        
        cb.openConnection();
        
        boolean eliminado = cb.eliminarPaciente(pacienteId);
        
        cb.closeConnection();
        
        if (eliminado) {
            textoError.setText("Paciente con ID " + pacienteId + " eliminado exitosamente.");
            // Actualizar la tabla después de la eliminación
            actualizarTablaPacientes();
        } else {
            textoError.setText("No se encontró paciente con ID " + pacienteId + ".");
        }
    } catch (NumberFormatException ex) {
        textoError.setText("ID de paciente inválido: " + idPaciente.getText());
        Logger.getLogger(vistaPacientes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        textoError.setText("Error al eliminar el paciente: " + ex.getMessage());
        Logger.getLogger(vistaPacientes.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        cb.closeConnection();
    }
    }//GEN-LAST:event_EliminarPacienteActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(loginInMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(loginInMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(loginInMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(loginInMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new loginInMedico().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EliminarPaciente;
    private javax.swing.JButton botonVerDatos;
    private javax.swing.JTextField busquedaFiltroTXT;
    private javax.swing.JTextField idPaciente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel textoError;
    // End of variables declaration//GEN-END:variables
}
