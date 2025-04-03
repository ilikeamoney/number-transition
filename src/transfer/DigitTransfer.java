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
        boolean c = true;

        for (int i = 0; i < digit.length(); i++) {
            //9 보다 크다면
            if (digit.charAt(i) - 48 > 9) {
                return !c;
                // 0 보다 작다면
            } else if (digit.charAt(i) - 48 < 0) {
                return !c;
            }
        }

        return c;
    }

    public static int getDigitValue(String digit) {
        int d = 0;

        // 자릿수 1개
        if (digit.length() == 1) {
            return digit.charAt(0) - 48;
        }

        for (int i = 0; i < digit.length() - 1; i++) {
            d += digit.charAt(i) - 48;
            d *= 10;
        }
        // 1의 자릿수 더하기
        d += digit.charAt(digit.length() - 1) - 48;

        return d;
    }

}
