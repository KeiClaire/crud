package crud;
import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame {
    Login bb = new Login();

    public Menu() {
            if(Session.getStatusLogin()=="AKTIF")
            {
                initComponents();
                setSessionNama();
            } else {
                dispose();
                LoginForm form = new LoginForm();
                form.setVisible(true);
            }
        }

    private void setSessionNama(){
            label_nama.setText("hai " + Session.getNama());
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_nama = new javax.swing.JLabel();
        label_keterangan = new javax.swing.JLabel();
        jMenuAplikasiBar = new javax.swing.JMenuBar();
        jMenuAplikasi = new javax.swing.JMenu();
        jMenuKeluar = new javax.swing.JCheckBoxMenuItem();
        jMenuCRUD = new javax.swing.JMenu();
        jMenuCRUDSiswa = new javax.swing.JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_nama.setText("Hi Nama User");

        label_keterangan.setText("Selamat Datang di Aplikasi Pratikum PBO");

        jMenuAplikasi.setText("Aplikasi");

        jMenuKeluar.setSelected(true);
        jMenuKeluar.setText("Keluar");
        jMenuKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuKeluarActionPerformed(evt);
            }
        });
        jMenuAplikasi.add(jMenuKeluar);

        jMenuAplikasiBar.add(jMenuAplikasi);

        jMenuCRUD.setText("CRUD");

        jMenuCRUDSiswa.setSelected(true);
        jMenuCRUDSiswa.setText("CRUD Siswa");
        jMenuCRUDSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCRUDSiswaActionPerformed(evt);
            }
        });
        jMenuCRUD.add(jMenuCRUDSiswa);

        jMenuAplikasiBar.add(jMenuCRUD);

        jMenu3.setText("Polimorfisme");
        jMenuAplikasiBar.add(jMenu3);

        setJMenuBar(jMenuAplikasiBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_keterangan)
                    .addComponent(label_nama))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(label_nama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_keterangan)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuKeluarActionPerformed
        if(JOptionPane.showConfirmDialog(null,"apakah anda yakin akan keluar?","warning",2) == JOptionPane.YES_OPTION){
            bb.Logout(Session.getUserID());
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuKeluarActionPerformed

    private void jMenuCRUDSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCRUDSiswaActionPerformed
        try{
            Form_Siswa form = new Form_Siswa();
            form.setVisible(true);
        } catch(Exception ex){
            
        }
    }//GEN-LAST:event_jMenuCRUDSiswaActionPerformed

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
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Menu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenuAplikasi;
    private javax.swing.JMenuBar jMenuAplikasiBar;
    private javax.swing.JMenu jMenuCRUD;
    private javax.swing.JCheckBoxMenuItem jMenuCRUDSiswa;
    private javax.swing.JCheckBoxMenuItem jMenuKeluar;
    private javax.swing.JLabel label_keterangan;
    private javax.swing.JLabel label_nama;
    // End of variables declaration//GEN-END:variables
}
