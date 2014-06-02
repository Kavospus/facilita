/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modelo.Scale;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre
 */
public class ScaleTest {
    
    public ScaleTest() {
    }
    Scale escalar;
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
    public void testEscalar() {
        escalar = new Scale(new double[][]{{1.0,2.0},{3.0,2.0}},-0.25, 2, 2);
        escalar.calculate();
        double[][] saida = new double[][]{{-0.25,-0.5},{-0.75,-0.5}};
        assertArrayEquals(saida[0],escalar.getResult()[0], 0.000001);
        assertArrayEquals(saida[1],escalar.getResult()[1], 0.000001);
    }
}
