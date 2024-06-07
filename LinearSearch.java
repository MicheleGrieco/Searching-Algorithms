public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        // Loop through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // Check if the current element is the target
            if (arr[i] == target) {
                // If found, return the index
                return i;
            }
        }
        // If the target is not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 0, 1, 9 };
        int target = 1;
        int result = linearSearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}