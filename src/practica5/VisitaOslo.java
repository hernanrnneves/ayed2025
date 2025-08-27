package practica5;

import Grafos.Graph;
import Grafos.Vertex;
import Grafos.Edge;
import adjList.AdjListGraph; // Usamos lista de adyacencia para este ejemplo
import java.util.List;
import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;


public class VisitaOslo {
	/*se quiere realizar un paseo en bicicleta por lugares emblemáticos de Oslo. Para esto se cuenta con un grafo de
	bicisendas. Partiendo desde el “Ayuntamiento” hasta un lugar destino en menos de X minutos, sin pasar por un
	conjunto de lugares que están restringidos.*/
	public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) {
		List<Vertex<String>> l= lugares.getVertices();
		Iterator <Vertex<String>> it =  l.iterator();
		Vertex<String> aux, origen= null;
		while (it.hasNext() && origen == null) {
			aux=it.next();
			if (aux.getData().equals("ayuntamiento"))
				origen=aux;
		}
		List<String> ret = new LinkedList<>();
		if (origen != null) {
			boolean []marcas = new boolean[lugares.getSize()]
			List<String> act= new List<>();
			ret =dfs (lugares, origen,destino,maxTiempo,lugaresRestringidos, ret, act , marcas,0);
		}
		return ret;
	}
	private void dfs (Graph<String> lugares,Vertex<String> origen, String destino, int maxTiempo, List<String> lugaresRestringidos, List<String>ret,List <String> lis, boolean [] marcas, int tiempoAcumulado) {
		marcas[origen.getPosition()] = true;
		int time =0;
		lis.add(origen.getData());
		if (!lis.contains(lugaresRestringidos)) {
			ret.removeAll(ret);
			ret.addAll(lis);
			
		}
		if (maxTiempo > time) {
			List<Vertex<String>> e = lugares.getEdges(origen);
			for (Vertex<String> edge : e) {
				Vertex <String> sig = e.getTarget();
                int peso = e.getWeight();

                if (!marcas[sig.getPosition()] && tiempoActual + peso <= maxTiempo) {
                    tiempoActual += peso;
                    dfs(grafo, sig, destino, maxTiempo, lugaresRestringidos,ret,lis, marcas, tiempoAcumulado);
                    tiempoActual -= peso;
			}
		}
	
		lis.remove(lis.size()-1);
		marcas [origen.getPosition()]= false;	
		
	}
	
}
}