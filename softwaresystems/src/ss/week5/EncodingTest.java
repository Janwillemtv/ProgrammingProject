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
        String hexString = "010203040506";
        String random = "U29mdHdhcmUgU31zdGVtcw==";
        String encoded = Hex.encodeHexString(input.getBytes());
        System.out.println(encoded);
        String randomOut = new String(Base64.decodeBase64(random));
        System.out.println(randomOut);
       // System.out.println(Base64.)
        System.out.println(Base64.encodeBase64String(input.getBytes()));
        byte[] output = Hex.decodeHex(encoded.toCharArray());
        byte[] uncoded = Hex.decodeHex(hexString.toCharArray());
        System.out.println(Base64.encodeBase64(uncoded));

        String outputDecoded = new String(output);
        System.out.println(outputDecoded);
        String out = "a";
        for (int i = 0; i< 10; i++) {
            String hereOut = new String(Base64.encodeBase64String(out.getBytes()));
            System.out.println(hereOut);
            out = out + "a";
        }


    }
}
