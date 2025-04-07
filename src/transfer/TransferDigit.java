package transfer;

public interface TransferDigit extends Transfer {
    String transferHexToDigit(String hex);
    String transferBinaryToDigit(String binary);
}
