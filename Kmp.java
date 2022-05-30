class KMP {
    private int[][] dfa;
    private static final int POSSIBLE_CHARACTERS_NUMBER = 256;
    private IterationCounter counter;

    public KMP(IterationCounter counter) {
        this.counter = counter;
    }

    public void dfaPreProcessing(String pattern) {
        int M = pattern.length();
        dfa = new int[POSSIBLE_CHARACTERS_NUMBER][M];
        dfa[pattern.charAt(0)][0] = 1;

        for (int state = 0, j = 1; j < M; j++) {
            for (int character = 0; character < POSSIBLE_CHARACTERS_NUMBER; character++) {
                dfa[character][j] = dfa[character][state];
                counter.increment();
            }
            dfa[pattern.charAt(j)][j] = j + 1;
            state = dfa[pattern.charAt(j)][state];
        }
    }

    public int search(String pattern, String text) {
        int j, M = pattern.length();
        int i, N = text.length();

        dfaPreProcessing(pattern);

        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[text.charAt(i)][j];
            counter.increment();
        }
        if (j == M)
            return i - M;
        else
            return N;
    }

}