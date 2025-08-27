package parciales;

import practica2.BinaryTree;

public class RecorrerArbolBinario {
	private BinaryTree <Integer> arbol;
	
	public BinaryTree <Integer> parcial (){
		if (this.arbol != null) {
			BinaryTree <Integer> ret= new BinaryTree<>(arbol.getData());
			resolution (arbol,ret, ret.getData());
			return ret;
		}else {
		return null;
		}
	}
	
	private void resolution(BinaryTree<Integer> arbol,BinaryTree<Integer> ret, int d ) {
		if (arbol.hasLeftChild()) {
			ret.addLeftChild(d+arbol.getLeftChild().getData());
			d=arbol.getLeftChild().getData();
			resolution(arbol.getLeftChild(),ret.getLeftChild(),d);
		}
		if (arbol.hasRightChild()) {
			ret.addRightChild(d+arbol.getRightChild().getData());
			d=arbol.getRightChild().getData();
			resolution(arbol.getRightChild(),ret.getRightChild(),d);
		}
	}
}
