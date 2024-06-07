public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (low == high) {
                if (arr[low] == target) {
                    return low;
                }
                return -1;
            }

            // Estimate the position of the target
            int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            // Check if the target is found
            if (arr[pos] == target) {
                return pos;
            }

            // If target is larger, target is in upper part
            if (arr[pos] < target) {
                low = pos + 1;
            } 
            // If target is smaller, target is in lower part
            else {
                high = pos - 1;
            }
        }
        
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47};
        int target = 18;
        int result = interpolationSearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
