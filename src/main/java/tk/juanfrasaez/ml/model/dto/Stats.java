package tk.juanfrasaez.ml.model.dto;

public class Stats {
    private int countMutant;
    private int countHuman;
    private double ratio;

    public int getCountMutant() {
        return countMutant;
    }

    public void setCountMutant(int countMutant) {
        this.countMutant = countMutant;
    }

    public int getCountHuman() {
        return countHuman;
    }

    public void setCountHuman(int countHuman) {
        this.countHuman = countHuman;
    }

    public double getRatio() {
        return ratio;
    }

    public void calculateRatio() {
        this.ratio = (double) countMutant / countHuman;
    }
}
