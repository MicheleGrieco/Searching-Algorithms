public class FibonacciSearch {
    public static int fibonacciSearch(int[] arr, int target) {
        int n = arr.length;

        // Initialize Fibonacci numbers
        int fibMMm2 = 0;   // (m-2)'th Fibonacci number
        int fibMMm1 = 1;   // (m-1)'th Fibonacci number
        int fibM = fibMMm2 + fibMMm1;  // m'th Fibonacci number

        // fibM is the smallest Fibonacci number greater than or equal to n
        while (fibM < n) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }

        // Marks the eliminated range from front
        int offset = -1;

        // While there are elements to be inspected
        // Note: We compare arr[fibMMm2] with target.
        // When fibM becomes 1, fibMMm2 becomes 0
        while (fibM > 1) {
            // Check if fibMMm2 is a valid location
            int i = Math.min(offset + fibMMm2, n - 1);

            // If target is greater than the value at index fibMMm2,
            // cut the subarray array from offset to i
            if (arr[i] < target) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            }

            // If target is less than the value at index fibMMm2,
            // cut the subarray after i+1
            else if (arr[i] > target) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            }

            // Element found, return index
            else {
                return i;
            }
        }

        // Comparing the last element with target
        if (fibMMm1 == 1 && arr[offset + 1] == target) {
            return offset + 1;
        }

        // Element not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100};
        int target = 85;
        int result = fibonacciSearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
