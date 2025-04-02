package transfer;

import java.util.HashMap;
import java.util.Map;

public class HexTransfer implements TransferHex {
    private static final int HEX = 16;

    private static HexTransfer hexTransfer;

    private static final Map<Integer, String> HEX_MAP = new HashMap<>();


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
        StringBuilder s = new StringBuilder();
        boolean c = DigitTransfer.checkDigit(digit);

        if (c) {
            int d = DigitTransfer.getDigitValue(digit);

            while (d > 0) {
                // 현재 r을 d로 나눈 나머지 구하기.
                int r = d % HEX;
                String n = HEX_MAP.get(r);

                if (n == null) {
                    s.append(r);
                } else {
                    s.append(n);
                }

                d /= HEX;
            }
        }

        // 사이즈가 1 이상이면
        if (s.length() > 1) {
            return reverse(s.toString());
        }

        return s.toString();
    }

    @Override
    public String TransferBinaryToHex(String binary) {
        boolean c = BinaryTransfer.checkBinary(binary);

        //TODO 2진수 -> 16진수
        if (c) {

        }


        return "";
    }

    @Override
    public String reverse(String n) {
        StringBuilder result = new StringBuilder();

        for (int i = n.length() - 1; i >= 0; i--) {
            result.append(n.charAt(i));
        }

        return result.toString();
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
