import org.apache.commons.math3.fraction.Fraction;
import java.util.Arrays;

public class ExactBalancer {
    static Fraction f(double d) { return new Fraction(d); }

    public static long[] balance(Fraction[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        // Gaussian elimination (Fraction arithmetic)
        Fraction[][] M = new Fraction[rows][cols];
        for (int i = 0; i < rows; i++) M[i] = Arrays.copyOf(A[i], cols);

        int rank = 0;
        for (int c = 0; c < cols && rank < rows; c++) {
            int pivot = rank;
            while (pivot < rows && M[pivot][c].equals(Fraction.ZERO)) pivot++;
            if (pivot == rows) continue;

            Fraction[] tmp = M[rank];
            M[rank] = M[pivot];
            M[pivot] = tmp;

            Fraction pivotVal = M[rank][c];
            for (int j = c; j < cols; j++)
                M[rank][j] = M[rank][j].divide(pivotVal);

            for (int i = 0; i < rows; i++) {
                if (i != rank && !M[i][c].equals(Fraction.ZERO)) {
                    Fraction factor = M[i][c];
                    for (int j = c; j < cols; j++)
                        M[i][j] = M[i][j].subtract(factor.multiply(M[rank][j]));
                }
            }
            rank++;
        }

        // last variable = free variable
        Fraction[] x = new Fraction[cols];
        Arrays.fill(x, Fraction.ZERO);
        x[cols - 1] = Fraction.ONE; // free variable = 1

        for (int i = rank - 1; i >= 0; i--) {
            int leading = -1;
            for (int j = 0; j < cols; j++) {
                if (!M[i][j].equals(Fraction.ZERO)) {
                    leading = j;
                    break;
                }
            }
            if (leading == -1) continue;
            Fraction sum = Fraction.ZERO;
            for (int j = leading + 1; j < cols; j++) {
                sum = sum.add(M[i][j].multiply(x[j]));
            }
            x[leading] = sum.negate();
        }

        // Convert to integers
        long lcm = 1;
        for (Fraction f : x)
            lcm = lcm(lcm, f.getDenominator());

        long[] result = new long[cols];
        for (int i = 0; i < cols; i++) {
            Fraction f = x[i]; // ← this line fixes it
            result[i] = f.getNumerator() * (lcm / f.getDenominator());
        }

        // Normalize (divide by gcd)
        long g = 0;
        for (long v : result) g = gcd(g, Math.abs(v));
        for (int i = 0; i < cols; i++) result[i] /= g;

        return result;
    }

    private static long gcd(long a, long b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a / gcd(a,b) * b);
    }
}