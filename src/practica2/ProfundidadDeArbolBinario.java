package practica2;


import practica2.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer>arbol;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer>arbol) {
		this.arbol=arbol;
	}
	private int sumaElementosProfundidadRecursiva(BinaryTree<Integer>ab,int p,int i) {
		if(ab.isEmpty()) {
			return 0;
		}
		else {
			if(p==i) {//si es la profundidad sumamos
				return ab.getData();
			}
			int sumaIzq=0;
			if(ab.hasLeftChild()) {
				sumaIzq =sumaElementosProfundidadRecursiva(ab.getLeftChild(),p,i+1);
			}
			int sumaDer=0;
			if(ab.hasRightChild()) {
				sumaDer =sumaElementosProfundidadRecursiva(ab.getRightChild(),p,i+1);	
			}
			
			return sumaIzq+sumaDer;
		}
	}
	public int sumaElementosProfundidad(int p) {
		if(arbol.isEmpty()) {
			return 0;
		}
		return sumaElementosProfundidadRecursiva(this.arbol,p,0);
	}
}