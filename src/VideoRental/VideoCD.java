package VideoRental;

import java.util.Date;

public class VideoCD extends Video {

	public VideoCD(String title, VideoType videoType, int priceCode, Date registeredDate) {
		super(title, videoType, priceCode, registeredDate);
	}

	@Override
	public int getLateReturnPointPenalty() {
		return 2;
	}
}
