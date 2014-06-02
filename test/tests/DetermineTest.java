/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modelo.Determine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre
 */
public class DetermineTest {
    
    public DetermineTest() {
    }
    Determine determinar;
    @Before
    public void setUp() {
    }
    @After
    public void tearDown() {
    }
    @Test
    public void testDetermineFirstValue(){
        testDetermine(new double[][]{{-0.5,0.75},{0.5,-0.25}}, 2, 2, -0.25);
    }
    
    @Test
    public void testDetermineSecondValue(){
        testDetermine(new double[][]{{-1,-2},{-3,-4}}, 2, 2, -2);
    }
    
    @Test
    public void testDetermineThirdValue(){
        testDetermine(new double[][]{{2014,2000},{2000,2010}}, 2, 2, 48140.0);
    }
    
    private void testDetermine(double[][] input, int linesA, int columnsA, double valueExpected) {
        determinar = new Determine(input, linesA, columnsA);
        determinar.calculate();
        double saida = valueExpected;
        assertEquals(saida,determinar.getResult(), 0.000001);
        
    }
}
