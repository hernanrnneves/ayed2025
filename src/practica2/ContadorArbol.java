package practica2;
import java.util.LinkedList;

import practica2.BinaryTree;
public class ContadorArbol {
	private BinaryTree<Integer> a;
	
	
	public ContadorArbol(BinaryTree<Integer> arbol) {
		this.a = arbol;
	}
	
	public LinkedList<Integer> NumerosPares (BinaryTree<Integer> a, LinkedList<Integer> l){
		if (a.hasRightChild()) {
			NumerosPares(a.getRightChild(),l);
		}
		if (a.getData() % 2 == 0) {
			l.add(a.getData());
		}
		if (a.hasLeftChild()) {
				NumerosPares (a.getLeftChild(),l);
		}
		return l;
	}
	  public LinkedList<Integer> NumerosPares_Start() {
		  if(this.a != null) {
			  LinkedList<Integer> lista = new LinkedList<Integer>();
			  NumerosPares(this.a,lista);
			  return lista;
		  }
		  else {return null;}
	  }
}
