package GUI_Test.src.movieVO;

public class MyMovie {
	// ��������(��ȭ �̸�, �ð���, �¼�)
		String mName;
		String time;
		String seat;

		public MyMovie() {

		}

		public MyMovie(String mName, String time, String seat) {
			this.mName = mName;
			this.time = time;
			this.seat = seat;
		}

		public String getmName() {
			return mName;
		}

		public void setmName(String mName) {
			this.mName = mName;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getSeat() {
			return seat;
		}

		public void setSeat(String seat) {
			this.seat = seat;
		}
	}
