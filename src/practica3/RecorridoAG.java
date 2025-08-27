package practica3;

import java.util.LinkedList;
import java.util.List;
import practica1.java.Queue;


public class RecorridoAG {
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n) {
		if (a.isEmpty()) {
			return null;
		}
		else {
			return BusquedaPreOrden(a,n);
		}
	}
	public List<Integer> BusquedaPreOrden (GeneralTree <Integer> a, Integer n){
		List <Integer> l = new LinkedList<Integer>();
		if ((a.getData() > n)&& (a.getData() %2 != 0)) {
			l.add(a.getData());
		}
		for (GeneralTree<Integer> hijo : a.getChildren()) {
			List<Integer> subLista = BusquedaPreOrden(hijo, n);
			l.addAll(subLista);
		}
		return l;
	}
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
		if (a.isEmpty()) {
			return null; 
		}else {
			return listaCompleta(a,n);
		}
	}
	
	public List<Integer> listaCompleta(GeneralTree<Integer> a, Integer n) {
        List<Integer> l = new LinkedList<Integer> ();
		if (!a.isEmpty()) {
        	List<GeneralTree<Integer>> hijos = a.getChildren();
        	if (!hijos.isEmpty()) {
        		this.listaCompleta(hijos.get(0), n);
        	}
        	if(a.getData() % 2 != 0) {
        		l.add(a.getData());
        	}
        	if (hijos.size() > 1) {
        		for (int i=1;i<hijos.size();i++) {
        			GeneralTree<Integer> hijo = hijos.get(i);
        			listaCompleta(hijo,n);
        		}
        	}
        }
		return l;
       
	}
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n) {
		List <Integer> ret = new LinkedList<Integer> ();
		if (!a.isEmpty()) {
			cargarLis(a, ret, n);
		}
		return ret;
	}
	
	private void cargarLis (GeneralTree <Integer> a,List<Integer> ret,Integer n) {
		for (GeneralTree<Integer> child : a.getChildren()) {
			cargarLis(child,ret,n);
		}
		if ((a.getData() % 2 == 1) && a.getData() > n) {
			ret.add(a.getData());
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n) {
		List<Integer> ret = new LinkedList<Integer> ();
		if (!a.isEmpty()) {
			busquedaN (a,ret,n);
		}
		return ret;
		
	}
	
	private void busquedaN (GeneralTree <Integer> a,List<Integer>ret,Integer n) {
		Queue<GeneralTree<Integer>> cola= new Queue<GeneralTree<Integer>>();
		cola.enqueue(a);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			GeneralTree<Integer>elemento = cola.dequeue();
			if (elemento != null) {
				if (elemento.getData() % 2 == 1 && elemento.getData()> n) {
					ret.add(elemento.getData());
				}
				List<GeneralTree<Integer>> hijos = elemento.getChildren();
				for (GeneralTree<Integer> elem : hijos) {
					cola.enqueue(elem);;
				}
			}else if (!cola.isEmpty()) {
				cola.enqueue(null);
			}
			
		}
	}
}
