/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modelo.Sum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre
 */
public class SomarTest {
    
    public SomarTest() {
    }
    Sum somar;
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
    public void testSomar() {
        somar = new Sum(new double[][]{{1.0,2.0},{3.0,2.0}},new double[][]{{1.0,2.0},{3.0,2.0}}, 2, 2);
        somar.calculate();
        double[][] saida = new double[][]{{2.0,4.0},{6.0,4.0}};
        assertArrayEquals(saida[0],somar.getResult()[0], 0.000001);
        assertArrayEquals(saida[1],somar.getResult()[1], 0.000001);
    }
}
