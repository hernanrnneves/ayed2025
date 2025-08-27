package practica2;

import practica1.java.*;
import practica2.BinaryTree;

public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;
	
	public RedBinariaLlena(BinaryTree<Integer> arbol) {
		this.arbol=arbol;
	}
	
	
	public int retardoReenvio() {
		if(this.arbol.isEmpty()) {
			return 0;
		}
		else {
			int suma=0;
			Integer max=Integer.MIN_VALUE;
			Queue<BinaryTree<Integer>>cola=new Queue<BinaryTree<Integer>>();
			cola.enqueue(this.arbol);
			cola.enqueue(null);
			while(!cola.isEmpty()) {
				BinaryTree<Integer>ab=cola.dequeue();
				if(ab!=null) {
					if(ab.getData()>=max) {
						max=ab.getData();
					}
					if(ab.hasLeftChild()) {
						cola.enqueue(ab.getLeftChild());
					}
					if(ab.hasRightChild()) {
						cola.enqueue(ab.getRightChild());
					}
				}
				else {
					suma+=max;
					max=Integer.MIN_VALUE;
					if(!cola.isEmpty()) {
						cola.enqueue(null);
					}
				}
			}
			return suma;
		}
	}
}