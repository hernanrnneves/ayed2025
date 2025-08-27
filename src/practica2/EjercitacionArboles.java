// LO QUE HACE ESTE EJERCIO ES UNA SUMA DE LOS 2 ARBOLES EN EL CASO QUE SEAN IGUALES Y ESTEN LLENOS DE LA MISMA FORMA ;;

package practica2;
	
import practica2.BinaryTree;
public class EjercitacionArboles {
	
	public BinaryTree<Integer> sumarArboles (BinaryTree<Integer> ar1, BinaryTree<Integer> ar2){
		BinaryTree<Integer> arsuma = new BinaryTree<Integer>();
		if (ar1 == null || ar2 == null) return null;
		if (ar1.isEmpty() || ar2.isEmpty()) return arsuma;
		
		boolean estructuraValida = sumaRecursiva (ar1,ar2,arsuma);
		return estructuraValida ? arsuma : new BinaryTree<Integer>();
		
	}
	private static boolean sumaRecursiva (BinaryTree<Integer> ar1,BinaryTree<Integer> ar2,BinaryTree<Integer> arsuma) {
		boolean valid= true;
		
		arsuma.setData(ar1.getData()+ ar2.getData());
		
		if (ar1.hasLeftChild() && ar2.hasLeftChild()){
			if (ar1.hasRightChild() == ar2.hasRightChild()) {
				arsuma.addLeftChild(new BinaryTree<Integer> ());
				valid = sumaRecursiva (ar1.getLeftChild(), ar2.getLeftChild(),arsuma.getLeftChild());
			}
			else {valid=false;}
		}
		if (valid) {
			if (ar1.hasRightChild() && ar2.hasRightChild()) {
				arsuma.addRightChild(new BinaryTree<Integer> ());
				valid= sumaRecursiva (ar1.getRightChild(), ar2.getRightChild(), arsuma.getRightChild());
			}
			else {valid = ar1.hasRightChild() == ar2.hasRightChild();}
		}
		return valid;
	}
	
	
	public static void main (String [] args) {
		BinaryTree<Integer> ar1  = new BinaryTree<Integer> (4);
		BinaryTree<Integer> ar2 = new BinaryTree<Integer> (5);
		BinaryTree<Integer> izq  = new BinaryTree<Integer> (3);
		BinaryTree<Integer> der = new BinaryTree<Integer> (90);
		ar1.addLeftChild(izq);
		ar1.addRightChild(der);
		ar2.addLeftChild(izq);
		ar2.addRightChild(der);
		System.out.println ("///// ARBOL 1//////////");
		ar1.printEntreNiveles();
		System.out.println ("///// ARBOL 2//////");
		ar2.printEntreNiveles();
		EjercitacionArboles ej = new EjercitacionArboles();
		BinaryTree<Integer> suma = ej.sumarArboles(ar1, ar2);
		System.out.println ("///// ARBOL SUMA /////");
		suma.printEntreNiveles();
		
	}
	
	}
