package com.example.sorting;

public class SortingUtility {


    public static <T extends Comparable<T>> void gnomeSort(T[] data) {

        /*
        procedure gnomeSort(a[]):
            pos := 0
            while pos < length(a):
                if (pos == 0 or a[pos] >= a[pos-1]):
                    pos := pos + 1
                else:
                    swap a[pos] and a[pos-1]
                    pos := pos - 1
         */

        int pos = 0;
        while (pos < data.length) {
            if (pos == 0 || data[pos].compareTo(data[pos - 1]) >= 0) {
                pos++;
            } else {
                swap(data, pos, pos - 1);
                pos--;
            }
        }
    }

    public static <T extends Comparable<T>> void cocktailShakerSort(T[] data) {

        /*
        procedure cocktailShakerSort(A : list of sortable items) is
            do
                swapped := false
                for each i in 0 to length(A) − 1 do:
                    if A[i] > A[i + 1] then // test whether the two elements are in the wrong order
                        swap(A[i], A[i + 1]) // let the two elements change places
                        swapped := true
                    end if
                end for
                if not swapped then
                    // we can exit the outer loop here if no swaps occurred.
                    break do-while loop
                end if
                swapped := false
                for each i in length(A) − 1 to 0 do:
                    if A[i] > A[i + 1] then
                        swap(A[i], A[i + 1])
                        swapped := true
                    end if
                end for
            while swapped // if no elements have been swapped, then the list is sorted
        end procedure
         */

        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    swap(data, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = data.length - 1; i > 0; i--) {
                if (data[i].compareTo(data[i - 1]) < 0) {
                    swap(data, i, i - 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public static <T extends Comparable<T>> void shellSort(T[] data) {

        /*
        asked copilot : can you help me create a shellSort method based on the
        pseudocode in the class under the shellSort method

        create 'gaps' as an ArrayList and fill it with the values in the pseudocode below.
        Also, the input array is going to be of Comparable objects.

        # Sort an array a[0...n-1].
        gaps = [701, 301, 132, 57, 23, 10, 4, 1]  # Ciura gap sequence
        n = a[] length

        # Start with the largest gap and work down to a gap of 1
        # similar to insertion sort but instead of 1, gap is being used in each step
        foreach (gap in gaps)
        {
            Do a gapped insertion sort for every elements in gaps
            Each loop leaves a[0..gap-1] in gapped order
            for (i = gap; i < n; i += 1)
            {
                save a[i] in temp and make a hole at position i
                temp = a[i]
                shift earlier gap-sorted elements up until the correct location for a[i] is found
                for (j = i; (j >= gap) && (a[j - gap] > temp); j -= gap)
                {
                    a[j] = a[j - gap]
                }
                put temp (the original a[i]) in its correct location
                a[j] = temp
            }
        }
         */

        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};
        int n = data.length;

        for (int gap : gaps) {
            for (int i = gap; i < n; i++) {
                T temp = data[i];
                int j;
                for (j = i; j >= gap && data[j - gap].compareTo(temp) > 0; j -= gap) {
                    data[j] = data[j - gap];
                }
                data[j] = temp;
            }
        }

    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





