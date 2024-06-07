public class ExponentialSearch {
    // Utility method to perform binary search within a specific range
    public static int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Method to perform exponential search
    public static int exponentialSearch(int[] arr, int target) {
        int n = arr.length;

        // If the target is at the first position
        if (arr[0] == target) {
            return 0;
        }

        // Find the range for binary search by repeated doubling
        int i = 1;
        while (i < n && arr[i] <= target) {
            i = i * 2;
        }

        // Perform binary search within the found range
        return binarySearch(arr, i / 2, Math.min(i, n - 1), target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int target = 14;
        int result = exponentialSearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
