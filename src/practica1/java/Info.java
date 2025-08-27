package practica1.java;

public class Info {
	private String nombre, apellido, mail;

	public Info(String nombre, String apellido, String mail) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
	}
	
	public void TusDatos() {
		System.out.println("el nonmbre es  "+this.nombre+" el apellido es "+this.apellido+
				" y su mail "+this.mail);
		
	}

	@Override
	public String toString() {
		return "Info [nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + "]";
	}
	
	
}
