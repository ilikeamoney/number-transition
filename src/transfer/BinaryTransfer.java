package transfer;

import java.util.Map;

public class BinaryTransfer implements TransferBinary {
    private static BinaryTransfer binaryTransfer;

    private BinaryTransfer() {}

    public static BinaryTransfer getInstance() {
        if (binaryTransfer == null) {
            return new BinaryTransfer();
        }
        return binaryTransfer;
    }

    @Override
    public String transferDigitToBinary(String digit) {
        if (DigitTransfer.checkDigit(digit)) {
            return reverse(digitToBinaryOperator(digit));
        }
        return "Current Value is not Digit Sorry try again";
    }

    @Override
    public String transferHexToBinary(String hex) {
        if (HexTransfer.checkHex(hex)) {
            return reverse(hexToBinaryOperator(hex));
        }
        return "Current Value is not Hex Sorry try again";
    }

    @Override
    public String reverse(String n) {
        StringBuilder result = new StringBuilder();

        for (int i = n.length() - 1; i >= 0; i--) {
            result.append(n.charAt(i));
        }

        return result.toString();
    }

    // Core
    private String digitToBinaryOperator(String digit) {
        StringBuilder sb = new StringBuilder();
        int d = DigitTransfer.stringDigitToRealValue(digit);

        // 입력이 0이면
        if (d == 0) {
            return String.valueOf(d);
        }

        while (d > 0) {
            int r = d % 2;
            sb.append(r);
            d /= 2;
        }

        return String.valueOf(sb);
    }

    // Core
    private String hexToBinaryOperator(String hex) {
        String d = hexToDigitOperator(hex);
        return digitToBinaryOperator(d);
    }

    // Core
    private String hexToDigitOperator(String hex) {
        Map<String, Integer> hexMapReverse = HexTransfer.getHexMapReverse();
        hex = reverse(hex);
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

    public static boolean checkBinary(String binary) {
        boolean c = true;

        for (int i = 0; i < binary.length(); i++) {
            // A ~ F
            if (binary.charAt(i) > 64 && 71 > binary.charAt(i)) {
                return !c;
                // 2 ~ 9
            } else if (binary.charAt(i) - 48 > 1 && 10 > binary.charAt(i)) {
                return !c;
            }
        }
        return c;
    }

    // 4비트씩 자르기
    public static String[] cutByteStr(String longBinary) {
        StringBuilder sb = new StringBuilder();

        // 바이너리 뒤에서 부터 자르기
        int cnt = 0;
        for (int i = longBinary.length() - 1; i >= 0; i--) {
            sb.append(longBinary.charAt(i));
            cnt += 1;

            if (cnt == 4) {
                sb.append(" ");
                cnt = 0;
            }
        }

        return String.valueOf(sb).split(" ");
    }
}
