package my.idea.list;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DryMixes {
    public static void main(String[] args) throws InterruptedException {

        Scanner console = new Scanner(System.in);
        DryMixesService service = new DryMixesService();
        int countRunner = 50;

        System.out.println();
        System.out.println("Расчёт затрачиваемого времени на фасовку партии.");
        int deviationPallet = 3;
        String kremiKo = "КРЕМИКО";
        String kremiGold = "КРЕМИГОЛД";
        String kremiLite = "КРЕМИЛАЙТ";
        System.out.println();

        for (int a = 0; a < countRunner; a++) mainMenu: {
            System.out.println("Укажите количество партий");
            int countParty = console.nextInt();
            System.out.println("Укажите продолжительность чистки между партиями в минутах");
            System.out.println("Если чистки не требуются, введите 0");
            int clean = console.nextInt();
            int dinner = 45; //перерыв на обед
            int endClean = 45; //уборка в конце смены

            System.out.println();
            System.out.println("Выберите продукт:");
            System.out.println("1 - " + kremiKo);
            System.out.println("2 - " + kremiGold);
            System.out.println("3 - " + kremiLite);
            int product = console.nextInt();
            System.out.println();

            if (product == 1) {
                int quantity = 1_000; //вес партии в килограммах
                int time = 100; //время приготовления партии в минутах
                System.out.println("Укажите время начала приготовления");
                System.out.println("Укажите часы:");
                int hor1 = console.nextInt();
                System.out.println("Укажите минуты:");
                int min1 = console.nextInt();

                String minKG = service.givKGOneMin(quantity, time);
                int kgMin = (int) service.givTimeOneKG(quantity, time);
                int remMinTime = service.givRemMinTime(time);
                int remHorTime = service.givRemHorTime(time);
                int remMinEnd = service.givRemMinEnd(hor1, min1, time, deviationPallet);
                int remHorEnd = service.givRemHorEnd(hor1, min1, time, deviationPallet);

                TimeUnit.SECONDS.sleep(1);
                System.out.println();
                System.out.println("Ориентировочное время фасовки партии " + kremiKo + " составляет:");
                System.out.println(remHorTime + " час. и " + remMinTime + " мин.");

                TimeUnit.SECONDS.sleep(1);
                System.out.println();
                System.out.println("СПРАВОЧНО: рассчётный норматив выхода продукта:");
                System.out.println("За 1 минуту выход " + minKG + " кг. продукта;");
                System.out.println("1 кг. продукта за " + kgMin + " сек.");

                TimeUnit.SECONDS.sleep(1);
                System.out.println();
                System.out.println("Начало " + hor1 + " час. и " + min1 + " мин.");
                System.out.println("Окончание " + remHorEnd + " час. и " + remMinEnd + " мин.");

            } if (product == 2) {
                int quantity = 1_000; //вес партии в килограммах
                int time = 110; //время приготовления партии в минутах
                System.out.println("Укажите время начала приготовления");
                System.out.println("Укажите часы:");
                int hor1 = console.nextInt();
                System.out.println("Укажите минуты:");
                int min1 = console.nextInt();

                String minKG = service.givKGOneMin(quantity, time);
                int kgMin = (int) service.givTimeOneKG(quantity, time);
                int remMinTime = service.givRemMinTime(time);
                int remHorTime = service.givRemHorTime(time);
                int remMinEnd = service.givRemMinEnd(hor1, min1, time, deviationPallet);
                int remHorEnd = service.givRemHorEnd(hor1, min1, time, deviationPallet);

                TimeUnit.SECONDS.sleep(1);
                System.out.println();
                System.out.println("Ориентировочное время фасовки партии " + kremiGold + " составляет:");
                System.out.println(remHorTime + " час. и " + remMinTime + " мин.");

                TimeUnit.SECONDS.sleep(1);
                System.out.println();
                System.out.println("СПРАВОЧНО: рассчётный норматив выхода продукта:");
                System.out.println("За 1 минуту выход " + minKG + " кг. продукта;");
                System.out.println("1 кг. продукта за " + kgMin + " сек.");

                TimeUnit.SECONDS.sleep(1);
                System.out.println();
                System.out.println("Начало " + hor1 + " час. и " + min1 + " мин.");
                System.out.println("Окончание " + remHorEnd + " час. и " + remMinEnd + " мин.");

            } if (product == 3) {
                System.out.println("Функционал подсчёта выбранного продукта в разработке.");
                System.out.println();
                System.out.println("            ()_()");
                System.out.println("           ( 'x' ) " + "          Пока не готово");
                System.out.println("           c(')(') " + "          Ждёмс.........");

            } else {
                System.out.println("Вы указали неверное значение.");
            }

            TimeUnit.SECONDS.sleep(3);
            System.out.println();
            System.out.println("Выберите дальнейшее действие:");
            System.out.println("1 - Произвести новый расчёт");
            System.out.println("2 - Завершение программы");
            int choice = console.nextInt();
            if (choice == 1) {
                break mainMenu;
            } if (choice == 2) {
                System.out.println("Программа завершена.");
                System.exit(0);
            }
        }
    }
}