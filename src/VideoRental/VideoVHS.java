package VideoRental;

import java.util.Date;

public class VideoVHS extends Video {

	public VideoVHS(String title, VideoType videoType, int priceCode, Date registeredDate) {
		super(registeredDate);
		this.setTitle(title) ;
		this.setVideoType(videoType) ;
		this.setPriceCode(priceCode) ;
	}

	@Override
	public int getLateReturnPointPenalty() {
		return 1;
	}
}