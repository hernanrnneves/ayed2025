package practica1.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArrayList {

	public static void main(String[] args) {
		List<Integer> lista = new ArrayList<Integer>(Arrays.asList(1, 10, 200, 12));
		for (int e : lista) {
			System.out.println (e);
	}
	Estudiante e1 = new Estudiante ("hernan", "neves", "mail@gmial", "dir", "arg");
	Estudiante e2 = new Estudiante ("hernan", "neves2", "mail@gmial", "dir", "aaa");
	Estudiante e3 = new Estudiante ("hernan", "neves3", "mail@gmial", "dir", "aaa");
	List<Estudiante> lis= new ArrayList <Estudiante>();
	lis.add(e3);
	lis.add(e2);
	lis.add(e1);
	List<Estudiante> lisco= new ArrayList <Estudiante>();
	for (Estudiante e: lis) {
		lisco.add(e);
	}						// PRIMERA FORMA DE COPIAR UNA LISTA
	//lisco =lis;				// SEGUNDA FORMA DE COPIAR UNA LISTA
	for (Estudiante e:lis) {
		System.out.println(e.toString());
	}
	for (Estudiante e:lisco) {
		System.out.println(e.toString());
	}
	System.out.println (lis.size());
	for (Estudiante e:lisco) {
		if (e.getDireccion().equals("arg")) {
			e.setComision("comision nula");
		}
	}
	for (Estudiante e:lisco) {
		System.out.println(e.toString());
	}
	
}
}