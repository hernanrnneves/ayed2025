package practica3;

import java.util.ArrayList;
import java.util.List;
import practica1.java.Queue;

public class ejAG {

	public static void main(String[] args) {
		GeneralTree<Integer> A = new GeneralTree<Integer> (10);
		GeneralTree<Integer> B = new GeneralTree<Integer> (7);
		GeneralTree<Integer> C = new GeneralTree<Integer> (-1);
		GeneralTree<Integer> D = new GeneralTree<Integer> (100);
		GeneralTree<Integer> E = new GeneralTree<Integer> (-99);
		GeneralTree<Integer> F = new GeneralTree<Integer> (142);
		GeneralTree<Integer> G = new GeneralTree<Integer> (183);
		
		A.addChild(B);
		A.addChild(C);
		A.addChild(D);
		
		B.addChild(E);
		
		C.addChild(F);
		C.addChild(G);
		RecorridoAG recorrido = new RecorridoAG();
		List<Integer> preorden = recorrido.numerosImparesMayoresQuePreOrden(A,-99);
		System.out.println (preorden);
		
		RecorridoAG recorrido2 = new RecorridoAG();
		List<Integer> niveles = recorrido2.numerosImparesMayoresQuePorNiveles(A, 10);
		
		System.out.println (niveles);
		
		
	} 

}
