package practica2;

import java.util.*;
import java.util.Queue;
import practica1.java.*;

public class PruebaBinaryTree {

	public static void main(String[] args) {
		BinaryTree<Integer>ar=new BinaryTree<Integer>(10);
		BinaryTree<Integer>hijoIzq=new BinaryTree<Integer>(2);
		BinaryTree<Integer>hijoDer=new BinaryTree<Integer>(3);
		BinaryTree<Integer>subHijoIzqIzq=new BinaryTree<Integer>(5);
		BinaryTree<Integer>subHijoIzqDer=new BinaryTree<Integer>(4);
		BinaryTree<Integer>subHijoDerIzq=new BinaryTree<Integer>(9);
		BinaryTree<Integer>subHijoDerDer=new BinaryTree<Integer>(8);
		subHijoIzqIzq.addLeftChild(new BinaryTree<Integer>(7));
		subHijoIzqIzq.addRightChild(new BinaryTree<Integer>(8));
		subHijoIzqDer.addLeftChild(new BinaryTree<Integer>(5));
		subHijoIzqDer.addRightChild(new BinaryTree<Integer>(6));
		subHijoDerIzq.addLeftChild(new BinaryTree<Integer>(12));
		subHijoDerIzq.addRightChild(new BinaryTree<Integer>(8));
		subHijoDerDer.addLeftChild(new BinaryTree<Integer>(2));
		subHijoDerDer.addRightChild(new BinaryTree<Integer>(1));
		hijoIzq.addLeftChild(subHijoIzqIzq);
		hijoIzq.addRightChild(subHijoIzqDer);
		hijoDer.addLeftChild(subHijoDerIzq);
		hijoDer.addRightChild(subHijoDerDer);
		ar.addLeftChild(hijoIzq);
		ar.addRightChild(hijoDer);
		ar.printPreOrden();
		boolean ok= ar.lleno();
		System.out.println(ok);
		/*Queue <Integer> cola=new LinkedList<Integer>();
		//CircularQueue<Integer> cola=new CircularQueue<Integer>();
		//DoubleEndedQueue<Integer> cola=new DoubleEndedQueue<Integer>();
		//el shift pone el primero a lo ultimo : rota el primer elemento de la cola al final
		cola.enqueue(10);
		cola.enqueue(20);
		cola.enqueue(30);
		cola.enqueue(40);
		//cola.enqueueFirst(50);//encola al principio
		cola.dequeue();//borra el primer elemento de la cola en este caso 50 porque lo encole al principip
		cola.dequeue();//borra el 10	
		System.out.println(cola.toString()); */
	}

}
