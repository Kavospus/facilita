/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.ArrayList;
import modelo.MatrixParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre
 */
public class MatrixParserTest {
    
    public MatrixParserTest() {
    }
    MatrixParser parser;
    @Before
    public void setUp() {
        parser = new MatrixParser();
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testParser() {
        double[][] matrix;
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("olá");
        strings.add("teste");
        
        assertEquals("olá;teste;",parser.concat(strings));
        assertEquals("{3.0}",parser.parseString(3.0));
        assertEquals(3.0,parser.parseNumber("{3.0}"),0.000001);
        double infinito = Double.parseDouble("Infinity");
        matrix = new double[][]{{infinito,-infinito},{-infinito,infinito}};
        assertArrayEquals(matrix, parser.parseMatrix("{{Infinity,-Infinity},{-Infinity,Infinity}}"));

       
    }
}
