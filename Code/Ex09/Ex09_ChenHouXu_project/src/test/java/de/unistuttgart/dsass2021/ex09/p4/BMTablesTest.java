package de.unistuttgart.dsass2021.ex09.p4;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.Arrays;

public class BMTablesTest {
    @Test
    public void testLastTable(){
        final String pattern = "jkjljkjl";
        BMTables.initShift(pattern);
        System.out.println(Arrays.toString(BMTables.initLast(pattern)));
    }

    @Test
    public void testShiftSuffixTable(){
        final String pattern = "jkjljkjl";
        int[] shift = new int[pattern.length()];
        int[] suffix = new int[pattern.length()];
        BMTables.bmShiftSuffix(pattern, shift, suffix);
        System.out.println(Arrays.toString(shift));
        System.out.println(Arrays.toString(suffix));
    }

    @Test
    public void testbmSearch(){
        final String pattern = "rewwrwrrw";
        final String text = "etwqwrerwtwrrwwrreerewwrwrrwrw";
        int position = BMTables.bmSearch(text, pattern);
        System.out.println(position);
    }
}
