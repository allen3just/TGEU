package TGEU;

public class GymEquipment {
	private int id;
	private String name;
	private int numb;

	public GymEquipment(int id, String name, int numb) {
		super();
		this.id = id;
		this.name = name;
		this.numb = numb;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumb() {
		return numb;
	}
	public void setNumb(int numb) {
		this.numb = numb;
	}
	
	
}
