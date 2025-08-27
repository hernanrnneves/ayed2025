package practica2;

import practica2.BinaryTree;

public class ProfundidadArbol {
	private BinaryTree <Integer> a;
	
	 private int sumaRecursiva(BinaryTree<Integer> nodo, int profundidadObjetivo, int profundidadActual) {
	        if (nodo == null) {
	            return 0;
	        }

	        if (profundidadActual == profundidadObjetivo) {
	            return nodo.getData();  // sumamos el dato si estamos en la profundidad correcta
	        }

	        int sumaIzquierda = 0;
	        int sumaDerecha = 0;

	        if (nodo.hasLeftChild()) {
	            sumaIzquierda = sumaRecursiva(nodo.getLeftChild(), profundidadObjetivo, profundidadActual + 1);
	        }
	        if (nodo.hasRightChild()) {
	            sumaDerecha = sumaRecursiva(nodo.getRightChild(), profundidadObjetivo, profundidadActual + 1);
	        }

	        return sumaIzquierda + sumaDerecha;
	    }

	
	public ProfundidadArbol (BinaryTree <Integer> ar) {
		this.a=ar;
	}
	
	public int  sumaElementosProfundidad (int p) {
		if (a.isEmpty()) {}
		return 0;
	}
	else {
		return sumaRecursiva(a,p,0);
		}
}

