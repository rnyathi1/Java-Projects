package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    Main main = new Main();
    @Test
    public void main() {
        assertEquals(main.addition(3,3),6,0);
        assertEquals(main.subtraction(3,3),0,0);
        assertEquals(main.multiplication(3,3),9,0);
        assertEquals(main.division(3,3),1,0);

    }
}