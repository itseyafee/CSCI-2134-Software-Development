import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/* Test failure record:
 * 1.   [multiplyWithScalarTest]  [multiplyWithScalar()]   [I created a 2 by 2 matrix and put input 1,2,3,4 and initialized double and multiplied with 2.0 but my result does not match with programs output.]
 * 2.
 * 3.
 * 4.
 * 5.
 *  ...
 */
class MatrixTest {
private static String mattrix1 ="2 2 1 2 3 4";
private static String mattrix2 ="2 2 -1 -2 -3 -4";
private static String result1 ="2 2 0 0 0 0";
    @Test
    void testEquals() {
    }

    @Test
    void negate() {
    }

    @Test
    void add() {
        Matrix x = new Matrix(new Scanner(mattrix1));
        Matrix y = new Matrix(new Scanner(mattrix2));
        Matrix result=new Matrix(2,2 );
        Matrix correctResult=new Matrix(new Scanner(result1));

        x.add(y,result);

        assertTrue(result.equals(correctResult),"Did not add properly");

    }

    @Test
    void multiplyWithScalar() {
        Matrix multiplyWithScalarTest = new Matrix(new Scanner(mattrix1));
        double scalar = 2;
        Matrix result1 = new Matrix(2,2);
        String mattrixValue = "2 2 2.0 4.0 6.0 8.0";
        Matrix correctResult = new Matrix(new Scanner(mattrixValue));

        multiplyWithScalarTest.multiplyWithScalar(scalar,result1);

        assertTrue(result1.equals(correctResult), "Did not multiply with Scalar properly");

    }

    @Test
    void multiplyWithMatrix() {
        Matrix x = new Matrix(new Scanner(mattrix1));
        Matrix y = new Matrix(new Scanner(mattrix1));
        Matrix result = new Matrix(2,2);
        String value = "2 2 7 10 15 22";
        Matrix correctResult = new Matrix(new Scanner(value));

        x.multiplyWithMatrix(y,result);

        assertTrue(result.equals(correctResult), "Did not multiply with properly");
    }

    @Test
    void getElem() {
    }

    @Test
    void setElem() {
    }

    @Test
    void getHeight() {
    }

    @Test
    void getWidth() {
    }
}