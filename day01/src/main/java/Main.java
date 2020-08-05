import org.w3c.dom.ls.LSOutput;
import somepackage.Other;
import somepackage.Some;

import java.sql.SQLOutput;

public class Main {
    static void integralTypes() {
        byte b = 116;
        short s = 1123;
        int i = 64536;
        long l = 2147483648L; // Постфикс l или L обозначает литералы типа long
        System.out.println(i);
        System.out.println(b);
        System.out.println(s);
        System.out.println(l);
    }

    static void characters() {
        char a = 'a', b, c = 'c';
        b = (char) ((a + c) / 2); // Можно складывать, вычитать, делить и умножать
        // Но из-за особенностей арифметики Java результат приходится приводить к типу char явно
        System.out.println(b); // Выведет символ 'b'
    }

    static void floatingPointTypes() {
        double a, b = 4.12;
        a = 22.1 + b;
        float pi = 3.14f; // При использовании типа float требуется указывать суффикс f или F
        // так как без них типом литерала будет считаться double
        float anotherPi = (float) 3.14; // Можно привести явно
        double c = 27;
        double d = pi * c;
        System.out.println(d);
    }

    static void strings() {
        String a = "Hello", b = "World";
        System.out.println(a + " " + b); // Здесь + означает объединение (конкатенацию) строк
        // Пробел не вставляется автоматически

        // Строки конкатенируются слева направо, надо помнить это когда соединяешь строку и примитив
        String c = 2 + 2 + ""; // "4"
        String d = "" + 2 + 2; // "22"
        d = "" + (2 + 2); // а теперь d тоже "4"

        String foo = "a string";
        String bar = "a string"; // bar будет указывать на тот же объект что и foo
        String baz = new String("a string"); // Чтобы гарантированно создать новую строку надо вызвать конструктор
        System.out.println("foo == bar ? " + (foo == bar)); // == сравнивает ссылки на объекты
        System.out.println("foo равен bar ? " + (foo.equals(bar))); // Метод equals служит для проверки двух объектов на равенство
        System.out.println("foo == baz ? " + (foo == baz));
        System.out.println("foo равен baz ? " + (foo.equals(baz)));

        String str1 = "Java";
        String str2 = "Hello";
        String str12 = str2.concat(str1); // HelloJava

        String str3 = String.join(" ", str2, str1); // Hello Java

        char z = str1.charAt(2);
        System.out.println(z); // v
    }

    static void wrappers() {
        int i = 1;
        Integer boxed;
        //boxed = new Integer(i); // Обычное создание объекта
        boxed = Integer.valueOf(i); // Фабричный метод
        System.out.println(boxed);
        boxed = i; // Автоматическая упаковка, компилятор просто вставит вызов Integer.valueOf
        System.out.println(boxed);

        Integer unboxed = Integer.valueOf(5);
        int j;
        j = unboxed.intValue(); // Явная распаковка
        System.out.println(j);
        j = unboxed; // Автоматическая распаковка
        System.out.println(j);
    }

    // Ниже идут методы, относящиеся к ДЗ
    static void doSomeWork() {
        Some stuff = new Some("1-billion dollar secret!");
        
        stuff.setNoMoreSecrets("Секретов больше нет :(");
        System.out.println(stuff.getSecret());
        System.out.println(stuff.getSecret(true));
        System.out.println(stuff.toString());
        System.out.println(stuff.getДаТакТожеМожно());
        System.out.println();
    }

    static void doOtherWork() {
        Other stuff = new Other();

        stuff.saySomething();
        System.out.println();
    }

    static int getMin(int[] array) {
        int n = 0, min = array[0];

        do {
            n++;
            if (array[n] < min)
                min = array[n];
        }
        while ((n + 1) != array.length);
        return min;
    }

    static void findSpecial(char[] array) {
        int n = 0;

        System.out.print("Спецсимволы в char-массиве: ");
        while (n != array.length) {
            if ((array[n] >= 97) & (array[n] <= 122)) {
                n++;
            } else {
                System.out.print(array[n] + " ");
                n++;
            }
        }
        System.out.println();
    }

    static float getMean(float[] array) {
        float sum = 0;

        for (int i = 0; i < array.length; i++)
           sum += array[i];
        return (sum / array.length);
    }

    public static void main(String[] args) {
        //Задание 1
        doOtherWork();
        doSomeWork();

        //Задание 2
        int[] arrayOfInt = {32, -128, 15, 1526, -273, 0, 1, 65536, 777, -1001}; // Будем искать минимальное значение
        char[] arrayOfChar = {'i', 'q', '$', 'b', 'z', '@', 'o'}; // Будем искать символы, не являющиеся строчными буквами
        float[] arrayOfFloat = {3.14f, 146.0f, -0.9999f, 3.2f, -0.01f}; // Будем искать среднее арифметическое

        System.out.println("Минимальное число в int-массиве: " + getMin(arrayOfInt));
        findSpecial(arrayOfChar);
        System.out.println("Среднее арифметическое элементов во float-массиве: " + getMean(arrayOfFloat));
    }
}
