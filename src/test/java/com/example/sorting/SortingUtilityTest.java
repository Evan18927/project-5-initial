package com.example.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortingUtilityTest {

    // ─────────────────────────────────────────────
    //  Helper
    // ─────────────────────────────────────────────
    private <T extends Comparable<T>> void assertSorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            assertTrue(arr[i].compareTo(arr[i + 1]) <= 0,
                    "Expected arr[" + i + "]=" + arr[i] + " <= arr[" + (i+1) + "]=" + arr[i+1]);
        }
    }

    // ═══════════════════════════════════════════
    //  GNOME SORT TESTS
    // ═══════════════════════════════════════════

    @Test
    void gnomeSort_emptyArray_noException() {
        Integer[] arr = {};
        SortingUtility.gnomeSort(arr);
        assertEquals(0, arr.length);
    }

    @Test
    void gnomeSort_singleElement_unchanged() {
        Integer[] arr = {5};
        SortingUtility.gnomeSort(arr);
        assertArrayEquals(new Integer[]{5}, arr);
    }

    @Test
    void gnomeSort_alreadySorted_remainsSorted() {
        Integer[] arr = {1, 2, 3, 4, 5};
        SortingUtility.gnomeSort(arr);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void gnomeSort_reverseSorted_sortedCorrectly() {
        Integer[] arr = {5, 4, 3, 2, 1};
        SortingUtility.gnomeSort(arr);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void gnomeSort_duplicates_sortedCorrectly() {
        Integer[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        SortingUtility.gnomeSort(arr);
        assertSorted(arr);
    }

    @Test
    void gnomeSort_allSameElements_unchanged() {
        Integer[] arr = {5, 5, 5, 5, 5};
        SortingUtility.gnomeSort(arr);
        assertArrayEquals(new Integer[]{5, 5, 5, 5, 5}, arr);
    }

    @Test
    void gnomeSort_twoElementsSwapped_sortedCorrectly() {
        Integer[] arr = {2, 1};
        SortingUtility.gnomeSort(arr);
        assertArrayEquals(new Integer[]{1, 2}, arr);
    }

    @Test
    void gnomeSort_twoElementsSorted_unchanged() {
        Integer[] arr = {1, 2};
        SortingUtility.gnomeSort(arr);
        assertArrayEquals(new Integer[]{1, 2}, arr);
    }

    @Test
    void gnomeSort_randomOrder_sortedCorrectly() {
        Integer[] arr = {64, 34, 25, 12, 22, 11, 90};
        SortingUtility.gnomeSort(arr);
        assertArrayEquals(new Integer[]{11, 12, 22, 25, 34, 64, 90}, arr);
    }

    @Test
    void gnomeSort_stringArray_sortedAlphabetically() {
        String[] arr = {"zebra", "apple", "mango", "banana"};
        SortingUtility.gnomeSort(arr);
        assertArrayEquals(new String[]{"apple", "banana", "mango", "zebra"}, arr);
    }

    // ═══════════════════════════════════════════
    //  COCKTAIL SHAKER SORT TESTS
    // ═══════════════════════════════════════════

    @Test
    void cocktailShakerSort_emptyArray_noException() {
        Integer[] arr = {};
        SortingUtility.cocktailShakerSort(arr);
        assertEquals(0, arr.length);
    }

    @Test
    void cocktailShakerSort_singleElement_unchanged() {
        Integer[] arr = {5};
        SortingUtility.cocktailShakerSort(arr);
        assertArrayEquals(new Integer[]{5}, arr);
    }

    @Test
    void cocktailShakerSort_alreadySorted_remainsSorted() {
        Integer[] arr = {1, 2, 3, 4, 5};
        SortingUtility.cocktailShakerSort(arr);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void cocktailShakerSort_reverseSorted_sortedCorrectly() {
        Integer[] arr = {5, 4, 3, 2, 1};
        SortingUtility.cocktailShakerSort(arr);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void cocktailShakerSort_duplicates_sortedCorrectly() {
        Integer[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        SortingUtility.cocktailShakerSort(arr);
        assertSorted(arr);
    }

    @Test
    void cocktailShakerSort_allSameElements_unchanged() {
        Integer[] arr = {5, 5, 5, 5, 5};
        SortingUtility.cocktailShakerSort(arr);
        assertArrayEquals(new Integer[]{5, 5, 5, 5, 5}, arr);
    }

    @Test
    void cocktailShakerSort_twoElementsSwapped_sortedCorrectly() {
        Integer[] arr = {2, 1};
        SortingUtility.cocktailShakerSort(arr);
        assertArrayEquals(new Integer[]{1, 2}, arr);
    }

    @Test
    void cocktailShakerSort_twoElementsSorted_unchanged() {
        Integer[] arr = {1, 2};
        SortingUtility.cocktailShakerSort(arr);
        assertArrayEquals(new Integer[]{1, 2}, arr);
    }

    @Test
    void cocktailShakerSort_randomOrder_sortedCorrectly() {
        Integer[] arr = {64, 34, 25, 12, 22, 11, 90};
        SortingUtility.cocktailShakerSort(arr);
        assertArrayEquals(new Integer[]{11, 12, 22, 25, 34, 64, 90}, arr);
    }

    @Test
    void cocktailShakerSort_stringArray_sortedAlphabetically() {
        String[] arr = {"zebra", "apple", "mango", "banana"};
        SortingUtility.cocktailShakerSort(arr);
        assertArrayEquals(new String[]{"apple", "banana", "mango", "zebra"}, arr);
    }

    // ═══════════════════════════════════════════
    //  SHELL SORT TESTS
    // ═══════════════════════════════════════════

    @Test
    void shellSort_emptyArray_noException() {
        Integer[] arr = {};
        SortingUtility.shellSort(arr);
        assertEquals(0, arr.length);
    }

    @Test
    void shellSort_singleElement_unchanged() {
        Integer[] arr = {5};
        SortingUtility.shellSort(arr);
        assertArrayEquals(new Integer[]{5}, arr);
    }

    @Test
    void shellSort_alreadySorted_remainsSorted() {
        Integer[] arr = {1, 2, 3, 4, 5};
        SortingUtility.shellSort(arr);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void shellSort_reverseSorted_sortedCorrectly() {
        Integer[] arr = {5, 4, 3, 2, 1};
        SortingUtility.shellSort(arr);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void shellSort_duplicates_sortedCorrectly() {
        Integer[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        SortingUtility.shellSort(arr);
        assertSorted(arr);
    }

    @Test
    void shellSort_randomOrder_sortedCorrectly() {
        Integer[] arr = {64, 34, 25, 12, 22, 11, 90};
        SortingUtility.shellSort(arr);
        assertArrayEquals(new Integer[]{11, 12, 22, 25, 34, 64, 90}, arr);
    }

    @Test
    void shellSort_stringArray_sortedAlphabetically() {
        String[] arr = {"zebra", "apple", "mango", "banana"};
        SortingUtility.shellSort(arr);
        assertArrayEquals(new String[]{"apple", "banana", "mango", "zebra"}, arr);
    }
}