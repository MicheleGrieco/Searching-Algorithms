public class UbiquitousBinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;  // Return the index of the target
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;  // Target not found
    }

    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;  // Record the index of the target
                right = mid - 1;  // Move to the left half
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;  // Return the index of the first occurrence or -1 if not found
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;  // Record the index of the target
                left = mid + 1;  // Move to the right half
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;  // Return the index of the last occurrence or -1 if not found
    }

    public static int findSmallestElementGreaterThanOrEqual(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                result = mid;  // Record the index
                right = mid - 1;  // Move to the left half
            } else {
                left = mid + 1;
            }
        }
        return result;  // Return the index or -1 if not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 5, 5, 5, 7, 9, 10, 10};
        int target = 5;

        // Perform basic binary search
        int indexAny = binarySearch(arr, target);
        System.out.println("Any occurrence of " + target + " found at index: " + indexAny);

        // Perform binary search to find the first occurrence
        int indexFirst = findFirstOccurrence(arr, target);
        System.out.println("First occurrence of " + target + " found at index: " + indexFirst);

        // Perform binary search to find the last occurrence
        int indexLast = findLastOccurrence(arr, target);
        System.out.println("Last occurrence of " + target + " found at index: " + indexLast);

        // Perform binary search to find the smallest element greater than or equal to the target
        int target2 = 8;
        int indexSmallest = findSmallestElementGreaterThanOrEqual(arr, target2);
        if (indexSmallest != -1) {
            System.out.println("Smallest element greater than or equal to " + target2 + " found at index: " + indexSmallest);
        } else {
            System.out.println("No element greater than or equal to " + target2 + " found.");
        }
    }
}
