package my.idea.list;

public class PalletTimeService {

    public int getFullMin1Pallet(int hor1, int min1, int hor2, int min2) {
        int fullMin1 = (hor1 * 60) + min1;
        int fullMin2Temp = (hor2 * 60) + min2;
        int fullMin2;
        if (fullMin2Temp >= fullMin1) {
            fullMin2 = fullMin2Temp;
        } else {
            fullMin2 = fullMin2Temp + 1440;
        }
        int fullMin1Pallet = fullMin2 - fullMin1;
        return fullMin1Pallet;
    }

    public int getRemMin1Pallet(int fullMin1Pallet) {
        int dopHor1Pallet = fullMin1Pallet / 60;
        int tempMin1Pallet = dopHor1Pallet * 60;
        int remMin1Pallet = fullMin1Pallet - tempMin1Pallet;
        return remMin1Pallet;
    }

    public int getRemHor1Pallet(int fullMin1Pallet) {
        int remHor1Pallet = fullMin1Pallet / 60;
        return remHor1Pallet;
    }

    public int getRemMinParty(int count, int hor1, int min1, int hor2, int min2) {
        int fullMinParty = getFullMin1Pallet(hor1, min1, hor2, min2) * count;
        int dopHorParty = fullMinParty / 60;
        int tempMinParty = dopHorParty * 60;
        int remMinParty = fullMinParty - tempMinParty;
        return remMinParty;
    }

    public int getRemHorParty(int count, int hor1, int min1, int hor2, int min2) {
        int fullMinParty = getFullMin1Pallet(hor1, min1, hor2, min2) * count;
        int fullHorParty = fullMinParty / 60;
        int remDayParty = fullHorParty / 24;
        int tempHorParty = remDayParty * 24;
        int remHorParty = fullHorParty - tempHorParty;
        return remHorParty;
    }

    public int getRemDayParty(int count, int hor1, int min1, int hor2, int min2) {
        int fullMinParty = getFullMin1Pallet(hor1, min1, hor2, min2) * count;
        int fullHopParty = fullMinParty / 60;
        int remDayParty = fullHopParty / 24;
        return remDayParty;
    }
}