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
public class TransposeTest {
    
    public TransposeTest() {
    }
    Transpose transpose;
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
    public void testTransposeFirstValue(){
        testTranspose(new double[][]{{-0.5,0.5},{0.75,-0.25}}, 2, 2,new double[][]{{-0.5,0.75},{0.5,-0.25}});
    }
    
    @Test
    public void testTransposeSecondValue(){
        testTranspose(new double[][]{{1111.2222,3333.4444},{5555.6666,7777.8888}}, 2, 2,new double[][]{{1111.2222,5555.6666},{3333.4444,7777.8888}});
    }
    
    @Test
    public void testTransposeThirdValue(){
        testTranspose(new double[][]{{1,2},{-3,-4}}, 2, 2,new double[][]{{1,-3},{2,-4}});
    }
    
    private void testTranspose(double[][] input, int linesA, int columnsA, double[][] valueExpected) {
        transpose = new Transpose(input, linesA, columnsA);
        transpose.calculate();
        double[][] saida = valueExpected;
        assertArrayEquals(saida[0],transpose.getResult()[0], 0.000001);
        assertArrayEquals(saida[1],transpose.getResult()[1], 0.000001);
    }
}
