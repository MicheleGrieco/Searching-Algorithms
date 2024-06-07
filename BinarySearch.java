public class BinarySearch {
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is smaller than mid, it can only be in left subarray
            if (arr[mid] > target) {
                return binarySearchRecursive(arr, target, left, mid - 1);
            }

            // Else, the target can only be in right subarray
            return binarySearchRecursive(arr, target, mid + 1, right);
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int result = binarySearchRecursive(arr, target, 0, arr.length - 1);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
