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
    Scale scale;
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
    public void testInvertFirstValue(){
        testScale(new double[][]{{1.0,2.0},{3.0,2.0}}, -0.25, 2,2, new double[][]{{-0.25,-0.5},{-0.75,-0.5}});
    }
    
    @Test
    public void testInvertSecondValue(){
        testScale(new double[][]{{1.0,2.0},{3.0,4.0}}, 1000.0, 2,2, new double[][]{{1000,2000},{3000,4000}});
    }
    
    @Test
    public void testInvertThirdValue(){
        testScale(new double[][]{{-1.0,2.0},{3.0,-4.0}}, -1.0, 2,2, new double[][]{{1.0,-2.0},{-3.0,4.0}});
    }
    
    private void testScale(double[][] inputA, double inputB, int linesA,
	    int columnsA, double [][] valueExpected) {
        scale = new Scale(inputA, inputB, linesA, columnsA);
        scale.calculate();
        double[][] saida = valueExpected;
        assertArrayEquals(saida[0],scale.getResult()[0], 0.000001);
        assertArrayEquals(saida[1],scale.getResult()[1], 0.000001);
    }
}
