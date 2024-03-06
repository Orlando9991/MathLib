package org.example.math;

import java.util.Arrays;
import java.util.Map;

public class MathOperations {
    private MathOperations(){}
    public static final String EMPTY_ARRAY_MESSAGE = "Empty Array";
    public static final String NULL_ARRAY_MESSAGE = "Null Array";
    public static final String NULL_SORT_TYPE_MESSAGE = "Null Sort Type";
    public static final String STDDEV_INSUF_DATA_ARRAY_MESSAGE = "Array needs at least 2 values";

    public static enum SortType{
        ASC,
        DSC
    }

    public static float max(float... values){
        if(values == null){
            throw new RuntimeException(NULL_ARRAY_MESSAGE);
        }else if(size(values) == 0){
            throw new RuntimeException(EMPTY_ARRAY_MESSAGE);
        }

        float maxValue = Float.MIN_VALUE;
        for (float v: values) {
            if(v > maxValue){
                maxValue = v;
            }
        }
        return maxValue;
    }

    public static float min(float... values){
        if(values == null){
            throw new RuntimeException(NULL_ARRAY_MESSAGE);
        }else if(size(values) == 0){
            throw new RuntimeException(EMPTY_ARRAY_MESSAGE);
        }

        float minValue = Float.MAX_VALUE;
        for (float v: values) {
            if(v < minValue){
                minValue = v;
            }
        }
        return minValue;
    }

    public static float average(float... values){
        if(values == null){
            throw new RuntimeException(NULL_ARRAY_MESSAGE);
        }else if(size(values) == 0){
            throw new RuntimeException(EMPTY_ARRAY_MESSAGE);
        }

        float sum = 0;
        int size = values.length;

        for (float v: values) {
            sum+=v;
        }

        float average = sum/size;

        return average;
    }

    public static float std_dev(float... values){
        if(values == null){
            throw new RuntimeException(NULL_ARRAY_MESSAGE);
        }else if(size(values) < 2){
            throw new RuntimeException(STDDEV_INSUF_DATA_ARRAY_MESSAGE);
        }

        float average = average(values);
        int size = size(values);

        int sumValues = 0;

        for (float v: values) {
            sumValues += Math.pow(v - average, 2);
        }

        float stdDevValue = (float) Math.sqrt(sumValues/size);

        return stdDevValue;
    }

    public static int size(float... values){
        if(values == null){
            throw new RuntimeException(NULL_ARRAY_MESSAGE);
        }

        return values.length;
    }

    public static float[] sort(SortType type, float... values){
        if(values == null && type == null){
            throw new RuntimeException(NULL_SORT_TYPE_MESSAGE + " & " + NULL_ARRAY_MESSAGE );
        }else if(type == null){
            throw new RuntimeException(NULL_SORT_TYPE_MESSAGE);
        }

        int size = size(values);
        float [] sortedValues = Arrays.copyOf(values, size);

        while (true){
            boolean correctPlace = true;
            for (int i = 0; i < size - 1; i++){
                switch (type){
                    case DSC:{
                        if (sortedValues[i] < sortedValues[i+1]) {
                            sortedValues = switchArrayPositionValue(i, i+1, sortedValues);
                            correctPlace = false;
                        }
                        break;
                    }
                    case ASC: {
                        if (sortedValues[i] > sortedValues[i+1]) {
                            sortedValues = switchArrayPositionValue(i, i+1, sortedValues);
                            correctPlace = false;
                        }
                        break;
                    }
                }
            }
            if(correctPlace){
                break;
            }
        }
        return sortedValues;
    }

    public static float[] reverse(float... values){
        int size = size(values);
        float [] reversedValues = Arrays.copyOf(values, size);

        for (int i = 0, f = size - 1; i < size/2; i++, f--){
            reversedValues = switchArrayPositionValue(i, f, reversedValues);
        }

        return reversedValues;
    }

    private static float [] switchArrayPositionValue(int pos1, int pos2, float... values){
        float [] newArray = Arrays.copyOf(values, size(values));
        float vAux = newArray[pos1];
        newArray[pos1] = newArray[pos2];
        newArray[pos2] = vAux;
        return newArray;
    }
}
