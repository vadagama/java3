package lesson6;

/*
1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки.
Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 */

public class DZ1 {
    public int[] DZ1Method(int[] array) throws RuntimeException {
        int[] result = null;
        int i = array.length - 1;
        int j = 0;
        boolean foundFour = false;

        while (i >= 0 && !foundFour) {
            foundFour = array[i] == 4;
            j = i;
            i--;
        }

        if(foundFour) {
            result = new int[array.length - j - 1];
            for (i = j + 1; i < array.length; i++) {
                result[i - j - 1] = array[i];
            }
        } else {
            throw new RuntimeException("В массиве нет четверок");
        }

        return  result;
    }
}
