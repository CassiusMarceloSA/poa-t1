public class App {
    public static void main(String[] args) {
        String pat = "BAA";
        String txt = "AACBAZaBAAASJDIOSAJDOISAJDOIASDJSOAIDJSAIDJIAS";
        IterationCounter counter = new IterationCounter();
        KMP kmp = new KMP(counter);
        kmp.search(pat, txt);
        System.out.println("Iterações [KMP]: " + counter.getCounter());
        counter.reset();
        RabinKarp rk = new RabinKarp(counter);
        rk.search(pat, txt);
        System.out.println("Iterações [RK]: " + counter.getCounter());
    }
}
