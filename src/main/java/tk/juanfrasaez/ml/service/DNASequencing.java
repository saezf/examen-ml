package tk.juanfrasaez.ml.service;

public class DNASequencing {

    /**
     * This method analyzes a given nucleic acid sequence within a DNA molecule to determine if the DNA is mutant. If
     * there is more than one sequence of four equal nucleobases (AAAA, CCCC, GGGG, TTTT), then the DNA is mutant.
     *
     * @param dna the string array representation of a DNA molecule
     * @return {@code true} if the DNA is mutant, {@code false} otherwise
     * @throws IllegalArgumentException if dna is not a valid representation for an DNA molecule
     */
    public boolean isMutant(String[] dna) throws IllegalArgumentException {
        if (dna == null || dna.length < 4)
            throw new IllegalArgumentException();
        int matchSequence = 0;
        int[] vertical = new int[dna.length];
        for (int row = 0; row < dna.length; row++) {
            int horizontal = 0, positiveSlope = 0, negativeSlope = 0;
            if (dna[row].length() != dna.length)
                throw new IllegalArgumentException();
            for (int column = 0; column < dna.length; column++) {
                if (!isValidNucleobaseRepresentation(dna[row].charAt(column)))
                    throw new IllegalArgumentException();
                horizontal += dna[row].charAt(column);
                if (horizontal % dna[row].charAt(column) > 0) {
                    horizontal = dna[row].charAt(column);
                } else if (horizontal / 4 == dna[row].charAt(column)) {
                    matchSequence++;
                    horizontal = 0;
                }
                vertical[column] += dna[row].charAt(column);
                if (vertical[column] % dna[row].charAt(column) > 0) {
                    vertical[column] = dna[row].charAt(column);
                } else if (vertical[column] / 4 == dna[row].charAt(column)) {
                    matchSequence++;
                    vertical[column] = 0;
                }
                if (row == 0) {
                    if (dna.length - column > 3) {
                        negativeSlope = 0;
                        for (int slope = column; slope < dna.length - column; slope++) {
                            negativeSlope += dna[slope].charAt(column + slope);
                            if (negativeSlope % dna[slope].charAt(column + slope) > 0) {
                                negativeSlope = dna[slope].charAt(column + slope);
                            } else if (negativeSlope / 4 == dna[slope].charAt(column + slope)) {
                                matchSequence++;
                                negativeSlope = 0;
                            }
                        }
                    }
                    if (column > 2) {
                        positiveSlope = 0;
                        for (int slope = column; slope >= 0; slope--) {
                            positiveSlope += dna[slope].charAt(column - slope);
                            if (positiveSlope % dna[slope].charAt(column - slope) > 0) {
                                positiveSlope = dna[slope].charAt(column - slope);
                            } else if (positiveSlope / 4 == dna[slope].charAt(column - slope)) {
                                matchSequence++;
                                positiveSlope = 0;
                            }
                        }
                    }
                } else {
                    if (dna.length - row > 3 && row + column < dna.length) {
                        negativeSlope += dna[row + column].charAt(column);
                        if (negativeSlope % dna[row + column].charAt(column) > 0) {
                            negativeSlope = dna[row + column].charAt(column);
                        } else if (negativeSlope / 4 == dna[row + column].charAt(column)) {
                            matchSequence++;
                            negativeSlope = 0;
                        }
                    }
                    if (dna.length - column > 3 && row + column < dna.length) {
                        positiveSlope += dna[dna.length - column - 1].charAt(row + column);
                        if (positiveSlope % dna[dna.length - column - 1].charAt(row + column) > 0) {
                            positiveSlope = dna[dna.length - column - 1].charAt(row + column);
                        } else if (positiveSlope / 4 == dna[dna.length - column - 1].charAt(row + column)) {
                            matchSequence++;
                            positiveSlope = 0;
                        }
                    }
                }
            }
        }
        return matchSequence > 1;
    }

    private boolean isValidNucleobaseRepresentation(char n) {
        return ('A' == n || 'C' == n || 'G' == n || 'T' == n);
    }
}
