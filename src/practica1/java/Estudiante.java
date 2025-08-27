package practica1.java;

public class Estudiante extends Info{
	private Info in;
	private String comision, direccion;
	public Estudiante(String nombre, String apellido, String mail,String comision, String direccion) {
		super(nombre, apellido, mail);
		this.comision = comision;
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Estudiante " + super.toString() + ", comision=" + comision + ", direccion=" + direccion + "]";
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public Info getIn() {
		return in;
	}
	public String getComision() {
		return comision;
	}
	public String getDireccion() {
		return direccion;
	}
	
	
}
