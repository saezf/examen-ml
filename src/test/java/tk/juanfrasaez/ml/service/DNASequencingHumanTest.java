package tk.juanfrasaez.ml.service;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class DNASequencingHumanTest {

    final DNASequencing dnaSequencing = new DNASequencing();

    @Test
    public void isHumanSequenceOf4() {
        String[] dna = {"CACT", "TTGT", "GCCT", "AGAG"};
        assertFalse(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isHumanSequenceOf5() {
        String[] dna = {"ATGGT", "AGGGA", "TAGGC", "AGTAA", "CAAGG"};
        assertFalse(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isHumanSequenceOf6() {
        String[] dna = {"TCTAAA", "AGCACG", "AGAAGC", "ACGCTT", "TTGTAT", "CCGCAG"};
        assertFalse(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isHumanSequenceOf7() {
        String[] dna = {"TGGTCAT", "TATAGAA", "GTTCACG", "GGCGCAT", "AGATGTC", "ATCTTTT", "ATTATCC"};
        assertFalse(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isHumanSequenceOf8() {
        String[] dna = {"AGAGACTG", "AAGACGAA", "TTAGGACT", "CACAATGG", "TCTGACTC", "CGATCATA", "TGATCCCA", "AGATAGCC"};
        assertFalse(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isHumanSequenceOf9() {
        String[] dna = {"GGCGTAAGA", "CGGACGCGG", "GTGGATATG", "CGATCTAAC",
                "ATAGCTATT", "AGCTATCAT", "AACTAGCTC", "TCTTTGGCG", "CATCCCATT"};
        assertFalse(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isHumanSequenceOf10() {
        String[] dna = {"TTGCATCAAG", "TAGGGCGATT", "CGATACGAGT", "CGCACACGTG",
                "AAGTCGCGAG", "CGCTTCCACT", "ATGGGATTGA", "CGCTCGTCTA", "TAGGGTGAAG", "ACTAAGGTAA"};
        assertFalse(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isHumanSequenceOf11() {
        String[] dna = {"TGACATGAGCG", "GTGAAAGGCCA", "AGGTTACAGTT", "TGTCGCTCCTA",
                "AACCTTAGATC", "AATGCTAAGGC", "TCACCCAAAAC", "ACTCAGTGATG", "GACCGGAATAG", "GCGTTCTCTAA", "CTTGCTGTCGA"};
        assertFalse(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isHumanSequenceOf12() {
        String[] dna = {"AGCATTTGTTTA", "CGTTGATTGTGA", "TCAAGTATGTGG", "TGTTATCTCATG",
                "ACTGAGCAAAGG", "GCTTCAGAAGCA", "GCGAATGGTCTG", "GTTATCATGATG",
                "TTAACGTGTCCC", "CCGCTGGCGATA", "ATGGGCTTCAGC", "TTTTAGTCTAGC"};
        assertFalse(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isHumanSequenceOf13() {
        String[] dna = {"GAAACCCGCGGAC", "GCTTTCGAACGGT", "TGAGTGCTCAATT", "GAACTGTCGTGCG",
                "AAGGGGACCTATG", "TTAACAGAGGTGG", "TTCCTACGGGCCC", "AGTCACTGACTGT",
                "CAAGCAACCGGCC", "CCGGCTTCTGTCA", "TCTCACCACCAAA", "CCTCCGGTTGACT", "AAGCATTAGTCGT"};
        assertFalse(dnaSequencing.isMutant(dna));
    }
}