/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puissance4_ackermann_bellod;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author vanin
 */
public class CelluleGraphique extends JButton { //cette classe est l'extension d'une cellule avec des propriétés graphiques 

    Cellule celluleAssociee;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_desint = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_jetonJaune = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_jetonRouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_trouNoir = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));

    public CelluleGraphique(Cellule uneCellule) {
        celluleAssociee = uneCellule;
    }

    //affiche la bonne image en fonction de cellule associee
    @Override //dessiner la cellule graphique 
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        if (celluleAssociee.presenceTrouNoir() == true) {
            setIcon(img_trouNoir); //on attribue l'image trouNoir.png si presence trounoir renvoie vrai
        } else if (celluleAssociee.presenceDesintegrateur() == true) {
            setIcon(img_desint); //on attribue l'image desintegrateur.png si presence trounoir renvoie vrai
        } else {
            String couleur_jeton = celluleAssociee.lireCouleurDuJeton();
            switch (couleur_jeton) {
                case "cellule vide":
                    setIcon(img_vide); //on attribue l'image celluleVide.png 
                    break;
                case "Rouge":
                    setIcon(img_jetonRouge);
                    break;
                case "Jaune":
                    setIcon(img_jetonJaune);
                    break;
            }
        }

    }
}
