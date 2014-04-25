/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modelo.Determine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre
 */
public class DeterminarTest {
    
    public DeterminarTest() {
    }
    Determine determinar;
    @Before
    public void setUp() {
    }
    @After
    public void tearDown() {
    }
    @Test
    public void testDeterminar() {
        determinar = new Determine(new double[][]{{-0.5,0.75},{0.5,-0.25}}, 2, 2);
        determinar.calculate();
        double saida = -0.25;
        assertEquals(saida,determinar.getResult(), 0.000001);
        assertEquals(saida,determinar.getResult(), 0.000001);
    }
}
