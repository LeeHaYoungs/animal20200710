package ReseveVO;

public class Reserve {
	String animaltype;
	int sirialNum;
	String animalname;
	String animalgender;
	String animalcate;
	int animalage;
	boolean genderless;//중성화 유무
	
	//보호자
	String name;
	String phone;
	
	public Reserve(String animaltype, int sirialNum, String animalname, String animalgender, String animalcate,
			int animalage, boolean genderless, String name, String phone) {
		this.animaltype = animaltype;
		this.sirialNum = sirialNum;
		this.animalname = animalname;
		this.animalgender = animalgender;
		this.animalcate = animalcate;
		this.animalage = animalage;
		this.genderless = genderless;
		this.name = name;
		this.phone = phone;
	}
	public String getAnimaltype() {
		return animaltype;
	}
	public void setAnimaltype(String animaltype) {
		this.animaltype = animaltype;
	}
	public int getSirialNum() {
		return sirialNum;
	}
	public void setSirialNum(int sirialNum) {
		this.sirialNum = sirialNum;
	}
	public String getAnimalname() {
		return animalname;
	}
	public void setAnimalname(String animalname) {
		this.animalname = animalname;
	}
	public String getAnimalgender() {
		return animalgender;
	}
	public void setAnimalgender(String animalgender) {
		this.animalgender = animalgender;
	}
	public String getAnimalcate() {
		return animalcate;
	}
	public void setAnimalcate(String animalcate) {
		this.animalcate = animalcate;
	}
	public int getAnimalage() {
		return animalage;
	}
	public void setAnimalage(int animalage) {
		this.animalage = animalage;
	}
	public boolean isGenderless() {
		return genderless;
	}
	public void setGenderless(boolean genderless) {
		this.genderless = genderless;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
