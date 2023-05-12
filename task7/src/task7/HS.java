package task7;

public class HS {
    
    // This method sorts an array using heap sort
    public void sort(int array[]) {
        int size = array.length;
        
        // Build max heap
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, size, i);
        }
        
        // Heap sort
        for (int i = size - 1; i >= 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            
            // Heapify the reduced heap
            heapify(array, i, 0);
        }
    }
    
    // This method heapifies a subtree with root at given index
    void heapify(int array[], int size, int index) {
        // Find largest among root, left child and right child
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        
        if (left < size && array[left] > array[largest])
            largest = left;
        
        if (right < size && array[right] > array[largest])
            largest = right;
        
        // Swap and continue heapifying if root is not largest
        if (largest != index) {
            int swap = array[index];
            array[index] = array[largest];
            array[largest] = swap;
            
            heapify(array, size, largest);
        }
    }
    
    // This method prints the elements of an array
    static void printArray(int array[]) {
        int size = array.length;
        for (int i = 0; i < size; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
    
    // This is the main method that tests the HeapSort class
    public static void main(String args[]) {
        int array[] = { 1, 3, 9, 7, 6, 10, 2, 11, 77, 8 };
        
        HS heapSort = new HS();
        
        // Sort the array
        heapSort.sort(array);
        
        // Print the sorted array
        System.out.println("Sorted array is:");
        printArray(array);
    }
}