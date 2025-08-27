package practica3;

import java.util.Iterator;
import java.util.List;

public class CaminosP7 {
	private GeneralTree <Integer> ar;
	
	public List<Integer> caminoAHojaMasLejana () {
		List <Integer> camino = new LinkedList<Integer>();
		List<Integer> retorno = new LinkedList <Integer> ();
		if ( ar != null && !ar.isEmpty() ) {
			buscarHojaMasLejana (this.ar, camino, retorno );
		}
		return retorno;
	}
	
    private void buscarHojaMasLejana(GeneralTree<Integer> nodo, List<Integer> caminoActual, List<Integer> caminoMasLargo) {
        caminoActual.add(nodo.getData());

        if (nodo.isLeaf()) {
            if (caminoActual.size() > caminoMasLargo.size()) {
                // Copiamos el camino actual al resultado
                caminoMasLargo.clear();
                caminoMasLargo.addAll(caminoActual);
            }
        } else {
            for (GeneralTree<Integer> hijo : nodo.getChildren()) {
                buscarHojaMasLejana(hijo, caminoActual, caminoMasLargo);
            }
        }

        // Backtracking: quitamos el último nodo para probar otro camino
        caminoActual.remove(caminoActual.size() - 1);
    }	
}
