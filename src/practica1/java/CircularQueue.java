package practica1.java;

public class CircularQueue<T> extends Queue<T>{
	
	//Permite rotar los elementos, haciéndolo circular. Retorna el elemento encolado.
	public T shift() {
		T dato=dequeue();
		enqueue(dato);
		return dato;
	}
}