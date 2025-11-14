package org.example.kmp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KmpMatcherTest {

    private List<Integer> run(String text, String pattern) {
        KmpMatcher matcher = new KmpMatcher(text, pattern);
        matcher.run();
        return matcher.matches();
    }

    @Test
    void simpleMatch() {
        String text = "ababa";
        String pattern = "aba";

        List<Integer> res = run(text, pattern);

        assertEquals(List.of(0, 2), res);
    }

    @Test
    void mediumMatch() {
        String text = "abcxabcdabxabcdabcdabcy";
        String pattern = "abcdabcy";

        List<Integer> res = run(text, pattern);

        assertEquals(List.of(15), res);
    }

    @Test
    void multipleOverlappingMatches() {
        String text = "aaaaa";
        String pattern = "aa";

        List<Integer> res = run(text, pattern);

        assertEquals(List.of(0, 1, 2, 3), res);
    }

    @Test
    void noMatch() {
        String text = "abcdef";
        String pattern = "gh";

        List<Integer> res = run(text, pattern);

        assertTrue(res.isEmpty());
    }

    @Test
    void patternLongerThanText() {
        String text = "abc";
        String pattern = "abcdef";

        List<Integer> res = run(text, pattern);

        assertTrue(res.isEmpty());
    }
}