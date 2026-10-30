package ru.vladify.vshum.gpt.stream;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class StreamMain {

    public static void main(String[] args) {
        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
    }

    // ============================================================
    // ЗАДАЧА 1. Три максимальные РАЗЛИЧНЫЕ зарплаты в каждом отделе
    //
    // Для каждого отдела найти всех сотрудников, зарплата которых
    // входит в три максимальные различные зарплаты этого отдела.
    //
    // Если сотрудников с одинаковой подходящей зарплатой несколько,
    // включить всех.
    //
    // Внутри каждого отдела:
    //   1. Зарплата по убыванию.
    //   2. При равенстве зарплаты — id по возрастанию.
    //
    // Если различных зарплат меньше трёх — включить всех.
    // Исходные данные не изменять.
    //
    // Тип результата: Map<String, List<Employee>>
    // ============================================================

    record Employee(long id, String name, String department, long salary) {}

    static void task1() {
        List<Employee> employees = List.of(
                new Employee(1, "Анна", "Backend", 300_000),
                new Employee(3, "Борис", "Backend", 250_000),
                new Employee(2, "Виктор", "Backend", 250_000),
                new Employee(4, "Глеб", "Backend", 200_000),
                new Employee(5, "Денис", "Backend", 180_000),
                new Employee(6, "Елена", "Frontend", 220_000),
                new Employee(7, "Жанна", "Frontend", 220_000),
                new Employee(8, "Иван", "Frontend", 190_000),
                new Employee(9, "Кирилл", "QA", 170_000),
                new Employee(10, "Лев", "QA", 170_000)
        );

        // TODO

    }
    // ============================================================
    // ЗАДАЧА 2. Статистика продаж по категориям
    //
    // Учитывать только оплаченные заказы.
    // Для каждой категории вычислить:
    //   1. Выручку: сумма quantity * unitPrice.
    //   2. Количество заказов с товарами этой категории.
    //   3. Количество уникальных покупателей этой категории.
    //
    // Несколько позиций одной категории в одном заказе увеличивают
    // выручку, но считаются одним заказом.
    //
    // Пустые заказы ничего не добавляют в результат.
    // Категории без оплаченных продаж в результат не включать.
    // Деньги считать без преобразования в double.
    // id заказов уникальны.
    //
    // Тип результата: Map<String, CategoryStats>
    // ============================================================

    enum Status { NEW, PAID, CANCELLED }

    record OrderItem(
            String sku,
            String category,
            int quantity,
            BigDecimal unitPrice
    ) {}

    record Order(
            long id,
            long customerId,
            Status status,
            List<OrderItem> items
    ) {}

    record CategoryStats(
            BigDecimal revenue,
            long orderCount,
            long uniqueCustomerCount
    ) {}

    static void task2() {
        List<Order> orders = List.of(
                new Order(1, 100, Status.PAID, List.of(
                        new OrderItem("java-book", "Books", 2, new BigDecimal("1500.00")),
                        new OrderItem("sql-book", "Books", 1, new BigDecimal("1200.50")),
                        new OrderItem("mouse", "Electronics", 1, new BigDecimal("2500.00"))
                )),
                new Order(2, 100, Status.PAID, List.of(
                        new OrderItem("java-book", "Books", 1, new BigDecimal("1500.00")),
                        new OrderItem("coffee", "Food", 3, new BigDecimal("450.90"))
                )),
                new Order(3, 200, Status.PAID, List.of(
                        new OrderItem("keyboard", "Electronics", 2, new BigDecimal("4000.00")),
                        new OrderItem("coffee", "Food", 1, new BigDecimal("450.90"))
                )),
                new Order(4, 300, Status.CANCELLED, List.of(
                        new OrderItem("monitor", "Electronics", 1, new BigDecimal("35000.00"))
                )),
                new Order(5, 400, Status.NEW, List.of(
                        new OrderItem("chair", "Furniture", 1, new BigDecimal("18000.00"))
                )),
                new Order(6, 200, Status.PAID, List.of()),
                new Order(7, 300, Status.PAID, List.of(
                        new OrderItem("sql-book", "Books", 2, new BigDecimal("1200.50"))
                ))
        );

        // TODO
    }

    // ============================================================
    // ЗАДАЧА 3. Последнее событие каждой сущности
    //
    // Для каждого entityId выбрать событие:
    //   1. С наиболее поздним timestamp.
    //   2. При равном timestamp — с наибольшим sequence.
    //   3. При равенстве обоих полей — первое во входном списке.
    //
    // Весь список сортировать нельзя.
    // Использовать collect с Collectors.toMap.
    //
    // Тип результата: Map<Long, Event>
    // ============================================================

    record Event(
            long entityId,
            Instant timestamp,
            long sequence,
            String payload
    ) {}

    static void task3() {
        List<Event> events = List.of(
                new Event(1, Instant.parse("2026-01-10T10:00:00Z"), 1, "created"),
                new Event(2, Instant.parse("2026-01-10T12:00:00Z"), 5, "first"),
                new Event(1, Instant.parse("2026-01-10T11:00:00Z"), 2, "updated"),
                new Event(2, Instant.parse("2026-01-10T12:00:00Z"), 5, "duplicate"),
                new Event(3, Instant.parse("2026-01-10T09:00:00Z"), 10, "old"),
                new Event(1, Instant.parse("2026-01-10T11:00:00Z"), 3, "confirmed"),
                new Event(3, Instant.parse("2026-01-10T10:00:00Z"), 1, "new"),
                new Event(2, Instant.parse("2026-01-10T11:00:00Z"), 100, "outdated")
        );

        // TODO
    }

    // ============================================================
    // ЗАДАЧА 4. Обратный индекс навыков
    //
    // Построить индекс: навык -> список id разработчиков.
    //
    // Навыки нормализовать:
    //   1. Удалить пробелы по краям через strip().
    //   2. Привести к нижнему регистру через Locale.ROOT.
    //   3. Пустые значения исключить.
    //
    // Один id может встречаться в нескольких записях:
    // навыки таких записей необходимо объединить.
    //
    // В результате:
    //   - оставить только навыки хотя бы двух разных разработчиков;
    //   - id внутри каждого списка уникальны и отсортированы;
    //   - порядок ключей не важен.
    //
    // Тип результата: Map<String, List<Long>>
    // ============================================================

    record Developer(long id, String name, List<String> skills) {}

    static void task4() {
        List<Developer> developers = List.of(
                new Developer(3, "Анна", List.of(" Java ", "JAVA", "SQL", " ")),
                new Developer(1, "Борис", List.of("java", "Docker", "SQL")),
                new Developer(2, "Вера", List.of("sql", "Kotlin")),
                new Developer(3, "Анна", List.of("Docker", " Kubernetes ")),
                new Developer(4, "Глеб", List.of("docker", "Go")),
                new Developer(5, "Денис", List.of()),
                new Developer(1, "Борис", List.of(" JAVA ", "kotlin", ""))
        );

        // TODO
    }

    // ============================================================
    // ЗАДАЧА 5. Любимый товар покупателя
    //
    // Для каждого покупателя найти товар с максимальным СУММАРНЫМ
    // количеством купленных единиц.
    //
    // При равенстве сумм выбрать лексикографически наименьшее
    // название товара согласно String.compareTo.
    //
    // quantity всегда положительное.
    // Суммы хранить в long, переполнения long не будет.
    // Не использовать внешнюю изменяемую Map внутри forEach.
    //
    // Тип результата: Map<Long, String>
    // ============================================================

    record Purchase(long customerId, String product, int quantity) {}

    static void task5() {
        List<Purchase> purchases = List.of(
                new Purchase(1, "coffee", 2),
                new Purchase(2, "bread", 4),
                new Purchase(1, "tea", 5),
                new Purchase(1, "coffee", 3),
                new Purchase(2, "milk", 2),
                new Purchase(3, "apple", 10),
                new Purchase(2, "milk", 3),
                new Purchase(3, "banana", 10),
                new Purchase(4, "water", 1),
                new Purchase(5, "rice", 2_000_000_000),
                new Purchase(5, "rice", 2_000_000_000),
                new Purchase(5, "pasta", 100)
        );

        // TODO
    }

    // ============================================================
    // ЗАДАЧА 6. Самая длинная серия посещений
    //
    // Для каждого пользователя найти длину самой длинной серии
    // посещений в последовательные календарные дни.
    //
    // Повторные посещения в один день не увеличивают серию
    // и не разрывают её.
    //
    // Входные записи расположены в произвольном порядке.
    // Группировку и подготовку дат выполнить через Stream API.
    // Для поиска серии внутри группы разрешён обычный цикл.
    //
    // Тип результата: Map<Long, Integer>
    // ============================================================

    record Visit(long userId, LocalDate date) {}

    static void task6() {
        List<Visit> visits = List.of(
                new Visit(1, LocalDate.parse("2026-01-05")),
                new Visit(2, LocalDate.parse("2026-02-01")),
                new Visit(1, LocalDate.parse("2026-01-01")),
                new Visit(1, LocalDate.parse("2026-01-02")),
                new Visit(2, LocalDate.parse("2026-01-31")),
                new Visit(1, LocalDate.parse("2026-01-02")),
                new Visit(1, LocalDate.parse("2026-01-04")),
                new Visit(3, LocalDate.parse("2026-03-10")),
                new Visit(2, LocalDate.parse("2026-02-02")),
                new Visit(1, LocalDate.parse("2026-01-06")),
                new Visit(3, LocalDate.parse("2026-03-10")),
                new Visit(4, LocalDate.parse("2026-04-01")),
                new Visit(4, LocalDate.parse("2026-04-03"))
        );

        // TODO
    }

    // ============================================================
    // ЗАДАЧА 7. Объединение настроек с приоритетами и удалением
    //
    // Даны настройки из нескольких источников.
    // Для каждого key выбрать настройку:
    //   1. С наибольшим priority.
    //   2. При равном priority — с наиболее поздним updatedAt.
    //   3. При полном равенстве — последнюю в порядке обхода:
    //      сначала внешний список, затем внутренний.
    //
    // Значение "<deleted>" означает удаление:
    // если победила такая настройка, ключа в результате быть не должно.
    //
    // Пустая строка — допустимое значение, а не удаление.
    // Сортировать все настройки нельзя.
    //
    // Тип результата: Map<String, String>
    // ============================================================

    record Setting(
            String key,
            String value,
            int priority,
            Instant updatedAt
    ) {}

    static void task7() {
        List<List<Setting>> sources = List.of(
                List.of(
                        new Setting("theme", "light", 1,
                                Instant.parse("2026-01-01T10:00:00Z")),
                        new Setting("timeout", "30", 1,
                                Instant.parse("2026-01-01T10:00:00Z")),
                        new Setting("language", "en", 1,
                                Instant.parse("2026-01-01T10:00:00Z")),
                        new Setting("banner", "Welcome", 1,
                                Instant.parse("2026-01-01T10:00:00Z"))
                ),
                List.of(
                        new Setting("theme", "dark", 2,
                                Instant.parse("2026-01-01T09:00:00Z")),
                        new Setting("timeout", "60", 1,
                                Instant.parse("2026-01-02T10:00:00Z")),
                        new Setting("language", "<deleted>", 2,
                                Instant.parse("2026-01-02T10:00:00Z"))
                ),
                List.of(),
                List.of(
                        new Setting("theme", "system", 2,
                                Instant.parse("2026-01-01T09:00:00Z")),
                        new Setting("timeout", "<deleted>", 1,
                                Instant.parse("2026-01-03T10:00:00Z")),
                        new Setting("language", "ru", 1,
                                Instant.parse("2026-01-05T10:00:00Z")),
                        new Setting("banner", "", 2,
                                Instant.parse("2026-01-01T10:00:00Z"))
                )
        );

        // TODO
    }
}
