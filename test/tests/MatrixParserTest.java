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
        
        assertEquals("olá;teste;",MatrixParser.concat(strings));
        assertEquals("{3.0}",MatrixParser.parseString(3.0));
        assertEquals(3.0,MatrixParser.parseNumber("{3.0}"),0.000001);
        double infinito = Double.parseDouble("Infinity");
        matrix = new double[][]{{infinito,-infinito},{-infinito,infinito}};
        assertArrayEquals(matrix, MatrixParser.parseMatrix("{{Infinity,-Infinity},{-Infinity,Infinity}}"));
    }
    
    @Test
    public void testMatrixParserConcatFirstString(){
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("olá");
        strings.add("teste");
        testMatrixParserConcat(strings,"olá;teste;");
    }
    
    @Test
    public void testMatrixParserConcatSecondString(){
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("ola");
        strings.add("teste");
        strings.add("2");
        testMatrixParserConcat(strings,"ola;teste;2;");
    }
    
    @Test
    public void testMatrixParserConcatThirdString(){
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("ola");
        strings.add("teste");
        strings.add("3");
        strings.add("teste");
        testMatrixParserConcat(strings,"ola;teste;3;teste;");
    }
    
    @Test
    public void testMatrixParserUnconcatFirstString(){
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("olá");
        strings.add("teste");
        testMatrixParserUnconcat("olá;teste;",strings);
    }
    
    @Test
    public void testMatrixParserUnconcatSecondString(){
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("ola");
        strings.add("teste");
        strings.add("2");
        testMatrixParserUnconcat("ola;teste;2;",strings);
    }
    
    @Test
    public void testMatrixParserUnconcatThirdString(){
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("ola");
        strings.add("teste");
        strings.add("3");
        strings.add("teste");
        testMatrixParserUnconcat("ola;teste;3;teste;",strings);
    }
    
    @Test
    public void testMatrixParserParseStringWithDoubleFirstValue(){
        testMatrixParserParseStringWithDouble(5.0,"{5.0}");
    }
    
    @Test
    public void testMatrixParserParseStringWithDoubleSecondValue(){
        testMatrixParserParseStringWithDouble(-1.75,"{-1.75}");
    }
    
    @Test
    public void testMatrixParserParseStringWithDoubleThirdValue(){
        testMatrixParserParseStringWithDouble(-1111.2222,"{-1111.2222}");
    }
    
    @Test
    public void testMatrixParserParseNumberFirstString(){
        testMatrixParserParseNumber("{5.0}",5.0);
    }
    
    @Test
    public void testMatrixParserParseNumberSecondString(){
        testMatrixParserParseNumber("{-1.75}",-1.75);
    }
    
    @Test
    public void testMatrixParserParseNumberThirdString(){
        testMatrixParserParseNumber("{-1111.2222}",-1111.2222);
    }
    
    @Test
    public void testMatrixParserParseStringWithDoublMatrixFirstMatrix(){
        testMatrixParserParseStringWithDoublMatrix(new double[][]{{-0.5,0.75},{0.5,-0.25}},"{{-0.5,0.75},{0.5,-0.25}}");
    }
    
    @Test
    public void testMatrixParserParseStringWithDoublMatrixSecondMatrix(){
        testMatrixParserParseStringWithDoublMatrix(new double[][]{{-1.0,-2.0},{-3.0,-4.0}},"{{-1.0,-2.0},{-3.0,-4.0}}");
    }
    
    @Test
    public void testMatrixParserParseStringWithDoublMatrixThirdMatrix(){
        testMatrixParserParseStringWithDoublMatrix(new double[][]{{2014.0,2000.0},{2000.0,2010.0}},"{{2014.0,2000.0},{2000.0,2010.0}}");
    }
    
    private void testMatrixParserConcat(ArrayList<String> data, String stringExpected) {
        assertEquals(MatrixParser.concat(data),stringExpected);
    }
    
    private void testMatrixParserUnconcat(String data, ArrayList<String> stringExpected) {
        assertEquals(MatrixParser.unconcat(data),stringExpected);
    }
    
    private void testMatrixParserParseStringWithDouble(double num, String stringExpected) {
        assertEquals(MatrixParser.parseString(num),stringExpected);
    }
    
    private void testMatrixParserParseNumber(String num, double valueExpected) {
        assertEquals(MatrixParser.parseNumber(num),valueExpected,0.00001);
    }
    
    private void testMatrixParserParseStringWithDoublMatrix(double[][] matrix, String stringExpected) {
        assertEquals(MatrixParser.parseString(matrix),stringExpected);
    }
    
}
