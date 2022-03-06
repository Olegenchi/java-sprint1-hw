import java.util.HashMap;

public class StepTracker {

    HashMap<Integer, MonthData> monthToData = new HashMap<>();
    int targetAtStart = 10000;
    Converter converter = new Converter(75, 50);

    public StepTracker() {
        for (int i = 1; i < 13; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    class MonthData {
        int[] days = new int[30];
    }

    void saveSteps(int month, int day, int steps) {
        monthToData.get(month).days[day - 1] += steps;
        System.out.println("Количество шагов добавлено.");
    }

    void monthStats(int month) {
        MonthData months = monthToData.get(month);
        System.out.println("30 день: " + stepsMonthStats(months) + ".");
        System.out.println("Общее количество шагов за месяц: " + totalStepsOfMonth(months));
        System.out.println("Максимальное пройденное количество " +
                "шагов за день в этом месяце: " + maxStepsOfMonth(months));
        System.out.println("Среднее количество шагов: " + averageStepsOfMonth(months));
        System.out.println("Пройденная дистанция: " + converter.getLength(maxStepsOfMonth(months)));
        System.out.println("Количество сожженных каллорий: " + converter.getCal(maxStepsOfMonth(months)));
        System.out.println("Лучшая серия: " + bestStepsSeries(months));
    }

    int stepsMonthStats(MonthData months) {
        for (int i = 0; i < (months.days.length - 1); i++) {
            System.out.print((i + 1) + " день: " + months.days[i] + ", ");
        }
        return months.days[29];
    }

    int totalStepsOfMonth(MonthData months) {
        int sumStepsOfMonth = 0;
        for (int i = 0; i < months.days.length; i++) {
            sumStepsOfMonth += months.days[i];
        }
        return sumStepsOfMonth;
    }

    int maxStepsOfMonth(MonthData months) {
        int maxStepsOfMonth = 0;
        for (int i = 0; i < months.days.length; i++) {
            if (months.days[i] > maxStepsOfMonth) {
                maxStepsOfMonth = months.days[i];
            }
        }
        return maxStepsOfMonth;
    }

    int averageStepsOfMonth(MonthData months) {
        return (totalStepsOfMonth(months) / 30);
    }

    int bestStepsSeries(MonthData months) {
        int currentSeries = 0;
        int maxSeries = 0;
        for (int i = 0; i < months.days.length; i++) {
            if (months.days[i] >= targetAtStart) {
                currentSeries = 1;
                for (int j = i + 1; j < (months.days.length - 1); j++) {
                    if (months.days[j] >= targetAtStart) {
                        currentSeries += 1;
                    } else {
                        break;
                    }
                }
            }
            if (currentSeries > maxSeries) {
                maxSeries = currentSeries;
            }
        }
        return maxSeries;
    }

    void changeTargetStepsDay(int day) {
        targetAtStart = day;
        System.out.println("Новая цель " + targetAtStart + " шагов.");
    }
}

