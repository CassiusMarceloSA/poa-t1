public class RabinKarp {
    private static final int alphabetSize = 26;
    private static final int quotient = 997;
    private IterationCounter counter;

    public RabinKarp(IterationCounter counter) {
        this.counter = counter;
    }

    public int search(String pattern, String text) {
        int M = pattern.length();
        int N = text.length();
        double patternHash = hash(pattern, M);
        double textHashSum = hash(text.substring(0, M), M);
        System.out.println(patternHash);

        for (int i = 0; i <= N - M; i++) {
            counter.increment();

            if (patternHash == textHashSum) {
                return i;
            }
            int nextCharacterIndex = i + M;
            double nextHash = hashCalc(text.charAt(nextCharacterIndex), M - 1, M - 1);
            double firstHash = hashCalc(text.charAt(i), M - 1, 0);
            textHashSum += nextHash - firstHash;
        }
        return N;
    }

    private double hash(String s, int M) {
        double h = 0;
        for (int i = 0; i < M; i++) {
            counter.increment();
            h += hashCalc(s.charAt(i), M - 1, i);
        }
        return h;
    }

    private static double hashCalc(char character, int textLength, int index) {
        // return (character * Math.pow(alphabetSize, textLength - index)) % quotient;
        return character;
    }
}
