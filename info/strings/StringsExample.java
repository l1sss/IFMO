package com.itmo.strings;

import java.util.Arrays;

/**
 * Created by xmitya on 18.09.16.
 */
public class StringsExample {
    public static void main(String[] args) {
        createString();
        concatenation();
        formatting();
        comparison();
        substrings();
        chars();
        stringBuilder();
    }

    public static void createString() {
        // Объявляем и создаем строку.
        String s1 = "string1";

        System.out.println(s1); // string1

        // Строки это объекты, поэтому строка может
        // быть создана при помощи ключевого слова new:
        String s2 = new String("string2");

        System.out.println(s2); // string2
    }

    public static void concatenation() {
        // Конкатенация - это присоединение строк друг к другу.

        // Три строки соединяются:
        String s1 = "str" + "ing" + "1";

        System.out.println(s1); // string1

        // Можно использовать метод concat():
        String s2 = "str".concat("ing").concat("2");

        System.out.println(s2); // string2

        // Можно присоединять объекты и примитивы:
        String s3 = "string" + 3;

        System.out.println(s3); // string3

        // Присоединяем к строке символы char и int
        String s4 = "";

        s4 += 's';
        s4 += 't';
        s4 += 'r';
        s4 += 'i';
        s4 += 'n';
        s4 += 'g';
        s4 += 4;

        System.out.println(s4); // string4
    }

    public static void formatting() {
        // Строки можно создавать с помощью форматирования.
        String s1 = String.format("String with int: %02d, float: %.2f", 1, 1.5F);

        System.out.println(s1); // String with int: 01, float: 1,50

        // То же самое, только сразу вывод в консоль:
        System.out.printf("String with int: %02d, float: %.2f", 1, 1.5F); // String with int: 01, float: 1,50

            // Подробные примеры можно узнать тут: https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
    }

    public static void comparison() {
        String s1 = "string";
        String s2 = "string";

        // В этом случае Java присвоила один и тот же объект строки
        // обеим переменным s1 и s2 для оптимизации.
        System.out.println(s1 == s2); // true

        String s3 = new String("string");

        // Т.к. мы явно создали новый объект строки, то и сравнение ==
        // вернет false.
        System.out.println(s1 == s3); // false

        // Т.к. мы не всегда можем контролировать создание строк, то корректный
        // спопоб сравнения будет при помощи equals():
        System.out.println(s1.equals(s3)); // true

        // Но String предоставляет еще методы для сравнения строк:

        // Без учета регистра
        System.out.println("STRING".equalsIgnoreCase("string")); // true

        // Сравнение начала строки и конца
        System.out.println("What a lovely string!".startsWith("What")); // true
        System.out.println("What a lovely string!".endsWith("string!")); // true

        // Даже сравнение регионов строки
        System.out.println("What a lovely string!".regionMatches(7, "My lovely code", 3, 6)); // true
        // Даже без учета регистра
        System.out.println("What a lovely string!".regionMatches(true, 7, "My LOVELY code", 3, 6)); // true

        // Для определения порядка строк используется метод compareTo()
        String str1 = "I am the first string";
        String str2 = "I am the first string";
        String str3 = "I am the second string";

        // Если строки одинаковы, то результат будет 0
        System.out.println(str1.compareTo(str2)); // 0
        // Если строка, с которой сравниваем, идет позже по порядку, то < 0
        System.out.println(str2.compareTo(str3)); // -13
        // Если строка, с которой сравниваем, идет раньше по порядку, то > 0
        System.out.println(str3.compareTo(str1)); // 13

        // Эти методы используются для сортировки строк:
        String[] strArr1 = {str1, str3, str2};

        // Сортируем массив со строками
        Arrays.sort(strArr1);

        // Отсортировали их по алфавиту
        System.out.println(Arrays.toString(strArr1)); // [I am the first string, I am the first string, I am the second string]

        // Другой пример:
        String[] strArr2 = {"Nick", "Fred", "Jack", "Michael", "Josh", "Zack"};

        // Сортируем
        Arrays.sort(strArr2);

        System.out.println(Arrays.toString(strArr2)); // [Fred, Jack, Josh, Michael, Nick, Zack]
    }

    public static void substrings() {
        // Мы можем выделить подстроку из строки по идексу:
        String sub1 = "My lovely string!".substring(3, 6);

        System.out.println(sub1); // lovely

        String sub2 = "My lovely string!".substring(3);

        System.out.println(sub2); // lovely string!

        // Поиск подстроки:
        System.out.println("My lovely string!".contains("lovely")); // true

        // Поиск индекса подстроки:
        System.out.println("My lovely string!".indexOf("lovely")); // 3

        // Если подстрока не найдена, то возвращается -1 (здесь мы начинаем поиск с 11-го символа)
        System.out.println("My lovely string!".indexOf("lovely", 10)); // -1
    }

    public static void chars() {
        // Также возможно работать с отдельными символами в строке

        // В нашей строке 17 символов
        System.out.println("My lovely string!".length()); // 17

        // А четвертый символ 'l'
        System.out.println("My lovely string!".charAt(3)); // l

        // А 'l' первый раз встречается четвертым сиволом
        System.out.println("My lovely string!".indexOf('l')); // 3
    }

    public static void stringBuilder() {
        // Для конструирования сложных строк (особенно в циклах) лучше использовать StringBuilder
        // т.к. в этом случае используется меньше ресурсов. В частности, на каждой итерации
        // цикла не создается новая строка.

        StringBuilder sb = new StringBuilder();
        String largeString = "";

        for (int i = 0; i < 10; i++) {
            sb.append("num: ").append(i).append(", ");

            // В этой точке создается новая строка.
            largeString += "num: " + i + ", ";
        }

        // StringBuilder создает строку только при вызове метода toString()
        System.out.println(largeString.equals(sb.toString())); // true
    }
}
