package practica2;

public class ej3p2 {

	public static void main(String[] args) {
		BinaryTree<Integer> arbol = new BinaryTree<Integer> (4);
		BinaryTree<Integer> hi = new BinaryTree<Integer> (5);
		BinaryTree<Integer> hd = new BinaryTree<Integer> (6);
		BinaryTree<Integer> nodo1 = new BinaryTree<Integer> (70);
		BinaryTree<Integer> nodo2 = new BinaryTree<Integer> (54);
		
		hi.addLeftChild(nodo1);
		hd.addRightChild(nodo2);
		
		arbol.addLeftChild(hi);
		arbol.addRightChild(hd);
		
		arbol.printInOrden();
		
		ContadorArbol cont = new ContadorArbol (arbol);
		System.out.println (cont.NumerosPares_Start());
	}

}
