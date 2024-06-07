public class JumpSearch {
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        
        // Finding the block size to be jumped
        int step = (int)Math.floor(Math.sqrt(n));
        
        // Finding the block where the element is present (if it is present)
        int prev = 0;
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int)Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return -1;
            }
        }
        
        // Doing a linear search for target in the block beginning with prev
        while (arr[prev] < target) {
            prev++;
            // If we reach the next block or end of the array
            if (prev == Math.min(step, n)) {
                return -1;
            }
        }
        
        // If the element is found
        if (arr[prev] == target) {
            return prev;
        }
        
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 5, 7, 8, 9, 11, 12, 14, 18, 21, 23, 27, 30};
        int target = 14;
        int result = jumpSearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
