package VideoRental;

public enum VideoType {
    VHS,
    CD,
    DVD;
    public static VideoType getValue(int type){
        if (0 < type && type < VideoType.values().length) {
            return values()[type];
        }
        return DVD;
    };
}