package VideoRental;

import java.util.Date;

public class VideoFactory {
    public static Video create(String title, VideoType videoType, int priceCode, Date registeredDate) {
        switch (videoType) {
            case VHS:
                return new VideoVHS(title, videoType, priceCode, registeredDate);
            case CD:
                return new VideoCD(title, videoType, priceCode, registeredDate);
            // default DVD
            default:
                return new VideoDVD(title, videoType, priceCode, registeredDate);
        }
    }
}