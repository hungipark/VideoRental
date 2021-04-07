package VideoRental;

import java.util.Date;

public class Rental {
	private Video video ;
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		rentDate = new Date() ;
	}

	public Video getVideo() {
		return video;
	}

	public void returnVideo() {
		if (video.isRented()) {
			returnDate = new Date() ;
			video.setRented(false);
		}
	}

	public int getDaysRentedLimit() {
		int limit = 0 ;
		int daysRented = getDaysRented();
		if ( daysRented <= 2) return limit ;

		switch ( video.getVideoType() ) {
			case VHS: limit = 5 ; break ;
			case CD: limit = 3 ; break ;
			case DVD: limit = 2 ; break ;
		}
		return limit ;
	}

	public int getDaysRented() {
		int daysRented;
		long diff;
		if (video.isRented() == false) { // returned Video
			diff = returnDate.getTime() - rentDate.getTime();
		} else { // not yet returned
			diff = new Date().getTime() - rentDate.getTime();
		}
		daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;

		return daysRented;
	}

	public double getCharge(int daysRented) {
		double charge = 0;
		switch (video.getPriceCode()) {
			case Video.REGULAR:
				charge += 2;
				if (daysRented > 2)
					charge += (daysRented - 2) * 1.5;
				break;
			case Video.NEW_RELEASE:
				charge = daysRented * 3;
				break;
		}
		return charge;
	}

	public int getPoint(int daysRented) {
		int eachPoint = 0 ;
		eachPoint++;

		if ((video.getPriceCode() == Video.NEW_RELEASE) )
			eachPoint++;

		if ( daysRented > getDaysRentedLimit() )
			eachPoint -= Math.min(eachPoint, video.getLateReturnPointPenalty()) ;
		return eachPoint;
	}
}
