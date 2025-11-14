package org.example.kmp;

import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.util.List;

public class TestCaseLoader {

    static class Wrapper { List<TestCase> tests; }

    public static List<TestCase> load() {
        var stream = TestCaseLoader.class.getResourceAsStream("/tests.json");
        var reader = new InputStreamReader(stream);
        var wrapper = new Gson().fromJson(reader, Wrapper.class);
        return wrapper.tests;
    }
}