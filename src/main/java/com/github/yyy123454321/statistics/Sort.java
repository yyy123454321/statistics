package com.github.yyy123454321.statistics;

import java.util.ArrayList;

public class Sort {
    double[] list;

    public Sort(double[] num) {
        list = num;
        quickSort(0, list.length);
    }

    public double[] get() {
        return list;
    }

    private void quickSort(int min, int max) {
        if (5 > (max - min)) {
            bubbleSort(min, max);
            return;
        }

        double pivot = list[min];

        double[] underPivotList = new double[max - min];
        int underIndex = 0;

        double[] abovePivotList = new double[max - min];
        int aboveIndex = 0;

        for (int i = min; i < max; i++) {
            if (list[i] <= pivot) {
                underPivotList[underIndex++] = list[i];
            } else {
                abovePivotList[aboveIndex++] = list[i];
            }
        }

        for (int i = 0; i < underIndex; i++) {
            list[min + i] = underPivotList[i];
        }

        for (int i = 0; i < aboveIndex; i++) {
            list[min + underIndex + i] = abovePivotList[i];
        }

        quickSort(min, min + underIndex);
        quickSort(min + underIndex, max);
    }

    private void bubbleSort(int min, int max) {
        for (int i = min; i < max; i++) {
            for (int j = min; j < max - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        double temporary = list[firstIndex];
        list[firstIndex] = list[secondIndex];
        list[secondIndex] = temporary;
    }
}
