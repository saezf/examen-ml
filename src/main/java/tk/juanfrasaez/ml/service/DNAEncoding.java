package tk.juanfrasaez.ml.service;

import java.math.BigInteger;
import java.util.Base64;
import java.util.StringJoiner;

public class DNAEncoding {

    /**
     * Encodes the specified DNA using the {@link Base64} encoding scheme.
     *
     * <p> This method first encodes all nucleobases into binary values
     * and then encodes the resulting bytes into a base64 encoded string.
     *
     * @param dna the string representation of a DNA molecule
     * @return A String containing the resulting Base64 encoded DNA
     * @throws IllegalArgumentException if dna is not a valid representation for an DNA molecule
     */
    public String encode(String dna) throws IllegalArgumentException {
        StringJoiner stringJoiner = new StringJoiner("");
        for (int i = 0; i < dna.length(); i++) {
            stringJoiner.add(getBinaryValues(dna.charAt(i)));
        }
        BigInteger binaryInt = new BigInteger(stringJoiner.toString(), 2);
        return Base64.getEncoder().encodeToString(binaryInt.toByteArray());
    }

    private String getBinaryValues(char nucleobase) {
        switch (nucleobase) {
            case 'A': return "00";
            case 'C': return "01";
            case 'G': return "10";
            case 'T': return "11";
            default: throw new IllegalArgumentException();
        }
    }
}
