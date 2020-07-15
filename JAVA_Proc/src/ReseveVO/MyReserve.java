package ReseveVO;

public class MyReserve {
	
	String name;
	String phone;
	String animalName;
	String date;
	String time;
	
	MyReserve(){
		
	}
	
	public MyReserve(String name, String phone, String animalName, String date,
			String time) {
		super();
		this.name = name;
		this.phone = phone;
		this.animalName = animalName;
		this.date = date;
		this.time = time;
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

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
