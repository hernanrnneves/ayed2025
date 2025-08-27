package practica5;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import Grafos.Graph;
import Grafos.Edge;
import Grafos.Vertex;

public class Recorridos {
	public List<Vertex<Integer>> dfs (Graph <Integer> grafo) {
		boolean [] marcas = new boolean [grafo.getSize()];
		List<Vertex<Integer>> l = new LinkedList<>();
		
		for (int i=0; i< grafo.getSize(); i++) {
			if (!marcas[i]) {
				dfs (i,grafo,l,marcas);
			}
		}
		
	return l;
	}
	
	private void dfs (int i, Graph<Integer> grafo,List l ,boolean []marcas) {
		marcas[i]= true;
		Vertex<Integer> v =grafo.getVertex(i);
		l.add(v);
		
		List <Edge<Integer>> edge = grafo.getEdges(v);
		for (Edge<Integer> e : edge) {
			int j = e.getTarget().getPosition();
			if (!marcas[j]) {
				dfs (j,grafo,l,marcas);
			}
		}
		
	}
	
	public List<Vertex<Integer>> bfs (Graph <Integer> grafo ) {
		List<Vertex<Integer>> l= new LinkedList<>();
		boolean []marcas = new boolean [grafo.getSize()];
		for (int i=0; i< grafo.getSize(); i++) {
			if (!marcas[i]) {
				bfs (i,grafo,l,marcas);
			}
		}
	return l;
	}
	
	private void bfs (int i, Graph<Integer> grafo, List<Vertex<Integer>> l,boolean []marcas) {
		Queue<Vertex<Integer>> cola= new LinkedList<>();
		Vertex<Integer> origen= grafo.getVertex(i);
		marcas[i]=true;
		cola.add(origen);
		
		while (!cola.isEmpty()) {
	        Vertex<Integer> actual = cola.poll();
	        l.add(actual); // ✅ agregás el que estás procesando

	        List<Edge<Integer>> adyacentes = grafo.getEdges(actual); // ✅ sacás los vecinos

	        for (Edge<Integer> e : adyacentes) {
	            int j = e.getTarget().getPosition();
	            if (!marcas[j]) {
	                marcas[j] = true;
	                cola.add(e.getTarget());
	            }
			}
		}
		
		
	} 


}
