package tk.juanfrasaez.ml.service;

import org.junit.Test;

public class DNASequencingNotValidRepresentationTest {

    final DNASequencing dnaSequencing = new DNASequencing();

    @Test(expected = IllegalArgumentException.class)
    public void notValidRepresentationOf3() {
        String[] dna = {"TACG", "TTGG", "TCCG"};
        dnaSequencing.isMutant(dna);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidRepresentationOf4By6() {
        String[] dna = {"TCTAAA", "AGCACG", "AGAAGC", "ACGCTT"};
        dnaSequencing.isMutant(dna);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidRepresentationOf5By3() {
        String[] dna = {"ATG", "AGG", "GGC", "AGA", "CGG"};
        dnaSequencing.isMutant(dna);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidRepresentationOf5ByIrregularLength() {
        String[] dna = {"ATGTA", "AG", "GGGC", "AGTTAAAGA", "CGG"};
        dnaSequencing.isMutant(dna);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidRepresentationOf5WithNonNucleobases() {
        String[] dna = {"AT1GT", "AG3UA", "TA5GC", "AvTAA", "CANG0"};
        dnaSequencing.isMutant(dna);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidRepresentationOf5WithInvalidNucleobases() {
        String[] dna = {"atggt", "aggga", "taggc", "agtaa", "caagg"};
        dnaSequencing.isMutant(dna);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidRepresentationOfEmpty() {
        String[] dna = {};
        dnaSequencing.isMutant(dna);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidRepresentationOfNull() {
        String[] dna = null;
        dnaSequencing.isMutant(dna);
    }
}
