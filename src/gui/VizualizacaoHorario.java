/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import timetable.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Gabriel M., Gabriel O., DAnillo, Marcos Antônio
 */
public class VizualizacaoHorario extends javax.swing.JFrame {
    
    JLabel lab= new JLabel();
    String userhome = System.getProperty("user.home");
    JFileChooser chooser = new JFileChooser(userhome +"\\Documents\\NetBeansProjects\\TimeTable\\src\\files");
  
    
    
    
    ArrayList<Aula> aula = new ArrayList<Aula>();
    
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";
    int flag;
    private String[] args;
    
    
    public VizualizacaoHorario() throws Exception {
        initComponents();
        
        TimeTable.main(args);
         
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);            //seta o tamanho da JFrame
        setLocationRelativeTo(null);  // coloca a JFrame no centro da tela.
        //setContentPane(sli);          //chama o slide de imagens
    
    }

   
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFiles = new javax.swing.JMenu();
        jMenuItemUparAnexo = new javax.swing.JMenuItem();
        jMenuHorario = new javax.swing.JMenu();
        jMenuCurso = new javax.swing.JMenu();
        jMenuEngEle = new javax.swing.JMenu();
        jMenuItemEE1 = new javax.swing.JMenuItem();
        jMenuItemEE2 = new javax.swing.JMenuItem();
        jMenuItemEE3 = new javax.swing.JMenuItem();
        jMenuItemEE4 = new javax.swing.JMenuItem();
        jMenuItemEE5 = new javax.swing.JMenuItem();
        jMenuItemEE6 = new javax.swing.JMenuItem();
        jMenuItemEE7 = new javax.swing.JMenuItem();
        jMenuItemEE8 = new javax.swing.JMenuItem();
        jMenuItemEE9 = new javax.swing.JMenuItem();
        jMenuItemEE10 = new javax.swing.JMenuItem();
        jMenuEngComp = new javax.swing.JMenu();
        jMenuItemEC1 = new javax.swing.JMenuItem();
        jMenuItemEC2 = new javax.swing.JMenuItem();
        jMenuItemEC3 = new javax.swing.JMenuItem();
        jMenuItemEC4 = new javax.swing.JMenuItem();
        jMenuItemEC5 = new javax.swing.JMenuItem();
        jMenuItemEC6 = new javax.swing.JMenuItem();
        jMenuItemEC7 = new javax.swing.JMenuItem();
        jMenuItemEC8 = new javax.swing.JMenuItem();
        jMenuItemEC9 = new javax.swing.JMenuItem();
        jMenuItemEC10 = new javax.swing.JMenuItem();
        jMenuItemEC11 = new javax.swing.JMenuItem();
        jMenuItemEC12 = new javax.swing.JMenuItem();
        jMenuEngMec = new javax.swing.JMenu();
        jMenuItemEM1 = new javax.swing.JMenuItem();
        jMenuItemEM2 = new javax.swing.JMenuItem();
        jMenuItemEM3 = new javax.swing.JMenuItem();
        jMenuItemEM4 = new javax.swing.JMenuItem();
        jMenuItemEM5 = new javax.swing.JMenuItem();
        jMenuItemEM6 = new javax.swing.JMenuItem();
        jMenuItemEM7 = new javax.swing.JMenuItem();
        jMenuItemEM8 = new javax.swing.JMenuItem();
        jMenuItemEM9 = new javax.swing.JMenuItem();
        jMenuItemEM10 = new javax.swing.JMenuItem();
        jMenuExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenuFiles.setText("Arquivo");

        jMenuItemUparAnexo.setText("Carregar Arquivo");
        jMenuItemUparAnexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUparAnexoActionPerformed(evt);
            }
        });
        jMenuFiles.add(jMenuItemUparAnexo);

        jMenuBar1.add(jMenuFiles);

        jMenuHorario.setText("Horários");
        jMenuBar1.add(jMenuHorario);

        jMenuCurso.setText("Cursos");

        jMenuEngEle.setText("Engenharia Elétrica");

        jMenuItemEE1.setText("1º Período");
        jMenuEngEle.add(jMenuItemEE1);

        jMenuItemEE2.setText("2º Período");
        jMenuItemEE2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEE2ActionPerformed(evt);
            }
        });
        jMenuEngEle.add(jMenuItemEE2);

        jMenuItemEE3.setText("3º Período");
        jMenuEngEle.add(jMenuItemEE3);

        jMenuItemEE4.setText("4º Período");
        jMenuItemEE4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEE4ActionPerformed(evt);
            }
        });
        jMenuEngEle.add(jMenuItemEE4);

        jMenuItemEE5.setText("5º Período");
        jMenuEngEle.add(jMenuItemEE5);

        jMenuItemEE6.setText("6º Período");
        jMenuEngEle.add(jMenuItemEE6);

        jMenuItemEE7.setText("7º Período");
        jMenuItemEE7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEE7ActionPerformed(evt);
            }
        });
        jMenuEngEle.add(jMenuItemEE7);

        jMenuItemEE8.setText("8º Período");
        jMenuEngEle.add(jMenuItemEE8);

        jMenuItemEE9.setText("9º Período");
        jMenuEngEle.add(jMenuItemEE9);

        jMenuItemEE10.setText("10º Período");
        jMenuEngEle.add(jMenuItemEE10);

        jMenuCurso.add(jMenuEngEle);

        jMenuEngComp.setText("Engenharia de Computação");

        jMenuItemEC1.setText("1º Período");
        jMenuEngComp.add(jMenuItemEC1);

        jMenuItemEC2.setText("2º Período");
        jMenuEngComp.add(jMenuItemEC2);

        jMenuItemEC3.setText("3º Período");
        jMenuEngComp.add(jMenuItemEC3);

        jMenuItemEC4.setText("4º Período");
        jMenuItemEC4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEC4ActionPerformed(evt);
            }
        });
        jMenuEngComp.add(jMenuItemEC4);

        jMenuItemEC5.setText("5º Período");
        jMenuEngComp.add(jMenuItemEC5);

        jMenuItemEC6.setText("6º Período");
        jMenuEngComp.add(jMenuItemEC6);

        jMenuItemEC7.setText("7º Período");
        jMenuEngComp.add(jMenuItemEC7);

        jMenuItemEC8.setText("8º Período");
        jMenuEngComp.add(jMenuItemEC8);

        jMenuItemEC9.setText("9º Período");
        jMenuEngComp.add(jMenuItemEC9);

        jMenuItemEC10.setText("10º Período");
        jMenuEngComp.add(jMenuItemEC10);

        jMenuItemEC11.setText("11º Período");
        jMenuEngComp.add(jMenuItemEC11);

        jMenuItemEC12.setText("12º Período");
        jMenuEngComp.add(jMenuItemEC12);

        jMenuCurso.add(jMenuEngComp);

        jMenuEngMec.setText("Engenharia Mecânica");

        jMenuItemEM1.setText("1º Período");
        jMenuEngMec.add(jMenuItemEM1);

        jMenuItemEM2.setText("2º Período");
        jMenuEngMec.add(jMenuItemEM2);

        jMenuItemEM3.setText("3º Período");
        jMenuEngMec.add(jMenuItemEM3);

        jMenuItemEM4.setText("4º Período");
        jMenuEngMec.add(jMenuItemEM4);

        jMenuItemEM5.setText("5º Período");
        jMenuEngMec.add(jMenuItemEM5);

        jMenuItemEM6.setText("6º Período");
        jMenuEngMec.add(jMenuItemEM6);

        jMenuItemEM7.setText("7º Período");
        jMenuEngMec.add(jMenuItemEM7);

        jMenuItemEM8.setText("8º Período");
        jMenuEngMec.add(jMenuItemEM8);

        jMenuItemEM9.setText("9º Período");
        jMenuEngMec.add(jMenuItemEM9);

        jMenuItemEM10.setText("10º Período");
        jMenuEngMec.add(jMenuItemEM10);

        jMenuCurso.add(jMenuEngMec);

        jMenuBar1.add(jMenuCurso);

        jMenuExit.setText("Exit");
        jMenuBar1.add(jMenuExit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemEE2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEE2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemEE2ActionPerformed

    private void jMenuItemEE4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEE4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemEE4ActionPerformed

    private void jMenuItemEE7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEE7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemEE7ActionPerformed

    private void jMenuItemEC4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEC4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemEC4ActionPerformed

    private void jMenuItemUparAnexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUparAnexoActionPerformed

        
        
         while(true){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files","csv");  //Cria um filtro
        
         chooser.setFileFilter(filter);  //Altera o filtro do JFileChooser 
         
         int returnVal = chooser.showOpenDialog(this);// abre a janela do filechose neste panel
    
         if(returnVal == JFileChooser.APPROVE_OPTION  && "ag-horarios.csv".equals(chooser.getSelectedFile().getName())) {     
             
         JOptionPane.showMessageDialog(null, "O Arquivo selecionado foi:\n"+chooser.getSelectedFile().getName(), "", JOptionPane.INFORMATION_MESSAGE);
           
         LerHorario();
         
            try {
                ExelViewer.HorariosGeral2(aula);
            } catch (Exception ex) {
                Logger.getLogger(VizualizacaoHorario.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        
         break;
        }
         else{
             JOptionPane.showMessageDialog(null, "Arquivo inválido.\n Selecione arquivo de HORÁRIOS.", "", JOptionPane.INFORMATION_MESSAGE); 
         }
         }
    }//GEN-LAST:event_jMenuItemUparAnexoActionPerformed

    public void LerHorario(){
        int i = 0;
        int profIndex = 0;
        int salaIndex = 0;
        
         try {
                
             br = new BufferedReader(new FileReader(chooser.getSelectedFile()));
             while ((line = br.readLine()) != null) {
                 

                 if(line.trim().isEmpty()){ 
                 }
                 else if(line.substring(0,2).equals("//")){
                     
                 }
                 else{
                    
                     String[] aux = line.split(cvsSplitBy);
                     
                     Aula au;
                     
                     for(Professor pf : LeituraCSV.PROFESSOR){
                         
                         if(Integer.parseInt(aux[2]) == LeituraCSV.PROFESSOR.get(i).getCod()){
                             
                           profIndex = i;
                           //System.out.println(i);
                           //break;
                             
                         }
                         
                        i++; 
                     }
                     i=0;
                     
                     for(SalaAula sa : LeituraCSV.SALA){
                         
                         if(Integer.parseInt(aux[3]) == LeituraCSV.SALA.get(i).getCod()){
                            // System.out.println("SALA DE AULA"+aux[3]);
                           salaIndex = i;
                          // break;
                             
                         }
                         
                        i++; 
                     }
                     i=0;
                     
                     
                     
                     for(Disciplina Ld : LeituraCSV.DISCIPLINA){
                         //System.out.println("aux: "+aux[0]+"Disp: " + LeituraCSV.DISCIPLINA.get(i).getCodD() );
                            if(Integer.parseInt(aux[0]) == LeituraCSV.DISCIPLINA.get(i).getCodD() ){
                                
                                //System.out.println("Entrous");
                                au = new Aula(LeituraCSV.DISCIPLINA.get(i).getCodC(),
                                                LeituraCSV.DISCIPLINA.get(i).getCodP(),
                                                LeituraCSV.DISCIPLINA.get(i),
                                                LeituraCSV.TIMESLOT.get(Integer.parseInt(aux[1])-1),
                                                LeituraCSV.PROFESSOR.get(profIndex),
                                                LeituraCSV.SALA.get(salaIndex));
                                
//                                System.out.println("Curso: " + LeituraCSV.DISCIPLINA.get(i).getCodC() + "\n"
//                                        + "Periodo: " + LeituraCSV.DISCIPLINA.get(i).getCodP()+ "\n"
//                                        + "Diciplina: " + LeituraCSV.DISCIPLINA.get(i).getCodD() + "\n"
//                                        + "Time Slot:" + LeituraCSV.TIMESLOT.get(Integer.parseInt(aux[1])-1).getCod() + "\n"
//                                        + "Professor: " + LeituraCSV.PROFESSOR.get(profIndex).getCod() + "\n"
//                                        + "Sala de Aula: " + LeituraCSV.SALA.get(salaIndex).getCod());
                                
                                aula.add(au);
          
                            }
                            i++; 
                     }
                     i=0;                   
                 }            
            }
             i=0;
             for( Aula al : aula){
            
                            System.out.println("Gravou: "+ aula.get(i).disp.getCodD()+","+aula.get(i).timeSlot.getCod()+","+aula.get(i).prof.getCod()+","+aula.get(i).sala.getCod());
                      i++;
                    }            
         }catch(FileNotFoundException e) {
                   e.printStackTrace();
         }catch (IOException e) {
                   e.printStackTrace();
                                 } 
         finally {
                if (br != null) {
                    try {
                        br.close();
                    }
                    catch(IOException e) {
                    e.printStackTrace();
                    }
                }
        }
           
    }
      
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
            java.util.logging.Logger.getLogger(VizualizacaoHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VizualizacaoHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VizualizacaoHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VizualizacaoHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VizualizacaoHorario().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(VizualizacaoHorario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCurso;
    private javax.swing.JMenu jMenuEngComp;
    private javax.swing.JMenu jMenuEngEle;
    private javax.swing.JMenu jMenuEngMec;
    private javax.swing.JMenu jMenuExit;
    private javax.swing.JMenu jMenuFiles;
    private javax.swing.JMenu jMenuHorario;
    private javax.swing.JMenuItem jMenuItemEC1;
    private javax.swing.JMenuItem jMenuItemEC10;
    private javax.swing.JMenuItem jMenuItemEC11;
    private javax.swing.JMenuItem jMenuItemEC12;
    private javax.swing.JMenuItem jMenuItemEC2;
    private javax.swing.JMenuItem jMenuItemEC3;
    private javax.swing.JMenuItem jMenuItemEC4;
    private javax.swing.JMenuItem jMenuItemEC5;
    private javax.swing.JMenuItem jMenuItemEC6;
    private javax.swing.JMenuItem jMenuItemEC7;
    private javax.swing.JMenuItem jMenuItemEC8;
    private javax.swing.JMenuItem jMenuItemEC9;
    private javax.swing.JMenuItem jMenuItemEE1;
    private javax.swing.JMenuItem jMenuItemEE10;
    private javax.swing.JMenuItem jMenuItemEE2;
    private javax.swing.JMenuItem jMenuItemEE3;
    private javax.swing.JMenuItem jMenuItemEE4;
    private javax.swing.JMenuItem jMenuItemEE5;
    private javax.swing.JMenuItem jMenuItemEE6;
    private javax.swing.JMenuItem jMenuItemEE7;
    private javax.swing.JMenuItem jMenuItemEE8;
    private javax.swing.JMenuItem jMenuItemEE9;
    private javax.swing.JMenuItem jMenuItemEM1;
    private javax.swing.JMenuItem jMenuItemEM10;
    private javax.swing.JMenuItem jMenuItemEM2;
    private javax.swing.JMenuItem jMenuItemEM3;
    private javax.swing.JMenuItem jMenuItemEM4;
    private javax.swing.JMenuItem jMenuItemEM5;
    private javax.swing.JMenuItem jMenuItemEM6;
    private javax.swing.JMenuItem jMenuItemEM7;
    private javax.swing.JMenuItem jMenuItemEM8;
    private javax.swing.JMenuItem jMenuItemEM9;
    private javax.swing.JMenuItem jMenuItemUparAnexo;
    // End of variables declaration//GEN-END:variables
}
