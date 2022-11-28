package my.idea.list;

import java.util.Scanner;

public class PalletTime {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		PalletTimeService service = new PalletTimeService();

		System.out.println("Укажите планируемое колличество паллет в партии");
		int count = console.nextInt();
		System.out.println("Укажите время начала фасовки паллета");
		System.out.println("Укажите часы:");
		int hor1 = console.nextInt();
		System.out.println("Укажите минуты:");
		int min1 = console.nextInt();
		System.out.println("Укажите время завершения фасовки паллета");
		System.out.println("Укажите часы:");
		int hor2 = console.nextInt();
		System.out.println("Укажите минуты:");
		int min2 = console.nextInt();

		int fullMin1Pallet = service.getFullMin1Pallet(hor1, min1, hor2, min2);
		int remMin1Pallet = service.getRemMin1Pallet(fullMin1Pallet);
		int remHor1Pallet = service.getRemHor1Pallet(fullMin1Pallet);
		int remMinParty = service.getRemMinParty(count, hor1, min1, hor2, min2);
		int remHorParty = service.getRemHorParty(count, hor1, min1, hor2, min2);
		int remDayParty = service.getRemDayParty(count, hor1, min1, hor2, min2);

		System.out.println("Ориентировочное время фасовки одного паллета составляет:");
		if (remHor1Pallet == 0) {
			System.out.println(remMin1Pallet + " мин.");
		} else {
			System.out.println(remHor1Pallet + " час. и " + remMin1Pallet + " мин.");
		}
		System.out.println("Ориентировочное время фасовки всей партии составляет:");
		if (remDayParty == 0) {
			System.out.println(remHorParty + " час. и " + remMin1Pallet + " мин.");
		} else {
			System.out.println(remDayParty + " сут., " + remHorParty + " час. и " + remMinParty + " мин.");
		}
	}
}