package practica1.java;
	public class DoubleEndedQueue<T> extends Queue<T>{
		
		//Permite encolar al inicio.
		public void enqueueFirst(T data) {
			this.data.add(0,data);
		}
	}

