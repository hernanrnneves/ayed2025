package practica3;

import practica1.java.Queue;
public class AnalizadorArbol {
	private GeneralTree <AreaEmpresa> a;
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>a) {
		if (!a.isEmpty()) {
			return maximoProm(a);
		}
		return 0.0;
	}
	private double maximoProm (GeneralTree<AreaEmpresa>arbol) {
		int acu=0, cant=0, nivel=0;
		double max=-99.0;
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			GeneralTree<AreaEmpresa> dato = cola.dequeue();
			if (dato != null) {
				acu+= dato.getData().getTar();
				cant++;
			
				for (GeneralTree<AreaEmpresa> child : dato.getChildren()) {
					cola.enqueue(child);
				}
			}else {
				double prom= acu/cant;
				if (prom > max) {
					max=prom;
			}
			}
			acu=0;
			cant=0;
			
		}if(!cola.isEmpty()) {
			acu=0;
			nivel++;
			cola.enqueue(null);
		}
		
		return max;
	} 
	
}
