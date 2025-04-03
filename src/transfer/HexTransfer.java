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

            // 입력이 0
            if (d == 0) return String.valueOf(d);

            while (d > 0) {
                // 현재 d을 HEX 나눈 나머지 구하기.
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
        StringBuilder sb = new StringBuilder();
        boolean c = BinaryTransfer.checkBinary(binary);

        if (c) {
            // 길이가 4 이상
            if (binary.length() > 3) {
                String[] bytes = cutByteStr(binary);

                for (String b : bytes) {
                    sb.append(exchangeHex(b));
                }

                return reverse(String.valueOf(sb));
            }
        }

        return exchangeHex(binary);
    }

    @Override
    public String reverse(String n) {
        StringBuilder result = new StringBuilder();

        for (int i = n.length() - 1; i >= 0; i--) {
            result.append(n.charAt(i));
        }

        return result.toString();
    }

    // 4비트씩 자르기
    private String[] cutByteStr(String longBinary) {
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

    private String exchangeHex(String binary) {
        int r = 1;
        int d = 0;
        for (int i = 0; i < binary.length(); i++) {
            d += (binary.charAt(i) - 48) * r;
            r *= 2;
        }

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