package practica1.java;

public class test {

	public static void main(String[] args) {
		Profesor[] vector = new Profesor[2]; 
		Estudiante [] vector2 = new Estudiante[3];
		for (int i=0; i<2; i++) {
			vector[i]= new Profesor ("juan", "pedro","juan@pedro", "catedra","ulp");
		}
		for (int j=0; j<3 ; j++) {
			vector2[j]= new Estudiante("juan alumno", "aaa","mail@mail","comision123", "midir23" );
		}
		for (int i=0; i<2; i++) {
			vector[i].TusDatos();
		} 
			for (int i=0; i<3; i++) {
				vector2[i].TusDatos();
			} 
	}

}
