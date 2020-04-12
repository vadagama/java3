package lesson2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int PAGE_SIZE = 1800;

/*  1) Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;

    2) Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
    Может пригодиться следующая конструкция: ArrayList<InputStream> al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);

    3) Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
    Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
    Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.

    4) Сделать клиен-серверное приложение. Передать по сети сеарилизованный объект.*/

    public static void main(String[] args) throws IOException {

        readFileIntoBytes();
        splitFiles();
        paging();

    }

    public static void readFileIntoBytes() {
        ArrayList<Byte> bytes = new ArrayList<>();
        try (DataInputStream in = new DataInputStream(new FileInputStream("input.txt"))){
            int x;

            while ((x = in.read()) != -1) {
                bytes.add((byte) x);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bytes);
    }

    public static void splitFiles() {
        File dir = new File("files");
        File[] f = dir.listFiles();
        List<File> files = Arrays.asList(f);
        Collections.reverse(files);
        ArrayList<Character> characters = new ArrayList<>();

        for (File file : files) {
            try (FileReader in = new FileReader(file)) {
                int x;
                while ((x = in.read()) != -1) {
                    characters.add((char) x);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String finalString = "";
        for (Character c : characters)
            finalString += c.toString();

        System.out.println(finalString);
    }

    public static void paging() throws FileNotFoundException {
        String str = "";
        int count = 0;
        try {
            FileReader file = new FileReader("Bratbja_Karamazovy.txt");
            int x;
            while ((x = file.read()) != -1) {
                if (count <= PAGE_SIZE) {
                    str += String.valueOf((char)x);
                    count++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(str);
    }
}
