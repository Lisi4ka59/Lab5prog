package models;

public enum Climate {
    TROPICAL_SAVANNA,
    HUMIDCONTINENTAL,
    OCEANIC,
    STEPPE;

    public static  Climate fromInt(int climateNumber){
        if (climateNumber == 1) {
            return Climate.TROPICAL_SAVANNA;
        } else if (climateNumber == 2) {
            return Climate.HUMIDCONTINENTAL;
        } else if (climateNumber == 3) {
            return Climate.OCEANIC;
        } else {
            return Climate.STEPPE;
        }
    }
}