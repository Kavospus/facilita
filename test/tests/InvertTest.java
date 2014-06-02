/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modelo.Invert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre
 */
public class InvertTest {
    
    public InvertTest() {
    }
    Invert inverter;
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
        testInvert(new double[][]{{-1.0,-2.0},{-3.0,-4.0}}, 2, 2, new double[][]{{2,-1.0},{-1.5,0.5}});
    }
    
    @Test
    public void testInvertSecondValue(){
        testInvert(new double[][]{{2014,2000},{2000,2010}}, 2, 2, new double[][]{{0.04175321977565382,-0.0415454923140834},{-0.0415454923140834,0.041836310760281985}});
    }
    
    @Test
    public void testInvertThirdValue(){
        testInvert(new double[][]{{1.0,2.0},{3.0,2.0}}, 2, 2, new double[][]{{-0.5,0.5},{0.75,-0.25}});
    }
    
    private void testInvert(double[][] input, int linesA, int columnsA, double[][] valueExpected) {
        inverter = new Invert(input, linesA, columnsA);
        inverter.calculate();
        double[][] saida = valueExpected;
        assertArrayEquals(saida[0],inverter.getResult()[0], 0.000001);
        assertArrayEquals(saida[1],inverter.getResult()[1], 0.000001);
    }
}
