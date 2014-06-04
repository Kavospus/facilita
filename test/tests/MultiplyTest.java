/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modelo.Multiply;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre
 */
public class MultiplyTest {
    
    public MultiplyTest() {
    }
    Multiply multiply;
    @Before
    public void setUp() {
    }
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void testMutiplyFirstValue(){
    testMultiply(new double[][]{{-0.25,-0.5},{-0.75,-0.5}},new double[][]{{1.0,2.0},{3.0,2.0}},2,2,2,new double[][]{{-1.75,-1.5},{-2.25,-2.5}});
    }
    
    @Test
    public void testMutiplySecondValue(){
    testMultiply(new double[][]{{2014,2000},{2000,2010}},new double[][]{{1000,1111},{2222,3333}},2,2,2,new double[][]{{6458000.0,8903554.0},{6466220.0,8921330.0}});
    }
    
    @Test
    public void testMutiplyThirdValue(){
    testMultiply(new double[][]{{-1,2},{3,-4}},new double[][]{{1.0,-2.0},{-3.0,4.0}},2,2,2,new double[][]{{-7,10},{15,-22}});
    }
    
    
    
    private void testMultiply(double[][] inputA, double[][] inputB, int linesA,
	    int columnsA, int linesB, double [][] valueExpected) {
        multiply = new Multiply(inputA,inputB,linesA,columnsA,linesB);
        multiply.calculate();
        double[][] saida = valueExpected;
        assertArrayEquals(saida[0],multiply.getResult()[0], 0.000001);
        assertArrayEquals(saida[1],multiply.getResult()[1], 0.000001);
    }
}
