package practica2;

import practica2.BinaryTree;
public class ParcialArboles {
	private BinaryTree<Integer> a;
	
	
	public ParcialArboles (BinaryTree<Integer> a) {
		this.a= a;
	}
	
	public boolean isLeftTree (int num) {
		boolean ok = false;
		if (a.isEmpty()) {
			return false;
		}
		else {
			ok = Buscar(a, num);
			return ok;
		}
	}
	
	private boolean Buscar (BinaryTree<Integer> a,int n){
		boolean ok =false;
		int der =0, izq =0;
		if (a.getData() == n) {
			if (a.hasLeftChild()) {
				izq += contar (a.getLeftChild());
			}else if (a.hasRightChild()) {
				der+= contar (a.getRightChild());
			}
		
		return izq > der;
	}
	else {
		if (a.hasLeftChild()) {
			ok = Buscar (a.getLeftChild(), n);
			return ok;
		}
		else if (a.hasRightChild()){
			ok= Buscar (a.getRightChild(),n);
			return ok;
		}
	} 
	return ok;	
	}
	
	private int contar (BinaryTree <Integer> ar) {
		int cantidad=0,izq=0,der=0;
		if (a.isLeaf()) {
			return 0;
		}else {
			if(ar.hasRightChild() && ar.hasLeftChild()) {
				cantidad = 0 + contar (ar.getRightChild());
				der += cantidad;
				cantidad = 0+ contar (ar.getLeftChild());
				izq += cantidad;
			}
			else if (ar.hasLeftChild() && !ar.getRightChild()) {
				cantidad = 0 + contar(ar.getLeftChild());
				izq+= cantidad;
			}else if (ar.hasRightChild() && !ar.hasLeftChild()) {
				cantidad =0 + contar(ar.getRightChild());
				der+=cantidad;
			}	
			}
		}
		
		
	}
}
