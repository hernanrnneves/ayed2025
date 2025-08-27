package practica2;

import practica1.java.*;

public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    public BinaryTree() {
        super();
    }

    public BinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }

    public BinaryTree<T> getRightChild() {
        return rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
    }

    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }

    public boolean isEmpty() {
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
        return (!this.hasLeftChild() && !this.hasRightChild());
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    @Override
    public String toString() {
        return this.getData().toString();
    }
	//PreOrden: primero raiz ,despues hijos
	public void printPreOrden() {
		System.out.println("Dato:"+this.toString());
		if(this.hasLeftChild()) {
			this.leftChild.printPreOrden();
		}
		if(this.hasRightChild()) {
			this.rightChild.printPreOrden();
		}
	}
	public boolean lleno() {
		BinaryTree<T> ab = null;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		boolean lleno = true;
		int cant_nodos = 0;
		int nivel = 0;
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty() && lleno) {
			ab = cola.dequeue();
		if (ab != null) {
		if (ab.hasLeftChild()) {
			cola.enqueue(ab.getLeftChild());
			cant_nodos++;
		}
		if (ab.hasRightChild()) {
			cola.enqueue(ab.getRightChild());
			cant_nodos++;
		}
		} else if (!cola.isEmpty()) {
		if (cant_nodos == Math.pow(2, ++nivel)) {
			cola.enqueue(null);
			cant_nodos = 0;
		} else
			lleno = false;
		}
		}
		return lleno;
		}
	//InOrden: primero hijo izquierdo , despues raiz y ultimo hijo derecho
	public void printInOrden() {
		if(this.hasLeftChild()) {
			this.leftChild.printInOrden();
		}
		System.out.println(this.toString());
		if(this.hasRightChild()) {
			this.rightChild.printInOrden();
		}
	}
	
	//PostOrden: primeros hijos , despues raiz
	public void printPostOrden() {
		if(this.hasLeftChild()) {
			this.leftChild.printPostOrden();
		}
		if(this.hasRightChild()) {
			this.rightChild.printPostOrden();
		}
		System.out.println(this.toString());
	}
	
	//EntreNiveles: Imprime los datos de los niveles del arbol
	public void printEntreNiveles() {
		Queue<BinaryTree<T>> cola=new Queue<BinaryTree<T>>();
		
		//encolas el dato
		cola.enqueue(this);
		//encolas una marca de nivel
		cola.enqueue(null);
		/*
		 *  10
		 * 20 30
		 */
		while(!cola.isEmpty()) {
			BinaryTree<T> ab=cola.dequeue();
			if(ab!=null) {
				System.out.println("Dato"+ab.getData().toString());
				if(ab.hasLeftChild()) {
					cola.enqueue(ab.getLeftChild());
				}
				if(ab.hasRightChild()) {
					cola.enqueue(ab.getRightChild());
				}
			}
			else {
				if(!cola.isEmpty()) {
					cola.enqueue(null);
				}
			}
		}
	}
	
	//contarHojas():int Devuelve la cantidad de árbol/subárbol hojas del árbol receptor.
	public int contarHojas() {
		if(this.isEmpty()) {
			return 0;
		}
		else {
			int sumarHojas=0;
			if(this.isLeaf()) {
				return sumarHojas + 1;
			}
			else {
				return this.getLeftChild().contarHojas()+this.getRightChild().contarHojas();
			}
		}
	}
	
	//espejo(): BinaryTree<T> Devuelve el árbol binario espejo del árbol receptor.
	public BinaryTree<T> espejo(){
		if(this.isEmpty()) {
			return null;
		}
		else {
			BinaryTree<T> ab=new BinaryTree<T>();
			if(this.hasLeftChild()) {
				ab.addRightChild(this.getLeftChild());
				return this.getLeftChild().espejo();
			}
			if(this.hasRightChild()) {
				ab.addLeftChild(this.getRightChild());
				return this.getRightChild().espejo();
			}
			return ab;
		}
	}
	/*
	 * c)	entreNiveles(int n, m) Imprime el recorrido por niveles de los elementos del árbol 
	 receptor entre los niveles n y m (ambos inclusive). (0≤n<m≤altura del árbol)
	 */
	public void entreNiveles(int n,int m) {
		if(this.isEmpty()||n<0||n>m) {
			System.out.println("Esta vacio o indices incorrectos.");
		}
		else {
			Queue<BinaryTree<T>> cola=new Queue<BinaryTree<T>>();
			cola.enqueue(this);
			cola.enqueue(null);
			int nivel=0;
			while(!cola.isEmpty() && nivel<=m) {
				BinaryTree<T>ab=cola.dequeue();
				if(ab!=null) {
					System.out.println("------->NIVEL "+nivel+" <------");
					if((nivel>=n) && (nivel<=m)) {
						System.out.println("Dato:"+ab.getData().toString());
						if(nivel<m) {// para no encolar demas los hijos .
							if(ab.hasLeftChild()) {
								cola.enqueue(ab.getLeftChild());
							}
							if(ab.hasRightChild()) {
								cola.enqueue(ab.getRightChild());
							}
						}
					}
				}
				else {
					if(!cola.isEmpty()) {
						cola.enqueue(null);
						nivel++;
					}
				}
			}
		}
	}
	
}

