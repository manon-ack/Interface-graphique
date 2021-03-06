/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puissance4_ackermann_bellod;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author namre
 */
public class FenetreDeJeu extends javax.swing.JFrame {

    Joueur[] ListeJoueurs = new Joueur[2];
    Joueur joueurCourant;
    Grille GrilleInitiale = new Grille();

    /**
     * Creates new form FenetreDeJeu
     */
    public FenetreDeJeu() {
        initComponents();
        panneau_info_joueur.setVisible(false); //permet de cacher les deux parties tant que la partie n'est pas demarré
        panneau_info_partie.setVisible(false);

        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                CelluleGraphique cellGraph = new CelluleGraphique(GrilleInitiale.Cellules[i][j]);
                cellGraph.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Cellule C = cellGraph.celluleAssociee;
                        if (C.jetonCourant == null) {
                            return;
                        }

                        if (C.jetonCourant.Couleur.equals(joueurCourant.Couleur)) {
                            textemessage.setText("Le joueur " + joueurCourant.Nom + " réupère un de ses jetons");
                            Jeton j_recup = C.recupererJeton();
                            joueurCourant.ajouterJeton(j_recup);
                            joueurSuivant();
                        } else {
                            if (joueurCourant.nombreDesintegrateurs > 0);
                            {
                                textemessage.setText("Le joueur " + joueurCourant.Nom + " désintègre un jeton adverse");
                                C.supprimerJeton();
                                joueurCourant.utiliserDesintegrateur();
                                joueurSuivant();
                            }
                        }
                        GrilleInitiale.tasserGrille();
                        panneau_grille.repaint();
                        lbl_j1_desint.setText(ListeJoueurs[0].nombreDesintegrateurs + ""); //affiche le nb de desting sur le panneau
                        lbl_j2_desint.setText(ListeJoueurs[1].nombreDesintegrateurs + "");

                        boolean vict_j1 = GrilleInitiale.etreGagnantePourJoueur(ListeJoueurs[0]);
                        boolean vict_j2 = GrilleInitiale.etreGagnantePourJoueur(ListeJoueurs[1]);

                        if (vict_j1 && !vict_j2) {
                            textemessage.setText("Victoire de " + ListeJoueurs[0].Nom + " ! Cliquer pour recommencer une partie !");
                            btn_col_0.setEnabled(false);
                            btn_col_1.setEnabled(false);
                            btn_col_2.setEnabled(false);
                            btn_col_3.setEnabled(false);
                            btn_col_4.setEnabled(false);
                            btn_col_5.setEnabled(false);
                            btn_col_6.setEnabled(false);
                            btn_start.setEnabled(true); //possibilité de redemarrer une partie apres une victoire
                        }
                        if (vict_j2 && !vict_j1) {
                            textemessage.setText("Victoire de " + ListeJoueurs[1].Nom + " ! Cliquer pour recommencer une partie !");
                            btn_col_0.setEnabled(false);
                            btn_col_1.setEnabled(false);
                            btn_col_2.setEnabled(false);
                            btn_col_3.setEnabled(false);
                            btn_col_4.setEnabled(false);
                            btn_col_5.setEnabled(false);
                            btn_col_6.setEnabled(false);
                            btn_start.setEnabled(true); //possibilité de redemarrer une partie apres une victoire
                        }

                        if (vict_j1 && vict_j2) {
                            if (joueurCourant == ListeJoueurs[0]) {
                                textemessage.setText("Victoire de " + ListeJoueurs[1].Nom + "faute de jeu de l'autre joueur" + " ! Cliquer pour recommencer une partie !");
                                btn_col_0.setEnabled(false);
                                btn_col_1.setEnabled(false);
                                btn_col_2.setEnabled(false);
                                btn_col_3.setEnabled(false);
                                btn_col_4.setEnabled(false);
                                btn_col_5.setEnabled(false);
                                btn_col_6.setEnabled(false);
                                btn_start.setEnabled(true); //possibilité de redemarrer une partie apres une victoire
                            } else {
                                textemessage.setText("Victoire de " + ListeJoueurs[0].Nom + "faute de jeu de l'autre joueur" + " ! Cliquer pour recommencer une partie !");
                                btn_col_0.setEnabled(false);
                                btn_col_1.setEnabled(false);
                                btn_col_2.setEnabled(false);
                                btn_col_3.setEnabled(false);
                                btn_col_4.setEnabled(false);
                                btn_col_5.setEnabled(false);
                                btn_col_6.setEnabled(false);
                                btn_start.setEnabled(true); //possibilité de redemarrer une partie apres une victoire
                            }
                            
                        }
                    }
                });
                panneau_grille.add(cellGraph);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneau_grille = new javax.swing.JPanel();
        panneau_info_joueur = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_j2_desint = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_j2_couleur = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_j1_desint = new javax.swing.JLabel();
        lbl_j1_couleur = new javax.swing.JLabel();
        lbl_j1_nom = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_j2_nom = new javax.swing.JLabel();
        panneau_création_partie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Nom_joueur_2 = new javax.swing.JTextField();
        Nom_joueur_1 = new javax.swing.JTextField();
        btn_start = new javax.swing.JButton();
        panneau_info_partie = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_joueurcourant = new javax.swing.JLabel();
        Message = new javax.swing.JScrollPane();
        textemessage = new javax.swing.JTextArea();
        btn_col_6 = new javax.swing.JButton();
        btn_col_0 = new javax.swing.JButton();
        btn_col_1 = new javax.swing.JButton();
        btn_col_2 = new javax.swing.JButton();
        btn_col_3 = new javax.swing.JButton();
        btn_col_4 = new javax.swing.JButton();
        btn_col_5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneau_grille.setBackground(new java.awt.Color(204, 255, 255));
        panneau_grille.setLayout(new java.awt.GridLayout(6, 7));
        getContentPane().add(panneau_grille, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 672, 576));

        panneau_info_joueur.setBackground(new java.awt.Color(255, 153, 255));
        panneau_info_joueur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 2, 18)); // NOI18N
        jLabel3.setText("Informations joueurs : ");
        panneau_info_joueur.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel4.setText("Joueur  2 :");
        panneau_info_joueur.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        lbl_j2_desint.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 14)); // NOI18N
        lbl_j2_desint.setText("NbDesintJoueur2");
        panneau_info_joueur.add(lbl_j2_desint, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 140, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 14)); // NOI18N
        jLabel7.setText("Désintégrateurs :");
        panneau_info_joueur.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        lbl_j2_couleur.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 14)); // NOI18N
        lbl_j2_couleur.setText("Couleur Joueur2");
        panneau_info_joueur.add(lbl_j2_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 130, -1));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 14)); // NOI18N
        jLabel9.setText("Couleur :");
        panneau_info_joueur.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel10.setText("Joueur 1 :");
        panneau_info_joueur.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 14)); // NOI18N
        jLabel11.setText("Couleur :");
        panneau_info_joueur.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 14)); // NOI18N
        jLabel12.setText("Désintégrateurs :");
        panneau_info_joueur.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        lbl_j1_desint.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 14)); // NOI18N
        lbl_j1_desint.setText("NbDesintJoueur1");
        panneau_info_joueur.add(lbl_j1_desint, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 140, -1));

        lbl_j1_couleur.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 14)); // NOI18N
        lbl_j1_couleur.setText("Couleur Joueur1");
        panneau_info_joueur.add(lbl_j1_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 140, -1));

        lbl_j1_nom.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lbl_j1_nom.setText("NomJoueur1");
        panneau_info_joueur.add(lbl_j1_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 120, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        panneau_info_joueur.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 132, 290, 10));

        lbl_j2_nom.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lbl_j2_nom.setText("NomJoueur2");
        panneau_info_joueur.add(lbl_j2_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 130, -1));

        getContentPane().add(panneau_info_joueur, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 300, 260));

        panneau_création_partie.setBackground(new java.awt.Color(255, 153, 255));
        panneau_création_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel1.setText("Nom Joueur 2 : ");
        panneau_création_partie.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel2.setText("Nom Joueur 1 : ");
        panneau_création_partie.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        Nom_joueur_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nom_joueur_2ActionPerformed(evt);
            }
        });
        panneau_création_partie.add(Nom_joueur_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 100, -1));
        panneau_création_partie.add(Nom_joueur_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 100, -1));

        btn_start.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        btn_start.setText("Démarrer Partie");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        panneau_création_partie.add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        getContentPane().add(panneau_création_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 300, 110));

        panneau_info_partie.setBackground(new java.awt.Color(255, 153, 255));
        panneau_info_partie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 2, 18)); // NOI18N
        jLabel5.setText("Informations jeu : ");
        panneau_info_partie.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        jLabel13.setText("Joueur Courant :");
        panneau_info_partie.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        lbl_joueurcourant.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 14)); // NOI18N
        lbl_joueurcourant.setText("NomJoueurCourant");
        panneau_info_partie.add(lbl_joueurcourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 140, -1));

        textemessage.setColumns(20);
        textemessage.setRows(5);
        Message.setViewportView(textemessage);

        panneau_info_partie.add(Message, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 280, 50));

        getContentPane().add(panneau_info_partie, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 500, 300, 120));

        btn_col_6.setText("7");
        btn_col_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_6ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(626, 40, -1, -1));

        btn_col_0.setText("1");
        btn_col_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_0ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        btn_col_1.setText("2");
        btn_col_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 40, -1, -1));

        btn_col_2.setText("3");
        btn_col_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 40, -1, -1));

        btn_col_3.setText("4");
        btn_col_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 40, -1, -1));

        btn_col_4.setText("5");
        btn_col_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 40, -1, -1));

        btn_col_5.setText("6");
        btn_col_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_col_5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_col_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        setBounds(0, 0, 1044, 702);
    }// </editor-fold>//GEN-END:initComponents

    private void Nom_joueur_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nom_joueur_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nom_joueur_2ActionPerformed

    private void btn_col_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_2ActionPerformed
        jouerDansColonne(2);
        if (GrilleInitiale.colonneRemplie(2) == true) {
            btn_col_2.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_2ActionPerformed

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        panneau_info_joueur.setVisible(true); //permet de cacher les deux parties tant que la partie n'est pas demarré
        panneau_info_partie.setVisible(true);
        initialiserPartie();
        panneau_grille.repaint(); //permet de redessiner l'ecran de jeu , rafraichit l'affichage 
        btn_start.setEnabled(false); //desactive le bouton pour plus pouvoir rafraichir 
    }//GEN-LAST:event_btn_startActionPerformed

    private void btn_col_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_0ActionPerformed
        jouerDansColonne(0);
        if (GrilleInitiale.colonneRemplie(0) == true) {
            btn_col_0.setEnabled(false); //si la colonne est remplie je desactive le bouton 0
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_0ActionPerformed

    private void btn_col_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_1ActionPerformed
        jouerDansColonne(1);
        if (GrilleInitiale.colonneRemplie(1) == true) {
            btn_col_1.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_1ActionPerformed

    private void btn_col_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_3ActionPerformed
        jouerDansColonne(3);
        if (GrilleInitiale.colonneRemplie(3) == true) {
            btn_col_3.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_3ActionPerformed

    private void btn_col_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_4ActionPerformed
        jouerDansColonne(4);
        if (GrilleInitiale.colonneRemplie(4) == true) {
            btn_col_4.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_4ActionPerformed

    private void btn_col_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_5ActionPerformed
        jouerDansColonne(5);
        if (GrilleInitiale.colonneRemplie(5) == true) {
            btn_col_5.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_5ActionPerformed

    private void btn_col_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_col_6ActionPerformed
        jouerDansColonne(6);
        if (GrilleInitiale.colonneRemplie(6) == true) {
            btn_col_6.setEnabled(false);
        }
        joueurSuivant();
    }//GEN-LAST:event_btn_col_6ActionPerformed

    public boolean jouerDansColonne(int indice_colonne) { //permt de factoriser le code plutot que d'ecrire tout le code dans chaque fonctio

        boolean jeu;
        //on utilise la methode ajouterjetondanscolonne pour mettre le jeton ou le joueur veut
        jeu = GrilleInitiale.ajouterJetonDansColonne(joueurCourant, indice_colonne); //renvoie vraie que si le jeton est bien ajouté 
      
        panneau_grille.repaint(); //on rafraichit la panneau 

        lbl_j1_desint.setText(ListeJoueurs[0].nombreDesintegrateurs + ""); //affiche le nb de desting sur le panneau
        lbl_j2_desint.setText(ListeJoueurs[1].nombreDesintegrateurs + "");

        boolean vict_j1 = GrilleInitiale.etreGagnantePourJoueur(ListeJoueurs[0]);
        boolean vict_j2 = GrilleInitiale.etreGagnantePourJoueur(ListeJoueurs[1]);

        if (vict_j1 && !vict_j2) {
            textemessage.setText("Victoire de " + ListeJoueurs[0].Nom + " ! Cliquer pour recommencer une partie !");
            btn_col_0.setEnabled(false); //on bloque les colonnes qd il y a victoire
            btn_col_1.setEnabled(false);
            btn_col_2.setEnabled(false);
            btn_col_3.setEnabled(false);
            btn_col_4.setEnabled(false);
            btn_col_5.setEnabled(false);
            btn_col_6.setEnabled(false);
            btn_start.setEnabled(true); //possibilité de redemarrer une partie apres une victoire
        }
        if (vict_j2 && !vict_j1) {
            textemessage.setText("Victoire de " + ListeJoueurs[1].Nom + " ! Cliquer pour recommencer une partie !");
            btn_col_0.setEnabled(false);
            btn_col_1.setEnabled(false);
            btn_col_2.setEnabled(false);
            btn_col_3.setEnabled(false);
            btn_col_4.setEnabled(false);
            btn_col_5.setEnabled(false);
            btn_col_6.setEnabled(false);
            btn_start.setEnabled(true); //possibilité de redemarrer une partie apres une victoire
        }

        if (vict_j1 && vict_j2) {
            if (joueurCourant == ListeJoueurs[0]) {
                textemessage.setText("Victoire de " + ListeJoueurs[1].Nom + " faute de jeu de l'autre joueur" + " ! Cliquer pour recommencer une partie !");
                btn_col_0.setEnabled(false);
                btn_col_1.setEnabled(false);
                btn_col_2.setEnabled(false);
                btn_col_3.setEnabled(false);
                btn_col_4.setEnabled(false);
                btn_col_5.setEnabled(false);
                btn_col_6.setEnabled(false);
                btn_start.setEnabled(true);
            } else {
                textemessage.setText("Victoire de " + ListeJoueurs[0].Nom + " faute de jeu de l'autre joueur" + " ! Cliquer pour recommencer une partie !");
                btn_col_0.setEnabled(false);
                btn_col_1.setEnabled(false);
                btn_col_2.setEnabled(false);
                btn_col_3.setEnabled(false);
                btn_col_4.setEnabled(false);
                btn_col_5.setEnabled(false);
                btn_col_6.setEnabled(false);
                btn_start.setEnabled(true);
            }
        }

        if (jeu == true) {
            return true;
        } else {
            return false;
        }
    }

    public void joueurSuivant() {
        if (joueurCourant == ListeJoueurs[0]) {
            joueurCourant = ListeJoueurs[1];
            lbl_joueurcourant.setText(joueurCourant.Nom);
            //textemessage.setText(joueurCourant.Nom + " il te reste " + joueurCourant.nombreJetonsRestant+" jetons");
        } else {
            joueurCourant = ListeJoueurs[0];
            lbl_joueurcourant.setText(joueurCourant.Nom); //on met à jour le texte dans le panneau
            //textemessage.setText(joueurCourant.Nom + " il te reste " + joueurCourant.nombreJetonsRestant+" jetons");
        }
    }

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
            java.util.logging.Logger.getLogger(FenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreDeJeu().setVisible(true);
            }
        });
    }

    public void initialiserPartie() {

        GrilleInitiale.viderGrille(); //on prepare la grille pour une partie

        //placer les 5 trous noirs 
        Random r = new Random();
        //placer les 5 trous noirs et 2 desintegrateurs sur les trous noirs
        int a = 0;
        for (int i = 0; i < 5; i++) {
            int ligTN = r.nextInt(6);
            int colTN = r.nextInt(7);
            if (a < 2) {
                if (!GrilleInitiale.placerDesintegrateur(ligTN, colTN)) {
                    a--;
                }
                a = a + 1;
            }
            if (!GrilleInitiale.placerTrouNoir(ligTN, colTN)) {
                i--;
            }
        }

        //placer les 3 desintegrateurs restants
        for (int i = 0; i < 3; i++) {
            int ligdesint = r.nextInt(6);
            int coldesint = r.nextInt(7);
            if (!GrilleInitiale.placerDesintegrateur(ligdesint, coldesint) || GrilleInitiale.Cellules[ligdesint][coldesint] == null) {
                i--;
            }
        }

        //on insere les joueurs   
        String nomJoueur1 = Nom_joueur_1.getText(); //permet de recuperer le texte qui a été tapé 
        Joueur Joueur_1 = new Joueur(nomJoueur1);
        String nomJoueur2 = Nom_joueur_2.getText(); //permet de recuperer le texte qui a été tapé 
        Joueur Joueur_2 = new Joueur(nomJoueur2);
        ListeJoueurs[0] = Joueur_1;
        ListeJoueurs[1] = Joueur_2;

        attribuerCouleursAuxJoueurs(); //on leur attribue une couleur grâce à la méthode 
        textemessage.setText("La partie va commencer, vous disposez chacun de 21 jetons");

        System.out.println(Joueur_1.Nom + " prend les jetons de couleur " + Joueur_1.Couleur);
        System.out.println(Joueur_2.Nom + " prend les jetons de couleur " + Joueur_2.Couleur);
        System.out.println("\n");

        for (int i = 0; i < 21; i++) { //on attribue les 21 jetons à chaque joueur
            Jeton jeton1 = new Jeton(ListeJoueurs[0].Couleur);
            Joueur_1.ajouterJeton(jeton1);
            Jeton jeton2 = new Jeton(ListeJoueurs[1].Couleur);
            Joueur_2.ajouterJeton(jeton2);
        }

        //on determine qui commence 
        Random c = new Random();
        boolean le1 = c.nextBoolean();
        if (le1) {
            joueurCourant = ListeJoueurs[0];
        } else {
            joueurCourant = ListeJoueurs[1];
        }
        lbl_joueurcourant.setText(joueurCourant.Nom); //on met dans le panneau info jeu le nom du joueur courant 

        //on met à jour le panneau infos joueurs avec les données 
        lbl_j1_nom.setText(nomJoueur1);
        lbl_j2_nom.setText(nomJoueur2);
        lbl_j1_couleur.setText(Joueur_1.Couleur);
        lbl_j2_couleur.setText(Joueur_2.Couleur);
        lbl_j1_desint.setText(Joueur_1.nombreDesintegrateurs + "");
        lbl_j2_desint.setText(Joueur_2.nombreDesintegrateurs + "");
        
        btn_col_0.setEnabled(true);
        btn_col_1.setEnabled(true);
        btn_col_2.setEnabled(true);
        btn_col_3.setEnabled(true);
        btn_col_4.setEnabled(true);
        btn_col_5.setEnabled(true);
        btn_col_6.setEnabled(true);
    }

    public void attribuerCouleursAuxJoueurs() { //attribue une couleur aux deux joueurs 
        ListeJoueurs[0].Couleur = "Jaune";
        ListeJoueurs[1].Couleur = "Rouge";

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Message;
    private javax.swing.JTextField Nom_joueur_1;
    private javax.swing.JTextField Nom_joueur_2;
    private javax.swing.JButton btn_col_0;
    private javax.swing.JButton btn_col_1;
    private javax.swing.JButton btn_col_2;
    private javax.swing.JButton btn_col_3;
    private javax.swing.JButton btn_col_4;
    private javax.swing.JButton btn_col_5;
    private javax.swing.JButton btn_col_6;
    private javax.swing.JButton btn_start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_j1_couleur;
    private javax.swing.JLabel lbl_j1_desint;
    private javax.swing.JLabel lbl_j1_nom;
    private javax.swing.JLabel lbl_j2_couleur;
    private javax.swing.JLabel lbl_j2_desint;
    private javax.swing.JLabel lbl_j2_nom;
    private javax.swing.JLabel lbl_joueurcourant;
    private javax.swing.JPanel panneau_création_partie;
    private javax.swing.JPanel panneau_grille;
    private javax.swing.JPanel panneau_info_joueur;
    private javax.swing.JPanel panneau_info_partie;
    private javax.swing.JTextArea textemessage;
    // End of variables declaration//GEN-END:variables
}
