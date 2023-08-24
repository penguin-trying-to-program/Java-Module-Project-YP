public class Formatter {

    public static String formatString(String string) {
        string = string.toLowerCase();
        string = string.substring(0, 1).toUpperCase() + string.substring(1);
        return string;
    }

    public static String formatFloat(float number) {
        return String.format("%.2f", number);
    }

    public static String formatRoubles(float number) {
        int i = (int) number;
        int lastDigit = i % 10;
        String format;

        if (i % 100 > 10 && i % 100 < 20) {
            format = "рублей";
            return format;
        }

        format = switch (lastDigit) {
            case 1 -> "рубль";
            case 2, 3, 4 -> "рубля";
            default -> "рублей";
        };

        return format;
    }

}
