package transfer;

import java.util.Map;

public class DigitTransfer implements TransferDigit {
    private static DigitTransfer digitTransfer;

    private DigitTransfer() {}

    public static DigitTransfer getInstance() {
        if (digitTransfer == null) {
            return new DigitTransfer();
        }
        return digitTransfer;
    }

    @Override
    public String transferHexToDigit(String hex) {
        if (HexTransfer.checkHex(hex)) {
            return hexToDigitOperator(reverse(hex));
        }

        return "Current Value is not Hex Sorry try again";
    }

    @Override
    public String transferBinaryToDigit(String binary) {
        if (BinaryTransfer.checkBinary(binary)) {
            return binaryToDigitOperator(reverse(binary));
        }

        return "Current Value is not Binary Sorry try again";
    }

    @Override
    public String reverse(String n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n.length() - 1; i >= 0; i--) {
            sb.append(n.charAt(i));
        }
        return sb.toString();
    }

    // Core
    private String binaryToDigitOperator(String binary) {
        int r = 1;
        int d = 0;
        for (int i = 0; i < binary.length(); i++) {
            d += (binary.charAt(i) - 48) * r;
            r *= 2;
        }

        return String.valueOf(d);
    }

    // Core
    private String hexToDigitOperator(String hex) {
        Map<String, Integer> hexMapReverse = HexTransfer.getHexMapReverse();
        int r = 1;
        int d = 0;

        for (int i = 0; i < hex.length(); i++) {
            Integer h = hexMapReverse.get(String.valueOf(hex.charAt(i)));

            // h가 null이 아니면
            if (h != null) {
                d += h * r;
            } else {
                d += (hex.charAt(i) - 48) * r;
            }

            r *= 16;
        }

        return String.valueOf(d);
    }

    public static boolean checkDigit(String digit) {
        boolean c = true;

        for (int i = 0; i < digit.length(); i++) {
            // 9 보다 크다면
            if (digit.charAt(i) - 48 > 9) {
                return !c;
                // 0 보다 작다면
            } else if (digit.charAt(i) - 48 < 0) {
                return !c;
            }
        }

        return c;
    }


    public static int stringDigitToRealValue(String strDigit) {
        int d = 0;

        // 자릿수 1개
        if (strDigit.length() == 1) {
            return strDigit.charAt(0) - 48;
        }

        for (int i = 0; i < strDigit.length() - 1; i++) {
            d += strDigit.charAt(i) - 48;
            d *= 10;
        }
        // 1의 자릿수 더하기
        d += strDigit.charAt(strDigit.length() - 1) - 48;

        return d;
    }

}
