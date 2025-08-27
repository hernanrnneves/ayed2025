package practica3;

import practica3.GeneralTree;
import practica1.java.Queue;

public class PArboles {
	public static boolean resolver(GeneralTree<Integer> arbol) {
		boolean ok=false;
		if(!arbol.isEmpty()) {
			ok= buscar(arbol);
		}
		return ok;
		
	}
	
	private boolean buscar (GeneralTree<Integer> a) {
		Queue<GeneralTree<Integer>> cola= new Queue<GeneralTree<Integer>> ();
		cola.enqueue(a);
		cola.enqueue(null);
		int nivel=0, contadorNivel=0;
		boolean ok=true;
		while (!cola.isEmpty()) {
			GeneralTree<Integer>elemento = cola.dequeue();
			if (elemento != null) {
					contadorNivel++;
				for (GeneralTree<Integer> child : elemento.getChildren()) {
					cola.enqueue(child);
				}
			}else{// recorre un nivel
				nivel++;
				contadorNivel=0;
				if  (contadorNivel != nivel+1) {
						return false;
				}
	
				if (!cola.isEmpty()) {
					cola.enqueue(null);
				}
			}
		}
		return true;
	}
	
		public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
			boolean ok=false; 
			if (!arbol.isEmpty()) {
				ok= seleccionA(arbol);
			}
			return ok;
			
		}
	private boolean seleccion1 (GeneralTree<Integer> ar) {
		boolean ok=true;
		int min=999;
		if (!ar.isLeaf()) {
			for (GeneralTree<Integer> child: ar.getChildren()) {
				ok = seleccionA 	(child);
				if (child.getData() > min) {
					min=child.getData();
				}
			}
			if (ar.getData() != min)) {
				ok=false;
			}
		}
	return ok;
		}	

}

