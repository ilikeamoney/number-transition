package transfer;

public class DigitTransfer implements TransferDigit {


    @Override
    public String TransferHexToDigit(String hex) {
        return "";
    }

    @Override
    public String TransferBinaryToDigit(String binary) {
        if (BinaryTransfer.checkBinary(binary)) {
            int d = binaryToDigitOperator(binary);
            return String.valueOf(d);
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

    private int binaryToDigitOperator(String binary) {
        int r = 1;
        int d = 0;
        for (int i = 0; i < binary.length(); i++) {
            d += (binary.charAt(i) - 48) * r;
            r *= 2;
        }

        return d;
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


    public static int stringDigitTORealValue(String strDigit) {
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
