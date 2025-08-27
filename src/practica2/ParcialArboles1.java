package practica2;

import practica3.GeneralTree;

public class ParcialArboles1 {
	public BinaryTree <SumaDif> sumAndDif (GeneralTree<Integer> arbol){
		if (!arbol.isEmpty()) {
			return resolver (arbol, 0,0);
		}
		else {return null;}
	}
	
	private BinaryTree<SumaDif> resolver(BinaryTree<Integer> arbol,int padre, int acu) {
		int actual= arbol.getData();
		int suma = acu + actual; 
		int dif = actual - padre;
		
		SumaDif sumadif= new SumaDif (suma, dif);
		BinaryTree <SumaDif> nuevo = new BinaryTree<SumaDif>(sumadif);
		
		if(arbol.hasLeftChild()) {
			nuevo.addLeftChild(resolver(arbol.getLeftChild(),actual, suma));
		}
		if(arbol.hasRightChild()) {
			nuevo.addRightChild(resolver (arbol.getRightChild(),actual,suma));
		}
	return nuevo;
	}
	
}