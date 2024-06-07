public class SentinelLinearSearch {
    public static int sentinelLinearSearch(int[] arr, int target) {
        int n = arr.length;

        // Store the last element of the array
        int last = arr[n - 1];
        
        // Place the target at the last position as a sentinel
        arr[n - 1] = target;
        
        int i = 0;
        
        // Loop through the array until the target is found
        while (arr[i] != target) {
            i++;
        }
        
        // Restore the last element of the array
        arr[n - 1] = last;
        
        // If the target is found at the last position, check if it is a true find or sentinel
        if (i < n - 1 || arr[n - 1] == target) {
            return i;
        }
        
        // If the target is not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 0, 1, 9};
        int target = 1;
        int result = sentinelLinearSearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}