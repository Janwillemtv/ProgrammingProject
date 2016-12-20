package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/*
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */

public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello World";
        String encoded = Hex.encodeHexString(input.getBytes());
        System.out.println(encoded);

        byte[] output = Hex.decodeHex(encoded.toCharArray());
        String outputDecoded = new String(output);
        System.out.println(outputDecoded);

    }
}
