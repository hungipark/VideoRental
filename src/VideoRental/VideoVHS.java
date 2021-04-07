package VideoRental;

import java.util.Date;

public class VideoVHS extends Video {

	public VideoVHS(String title, VideoType videoType, int priceCode, Date registeredDate) {
		super(title, videoType, priceCode, registeredDate);
	}

	@Override
	public int getLateReturnPointPenalty() {
		return 1;
	}
}
