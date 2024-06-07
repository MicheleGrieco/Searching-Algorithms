public class TernarySearch {
    public static int ternarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left <= right) {
            // Calculate the two mid points
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            // Check if the target is at any of the mid points
            if (arr[mid1] == target) {
                return mid1;
            }
            if (arr[mid2] == target) {
                return mid2;
            }

            // Determine which segment to search in
            if (target < arr[mid1]) {
                return ternarySearchRecursive(arr, target, left, mid1 - 1);
            } else if (target > arr[mid2]) {
                return ternarySearchRecursive(arr, target, mid2 + 1, right);
            } else {
                return ternarySearchRecursive(arr, target, mid1 + 1, mid2 - 1);
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int result = ternarySearchRecursive(arr, target, 0, arr.length - 1);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
