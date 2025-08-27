package practica1.java;

import java.util.ArrayList;
import java.util.Scanner;
public class Metodos {
	private ArrayList<Integer> lista;

	public Metodos (int i) {
		lista = new ArrayList <Integer>();
		int num=i;
		for (int j=0; j<i; j++) {
			lista.add(num);
			System.out.println("se agrego correctamente el num "+ num); 
			num=i*num;
		}
	}
	public static int contar42 ( ) {
		System.out.println("     igrese numero")	;
		Scanner s = new Scanner(System.in) ;
		s.nextInt();
		int cantidad = 1 ;
		while (s.nextInt() != 42) {
			cantidad++;
		}
		System.out.println("     ........... ")	;
		return cantidad;
		}
	@Override
	public String toString() {
		return "Metodos [lista=" + lista + "]";
	}
}
