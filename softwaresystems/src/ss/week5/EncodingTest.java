package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/*
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */

public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello World";
        String hexRandom = "4d6f64756c652032";
        String hexString = "010203040506";
        String random = "U29mdHdhcmUgU31zdGVtcw==";

        String encoded = Hex.encodeHexString(input.getBytes());
        System.out.println("5.11 encode hex: " + encoded);

        byte[] output = Hex.decodeHex(hexRandom.toCharArray());
        String outputDecoded = new String(output);
        System.out.println("5.12 decode hex: " + outputDecoded);

        String randomOut = new String(Base64.decodeBase64(random));
        System.out.println("5.13 - base64 decode: " + randomOut);

        System.out.println("5.13 - base64 encode: " + Base64.encodeBase64String(input.getBytes()));

        byte[] uncoded = Hex.decodeHex(hexString.toCharArray());
        System.out.println("5.13 - decode hex encode base64: " + Base64.encodeBase64(uncoded));



        System.out.println("5.13 encode base64:");
        String out = "a";
        for (int i = 0; i< 10; i++) {
            String hereOut = new String(Base64.encodeBase64String(out.getBytes()));
            System.out.println(hereOut);
            out = out + "a";
        }

    }
}
