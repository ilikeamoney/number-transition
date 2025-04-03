import transfer.HexTransfer;

/**
 * 아래는 10진수와 2진수를 16진수로 변환할 때 사용할 수 있는 간단한 테스트 케이스 몇 가지입니다.
 *
 * ---
 *
 * ### **10진수 → 16진수 테스트 케이스**
 * 1. **10진수: 10 → 16진수: A**
 * 2. **10진수: 255 → 16진수: FF**
 * 3. **10진수: 4096 → 16진수: 1000**
 * 4. **10진수: 12345 → 16진수: 3039**
 * 5. **10진수: 0 → 16진수: 0**
 *
 * ---
 *
 * ### **2진수 → 16진수 테스트 케이스**
 * 1. **2진수: 1010 → 16진수: A**
 * 2. **2진수: 11111111 → 16진수: FF**
 * 3. **2진수: 1000000000000 → 16진수: 1000**
 * 4. **2진수: 11000000111001 → 16진수: 3039**
 * 5. **2진수: 0 → 16진수: 0**
 *
 * ---
 *
 * 이 테스트 케이스들을 활용해 프로그램의 정확성을 확인해 보세요! 😊
 *
 * ---
 * Perplexity로부터의 답변: pplx.ai/share
 */

public class TransferMain {
    public static void main(String[] args) {

        HexTransfer h = HexTransfer.getInstance();

        String b1 = "1010";
        String b2 = "11111111";
        String b3 = "1000000000000";
        String b4 = "11000000111001";
        String b5 = "0";
        String b6 = "1001001011100010000000010111100";

        System.out.println(h.TransferBinaryToHex(b1));
        System.out.println(h.TransferBinaryToHex(b2));
        System.out.println(h.TransferBinaryToHex(b3));
        System.out.println(h.TransferBinaryToHex(b4));
        System.out.println(h.TransferBinaryToHex(b5));
        System.out.println(h.TransferBinaryToHex(b6));

        String d1 = "10";
        String d2 = "255";
        String d3 = "4096";
        String d4 = "12345";
        String d5 = "0";
        String d6 = "1232142524";


        System.out.println(h.TransferDigitToHex(d1));
        System.out.println(h.TransferDigitToHex(d2));
        System.out.println(h.TransferDigitToHex(d3));
        System.out.println(h.TransferDigitToHex(d4));
        System.out.println(h.TransferDigitToHex(d5));
        System.out.println(h.TransferDigitToHex(d6));

    }
}
