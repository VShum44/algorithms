package ru.vladify.vshum.algorithm.linearscan;


import ru.vladify.vshum.algorithm.Utils;

/*
 Дан массив символов chars.
 Верни строку, в которой каждая непрерывная серия одинаковых символов заменена:
 - самим символом;
 - количеством повторений, если их больше одного.
Одиночному символу единицу не дописываем. Исходный массив менять не требуется.

['a', 'a', 'b', 'b', 'c', 'c', 'c'] → "a2b2c3"
['a']                              → "a"
['a', 'b', 'a']                     → "aba"
['a', 'a', 'b', 'a', 'a']           → "a2ba2"
[]                                 → ""

 Важно: считаем повторы подряд, а не общее количество буквы во всём массиве.
 Поэтому "aabaa" превращается в "a2ba2", а не в "a4b".
 */
public class CompressChars {
    public static String compress(char[] chars) {
        // Твоё решение
        return "";
    }

    public static void main(String[] args) {
        Utils.runTest(
                "Несколько серий",
                compress("aabbccc".toCharArray()),
                "a2b2c3"
        );

        Utils.runTest(
                "Пустой массив",
                compress(new char[]{}),
                ""
        );

        Utils.runTest(
                "Один символ",
                compress("a".toCharArray()),
                "a"
        );

        Utils.runTest(
                "Нет повторов подряд",
                compress("aba".toCharArray()),
                "aba"
        );

        Utils.runTest(
                "Одна буква в разных сериях",
                compress("aabaa".toCharArray()),
                "a2ba2"
        );

        Utils.runTest(
                "Последняя серия из одного символа",
                compress("aaabbc".toCharArray()),
                "a3b2c"
        );

        Utils.runTest(
                "Все символы одинаковые",
                compress("aaaa".toCharArray()),
                "a4"
        );

        Utils.runTest(
                "Многозначное количество",
                compress("aaaaaaaaaaaa".toCharArray()),
                "a12"
        );

        Utils.runTest(
                "Разный регистр",
                compress("AAaaA".toCharArray()),
                "A2a2A"
        );
    }
}
