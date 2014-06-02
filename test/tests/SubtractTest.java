/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modelo.Subtract;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre
 */
public class SubtractTest {
    
    public SubtractTest() {
    }
    Subtract subtrair;
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
    public void testSubtrair() {
        subtrair = new Subtract(new double[][]{{1.0,2.0},{3.0,2.0}},new double[][]{{1.0,2.0},{3.0,2.0}}, 2, 2);
        subtrair.calculate();
        double[][] saida = new double[][]{{0.0,0.0},{0.0,0.0}};
        assertArrayEquals(saida[0],subtrair.getResult()[0], 0.000001);
        assertArrayEquals(saida[1],subtrair.getResult()[1], 0.000001);
    }
}
