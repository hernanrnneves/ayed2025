package practica3;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
		if (this.isEmpty()) {
			return 0;
		}else {
			return alturaC (0,this);
		}
	}
	
	public int alturaC (int nivel,GeneralTree<T> a) {
		int max=0;
		if (a.hasChildren()) {
			List<GeneralTree<T>> children = a.getChildren();
			for(GeneralTree<T> child:children) {
				max= Math.max(alturaC (nivel+1,child), max);
			}
		}
		if(this.isLeaf()) {
			return nivel;
		}
		 return Math.max(nivel, max); // Retorno el maximo entre el nivel y el max
		
	}
	
	
	public int nivel(T dato){
		 if (this.isEmpty()) {
			 return 0;
		 }
		 else {
			 int nivel=0;
			 if (this.hasChildren()) {
					List<GeneralTree<T>> children = this.getChildren();
					for(GeneralTree<T> child:children) {
						nivel += nivel(child);
					}
				}
				if(this.getData()== T) {
					return nivel;
				}
		 }
	  }
	public boolean esAncestro (T a,T b) {
		GeneralTree<T> nodoA = contiene(this, a);
		if (nodoA == null) {
			return false;
		}
		return busca(this, b);
	}
	private GeneralTree<T> contiene (GeneralTree<T> ar , T a) {
		if (ar != null) {
			if (ar.getData().equals(a)) {
				return ar;
			}
			for (GeneralTree<T> child : ar.getChildren()) {
				GeneralTree <T> res =contiene (child, a);
			}
		}
		return null;
	}
	
	private boolean busca(GeneralTree<T> ar, T b) {
		if (ar != null) {
			if (ar.getData().equals(b)) {
				return true;
			}
			for (GeneralTree child : ar.getChildren()) {
				if (contiene(child,b)) return true;
			}
		}
		return false;
	}
	

	
	public int ancho(){
		
		return 0;
	}
}