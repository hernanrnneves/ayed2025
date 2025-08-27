package practica3;

import java.util.LinkedList;
import java.util.List;

public class Caminos {
	private GeneralTree<Integer> ar;
	
	public List<Integer> caminoAHojaMasLejana (){
		List<Integer> l = new LinkedList<Integer>();
		if ((ar != null) && (!ar.isEmpty())) {
			return busqueda(ar, l);
		}
		return l;
	}
	
	private void busqueda (GeneralTree<Integer> ar, List<Integer> l) {
		int i=0, max= -1;
		List<Integer> camino= new LinkedList<Integer> ();
		camino.add(ar.getData());
		if (ar.isLeaf()) {
			if (l.size() < camino.size()) {
				l=camino;
			}
		}else {
			for (GeneralTree<Integer> child : ar.getChildren()) {
				busqueda(child,l);
		}
		}
		camino.remove(camino.size() - 1);
	}
	
}
