package practica3;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import practica2.BinaryTree;
public class videoPrueba {
	public static List<Integer> buscarCaminoMin(GeneralTree<Integer> a){
		List<Integer> ret= new LinkedList<Integer>();
		if (!a.isEmpty()) {
			buscarMin(a,ret,new LinkedList<Integer>(),0, 999);
		}
		return ret;
		
	}
	
	private void buscarMin (GeneralTree<Integer> nodo, List<Integer> caminoActual,List<Integer>caminoMin, int sumaActual,int minSuma) {
		caminoActual.add(nodo.getData());
		sumaActual += nodo.getData();

		if (nodo.isLeaf()) {
			if (sumaActual < minSuma) {
				minSuma = sumaActual;
				caminoMin.clear();
				caminoMin.addAll(caminoActual);
			}
		} else {
			for (GeneralTree<Integer> hijo : nodo.getChildren()) {
				buscarMin(hijo, caminoActual, caminoMin, sumaActual, minSuma);
			}
		}

		// backtracking
		caminoActual.remove(caminoActual.size() - 1);
	}	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// PARCIAL  ES INFERIOR PROFUNDO
	public boolean ComparadorDeArbolesGen (GeneralTree<Integer>a1, GeneralTree<Integer>a2) {
		boolean ok=true;
		if (a1 != null && a2 !=null) 
			{ok= bus(a1,a2);}
		return ok;
	}
	
	private boolean bus (GeneralTree<Integer>a1, GeneralTree<Integer>a2) {
		boolean ok=true;
			if (a1.getData() > a2.getData()) {
				ok= false;
			}
			if (!a1.isLeaf() && !a2.isLeaf()) {
				int cont1=0,cont2 =0;
				cont1= contador (a1);
				cont2= contador(a2);
				if (cont1 > cont2) {
					ok=false;
				}
				}else if (a1.getData() > a2.getData()) {
						ok=false;
					}
			if (a1.isLeaf() && !a2.isLeaf()) {
				if (a1.getData() > a2.getData()) {
					ok=false;
				}
			}
			if (!a1.isLeaf() && a2.isLeaf()) {return false;}
		 // Recursión por hijos
		    Iterator<GeneralTree<Integer>> it1 = a1.getChildren().iterator();
		    Iterator<GeneralTree<Integer>> it2 = a2.getChildren().iterator();

		    while (it1.hasNext() && it2.hasNext()) {
		        GeneralTree<Integer> c1 = it1.next();
		        GeneralTree<Integer> c2 = it2.next();
		        if (!bus(c1, c2)) ok=false;
		    }

		    return ok;
		}
	private static int contador (GeneralTree<Integer> a) {
		int cont=0;
		for(GeneralTree<Integer> child :  a.getChildren()) {
			cont+= child.getData();
		}
		return cont;
	}

}

