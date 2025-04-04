package transfer;

public class BinaryTransfer implements TransferBinary {
    @Override
    public String transferDigitToBinary(String digit) {

        return "";
    }

    @Override
    public String transferHexToBinary(String hex) {
        return "";
    }

    @Override
    public String reverse(String n) {
        return "";
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
