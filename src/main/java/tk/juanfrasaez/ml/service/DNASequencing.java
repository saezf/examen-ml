package tk.juanfrasaez.ml.service;

public class DNASequencing {

    /**
     * This method analyzes a given nucleic acid sequence within a DNA molecule to determine if the DNA is mutant. If
     * there is more than one sequence of four equal nucleobases (AAAA, CCCC, GGGG, TTTT), then the DNA is mutant.
     *
     * @param dna the string array representation of a DNA molecule
     * @return {@code true} if the DNA is mutant, {@code false} otherwise.
     * @throws IllegalArgumentException if dna is not a valid representation for an DNA molecule
     */
    public boolean isMutant(String[] dna) throws IllegalArgumentException {
        if (dna == null || dna.length < 4)
            throw new IllegalArgumentException();
        int matchSequence = 0;
        int horizontal = 0;
        int[] vertical = new int[dna.length];
        for (int row = 0; row < dna.length; row++) {
            if (dna[row].length() != dna.length)
                throw new IllegalArgumentException();
            for (int column = 0; column < dna[row].length(); column++) {
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
            }
        }
        return matchSequence > 1;
    }

    private boolean isValidNucleobaseRepresentation(char n) {
        return ('A' == n || 'C' == n || 'G' == n || 'T' == n);
    }
}
