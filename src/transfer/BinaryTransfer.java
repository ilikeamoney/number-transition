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
            if (binary.charAt(i) - 48 != 0 || binary.charAt(i) - 48 != 1) {
                return !c;
            }
        }

        return c;
    }
}
