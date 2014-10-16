package com.rschmitt.github.crystalmethod;

import com.github.rschmitt.crystalmethod.Multimethod;
import org.testng.annotations.Test;

import static com.github.rschmitt.crystalmethod.CrystalMethod.*;
import static org.testng.Assert.assertEquals;

public class StaticTest {
    @Test
    public void test() {
        defMulti(this::dispatch, GlobalMethod.class);

        addMethod("2", this::m2, GlobalMethod.class);
        addMethod("3", this::m1, GlobalMethod.class);

        assertEquals(invoke(GlobalMethod.class, 3.1).intValue(), 1);
        assertEquals(invoke(GlobalMethod.class, 3.2).intValue(), 1);
        assertEquals(invoke(GlobalMethod.class, 2.7).intValue(), 2);

        addMethod("4", this::m1, GlobalMethod.class);

        assertEquals(invoke(GlobalMethod.class, 4.9).intValue(), 1);
    }

    private String dispatch(double d) {
        return String.valueOf((int) d);
    }

    private int m1(double d) {
        return 1;
    }

    private int m2(double d) {
        return 2;
    }

    interface GlobalMethod extends Multimethod<String, Double, Integer> {}
}
