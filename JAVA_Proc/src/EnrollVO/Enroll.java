package EnrollVO;

//등록정보
public class Enroll {
	 String animal;//개 or 고양이
	 String name;
	 String sex;
	 String breeds;
	 int age;
	 boolean neutered;//중성화 여부
	 
	 String owner_name;
	 String owner_phone;
	 
	 //생성자
	public Enroll(String animal, String name, String sex, String breeds, int age, boolean neutered, String owner_name,
			String owner_phone) {
		this.animal = animal;
		this.name = name;
		this.sex = sex;
		this.breeds = breeds;
		this.age = age;
		this.neutered = neutered;
		this.owner_name = owner_name;
		this.owner_phone = owner_phone;
	}

	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBreeds() {
		return breeds;
	}
	public void setBreeds(String breeds) {
		this.breeds = breeds;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public boolean isNeutered() {
		return neutered;
	}
	public void setNeutered(boolean neutered) {
		this.neutered = neutered;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getOwner_phone() {
		return owner_phone;
	}
	public void setOwner_phone(String owner_phone) {
		this.owner_phone = owner_phone;
	}
	 
	 
}
