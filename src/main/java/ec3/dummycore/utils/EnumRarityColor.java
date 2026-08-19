package ec3.dummycore.utils;

public enum EnumRarityColor {
    BROKEN("8", "Broken"),
    COMMON("f", "Common"),
    GOOD("a", "Good"),
    UNCOMMON("2", "Uncommon"),
    RARE("9", "Rare"),
    UNIQUE("d", "Unique"),
    EPIC("e", "Epic"),
    LEGENDARY("6", "Legendary"),
    EXCEPTIONAL("b", "Exceptional"),
    PERFECT("3", "Perfect"),
    ULTIMATE("c", "Ultimate"),
    TURQUOISE("4", "Turquoise");

    private String value;
    private String name;

    EnumRarityColor(String s, String s1) {
        this.value = s;
        this.name = s1;
    }

    public String getRarityColor() {
        String ret = new String();
        ret = ret + "§";
        ret = ret + this.value;
        return ret;
    }

    public String getName() {
        return this.name;
    }

    public static ec3.dummycore.utils.EnumRarityColor getColorByHex(String hex) {
        EnumRarityColor retColor = BROKEN;

        for(int i = 0; i < values().length; ++i) {
            ec3.dummycore.utils.EnumRarityColor color = values()[i];
            if (color.value.equalsIgnoreCase(hex)) {
                return color;
            }
        }

        return retColor;
    }
}
