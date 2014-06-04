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
    Subtract subtract;
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
    public void testSubtractFirstValue(){
      testSubtract(new double[][]{{1.0,2.0},{3.0,2.0}},new double[][]{{1.0,2.0},{3.0,2.0}},2,2,new double[][]{{0.0,0.0},{0.0,0.0}});
    }
    
    @Test
    public void testSecondFirstValue(){
      testSubtract(new double[][]{{1111.2222,2222.3333},{4444.5555,6666.7777}},new double[][]{{8888.9999,1010.1111},{1212.1313,1414.1515}},2,2,new double[][]{{-7777.777700000001,1212.2221999999997},{3232.4242000000004,5252.6262}});
    }
    
    @Test
    public void testThirdFirstValue(){
      testSubtract(new double[][]{{-1.0,2.0},{3.0,-4.0}},new double[][]{{5.0,-6.0},{-7.0,8.0}},2,2,new double[][]{{-6.0,8.0},{10.0,-12.0}});
    }
    
    
    
    private void testSubtract(double[][] inputA, double[][] inputB, int linesA,
	    int columnsA, double [][] valueExpected) {
        subtract = new Subtract(inputA, inputB, linesA, columnsA);
        subtract.calculate();
        double[][] saida = valueExpected;
        assertArrayEquals(saida[0],subtract.getResult()[0], 0.000001);
        assertArrayEquals(saida[1],subtract.getResult()[1], 0.000001);
    }
}
