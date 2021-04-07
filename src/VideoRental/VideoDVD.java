package VideoRental;

import java.util.Date;

public class VideoDVD extends Video {

	public VideoDVD(String title, VideoType videoType, int priceCode, Date registeredDate) {
		super(title, videoType, priceCode, registeredDate);
	}

	@Override
	public int getLateReturnPointPenalty() {
		return 3;
	}
}
