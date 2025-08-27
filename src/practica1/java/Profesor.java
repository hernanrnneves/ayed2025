package practica1.java;

public class Profesor extends Info {
	private Info in;
	private String catedra, facultad;
	
	public Profesor(String nombre, String apellido, String mail, String catedra, String facultad) {
		super(nombre, apellido, mail);
		this.catedra = catedra;
		this.facultad = facultad;
	}

	
	
	
	
}
