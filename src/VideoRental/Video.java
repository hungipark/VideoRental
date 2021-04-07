package VideoRental;

import java.util.Date;

public abstract class Video {
    public static final int REGULAR = 1 ;
    public static final int NEW_RELEASE =2 ;
    protected Date registeredDate ;
    private String title ;
    private int priceCode ;
    private VideoType videoType ;
    private boolean rented ;

    public Video(String title, VideoType videoType, int priceCode, Date registeredDate) {
        this.registeredDate = registeredDate ;
        this.title = title ;
        this.videoType = videoType ;
        this.priceCode = priceCode ;
    }

    public abstract int getLateReturnPointPenalty();

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public VideoType getVideoType() {
        return videoType;
    }

    public void setVideoType(VideoType videoType) {
        this.videoType = videoType;
    }
}
