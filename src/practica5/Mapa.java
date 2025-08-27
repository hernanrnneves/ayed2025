package practica5;

import Grafos.Graph;
import Grafos.Vertex;
import Grafos.Edge;
import adjList.AdjListGraph; // Usamos lista de adyacencia para este ejemplo
import java.util.List;
import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;


public class Mapa {
	private Graph<String> grafo;
	
	public List<String> devolverCamino (String ciu1, String ciu2) {
		List<String> l = new LinkedList<>();
		List<Vertex<String>> g= grafo.getVertices();
		Iterator<Vertex<String>> ite= g.iterator();
		Vertex<String> aux , inicio= null;
		
		while (ite.hasNext() && inicio == null) {
			aux = ite.next();
			if (aux.getData().equals(ciu1)) {
				inicio=aux;
			}
		}
		if (inicio != null) {
			boolean [] marcas = new boolean [grafo.getSize()];
			if (dfs (inicio, ciu2, l, marcas)) {
				return l;
			}
			
		}else {
			return new LinkedList<>();
		}
	}
	private boolean dfs (Vertex<String> inicio, String ciu2, LinkedList<String> l, boolean[] marcas ) {
		marcas [inicio.getPosition()] = true;
		l.add(inicio.getData());
		if (inicio.getData().equals(ciu2)) {
			return true;
		}
		
		List<Edge<String>> edge = grafo.getEdges(inicio);
		for (Edge<String> e : edge) {
			Vertex<String> sig = e.getTarget();
			if (dfs (sig,ciu2,l,marcas)) {
				return true;
			}
		}
		
		l.removeLast();
		return false;
	}
	/*{Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
		que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
		vacía. (Sin tener en cuenta el combustible).*/
	
	public List <String> devolverCaminoExeptuando (String ciu1 , String ciu2, List<String> ciudades) {
		List<Vertex<String>> lis = grafo.getVertices();
		Iterator <Vertex<String>> ite = lis.iterator();
		Vertex<String> aux, inicio= null;
		List<String> ret = new LinkedList<> ();
		while (ite.hasNext() && inicio == null) {
			aux=ite.next();
			if (aux.getData().equals(inicio)) {
				inicio=aux;
			}
		}
		if (inicio != null) {
			boolean[] marcas = new boolean [grafo.getSize()];
			if (dfs (inicio, ciu2, ret, marcas)) {
				if (!ret.equals(ciudades)) {
					return ret;
				}
			}
		}
		return null;
	}
	private boolean dfs2 (Vertex<String> inicio, String ciu2, LinkedList<String> l,boolean []marcas ) {
		marcas[inicio.getPosition()]= true;
		l.add(inicio.getData());
		
		if (inicio.getData().equals(ciu2)) {
			return true;
		}
		
		List<Edge<String>> edge = grafo.getEdges(inicio);
		for (Edge<String> e : edge) {
			Vertex<String> sig = e.getTarget();
			if (dfs (sig, ciu2,l,marcas)) {
				return true;
			}
		}
		
	l.removeLast();
	return false;
	}
/*  
Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
existe camino retorna la lista vacía. (Las rutas poseen la distancia).
	} */
	public List <String> caminoMasCorto(String ciudad1, String ciudad2) {
		List<Vertex<String>> l = grafo.getVertices();
		Iterator <Vertex<String>> it = l.iterator();
		Vertex<String> aux, entrada= null;
		while (it.hasNext() && entrada == null) {
			aux=it.next();
			if (aux.getData().equals(ciudad1)) {
				entrada=it.next();
			}
		}
		List<String> ret = new LinkedList<> ();
		if (entrada != null) {
			boolean []marcas = new boolean [grafo.getSize()];
			return dfs3 (entrada,ciudad2, ret,new LinkedList<>(), marcas, 999, 0);
		}
		return ret;
	}
	private List<String> dfs3 (Vertex<String> entrada, String fin, LinkedList<String> ret,LinkedList<String> lista,boolean[]marcas, int min, int total)
		lista.add(entrada.getData());
	marcados [entrada.getPosition()] = true;
	if (lista.contains(fin) && total < min) {
			ret.removeAll(ret);
			ret.addAll(lista);
			min=total;
	}else {
		List<Edge<String>> aristas = this.grafo.getEdges(entrada);
		Iterator<Edge<String>> it = aristas.iterator();
		while (it.hasNext() && total < min) {
			Edge<String>ari  = it.next();
			Vertex<String> v = ari.getTarget();
			int suma = total +v.getWeight();
			if (!marcados[v.getPosition()] && suma <min) {
				min= dfs3 (v,fin,ret,lista,marcas,min,suma);
			}
		}		
	}
	lista.remove(ret.size()-1);
	marcados [entrada.getPosition()] =false;
	return ret;

}