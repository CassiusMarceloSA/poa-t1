public class RabinKarp {
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
                for(int j = 0; j < M; j++) { 
                    if(text.charAt(i + j) != pattern.charAt(j)) { 
                        break;
                    }

                    if(j == M - 1) { 
                        return i;
                    }
                }
            } else { 
                int nextCharacterIndex = i + M;
                double nextHash = hashCalc(text.charAt(nextCharacterIndex));
                double firstHash = hashCalc(text.charAt(i));
                textHashSum += nextHash - firstHash;
            }
        }
        return N;
    }

    private double hash(String s, int M) {
        double h = 0;
        for (int i = 0; i < M; i++) {
            counter.increment();
            h += hashCalc(s.charAt(i));
        }
        return h;
    }

    private static double hashCalc(char character) {
        // return (character * Math.pow(alphabetSize, textLength - index)) % quotient;
        return character;
    }
}
