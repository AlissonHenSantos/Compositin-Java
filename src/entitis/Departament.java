package entitis;

public class Departament {

	private String name;
	
	public Departament() {	
	}
	public Departament(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Departament [name=" + name + "]";
	}
	public void setDepartament(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
