package interfaceGraphique.gui.user;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JTree;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import utilisateur.FilDiscussion;

public class ThreadTree extends JTree {
	
	public ThreadTree(DefaultMutableTreeNode mainRoot, TreeModel modele) {
		super(modele);
		List<String> listeGroupes = User.getCurrentUser().getGroupesUtilisateur();
		for (int i = 0; i < listeGroupes.size(); i++) {
		DefaultMutableTreeNode newGroupe = new DefaultMutableTreeNode(listeGroupes.get(i));
		List<FilDiscussion> listeFils = User.getCurrentUser().getAllFilDiscussion();
			for (ListIterator<FilDiscussion> iterateur = listeFils.listIterator(); iterateur.hasNext();) {
					FilDiscussion newFil = iterateur.next();
					DefaultMutableTreeNode newSujet = new DefaultMutableTreeNode(newFil);
					newGroupe.add(newSujet);
			}
			mainRoot.add(newGroupe);
		}
	
		this.setVisibleRowCount(100);
		this.setPreferredSize(new Dimension(100, 100));
		this.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.setBackground(Color.LIGHT_GRAY);
	}
}