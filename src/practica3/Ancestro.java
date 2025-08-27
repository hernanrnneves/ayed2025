package practica3;

import java.util.LinkedList;
import java.util.List;

public class Ancestro {
	private GeneralTree <Integer> a;
	
	public public boolean esAncestro(int in, int fin) {
		boolean ok=false;
		if (a != null && !a.isEmpty()) {
			GeneralTree <Integer> nodoA = contiene (this.a, in);
			if (!nodoA.isEmpty()) {
				ok=buscar (nodoA , fin);
			}
		return ok;
		
	}
	}
	
	private GeneralTree <Integer> contiene (GeneralTree<Integer> a, int i){
		
		if (a.getData() == i) {
			return a;
		}
		List<Integer> children = a.getChildren();
		for (GeneralTree<Integer> child : children) {
			GeneralTree <Integer> res= contiene (a,i);
			if ( res != null) {
				return res;
			}
		}
		return null;
	}
	
	private boolean buscar (GeneralTree<Integer> a, int fin) {
		if (a.getData()== fin) {
			return true;
		}
		for (GeneralTree <Integer> child: a.getChildren()) {
			if (buscar (child,fin)) {
				return true;
			}
		}
		return false;
	}
	
}
