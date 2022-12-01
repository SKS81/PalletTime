package my.idea.list;

public class PalletTimeService {

    public int givFullMin1Pallet(int hor1, int min1, int hor2, int min2) {
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

    public int givRemMin1Pallet(int fullMin1Pallet) {
        int dopHor1Pallet = fullMin1Pallet / 60;
        int tempMin1Pallet = dopHor1Pallet * 60;
        int remMin1Pallet = fullMin1Pallet - tempMin1Pallet;
        return remMin1Pallet;
    }

    public int givRemHor1Pallet(int fullMin1Pallet) {
        int remHor1Pallet = fullMin1Pallet / 60;
        return remHor1Pallet;
    }

    public int givRemMinParty(int count, int hor1, int min1, int hor2, int min2) {
        int fullMinParty = givFullMin1Pallet(hor1, min1, hor2, min2) * count + ((count - 1) * 2);
        int dopHorParty = fullMinParty / 60;
        int tempMinParty = dopHorParty * 60;
        int remMinParty = fullMinParty - tempMinParty;
        return remMinParty;
    }

    public int givRemHorParty(int count, int hor1, int min1, int hor2, int min2) {
        int fullMinParty = givFullMin1Pallet(hor1, min1, hor2, min2) * count + ((count - 1) * 2);
        int fullHorParty = fullMinParty / 60;
        int remDayParty = fullHorParty / 24;
        int tempHorParty = remDayParty * 24;
        int remHorParty = fullHorParty - tempHorParty;
        return remHorParty;
    }

    public int givRemDayParty(int count, int hor1, int min1, int hor2, int min2) {
        int fullMinParty = givFullMin1Pallet(hor1, min1, hor2, min2) * count + ((count - 1) * 2);
        int fullHopParty = fullMinParty / 60;
        int remDayParty = fullHopParty / 24;
        return remDayParty;
    }

    public int givMinEnd(int hor2, int min2) {
        int minEnd = (hor2 * 60) + min2;
        return minEnd;
    }

    public int givRemMinStart(int minStart) {
        int dopHorStart = minStart / 60;
        int tempMinStart = dopHorStart * 60;
        int remMinStart = minStart - tempMinStart;
        return remMinStart;
    }

    public int givRemHorStart(int minStart) {
        int remHorStart;
        int tempHorStart = minStart / 60;
        if (tempHorStart >= 24) {
            remHorStart = tempHorStart - 24;
            return remHorStart;
        } else {
            remHorStart = tempHorStart;
            return remHorStart;
        }
    }

    public int givRemMinEnd(int minEnd) {
        int dopHor = minEnd / 60;
        int tempMin = dopHor * 60;
        int remMinEnd = minEnd - tempMin;
        return remMinEnd;
    }

    public int givRemHorEnd(int minEnd) {
        int remHorEnd;
        int tempHorEnd = minEnd / 60;
        if (tempHorEnd >= 24) {
            remHorEnd = tempHorEnd - 24;
            return remHorEnd;
        } else {
            remHorEnd = tempHorEnd;
            return remHorEnd;
        }
    }
}