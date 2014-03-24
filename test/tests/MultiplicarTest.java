/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modelo.Multiplicar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre
 */
public class MultiplicarTest {
    
    public MultiplicarTest() {
    }
    Multiplicar multiplicar;
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
    public void testMultiplicar() {
        multiplicar = new Multiplicar(new double[][]{{-0.25,-0.5},{-0.75,-0.5}},new double[][]{{1.0,2.0},{3.0,2.0}},2, 2,2);
        multiplicar.calcular();
        double[][] saida = new double[][]{{-1.75,-1.5},{-2.25,-2.5}};
        assertArrayEquals(saida[0],multiplicar.getResultado()[0], 0.000001);
        assertArrayEquals(saida[1],multiplicar.getResultado()[1], 0.000001);
    }
}
