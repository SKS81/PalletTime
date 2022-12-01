package my.idea.list;

import java.util.Scanner;

public class PalletTime {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		PalletTimeService service = new PalletTimeService();

		System.out.println("Расчёт затрачиваемого времени на фасовку партии.");
		System.out.println();
		System.out.println("Укажите планируемое колличество паллет в партии");
		int count = console.nextInt();
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

		System.out.println();
		System.out.println("Ориентировочное время фасовки одного паллета составляет:");
		if (remHor1Pallet == 0) {
			System.out.println(remMin1Pallet + " мин.");
		} else {
			System.out.println(remHor1Pallet + " час. и " + remMin1Pallet + " мин.");
		}

		System.out.println();
		System.out.println("Ориентировочное время фасовки всей партии составляет:");
		if (remDayParty == 0) {
			System.out.println(remHorParty + " час. и " + remMinParty + " мин.");
		} else {
			System.out.println(remDayParty + " сут., " + remHorParty + " час. и " + remMinParty + " мин.");
		}

		System.out.println();
		System.out.println("Ориентировочное время фасовки партии по-паллетно:");
		int numberPallet = 0;
		int minStart;
		int minEnd = service.givMinEnd(hor2, min2);
		int i;
		for (i = 0; i < count; i++) {
			numberPallet++;
			if (numberPallet == 1) {
				System.out.println("Паллет № " + numberPallet + " : начало в " + hor1 + " час., " + min1 + " мин." + " - окончание в " + hor2 + " час., " +  min2 + " мин.");
			} else {
				minStart = (minEnd + 2);
				minEnd = minStart + fullMin1Pallet;
				int remMinStart = service.givRemMinStart(minStart);
				int remHorStart = service.givRemHorStart(minStart);
				int remMinEnd = service.givRemMinEnd(minEnd);
				int remHorEnd = service.givRemHorEnd(minEnd);
				System.out.println("Паллет № " + numberPallet + " : начало в " + remHorStart + " час., " + remMinStart + " мин." + " - окончание в " + remHorEnd + " час., " + remMinEnd + " мин.");
			}
		}
		System.out.println();
		System.out.println("Не забудьте взять тестовый образец!");
		System.out.println("Время рассчитывается универсально для всех продуктов.");
		System.out.println("Погрешность фасовки одного паллета составляет до +/- 1 мин.");
		System.out.println("Общая погрешность фасовки всей партии составляет до +/- 15 мин.");
	}
}