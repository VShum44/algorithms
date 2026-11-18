package ru.vladify.vshum.algorithm.stack;

import ru.vladify.vshum.algorithm.Utils;

import java.util.*;

/*
Дана строка s, состоящая только из символов:

( ) { } [ ]

Верни true, если скобки расставлены правильно:

Каждая открывающая скобка закрывается скобкой того же типа.
Скобки закрываются в правильном порядке.
Нет лишних открывающих или закрывающих скобок.
Пустая строка считается корректной, s != null.

Примеры
"()"       → true
"()[]{}"   → true
"{[()]}"   → true
"(]"       → false
"([)]"     → false
"("        → false
"]"        → false
""         → true
 */

public class ValidParentheses {

//    public static boolean isValid(String s) {
//        // Напиши своё решение здесь.
//
//
//        return false;
//    }

    public static void main(String[] args) {

        runTest("Три типа скобок", "{[()]}", true);

        // Пустая строка.
        runTest("Пустая строка", "", true);

        // Одиночные скобки.
        runTest("Открывающая круглая", "(", false);
        runTest("Закрывающая круглая", ")", false);
        runTest("Открывающая квадратная", "[", false);
        runTest("Закрывающая квадратная", "]", false);
        runTest("Открывающая фигурная", "{", false);
        runTest("Закрывающая фигурная", "}", false);

        // Простые пары.
        runTest("Круглая пара", "()", true);
        runTest("Квадратная пара", "[]", true);
        runTest("Фигурная пара", "{}", true);
        runTest("Несовпадение типов", "(]", false);
        runTest("Обратный порядок", ")(", false);

        // Последовательные пары.
        runTest("Разные пары подряд", "()[]{}", true);
        runTest("Одинаковые пары подряд", "()()()", true);

        // Правильная вложенность.
        runTest("Два уровня", "(())", true);

        runTest("Вложенность и соседние пары", "{[()()]()}", true);
        runTest("Несколько вложенных групп", "([])({})", true);

        // Нарушения порядка и типов.
        runTest("Перекрещивание скобок", "([)]", false);
        runTest("Перекрещивание внутри фигурных", "{[(])}", false);
        runTest("Неверный тип внутри", "([]}", false);

        // Лишние скобки.
        runTest("Не закрыта внешняя скобка", "(()", false);
        runTest("Лишняя закрывающая в конце", "())", false);
        runTest("Лишняя открывающая в конце", "()(", false);
        runTest("Закрывающая в начале", "][]", false);
        runTest("Только открывающие", "([{", false);
        runTest("Только закрывающие", ")]}", false);

        // Чётная длина не гарантирует корректность.
        runTest("Не закрыты две скобки", "((", false);
        runTest("Пара и незакрытые скобки", "(){{", false);
        runTest("Баланс количества без правильного порядка", "())(", false);

        // Ошибка после корректного префикса.
        runTest("Корректный префикс и неверная пара", "()[](}", false);
        runTest("Корректный префикс и лишнее закрытие", "()[]{}", true);
        runTest("Дополнительное закрытие после всех пар", "()[]{}}", false);
    }

    private static void runTest(
            String testName,
            String input,
            boolean expected
    ) {
        String description = testName + " | вход: \"" + input + "\"";

        try {
            boolean actual = isValid(input);

            // Используем прежний формат сравнения через int[]:
            // true → 1, false → 0.
            Utils.runTest(
                    description,
                    new int[]{actual ? 1 : 0},
                    new int[]{expected ? 1 : 0}
            );
        } catch (Exception e) {
            // Продолжаем запуск остальных тестов.
            System.out.println(
                    description
                            + " | ожидалось: " + expected
                            + " -> ERROR: " + e
            );
        }
    }

    public static boolean isValid(String s) {
        // Напиши своё решение здесь.
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = Map.of(
                ')','(',
                '}','{',
                ']','['
        );
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character lastChar = stack.peek();
            if(map.containsValue(c)){
                stack.push(c);
            }else if(map.get(c).equals(lastChar)){
                stack.pop();
            }else {
                return false;
            }
        }

        return stack.isEmpty();
    }

}
