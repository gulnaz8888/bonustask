package org.example.string.kmp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KmpMatcher {

    private final String text;
    private final String pattern;
    private final int[] lps;
    private final List<Integer> matches = new ArrayList<>();

    public KmpMatcher(String text, String pattern) {
        this.text = Objects.requireNonNull(text);
        this.pattern = Objects.requireNonNull(pattern);
        if (pattern.isEmpty()) {
            this.lps = new int[0];
        } else {
            this.lps = buildLps(pattern);
        }
    }

    public void run() {
        matches.clear();

        if (pattern.isEmpty()) {
            return;
        }
        if (pattern.length() > text.length()) {
            return;
        }

        int i = 0;
        int j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    matches.add(i - j);
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    public List<Integer> matches() {
        return new ArrayList<>(matches);
    }

    private int[] buildLps(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}