


        package com.example.sorting;

import java.util.Arrays;

/**
 * Utility class containing implementations of three sorting algorithms:
 * Gnome Sort, Cocktail Shaker Sort, and Shell Sort.
 *
 * All methods sort arrays of Comparable objects in place (ascending order).
 */
public class SortingUtility {

    // -------------------------------------------------------------------------
    // Swap helper — provided by the template, used by Gnome and Cocktail Shaker
    // -------------------------------------------------------------------------

    /**
     * Swaps two elements in an array.
     *
     * @param a   the array
     * @param i   index of the first element
     * @param j   index of the second element
     */
    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i]   = a[j];
        a[j]   = temp;
    }

    // -------------------------------------------------------------------------
    // Part A — Gnome Sort (50 points)
    // -------------------------------------------------------------------------

    /**
     * Sorts an array using the Gnome Sort algorithm.
     *
     * Works like a garden gnome sorting flower pots:
     *   - Walk forward when the current pot is in order (or we're at the start).
     *   - Swap with the previous pot and step back when it's out of order.
     *
     * Pseudocode variable names preserved exactly: pos, a
     * Time complexity: O(n²) worst/average case, O(n) best case (already sorted)
     *
     * @param a the array of Comparable objects to sort (modified in place)
     */
    public static <T extends Comparable<T>> void gnomeSort(T[] a) {
        int pos = 0;

        while (pos < a.length) {
            // At the start, or current element is >= previous — move forward
            if (pos == 0 || a[pos].compareTo(a[pos - 1]) >= 0) {
                pos = pos + 1;
            } else {
                // Current element is out of order — swap and step back
                swap(a, pos, pos - 1);
                pos = pos - 1;
            }
        }
    }

    // -------------------------------------------------------------------------
    // Part B — Cocktail Shaker Sort (75 points)
    // -------------------------------------------------------------------------

    /**
     * Sorts an array using the Cocktail Shaker Sort algorithm.
     *
     * A bidirectional variant of bubble sort:
     *   - Forward pass bubbles the largest unsorted element to the right end.
     *   - Backward pass bubbles the smallest unsorted element to the left end.
     *   - Stops early when a full pass completes with no swaps.
     *
     * Pseudocode variable names preserved exactly: swapped, a, i
     * Time complexity: O(n²) worst case, O(n) best case (already sorted)
     *
     * @param a the array of Comparable objects to sort (modified in place)
     */
    public static <T extends Comparable<T>> void cocktailShakerSort(T[] a) {
        boolean swapped;

        do {
            // --- Forward pass (left → right) ---
            // Bubbles the largest element toward the end
            swapped = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

            // If no swaps happened on the forward pass, array is sorted — stop
            if (!swapped) {
                break;
            }

            // --- Backward pass (right → left) ---
            // Bubbles the smallest element toward the front
            swapped = false;
            for (int i = a.length - 2; i >= 0; i--) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

        } while (swapped);
    }

    // -------------------------------------------------------------------------
    // Part C — Shell Sort (75 points)
    // -------------------------------------------------------------------------

    /**
     * Sorts an array using the Shell Sort algorithm with the Ciura gap sequence.
     *
     * Works as a series of gapped insertion sorts:
     *   - Starts with a large gap so distant elements can be compared early.
     *   - Reduces the gap each round; the final gap of 1 is a regular insertion sort.
     *   - The Ciura sequence [701, 301, 132, 57, 23, 10, 4, 1] gives excellent
     *     practical performance.
     *
     * Pseudocode variable names preserved exactly: gaps, n, i, j, temp
     * Time complexity: O(n log² n) average with Ciura gap sequence
     *
     * @param a the array of Comparable objects to sort (modified in place)
     */
    public static <T extends Comparable<T>> void shellSort(T[] a) {
        // Ciura gap sequence
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};
        int n = a.length;

        // Work through each gap, largest first
        for (int gap : gaps) {
            // Gapped insertion sort for this gap size
            for (int i = gap; i < n; i += 1) {
                // Save a[i] in temp and create a "hole" at position i
                T temp = a[i];

                // Shift earlier gap-sorted elements up until the correct
                // location for a[i] (held in temp) is found
                int j;
                for (j = i; (j >= gap) && (a[j - gap].compareTo(temp) > 0); j -= gap) {
                    a[j] = a[j - gap];
                }

                // Put temp (the original a[i]) in its correct location
                a[j] = temp;
            }
        }
    }
}



