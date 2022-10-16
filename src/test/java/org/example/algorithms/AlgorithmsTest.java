package org.example.algorithms;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {
    Algorithms algorithms;

    @BeforeEach
    void setUp() {
        algorithms = new Algorithms();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void bubbleSortAlgorithms() {
        assertArrayEquals(new int[]{3, 4, 5, 5, 8}, algorithms.bubbleSortAlgorithms(new int[]{8, 5, 3, 5, 4}));

    }

    @Test
    void selectionSortAlgorithms() {
        assertArrayEquals(new int[]{3, 4, 5, 5, 8}, algorithms.selectionSortAlgorithms(new int[]{8, 5, 3, 5, 4}));
        assertArrayEquals(new int[]{0, 0, 0}, algorithms.selectionSortAlgorithms(new int[]{0, 0, 0}));
        assertArrayEquals(new int[]{}, algorithms.selectionSortAlgorithms(new int[]{}));

    }

    @Test
    void insertionSortAlgorithms() {
        assertArrayEquals(new int[]{3, 4, 5, 5, 8}, algorithms.insertionSortAlgorithms(new int[]{8, 5, 3, 5, 4}));
        assertArrayEquals(new int[]{2, 5, 7, 8, 12}, algorithms.insertionSortAlgorithms(new int[]{5, 2, 8, 12, 7}));

    }

    @Test
    void mergeSortAlgorithms() {
        assertArrayEquals(new int[]{2,5,7,8,9,12,16,23}, algorithms.mergeSortAlgorithms(new int[]{23,5,2,8,12,7,16,9}));

    }

    @Test
    void solution() {
       /* Assertions.assertAll("v",
                () -> assertEquals(2, app.iconWithinRange(
                                new int[]{100, 200, 100},
                                new int[]{50, 100, 100},
                                100,
                                100
                        )
                ),
                () -> assertEquals(-1, app.iconWithinRange(
                                new int[]{100, 200, 100},
                                new int[]{50, 100, 100},
                                200,
                                60
                        )
                ),
                () -> assertEquals(0, app.iconWithinRange(
                                new int[]{100, 200, 100},
                                new int[]{50, 100, 100},
                                100,
                                70
                        )
                )
        );*/
       // assertEquals(2, algorithms.solution(new int[]{100, 200, 100}, new int[]{50, 100, 100}, 100, 100));
        assertEquals(0, algorithms.solution(new int[]{100, 200, 100}, new int[]{50, 100, 100}, 100, 70));

    }

    @Test
    void twoSum() {
        assertArrayEquals(new int[]{0,1}, algorithms.twoSum(new int[]{2,7,11,15},9));

    }

    @Test
    void mergeSortAlgorithmEasy() {
        assertArrayEquals(new int[]{3, 4, 5, 5, 8}, algorithms.mergeSortAlgorithmEasy(new int[]{8, 5, 3, 5, 4}));

    }
}