package com.rschmitt.github.crystalmethod;

import com.github.rschmitt.crystalmethod.CrystalMethod;
import com.github.rschmitt.crystalmethod.Multimethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.lang.String.format;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// TODO:
// implement default method delegation for andThen, compose
// implement default dispatching value
// implement error handling
public class BasicTest {
    enum Letter { A, B }

    interface LetterMethod extends Multimethod<Letter, Integer, String> {}

    @Test
    public void testInvocation() {
        Map<Letter, Function<Integer, String>> dictionary = new HashMap<>();
        dictionary.put(Letter.A, this::letterA);
        dictionary.put(Letter.B, this::letterB);

        LetterMethod letterMethod = CrystalMethod.buildMultimethod(this::dispatch, dictionary, LetterMethod.class);

        assertEquals(letterMethod.apply(0), "a: 0");
        assertEquals(letterMethod.apply(1), "b: 1");
    }

    @Test
    public void testGetters() {
        Map<Letter, Function<Integer, String>> dictionary = new HashMap<>();

        LetterMethod letterMethod = CrystalMethod.buildMultimethod(this::dispatch, dictionary, LetterMethod.class);

        assertTrue(letterMethod.getDispatchMap().isEmpty());
        assertEquals(letterMethod.getDispatchFn().apply(2), Letter.A);
    }

    private Letter dispatch(Integer integer) {
        if (integer % 2 == 0) return Letter.A;
        else return Letter.B;
    }

    private String letterA(Integer integer) {
        return format("a: %d", integer);
    }

    private String letterB(Integer integer) {
        return format("b: %d", integer);
    }
}
