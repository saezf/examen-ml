package tk.juanfrasaez.ml.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DNAEncodingTest {

    final DNAEncoding encodingService = new DNAEncoding();
    final String dna = "ATGCGACAGTGCTTATGTAGAAGGCCCCTATCACTG";
    final String encodedDNA = "OYS587IKVc0e";

    @Test
    public void encode() {
        assertEquals(encodedDNA, encodingService.encode(dna));
    }
}