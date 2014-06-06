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
public class SumTest {
    
    public SumTest() {
    }
    Sum sum;
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
    public void testSumFirstValue(){
        testSum(new double[][]{{1.0,2.0},{3.0,2.0}},new double[][]{{1.0,2.0},{3.0,2.0}}, 2, 2,new double[][]{{2.0,4.0},{6.0,4.0}});
    }
    
    @Test
    public void testSumSecondValue(){
        testSum(new double[][]{{0.1,-0.2},{-0.3,0.2}},new double[][]{{-0.2,0.1},{0.2,-0.3}}, 2, 2,new double[][]{{-0.1,-0.1},{-0.1,-0.1}});
    }
    
    @Test
    public void testSumThirdValue(){
        testSum(new double[][]{{1000.0,2000.0},{-3000.0,-4000.0}},new double[][]{{-5000.0,-6000.0},{7000.0,8000.0}}, 2, 2,new double[][]{{-4000,-4000},{4000,4000}});
    }
    
    private void testSum(double[][] inputA, double[][] inputB, int linesA,
	    int columnsA, double [][] valueExpected) {
        sum = new Sum(inputA,inputB,linesA,columnsA);
        sum.calculate();
        double[][] saida = valueExpected;
        assertArrayEquals(saida[0],sum.getResult()[0], 0.000001);
        assertArrayEquals(saida[1],sum.getResult()[1], 0.000001);
    }
}
