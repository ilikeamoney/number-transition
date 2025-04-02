package transfer;

public class DigitTransfer implements TransferDigit {
    @Override
    public String TransferHexToDigit(String hex) {
        return "";
    }

    @Override
    public String TransferBinaryToDigit(String binary) {
        return "";
    }

    @Override
    public String reverse(String n) {
        return "";
    }

    public static boolean checkDigit(String digit) {
        boolean c = false;

        for (int i = 0; i < digit.length(); i++) {
            if (digit.charAt(i) >= 48 && 57 >= digit.charAt(i)) {
                c = true;
            } else {
                c = false;
                return c;
            }
        }

        return c;
    }

    public static int getDigitValue(String digit) {
        int d = 0;

        // 자릿수가 1개라면
        if (digit.length() == 1) {
            return d = digit.charAt(0) - 48;
        }

        for (int i = 0; i < digit.length(); i++) {
            d += digit.charAt(i) - 48;
            d *= 10;
        }

        return d;
    }

}
