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
}
