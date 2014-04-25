/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modelo.Invert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre
 */
public class InverterTest {
    
    public InverterTest() {
    }
    Invert inverter;
    @Before
    public void setUp() {
    }
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testInverter() {
        inverter = new Invert(new double[][]{{1.0,2.0},{3.0,2.0}}, 2, 2);
        inverter.calculate();
        double[][] saida = new double[][]{{-0.5,0.5},{0.75,-0.25}};
        assertArrayEquals(saida[0],inverter.getResult()[0], 0.000001);
        assertArrayEquals(saida[1],inverter.getResult()[1], 0.000001);
    }
}
