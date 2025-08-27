package practica2;

import java.util.List;

import practica3.GeneralTree;

public class ParcialLista {
	public List<GeneralTree<Integer>> resolver (GeneralTree<Integer>arbol){
		if (arbol!= null) {
			return res (arbol);	
		}
		return null;
	}
	private List<GeneralTree<Integer>> res (GeneralTree<Integer> a){
		List<BinaryTree<Integer>> nuevo=  new LinkedList<> ();
		for (GeneralTree<Integer> hijo : a.getChildren()) {
			if (!a.isLeaf() && (hijo.size() % 2 == 0))
				nuevo.add(res(hijo));
		}
	}
	
	
}
