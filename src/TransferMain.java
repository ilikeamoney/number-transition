import transfer.BinaryTransfer;
import transfer.DigitTransfer;
import transfer.HexTransfer;

/**
 * 아래는 10진수와 2진수를 16진수로 변환할 때 사용할 수 있는 간단한 테스트 케이스 몇 가지입니다.

 * **10진수 → 16진수 테스트 케이스
 * 1. **10진수: 10 → 16진수: A
 * 2. **10진수: 255 → 16진수: FF
 * 3. **10진수: 4096 → 16진수: 1000
 * 4. **10진수: 12345 → 16진수: 3039
 * 5. **10진수: 0 → 16진수: 0

 * **2진수 → 16진수 테스트 케이스
 * 1. **2진수: 1010 → 16진수: A
 * 2. **2진수: 11111111 → 16진수: FF
 * 3. **2진수: 1000000000000 → 16진수: 1000
 * 4. **2진수: 11000000111001 → 16진수: 3039
 * 5. **2진수: 0 → 16진수: 0
 * 6. **2진수: 1001001011100010000000010111100 → 16진수: 497100BC

 * 이 테스트 케이스들을 활용해 프로그램의 정확성을 확인해 보세요! 😊
 */

public class TransferMain {
    public static void main(String[] args) {
        HexTransfer h = HexTransfer.getInstance();
        DigitTransfer d = DigitTransfer.getInstance();
        BinaryTransfer b = BinaryTransfer.getInstance();


        // 2진수 -> 16진수
        System.out.println("----------2진수 -> 16진수----------");
        String h1 = "1010";
        String h2 = "11111111";
        String h3 = "1000000000000";
        String h4 = "11000000111001";
        String h5 = "0";
        String h6 = "1001001011100010000000010111100";

        System.out.println(h.transferBinaryToHex(h1));
        System.out.println(h.transferBinaryToHex(h2));
        System.out.println(h.transferBinaryToHex(h3));
        System.out.println(h.transferBinaryToHex(h4));
        System.out.println(h.transferBinaryToHex(h5));
        System.out.println(h.transferBinaryToHex(h6));

        // 10진수 -> 16진수
        System.out.println("----------10진수 -> 16진수----------");
        String h7 = "10";
        String h8 = "255";
        String h9 = "4096";
        String h10 = "12345";
        String h11 = "0";
        String h12 = "1232142524";

        System.out.println(h.transferDigitToHex(h7));
        System.out.println(h.transferDigitToHex(h8));
        System.out.println(h.transferDigitToHex(h9));
        System.out.println(h.transferDigitToHex(h10));
        System.out.println(h.transferDigitToHex(h11));
        System.out.println(h.transferDigitToHex(h12));

        // 2진수 -> 10진수
        System.out.println("----------2진수 -> 10진수----------");
        String d1 = "1010"; // 10
        String d2 = "11111111"; // 255
        String d3 = "1000000000000"; // 4096
        String d4 = "11000000111001"; // 12345
        String d5 = "0"; // 0
        String d6 = "1001001011100010000000010111100"; // 1232142524

        System.out.println(d.transferBinaryToDigit(d1));
        System.out.println(d.transferBinaryToDigit(d2));
        System.out.println(d.transferBinaryToDigit(d3));
        System.out.println(d.transferBinaryToDigit(d4));
        System.out.println(d.transferBinaryToDigit(d5));
        System.out.println(d.transferBinaryToDigit(d6));

        // 16진수 -> 10진수
        System.out.println("----------16진수 -> 10진수----------");
        String d7 = "A"; // 10
        String d8 = "FF"; // 255
        String d9 = "1000"; // 4096
        String d10 = "3039"; // 12345
        String d11 = "0"; // 0
        String d12 = "497100BC"; // 1232142524

        System.out.println(d.transferHexToDigit(d7));
        System.out.println(d.transferHexToDigit(d8));
        System.out.println(d.transferHexToDigit(d9));
        System.out.println(d.transferHexToDigit(d10));
        System.out.println(d.transferHexToDigit(d11));
        System.out.println(d.transferHexToDigit(d12));


        // 10진수 -> 16진수
        System.out.println("----------10진수 -> 2진수----------");
        String b1 = "10";
        String b2 = "255";
        String b3 = "4096";
        String b4 = "12345";
        String b5 = "0";
        String b6 = "1232142524";

        System.out.println(b.transferDigitToBinary(h7));
        System.out.println(b.transferDigitToBinary(h8));
        System.out.println(b.transferDigitToBinary(h9));
        System.out.println(b.transferDigitToBinary(h10));
        System.out.println(b.transferDigitToBinary(h11));
        System.out.println(b.transferDigitToBinary(h12));

        System.out.println("----------16진수 -> 2진수----------");
        String b7 = "A"; // 10
        String b8 = "FF"; // 255
        String b9 = "1000"; // 4096
        String b10 = "3039"; // 12345
        String b11 = "0"; // 0
        String b12 = "497100BC"; // 1232142524

        System.out.println(b.transferHexToBinary(d7));
        System.out.println(b.transferHexToBinary(d8));
        System.out.println(b.transferHexToBinary(d9));
        System.out.println(b.transferHexToBinary(d10));
        System.out.println(b.transferHexToBinary(d11));
        System.out.println(b.transferHexToBinary(d12));
    }
}
