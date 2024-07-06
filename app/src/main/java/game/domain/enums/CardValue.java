package game.domain.enums;

public enum CardValue {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    private final int numValue;

    private CardValue(int numValue) {
        this.numValue = numValue;
    }

    public int getNumValue() {
        return this.numValue;
    }

    //returns TWO if given 2, JACK if given 11, etc
    public static String getName(int num) {
        for (CardValue e : values()) {
            if (e.numValue == num) {
                return e.name();
            }
        }
        return "";
    }
}