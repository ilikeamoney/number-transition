package transfer;

import java.util.HashMap;
import java.util.Map;

public class HexTransfer implements TransferHex {
    private static final int HEX = 16;

    private static HexTransfer hexTransfer;

    private static final Map<Integer, String> HEX_MAP = new HashMap<>();

    private static final DigitTransfer digitTransfer = new DigitTransfer();

    private HexTransfer() {
    }

    public static HexTransfer getInstance() {
        if (hexTransfer == null) {
            hexMapSetter();
            hexTransfer = new HexTransfer();
        }

        return hexTransfer;
    }


    @Override
    public String TransferDigitToHex(String digit) {
        if (DigitTransfer.checkDigit(digit)) {
            StringBuilder sb = new StringBuilder();
            sb.append(digitToHexOperator(digit));

            // 사이즈가 1 이상이면
            if (sb.length() > 1) {
                return reverse(sb.toString());
            }

            return sb.toString();
        }

        return "Current Value is not Digit Sorry try again";
    }

    @Override
    public String TransferBinaryToHex(String binary) {
        if (BinaryTransfer.checkBinary(binary)) {
            StringBuilder sb = new StringBuilder();

            // 길이가 4 이상
            if (binary.length() > 3) {
                for (String b : BinaryTransfer.cutByteStr(binary)) {
                    sb.append(binaryToHexOperator(b));
                }
                return reverse(String.valueOf(sb));
            }
            return binaryToHexOperator(binary);
        }

        return "Current Value is not Binary Sorry try again";
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
    private String digitToHexOperator(String digit) {
        StringBuilder sb = new StringBuilder();
        int d = DigitTransfer.stringDigitTORealValue(digit);

        // 입력이 0
        if (d == 0) return String.valueOf(d);

        while (d > 0) {
            // 현재 d을 HEX 나눈 나머지 구하기.
            int r = d % HEX;

            String n = HEX_MAP.get(r);

            if (n == null) {
                sb.append(r);
            } else {
                sb.append(n);
            }

            d /= HEX;
        }

        return String.valueOf(sb);
    }

    // Core
    private String binaryToHexOperator(String binary) {
//        2진수 10진수 변환 이 로직을 10진수 class 를 불러와 의존관계를 만들어야 함.
//        메서드의 관계에서는 너무 의존 관계가 깊음
//        int r = 1;
//        int d = 0;
//        for (int i = 0; i < binary.length(); i++) {
//            d += (binary.charAt(i) - 48) * r;
//            r *= 2;
//        }

        int d = DigitTransfer.stringDigitTORealValue(digitTransfer.TransferBinaryToDigit(binary));

        // 10진수 16진수로 변환
        if (d >= 10) {
            return HEX_MAP.get(d);
        }

        return String.valueOf(d);
    }

    private static void hexMapSetter() {
        HEX_MAP.put(10, "A");
        HEX_MAP.put(11, "B");
        HEX_MAP.put(12, "C");
        HEX_MAP.put(13, "D");
        HEX_MAP.put(14, "E");
        HEX_MAP.put(15, "F");
    }

}