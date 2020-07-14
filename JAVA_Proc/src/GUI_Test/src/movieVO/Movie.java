package GUI_Test.src.movieVO;

public class Movie {

	String mName; //��ȭ �̸�
	int price; //��ȭ ����
	double score; //��ȭ ����
	String story; //��ȭ �ٰŸ�
	String review; //��ȭ �ı�(����+�̸�+������)
	
	int total; //���� ������		
	int personScore; //��� ����� ����
	String rev; //���� �� ���
	int personNum; //���� ����� ��� ��
	String reviewName = ""; //���� ����� ��� �̸�
	
       //������
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
		this.review += this.personScore + "��\t<" + this.reviewName +  ">\t" + this.rev +"\n";
	}

	public int getPrice() {
		return price;
	}

	public String getStory() {
		return story;
	}

	@Override
	public String toString() {
		return "�ڿ�ȭ ���� : " + mName + 
		"\n�ڰ��� : " + price + "\n������ : " + score + 
		"\n���ֽ� ���� �� : " + review;
	}	
}

