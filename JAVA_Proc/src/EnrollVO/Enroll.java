package EnrollVO;

//등록정보
public class Enroll {
    final String animaltype="개";
    String animalname;
    String animalgender;
    String animalcate;
    int animalage;
    boolean genderless;//중성화 여부
    
    String name;
    String phone;
    
   int sirialNum;

    
    //생성자
    
    public Enroll(String animalname, String animalgender, String animalcate, int animalage, boolean genderless,
            String name, String phone,int sirialNum) {
         this.animalname = animalname;
         this.animalgender = animalgender;
         this.animalcate = animalcate;
         this.animalage = animalage;
         this.genderless = genderless;
         this.name = name;
         this.phone = phone;
         this.sirialNum=123456;
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
   public String getAnimaltype() {
      return animaltype;
   }
   public int getSirialNum() {
      return sirialNum;
   }
   public void setSirialNum(int sirialNum) {
      this.sirialNum = sirialNum;
   }

}