import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static boolean isAlphabet(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    public static boolean isUppercase(char c) {
        return c >= 65 && c <= 90;
    }

    public static boolean isNumeric(char c) {
        return c >= 48 && c <= 57;
    }

    public static int[] integerArrayToPrimitive(Integer[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }

    public static boolean isPrime(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return false;
        }

        for (int i = 1; i < (int)(Math.sqrt(n))+1; i++) {
            if (n%i == 0 && i != 1 && i != n) {
                return false;
            }
        }
        return true;
    }

    public static int[] getPrimeFactors(int n) {
        if (isPrime(n)) {
            return new int[]{1, n};
        }
        List<Integer> factorsSmallerThanSqrt = new ArrayList<>();

        for (int i = 2; i < (int)(Math.sqrt(n)) + 1; i++) {
            if (n%i == 0 && isPrime(i)) {
                int num = n;
                while (num%i == 0) {
                    num /= i;
                    factorsSmallerThanSqrt.add(i);
                }
            }
        }

        int mult = 1;

        for (int i = 0; i < factorsSmallerThanSqrt.size(); i++) {
            mult *= factorsSmallerThanSqrt.get(i);
        }

        if (mult != n) {
            factorsSmallerThanSqrt.add(n/mult);
        }

        return integerArrayToPrimitive(factorsSmallerThanSqrt.toArray(new Integer[0]));
    }

    public static<T> boolean has(T[] arr, T value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static<T> T[] removeFirstAppearance(T[] arr, T value) {
        if (has(arr, value)) {
            T[] removed = Arrays.copyOf(arr, arr.length-1);
            int removedIndex = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals(value)) {
                    for (int j = i+1; j < arr.length; j++) {
                        removed[removedIndex] = arr[j];
                        removedIndex++;
                    }
                    return removed;
                }
                else {
                    removed[removedIndex] = arr[i];
                    removedIndex++;
                }
            }
        }
        return Arrays.copyOf(arr, arr.length);
    }

    public static<T> T[] intersection(T[] arr1In, T[] arr2In) {
        T[] out;
        int outIndex = 0;
        if (arr1In.length >= arr2In.length) {
            T[] arr2InTemp = Arrays.copyOf(arr2In, arr2In.length);
            out = Arrays.copyOf(arr2In, arr2In.length);
            Arrays.fill(out, null);

            for (int i = 0; i < arr1In.length; i++) {
                if (has(arr2InTemp, arr1In[i])) {
                    arr2InTemp = removeFirstAppearance(arr2InTemp, arr1In[i]);
                    out[outIndex] = arr1In[i];
                    outIndex++;
                }
            }
        }
        else {
            T[] arr1InTemp = Arrays.copyOf(arr1In, arr1In.length);
            out = Arrays.copyOf(arr1In, arr1In.length);
            Arrays.fill(out, null);

            for (int i = 0; i < arr2In.length; i++) {
                if (has(arr1InTemp, arr2In[i])) {
                    arr1InTemp = removeFirstAppearance(arr1InTemp, arr2In[i]);
                    out[outIndex] = arr2In[i];
                    outIndex++;
                }
            }
        }

        out = Arrays.copyOf(out, outIndex);
        return out;
    }

    public static int[] intersection(int[] arr1In, int[] arr2In) {
        Integer[] arr1 = new Integer[arr1In.length];
        Integer[] arr2 = new Integer[arr2In.length];

        for (int i = 0; i < arr1In.length; i++) {
            arr1[i] = arr1In[i];
        }

        for (int i = 0; i < arr2In.length; i++) {
            arr2[i] = arr2In[i];
        }

        Integer[] result = intersection(arr1, arr2);

        int[] out = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            out[i] = result[i];
        }
        return out;
    }

    public static void normalize(double[] vec) {
        // Flip sign so first nonzero coefficient is positive
        for (double d : vec) {
            if (Math.abs(d) > 1e-6) {
                if (d < 0) {
                    for (int i = 0; i < vec.length; i++) vec[i] *= -1;
                }
                break;
            }
        }

        // Find smallest absolute nonzero value
        double minNonZero = Double.MAX_VALUE;
        for (double v : vec) {
            if (Math.abs(v) > 1e-6)
                minNonZero = Math.min(minNonZero, Math.abs(v));
        }

        // Scale vector so smallest value ≈ 1
        for (int i = 0; i < vec.length; i++) {
            vec[i] /= minNonZero;
        }

        // Round near-integers
        for (int i = 0; i < vec.length; i++) {
            double round = Math.round(vec[i]);
            if (Math.abs(vec[i] - round) < 1e-3)
                vec[i] = round;
        }

        // Convert all to integers by dividing by GCD
        double currentGCD = 0;
        for (double v : vec) {
            currentGCD = gcd(currentGCD, Math.abs(v));
        }
        if (currentGCD > 1e-6) {
            for (int i = 0; i < vec.length; i++) {
                vec[i] /= currentGCD;
            }
        }

        // Final rounding to clean integers
        for (int i = 0; i < vec.length; i++) {
            vec[i] = Math.round(vec[i]);
        }
    }

    private static double gcd(double a, double b) {
        if (a < 1e-8) return b;
        if (b < 1e-8) return a;
        while (Math.abs(b) > 1e-8) {
            double temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}
