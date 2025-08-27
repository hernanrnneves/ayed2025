package practica1.java;
import java.util.ArrayList;
public class Calculadora {
	private int principio;
	private int fin;
	
	public Calculadora (int pri, int  f ) {
		this.principio= pri;
		this.fin= f;
		
		for (int i=this.principio; i<this.fin+1; i++) {
			System.out.println (i);
		}
	}
	public void calculadoraWhile (int pri, int f) {
		this.principio= pri;
		this.fin= f;
		while (this.principio < this.fin+1) {
			System.out.println (this.principio);
			principio++;	
		}
		
	}
	
	public void sin_iteracion(int p, int f) {
        this.principio = p;
        this.fin = f;
        
        ArrayList<Integer> num = new ArrayList<>();

        for (int i = p; i <= f; i++) { // Usa 'i <= f' en lugar de 'i < f+1'
            num.add(i);
        }

        System.out.println(num); // Imprime la lista
    }
	
}