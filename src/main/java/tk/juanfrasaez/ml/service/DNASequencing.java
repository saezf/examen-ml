package tk.juanfrasaez.ml.service;

public class DNASequencing {
    public boolean isMutant(String[] dna) {
        return dna.length > 5 ? false : true;
    }
}
