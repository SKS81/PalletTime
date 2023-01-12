package my.idea.list;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PalletTime {

	public static void main(String[] args) throws InterruptedException {

		Scanner console = new Scanner(System.in);
		PalletTimeService service = new PalletTimeService();

		int countRunner = 30;
		int deviationPallet = 1;
		System.out.println();
		System.out.println("Расчёт затрачиваемого времени на фасовку партии.");

		for (int a = 0; a < countRunner; a++) mainMenu: {

			System.out.println();
			System.out.println("Выберите фасовочную тару:");
			System.out.println("1 - КОРОБКИ");
			System.out.println("2 - ВЁДРА");
			int tara = console.nextInt();
			System.out.println();
			System.out.println("Укажите планируемое колличество паллет в партии");
			int count = console.nextInt();
			System.out.println("Отфасуйте первый паллет и укажите следующие данные:");
			System.out.println("Укажите время начала фасовки первого паллета");
			System.out.println("Укажите часы:");
			int hor1 = console.nextInt();
			System.out.println("Укажите минуты:");
			int min1 = console.nextInt();
			System.out.println("Укажите время завершения фасовки первого паллета");
			System.out.println("Укажите часы:");
			int hor2 = console.nextInt();
			System.out.println("Укажите минуты:");
			int min2 = console.nextInt();

			int fullMin1Pallet = service.givFullMin1Pallet(hor1, min1, hor2, min2);
			int remMin1Pallet = service.givRemMin1Pallet(fullMin1Pallet);
			int remHor1Pallet = service.givRemHor1Pallet(fullMin1Pallet);
			int remMinParty = service.givRemMinParty(count, hor1, min1, hor2, min2);
			int remHorParty = service.givRemHorParty(count, hor1, min1, hor2, min2);
			int remDayParty = service.givRemDayParty(count, hor1, min1, hor2, min2);
			int deviationMinParty = service.givDeviationMinParty(count, deviationPallet);
			int deviationHorParty = service.givDeviationHorParty(count, deviationPallet);

			for (int b = 0; b < 125;) {
				System.out.println("Рассчёт... " + b + "% завершено");
				b = b + 25;
				TimeUnit.SECONDS.sleep(1);
			}

			System.out.println();
			System.out.println("Ориентировочное время фасовки одного паллета составляет:");
			if (remHor1Pallet == 0) {
				System.out.println(remMin1Pallet + " мин.");
			} else {
				System.out.println(remHor1Pallet + " час. и " + remMin1Pallet + " мин.");
			}
			TimeUnit.SECONDS.sleep(1);
			System.out.println();
			System.out.println("Ориентировочное время фасовки всей партии составляет:");
			if (remDayParty == 0) {
				System.out.println(remHorParty + " час. и " + remMinParty + " мин.");
			} else {
				System.out.println(remDayParty + " сут. ( это " + remDayParty * 2 + " смен ), " + remHorParty + " час. и " + remMinParty + " мин.");
			}
			TimeUnit.SECONDS.sleep(1);
			System.out.println();
			System.out.println("Ориентировочное время фасовки партии по-паллетно:");
			int numberPallet = 0;
			int minStart;
			int minEnd = service.givMinEnd(hor2, min2);
			for (int i = 0; i < count; i++) {
				numberPallet++;
				if (numberPallet == 1) {
					System.out.println("Паллет № " + numberPallet + " : начало в " + hor1 + " час., " + min1 + " мин." + " - окончание в " + hor2 + " час., " +  min2 + " мин.");
				} else {
					minStart = (minEnd + 2);
					minEnd = (minStart + fullMin1Pallet);
					int remMinStart = service.givRemMinStart(minStart);
					int remHorStart = service.givRemHorStart(minStart);
					int remMinEnd = service.givRemMinEnd(minEnd);
					int remHorEnd = service.givRemHorEnd(minEnd);
					System.out.println("Паллет № " + numberPallet + " : начало в " + remHorStart + " час., " + remMinStart + " мин." + " - окончание в " + remHorEnd + " час., " + remMinEnd + " мин.");
				}
			}
			TimeUnit.SECONDS.sleep(1);
			System.out.println();
			System.out.println("Не забудьте взять тестовый образец!");
			System.out.println("Время рассчитывается универсально для всех продуктов.");
			System.out.println("Погрешность фасовки одного паллета составляет до +/- " + deviationPallet + " мин.");
			if (deviationHorParty == 0) {
				System.out.println("Общая погрешность фасовки всей партии составляет до (+/-) " + deviationMinParty + " мин.");
			} else {
				System.out.println("Общая погрешность фасовки всей партии составляет до (+/-) " + deviationHorParty + " час. и " + deviationMinParty + " мин.");
			}
			TimeUnit.SECONDS.sleep(1);
			System.out.println();
			System.out.println("Ориентировочный расход материалов:");
			System.out.println(count + " поддон(а/ов)");
			if ( tara == 1 ) {
				int gofra = service.givGofra(tara, count);
				int packing = service.givPacking(tara, count);
				System.out.println(gofra + " гофролист(а/ов)");
				System.out.println("По " + packing + " коробке(и/ок) и пакету(а/ов)");
			} if ( tara == 2 ) {
				int gofra = service.givGofra(tara, count);
				int packing = service.givPacking(tara, count);
				System.out.println(gofra + " гофролист(а/ов)");
				System.out.println("По " + packing + " ведру(а/ер) и крышке(ек)");
			}

			TimeUnit.SECONDS.sleep(3);
			System.out.println();
			System.out.println("Выполнить рассчёт ещё одной партии?");
			System.out.println("1 - ДА, рассчитаем ещё");
			System.out.println("2 - НЕТ, завершить программу");
			int choice = console.nextInt();
			if (choice == 1) {
				break mainMenu;
			} if (choice == 2) {
				System.out.println("Программа завершена.");
				System.exit(0);
			} else {
				System.out.println("Вы указали некорректное значение. Программа завершена.");
				System.exit(0);
			}
		}
	}
}