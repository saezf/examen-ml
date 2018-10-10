package tk.juanfrasaez.ml.model.dto;

public class Sample {
    private String[] dna;

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    @Override
    public String toString() {
        return String.join("", dna);
    }
}
