/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaodeeficienciadealunos.forms;

import br.com.gestaodeeficienciadealunos.forms.FormAreaPesquisa;

public class FormMain extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public FormMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        menu_algoritmo = new javax.swing.JMenuItem();
        menu_aluno = new javax.swing.JMenuItem();
        menu_area_pesquisa = new javax.swing.JMenuItem();
        menu_complexidade = new javax.swing.JMenuItem();
        menu_curso = new javax.swing.JMenuItem();
        menu_linguagem_programacao = new javax.swing.JMenuItem();
        menu_problema = new javax.swing.JMenuItem();
        menu_solucao = new javax.swing.JMenuItem();
        menu_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestão de Eficiência de Alunos");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Mais usados"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 952, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenuBar1.setName("menu_principal"); // NOI18N

        jMenu1.setText("Gestão de Eficiência de Alunos");

        jMenu3.setText("Cadastro");

        menu_algoritmo.setText("Algoritmo");
        menu_algoritmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_algoritmoActionPerformed(evt);
            }
        });
        jMenu3.add(menu_algoritmo);

        menu_aluno.setText("Aluno");
        menu_aluno.setToolTipText("");
        menu_aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_alunoActionPerformed(evt);
            }
        });
        jMenu3.add(menu_aluno);

        menu_area_pesquisa.setText("Área de pesquisa");
        menu_area_pesquisa.setToolTipText("");
        menu_area_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_area_pesquisaActionPerformed(evt);
            }
        });
        jMenu3.add(menu_area_pesquisa);

        menu_complexidade.setText("Complexidade");
        menu_complexidade.setToolTipText("");
        menu_complexidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_complexidadeActionPerformed(evt);
            }
        });
        jMenu3.add(menu_complexidade);

        menu_curso.setText("Curso");
        menu_curso.setToolTipText("");
        menu_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cursoActionPerformed(evt);
            }
        });
        jMenu3.add(menu_curso);

        menu_linguagem_programacao.setText("Linguagem de programação");
        menu_linguagem_programacao.setToolTipText("");
        menu_linguagem_programacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_linguagem_programacaoActionPerformed(evt);
            }
        });
        jMenu3.add(menu_linguagem_programacao);

        menu_problema.setText("Problema");
        menu_problema.setToolTipText("");
        menu_problema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_problemaActionPerformed(evt);
            }
        });
        jMenu3.add(menu_problema);

        menu_solucao.setText("Solução");
        menu_solucao.setToolTipText("");
        menu_solucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_solucaoActionPerformed(evt);
            }
        });
        jMenu3.add(menu_solucao);

        jMenu1.add(jMenu3);

        menu_sair.setText("Sair");
        menu_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_sairActionPerformed(evt);
            }
        });
        jMenu1.add(menu_sair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(594, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_alunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_alunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_alunoActionPerformed

    private void menu_area_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_area_pesquisaActionPerformed
        FormAreaPesquisa area_pesquisa = new FormAreaPesquisa(this);
        this.setEnabled(false);
        area_pesquisa.setVisible(true);
    }//GEN-LAST:event_menu_area_pesquisaActionPerformed

    private void menu_complexidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_complexidadeActionPerformed
        FormComplexidade complexidade = new FormComplexidade(this);
        this.setEnabled(false);
        complexidade.setVisible(true);
    }//GEN-LAST:event_menu_complexidadeActionPerformed

    private void menu_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cursoActionPerformed
        FormCursos cursos = new FormCursos(this);
        this.setEnabled(false);
        cursos.setVisible(true);
    }//GEN-LAST:event_menu_cursoActionPerformed

    private void menu_linguagem_programacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_linguagem_programacaoActionPerformed
        FormLinguagens linguagens = new FormLinguagens(this);
        this.setEnabled(false);
        linguagens.setVisible(true);     
    }//GEN-LAST:event_menu_linguagem_programacaoActionPerformed

    private void menu_problemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_problemaActionPerformed
        FormProblemas problemas = new FormProblemas(this);
        this.setEnabled(false);
        problemas.setVisible(true);
    }//GEN-LAST:event_menu_problemaActionPerformed

    private void menu_solucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_solucaoActionPerformed
        FormSolucao solucao = new FormSolucao(this);
        this.setEnabled(false);
        solucao.setVisible(true);
    }//GEN-LAST:event_menu_solucaoActionPerformed

    private void menu_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_sairActionPerformed
        this.dispose();
    }//GEN-LAST:event_menu_sairActionPerformed

    private void menu_algoritmoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_algoritmoActionPerformed
        FormAlgoritmo algoritmo = new FormAlgoritmo(this);
        this.setEnabled(false);
        algoritmo.setVisible(true);
    }//GEN-LAST:event_menu_algoritmoActionPerformed

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
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormMain main_screen = new FormMain();
                main_screen.setVisible(true);
                main_screen.setEnabled(false);
                FormLogin login_screen = new FormLogin(main_screen);
                login_screen.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menu_algoritmo;
    private javax.swing.JMenuItem menu_aluno;
    private javax.swing.JMenuItem menu_area_pesquisa;
    private javax.swing.JMenuItem menu_complexidade;
    private javax.swing.JMenuItem menu_curso;
    private javax.swing.JMenuItem menu_linguagem_programacao;
    private javax.swing.JMenuItem menu_problema;
    private javax.swing.JMenuItem menu_sair;
    private javax.swing.JMenuItem menu_solucao;
    // End of variables declaration//GEN-END:variables
}
