package GUI_Test.src.movieVO;

public class Movie {

	String mName; //영화 이름
	int price; //영화 가격
	double score; //영화 평점
	String story; //영화 줄거리
	String review; //영화 후기(평점+이름+한줄평)
	
	int total; //평점 누적합		
	int personScore; //방금 등록한 평점
	String rev; //한줄 평 등록
	int personNum; //평점 등록한 사람 수
	String reviewName = ""; //평점 등록한 사람 이름
	
       //생성자
	public Movie(String mName, int price, double score, String story,String review) {
		//super();
		this.mName = mName;
		this.price = price;
		this.total = (int)score;
		this.story = story;
		this.review = review;
		this.personNum = 1;
		setScore();
	}

	public String getmName() {
		return mName;
	}

	public int getPersonScore() {
		return personScore;
	}

	public void setPersonScore(int personScore) {
		this.personScore = personScore;
	}
	
	public int getPersonNum() {
		return personNum;
	}

	public void setPersonNum() {
		this.personNum++;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int personN) {
		this.total += personN;
	}

	public String getRev() {
		return rev;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}

	public String getReviewName() {
		return reviewName;
	}

	public void setReviewName(String reviewName) {
		this.reviewName = reviewName;
	}

	public void setStory(String story) {
		this.story = story;
	}
		
	public double getScore() {
		return score;
	}

	public void setScore() {
		this.score = (double)this.total / this.personNum;
	}

	public String getReview() {
		return review;
	}

	public void setReview() {
		this.review += this.personScore + "점\t<" + this.reviewName +  ">\t" + this.rev +"\n";
	}

	public int getPrice() {
		return price;
	}

	public String getStory() {
		return story;
	}

	@Override
	public String toString() {
		return "★영화 제목 : " + mName + 
		"\n★가격 : " + price + "\n★평점 : " + score + 
		"\n★최신 한줄 평 : " + review;
	}	
}

