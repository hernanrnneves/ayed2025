package practica2;

import practica2.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer>arbol;
	
	public Transformacion(BinaryTree<Integer> arbol) {
		this.arbol=arbol;
	}
	//Modifico el arbol de la variable de instancia por que no me salio hacer un nuevo arbol.-->ya me salio 
	private int sumaRecursiva(BinaryTree<Integer>ab){
		int sumaTotal=0;
		//creo que podria tener una sola variable pero queda mas legible asi
		int sumaIzq=0;
		int sumaDer=0;
		//Si es hoja sumo (seteo en 0 y me tengo q guardar el dato antes)
		if(ab.isLeaf()) {
			sumaTotal=ab.getData();
			ab.setData(0);
			return sumaTotal;
		}
		//suma de hijos izquierdos
		if(ab.hasLeftChild()) {
			sumaIzq=sumaRecursiva(ab.getLeftChild());
		}
		if(ab.hasRightChild()) {
			sumaDer=sumaRecursiva(ab.getRightChild());
		}
		sumaTotal =sumaIzq+sumaDer;
		//me quedo con el dato actual
		int aux=ab.getData();
		ab.setData(sumaTotal);
		return sumaTotal+aux;
		
	}
	
	//Forma alternativa de hacerlo
	private BinaryTree<Integer>sumaRecursivaAlternativa(BinaryTree<Integer>ab){
		//podria ser sin parametros 
		int suma=0;
		BinaryTree<Integer>nuevoArbol=new BinaryTree<Integer>();
		if(ab.isLeaf()) {
			nuevoArbol.setData(0);
		}
		if(ab.hasLeftChild()) {
			BinaryTree<Integer> izq = sumaRecursivaAlternativa(ab.getLeftChild());
			suma+= izq.getData()+ab.getLeftChild().getData();
			nuevoArbol.addLeftChild(izq);
		}
		if(ab.hasRightChild()) {
			BinaryTree<Integer>der=sumaRecursivaAlternativa(ab.getRightChild());
			suma +=der.getData()+ab.getRightChild().getData();
			nuevoArbol.addRightChild(der);
		}
		nuevoArbol.setData(suma);
		return nuevoArbol;
	}
	/*
	 	
	 */
	public BinaryTree<Integer>suma(){
		if(this.arbol.isEmpty()) {
			return null;
		}
		//sumaRecursiva(this.arbol);
		return sumaRecursivaAlternativa(this.arbol);
	}
}