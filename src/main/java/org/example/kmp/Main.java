package org.example.kmp;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        runExampleTests();
        runSimpleBenchmark();
        runJsonBenchmark();
    }

    private static void runExampleTests() {
        String text1 = "ababa";
        String pattern1 = "aba";
        runTest("short", text1, pattern1);

        String text2 = "abcxabcdabxabcdabcdabcy";
        String pattern2 = "abcdabcy";
        runTest("medium", text2, pattern2);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append("aaaaab");
        }
        String text3 = sb.toString();
        String pattern3 = "aaaaab";
        runTest("long", text3, pattern3);
    }

    private static void runTest(String name, String text, String pattern) {
        System.out.println("=== " + name + " test ===");
        System.out.println("text    = " + text);
        System.out.println("pattern = " + pattern);

        KmpMatcher matcher = new KmpMatcher(text, pattern);
        matcher.run();
        List<Integer> matches = matcher.matches();

        System.out.println("matches = " + matches);
        System.out.println();
    }

    private static void runSimpleBenchmark() {
        System.out.println("=== benchmark (manual sizes) ===");

        int[] sizes = {1000, 10_000, 100_000, 500_000};
        String pattern = "AAAB";

        for (int n : sizes) {
            String text = generateText(n, pattern);

            KmpMatcher matcher = new KmpMatcher(text, pattern);

            long start = System.nanoTime();
            matcher.run();
            long end = System.nanoTime();

            double ms = (end - start) / 1_000_000.0;
            List<Integer> matches = matcher.matches();

            System.out.println("n = " + n);
            System.out.println("text length = " + text.length());
            System.out.println("pattern = " + pattern);
            System.out.println("matches = " + matches);
            System.out.println("time (ms) = " + String.format("%.4f", ms));
            System.out.println();
        }
    }

    private static void runJsonBenchmark() {
        System.out.println("=== benchmark (from json) ===");

        List<TestCase> tests = TestCaseLoader.load();
        for (TestCase t : tests) {
            String text = generateText(t.n, t.pattern);

            KmpMatcher matcher = new KmpMatcher(text, t.pattern);

            long start = System.nanoTime();
            matcher.run();
            long end = System.nanoTime();

            long timeMs = (end - start) / 1_000_000;
            int count = matcher.matches().size();

            System.out.println("n = " + t.n +
                    " pattern = " + t.pattern +
                    " time(ms) = " + timeMs +
                    " matches = " + count);
        }
        System.out.println();
    }

    private static String generateText(int n, String pattern) {
        if (n <= pattern.length()) {
            return pattern.substring(0, n);
        }

        StringBuilder sb = new StringBuilder(n);
        int prefixLength = n - pattern.length();

        for (int i = 0; i < prefixLength; i++) {
            sb.append('A');
        }
        sb.append(pattern);

        return sb.toString();
    }
}