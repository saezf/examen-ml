package tk.juanfrasaez.ml.service;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DNASequencingMutantTest {

    final DNASequencing dnaSequencing = new DNASequencing();

    @Test
    public void isMutantSequenceOf4() {
        String[] dna = {"TACG", "TTGG", "TCCG", "TGAG"};
        assertTrue(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isMutantSequenceOf5() {
        String[] dna = {"ATGGT", "AGGGA", "AAGGC", "AGTGA", "CAAGG"};
        assertTrue(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isMutantSequenceOf6() {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        assertTrue(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isMutantSequenceOf7() {
        String[] dna = {"TGGTCAT", "TATAGAA", "GTTCACG", "GGTGCAT", "AGATGTC", "ATCTTTT", "ATTATCC"};
        assertTrue(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isMutantSequenceOf8() {
        String[] dna = {"AGAGACTG", "AAGACGAA", "TTAGGACT", "CACAATGG", "TCTCACTC", "CGATCATA", "TGATCCCA", "AGATAGCC"};
        assertTrue(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isMutantSequenceOf9() {
        String[] dna = {"GGCGTAAGA", "CGGACGCGG", "GTGGATATG", "CGATCTAAC",
                "ATAGCTATT", "AGCTATCAT", "AACTTGCTC", "TCTTTGGCG", "CATCCCATT"};
        assertTrue(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isMutantSequenceOf10() {
        String[] dna = {"TTGCATCAAG", "TAGGGCGATT", "CGATACAAGT", "CGCACACGTG",
                "AAGTCGCGAG", "CGCTTCCACT", "ATGGGATTGA", "CGCTCGTGTA", "TAGGGTGAAG", "ACTAAGGTAA"};
        assertTrue(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isMutantSequenceOf11() {
        String[] dna = {"TGACATGAGCG", "GTGAAAGGCCA", "AGGTTACAGTT", "TGTCGCTCCTA",
                "AACCTTAGATC", "AATGCTAAGGC", "TCACCCAAAAC", "ACTCAGTGATG", "GACCGGAATAG", "GCGTTCTCTAA", "CTTGCTGTCGA"};
        assertTrue(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isMutantSequenceOf12() {
        String[] dna = {"AGCATTTGTTTA", "CGTTGATTGTGA", "TCAAGTATGTGG", "TGTTATCTCATG",
                "ACTGAGCAAAGG", "GCTTCAGAAGCA", "GCGAATGGTCTG", "GTTATCATGATG",
                "TTAACGTGTCCC", "CCGCTGGCGATA", "ATGGGCTTCAGC", "TTTTAGTCTAGC"};
        assertTrue(dnaSequencing.isMutant(dna));
    }

    @Test
    public void isMutantSequenceOf13() {
        String[] dna = {"GAAACCCGCGGAC", "GCTTTCGAACGGT", "TGAGTGCTCAATT", "GAACTGTCGTGCG",
                "AAGGGGACCTATG", "TTAACAGAGGTGG", "TTCCTACGGGCCC", "AGTCACTGACTGT",
                "CAAGCAACCGGCC", "CCGGCTTCTGTCA", "TCTCACCACCAAA", "CCTCCGGTTGACT", "AAGCATTAGTCGT"};
        assertTrue(dnaSequencing.isMutant(dna));
    }
}