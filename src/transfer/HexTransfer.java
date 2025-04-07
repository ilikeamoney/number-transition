package transfer;

import java.util.HashMap;
import java.util.Map;

public class HexTransfer implements TransferHex {
    private static final int HEX = 16;

    private static HexTransfer hexTransfer;

    private static final Map<Integer, String> HEX_MAP = new HashMap<>();

    private static final Map<String, Integer> HEX_MAP_REVERSE = new HashMap<>();

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
    public String transferDigitToHex(String digit) {
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
    public String transferBinaryToHex(String binary) {
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
        int d = DigitTransfer.stringDigitToRealValue(digit);

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
        int d = binaryToDigitOperator(binary);

        // 10진수 16진수로 변환
        if (d >= 10) {
            return HEX_MAP.get(d);
        }

        return String.valueOf(d);
    }

    /**
     *
     * 현재 reverse 로직에서 진수 변환에 협업 관계에서 꼬임 현상이 발생함
     * 난 개인적으로 각 진수 변환에 의존 관계를 두어서 협업 흐름을 만들고 싶었는데
     * 각 독립적으로 수행하는것이 맞다고 생각 됨 진수는 오른쪽에서부터 계산하지만 실제
     * 컴파일러 연산은 왼쪽에서 부터 수행하기 때문에 reverse 로직이 꼬여서 발생한 문제가 발생함
     */
    // Core
    private int binaryToDigitOperator(String binary) {
        int r = 1;
        int d = 0;
        for (int i = 0; i < binary.length(); i++) {
            d += (binary.charAt(i) - 48) * r;
            r *= 2;
        }

        return d;
    }

    public static boolean checkHex(String hex) {
        return hex.matches("^[0-9A-Fa-f]+$");
    }

    private static void hexMapSetter() {
        HEX_MAP.put(10, "A");
        HEX_MAP.put(11, "B");
        HEX_MAP.put(12, "C");
        HEX_MAP.put(13, "D");
        HEX_MAP.put(14, "E");
        HEX_MAP.put(15, "F");

        HEX_MAP_REVERSE.put("A", 10);
        HEX_MAP_REVERSE.put("B", 11);
        HEX_MAP_REVERSE.put("C", 12);
        HEX_MAP_REVERSE.put("D", 13);
        HEX_MAP_REVERSE.put("E", 14);
        HEX_MAP_REVERSE.put("F", 15);
    }

    public static Map<Integer, String> getHexMap() {
        return HEX_MAP;
    }

    public static Map<String, Integer> getHexMapReverse() {
        return HEX_MAP_REVERSE;
    }

}