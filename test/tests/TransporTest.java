/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modelo.Transpose;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre
 */
public class TransporTest {
    
    public TransporTest() {
    }
    Transpose transpor;
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
    public void testTranspor() {
        transpor = new Transpose(new double[][]{{-0.5,0.5},{0.75,-0.25}}, 2, 2);
        transpor.calcular();
        double[][] saida = new double[][]{{-0.5,0.75},{0.5,-0.25}};
        assertArrayEquals(saida[0],transpor.getResultado()[0], 0.000001);
        assertArrayEquals(saida[1],transpor.getResultado()[1], 0.000001);
    }
}
