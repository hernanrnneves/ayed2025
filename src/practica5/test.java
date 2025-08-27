package practica5;
	import Grafos.Graph;
		import Grafos.Vertex;
		import adjList.AdjListGraph; // Usamos lista de adyacencia para este ejemplo
		import java.util.List;

public class test {

	public static void main(String[] args) {
		        // Crear el grafo
		        Graph<Integer> grafo = new AdjListGraph<>();

		        // Crear vértices
		        Vertex<Integer> v1 = grafo.createVertex(1);
		        Vertex<Integer> v2 = grafo.createVertex(2);
		        Vertex<Integer> v3 = grafo.createVertex(3);
		        Vertex<Integer> v4 = grafo.createVertex(4);
		        Vertex<Integer> v5 = grafo.createVertex(5);

		        // Conectar vértices
		        grafo.connect(v1, v2);
		        grafo.connect(v1, v3);
		        grafo.connect(v2, v4);
		        grafo.connect(v4, v5);
		        // Nota: v3 y v5 no están directamente conectados

		        // Ejecutar DFS
		        Recorridos recorrido = new Recorridos();
		        List<Vertex<Integer>> resultado = recorrido.dfs(grafo);

		        // Mostrar resultado
		        System.out.println("Recorrido DFS:");
		        for (Vertex<Integer> v : resultado) {
		            System.out.print(v.getData() + " ");
		        }
		        
		        List<Vertex<Integer>> resBFS = recorrido.bfs(grafo);

		        System.out.println("Recorrido BFS:");
		        for (Vertex<Integer> v : resBFS) {
		            System.out.print(v.getData() + " ");
		        }
    }
}

	


