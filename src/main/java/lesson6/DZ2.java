package lesson6;

/*
2. Написать метод, который проверяет состав массива из чисел 1 и 4.
Если в нем нет хоть одной четверки или единицы, то метод вернет false;
Написать набор тестов для этого метода (по 3-4 варианта входных данных).
*/

public class DZ2 {
    public boolean DZ2Method(int[] array) throws RuntimeException {
        boolean result = true;
        int numberOne = 0;
        int numberFour = 0;
        int i = 0;

        boolean foundFour = false;

        while (i < array.length && result) {
            if(array[i] == 1) {
                result = true;
                numberOne++;
            } else {
                if(array[i] == 4) {
                    result = true;
                    numberFour++;
                } else {
                    result = false;
                }
            }
            i++;
        }
        return result && (numberOne > 0) && (numberFour > 0);
    }
}
