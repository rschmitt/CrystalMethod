package com.rschmitt.github.crystalmethod;

import com.github.rschmitt.crystalmethod.CrystalMethod;
import com.github.rschmitt.crystalmethod.Multimethod;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

// TODO:
// cache dispatch fn lookups
// design hierarchy management features (if any), figure out where to stick them
// covariance? contravariance?
// support for static (global) multimethods?
public class BasicTest {
    @Test
    public void test() {
        Map<Letter, Function<Integer, String>> dictionary = new HashMap<>();
        dictionary.put(Letter.A, this::letterA);
        dictionary.put(Letter.B, this::letterB);

        LetterMethod letterMethod = CrystalMethod.buildMultimethod(this::dispatch, dictionary, LetterMethod.class);

        assertEquals("a: 0", letterMethod.invoke(0));
        assertEquals("b: 1", letterMethod.invoke(1));
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

    enum Letter {
        A, B
    }

    interface LetterMethod extends Multimethod<Letter, String, Integer> {
    }
}
