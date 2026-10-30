package ru.vladify.vshum.algorithm.greedy;

import ru.vladify.vshum.algorithm.Utils;

public class MaxProfit {

    //Верное решение снизу
    public static int maxProfit(int[] prices) {
        // Твоё решение
        return 0;
    }


    public static void main(String[] args) {
        Utils.runTest(
                "Базовый пример",
                maxProfit(new int[]{7, 1, 5, 3, 6, 4}),
                5
        );

        Utils.runTest(
                "Цена только падает",
                maxProfit(new int[]{7, 6, 4, 3, 1}),
                0
        );

        Utils.runTest(
                "Один день",
                maxProfit(new int[]{5}),
                0
        );

        Utils.runTest(
                "Цена только растёт",
                maxProfit(new int[]{1, 2, 3, 4, 5}),
                4
        );

        Utils.runTest(
                "Одинаковые цены",
                maxProfit(new int[]{3, 3, 3}),
                0
        );

        Utils.runTest(
                "Минимум после выгодной сделки",
                maxProfit(new int[]{2, 4, 1}),
                2
        );

        Utils.runTest(
                "Новая возможность после падения",
                maxProfit(new int[]{3, 8, 1, 2, 9}),
                8
        );
    }


//    public static int maxProfit(int[] prices) {
//        int minPrice = prices[0];
//        int maxProfit = 0;
//        for (int i = 1; i < prices.length; i++) {
//            int currPrice = prices[i];
//            int tempProf = currPrice - minPrice;
//            maxProfit = Math.max(tempProf, maxProfit);
//            minPrice = Math.min(currPrice, minPrice);
//        }
//        return maxProfit;
//    }
}
