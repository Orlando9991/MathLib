import org.example.math.MathOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MathOperationsTest {

    @DisplayName("Positive test for Max value")
    @Test
    public void givenFloatArray_whenGetMax_thenReturnMaxValue(){
        float [] values = {1,2,33,4,5};
        float maxValue = MathOperations.max(values);
        Assertions.assertEquals(33, maxValue);
    }

    @DisplayName("Negative test for Max value (Empty Array)")
    @Test
    public void givenEmptyFloatArray_whenGetMax_thenReturnException(){
        float [] values = {};
        Exception exception = Assertions.assertThrows(RuntimeException.class, ()->{
                MathOperations.max(values);
            });
        String message = exception.getMessage();
        Assertions.assertEquals(MathOperations.EMPTY_ARRAY_MESSAGE, message);
    }

    @DisplayName("Negative test for Max value (Null Array)")
    @Test
    public void givenNull_whenGetMax_thenReturnException(){
        Exception exception = Assertions.assertThrows(RuntimeException.class, ()->{
            MathOperations.max(null);
        });
        String message = exception.getMessage();
        Assertions.assertEquals(MathOperations.NULL_ARRAY_MESSAGE, message);
    }



    @DisplayName("Positive test for Min value")
    @Test
    public void givenFloatArray_whenGetMin_thenReturnMinValue(){
        float [] values = {1,2,-4,4,5};
        float minValue = MathOperations.min(values);
        Assertions.assertEquals(-4, minValue);
    }

    @DisplayName("Negative test for Min value (Empty Array)")
    @Test
    public void givenEmptyFloatArray_whenGetMin_thenReturnException(){
        float [] values = {};
        Exception exception = Assertions.assertThrows(RuntimeException.class, ()->{
            MathOperations.min(values);
        });
        String message = exception.getMessage();
        Assertions.assertEquals(MathOperations.EMPTY_ARRAY_MESSAGE, message);
    }

    @DisplayName("Negative test for Min value (Null Array)")
    @Test
    public void givenNull_whenGetMin_thenReturnException(){
        Exception exception = Assertions.assertThrows(RuntimeException.class, ()->{
            MathOperations.min(null);
        });
        String message = exception.getMessage();
        Assertions.assertEquals(MathOperations.NULL_ARRAY_MESSAGE, message);
    }



    @DisplayName("Positive test for Average value")
    @Test
    public void givenFloatArray_whenGetAverage_thenReturnAverageValue(){
        float [] values = {1,2,-4,4,5};
        float average = MathOperations.average(values);
        Assertions.assertEquals(1.6f, average);
    }

    @DisplayName("Positive test for Average value (One Value)")
    @Test
    public void givenFloatArrayWithOneValue_whenGetAverage_thenReturnAverageValue(){
        float [] values = {1};
        float average = MathOperations.average(values);
        Assertions.assertEquals(1f, average);
    }

    @DisplayName("Negative test for Average value (Empty Array)")
    @Test
    public void givenEmptyFloatArray_whenGetAverage_thenReturnException(){
        float [] values = {};
        Exception exception = Assertions.assertThrows(RuntimeException.class, ()->{
            MathOperations.average(values);
        });
        String message = exception.getMessage();
        Assertions.assertEquals(MathOperations.EMPTY_ARRAY_MESSAGE, message);
    }

    @DisplayName("Negative test for Average value (Null Array)")
    @Test
    public void givenNull_whenGetAverage_thenReturnException(){
        float [] values = {};
        Exception exception = Assertions.assertThrows(RuntimeException.class, ()->{
            MathOperations.average(null);
        });
        String message = exception.getMessage();
        Assertions.assertEquals(MathOperations.NULL_ARRAY_MESSAGE, message);
    }



    @DisplayName("Positive test for Standard Deviation value")
    @Test
    public void givenFloatArrayWithOneValue_whenGetStdDev_thenReturnStdDevValue(){
        float [] values = {1,2,-4,4,5};
        float stdDevValue = MathOperations.std_dev(values);
        Assertions.assertEquals(3f, Math.round(stdDevValue));
    }

    @DisplayName("Negative test for Standard Deviation value (One Value)")
    @Test
    public void givenFloatArrayWithOneValue_whenGetStdDev_thenReturnException(){
        float [] values = {};
        Exception exception = Assertions.assertThrows(RuntimeException.class, ()->{
            MathOperations.std_dev(values);
        });
        String message = exception.getMessage();
        Assertions.assertEquals(MathOperations.STDDEV_INSUF_DATA_ARRAY_MESSAGE, message);
    }

    @DisplayName("Negative test for Standard Deviation value (Empty Array)")
    @Test
    public void givenEmptyFloatArray_whenGetStdDev_thenReturnException(){
        float [] values = {};
        Exception exception = Assertions.assertThrows(RuntimeException.class, ()->{
            MathOperations.std_dev(values);
        });
        String message = exception.getMessage();
        Assertions.assertEquals(MathOperations.STDDEV_INSUF_DATA_ARRAY_MESSAGE, message);
    }

    @DisplayName("Negative test for Standard Deviation (Null Array)")
    @Test
    public void givenNull_whenGetStdDev_thenReturnException(){
        Exception exception = Assertions.assertThrows(RuntimeException.class, ()->{
            MathOperations.std_dev(null);
        });
        String message = exception.getMessage();
        Assertions.assertEquals(MathOperations.NULL_ARRAY_MESSAGE, message);
    }



    @DisplayName("Positive test for Size value")
    @Test
    public void givenFloatArray_whenGetSize_thenReturnSizeValue(){
        float [] values = {1,2,-4,4,5};
        int size = MathOperations.size(values);
        Assertions.assertEquals(values.length, size);
    }

    @DisplayName("Positive test for Size value (Empty Array)")
    @Test
    public void givenEmptyFloatArray_whenGetSize_thenReturnZero(){
        float [] values = {};
        int size = MathOperations.size(values);
        Assertions.assertEquals(0, size);
    }


    @DisplayName("Negative test for Size (Null Array)")
    @Test
    public void givenNull_whenGetSize_thenReturnException(){
        Exception exception = Assertions.assertThrows(RuntimeException.class, ()->{
            MathOperations.size(null);
        });
        String message = exception.getMessage();
        Assertions.assertEquals(MathOperations.NULL_ARRAY_MESSAGE, message);
    }



    @DisplayName("Positive test for Sort Asc Array")
    @Test
    public void givenFloatArray_whenGetSortAsc_thenReturnSortedAscArray(){
        float [] values = {1,2,-4,4,5};
        float [] sortedAscArray = MathOperations.sort(MathOperations.SortType.ASC, values);
        Assertions.assertArrayEquals(new float[]{-4, 1, 2, 4, 5}, sortedAscArray);
    }

    @DisplayName("Positive test for Sort Dsc Array")
    @Test
    public void givenFloatArray_whenGetSortDsc_thenReturnSortedDscArray(){
        float [] values = {1,2,-4,4,5};
        float [] sortedAscArray = MathOperations.sort(MathOperations.SortType.DSC, values);
        Assertions.assertArrayEquals(new float[]{5, 4, 2, 1, -4}, sortedAscArray);
    }

    @DisplayName("Positive test for Sort Asc (Empty) Array")
    @Test
    public void givenEmptyFloatArray_whenGetSortAsc_thenReturnEmptyArray(){
        float [] values = {};
        float [] sortedAscArray = MathOperations.sort(MathOperations.SortType.ASC, values);
        Assertions.assertArrayEquals(new float[]{}, sortedAscArray);
    }

    @DisplayName("Positive test for Sort Dsc (Empty) Array")
    @Test
    public void givenEmptyFloatArray_whenGetSortDsc_thenReturnEmptyArray(){
        float [] values = {};
        float [] sortedAscArray = MathOperations.sort(MathOperations.SortType.DSC, values);
        Assertions.assertArrayEquals(new float[]{}, sortedAscArray);
    }

    @DisplayName("Negative test for Sort Asc (Null) Array")
    @Test
    public void givenNullArray_whenGetSortAsc_thenReturnException(){
        Exception exception = Assertions.assertThrows(RuntimeException.class, ()->{
            MathOperations.sort(MathOperations.SortType.ASC ,null);
        });
        String message = exception.getMessage();
        Assertions.assertEquals(MathOperations.NULL_ARRAY_MESSAGE, message);
    }

    @DisplayName("Positive test for Sort Dsc (Null) Array")
    @Test
    public void givenNullArray_whenGetSortDsc_thenReturnException(){
        Exception exception = Assertions.assertThrows(RuntimeException.class, ()->{
            MathOperations.sort(MathOperations.SortType.DSC ,null);
        });
        String message = exception.getMessage();
        Assertions.assertEquals(MathOperations.NULL_ARRAY_MESSAGE, message);
    }

    @DisplayName("Negative test for Sort (Null Type) Array")
    @Test
    public void givenNullTypeAndFloatArrayValues_whenGetSort_thenReturnException(){
        float [] values = {1,2,-4,4,5};
        Exception exception = Assertions.assertThrows(RuntimeException.class, ()->{
            MathOperations.sort(null ,values);
        });
        String message = exception.getMessage();
        Assertions.assertEquals(MathOperations.NULL_SORT_TYPE_MESSAGE, message);
    }

    @DisplayName("Negative test for Sort (Null Type, Null Array) Array")
    @Test
    public void givenNullTypeAndNullArray_whenGetSort_thenReturnException(){
        Exception exception = Assertions.assertThrows(RuntimeException.class, ()->{
            MathOperations.sort(null ,null);
        });
        String message = exception.getMessage();
        Assertions.assertEquals(MathOperations.NULL_SORT_TYPE_MESSAGE + " & " + MathOperations.NULL_ARRAY_MESSAGE , message);
    }

    @DisplayName("Positive test for Reverse Array")
    @Test
    public void givenFloatArray_whenGetReverse_thenReturnReverseArray(){
        float [] values = {1,2,-4,4,5};
        float [] reverseArray = MathOperations.reverse(values);
        Assertions.assertArrayEquals(new float[]{5, 4, -4, 2, 1}, reverseArray);
    }

    @DisplayName("Positive test for Reverse Empty Array")
    @Test
    public void givenEmptyArray_whenGetReverse_thenReturnEmptyArray(){
        float [] values = {};
        float [] reverseArray = MathOperations.reverse(values);
        Assertions.assertArrayEquals(new float[]{}, reverseArray);
    }

    @DisplayName("Negative test for Reverse (Null) Array")
    @Test
    public void givenNull_whenGetReverse_thenReturnException(){
        Exception exception = Assertions.assertThrows(RuntimeException.class, ()->{
            MathOperations.reverse(null);
        });
        String message = exception.getMessage();
        Assertions.assertEquals(MathOperations.NULL_ARRAY_MESSAGE, message);
    }

}
