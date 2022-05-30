public class App {
    public static void main(String[] args) {
        String pat = "BAA";
        String txt = "AACBACACBAA";
        IterationCounter counter = new IterationCounter();
        // KMP kmp = new KMP(counter);
        // System.out.println("text: " + txt);
        // int offset = kmp.search(pat, txt);
        // System.out.print("pattern: ");
        // for (int i = 0; i < offset; i++)
        // System.out.print(" ");
        // System.out.println(pat);
        // System.out.println(counter.getCounter());
        RabinKarp rk = new RabinKarp(counter);

        System.out.println(rk.search(pat, txt));
    }
}
