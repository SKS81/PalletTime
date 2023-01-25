package my.idea.list.service;

public class CompaundService {

    public int givFullMin1Pallet(int hor1, int min1, int hor2, int min2) {
        int fullMin1 = (hor1 * 60) + min1;
        int fullMin2Temp = (hor2 * 60) + min2;
        int fullMin2;
        if (fullMin2Temp >= fullMin1) {
            fullMin2 = fullMin2Temp;
        } else {
            fullMin2 = fullMin2Temp + 1440;
        }
        return fullMin2 - fullMin1;
    }

    public int givRemMin1Pallet(int fullMin1Pallet) {
        int dopHor1Pallet = fullMin1Pallet / 60;
        int tempMin1Pallet = dopHor1Pallet * 60;
        return fullMin1Pallet - tempMin1Pallet;
    }

    public int givRemHor1Pallet(int fullMin1Pallet) {
        return fullMin1Pallet / 60;
    }

    public int givRemMinParty(int count, int hor1, int min1, int hor2, int min2) {
        int fullMinParty = givFullMin1Pallet(hor1, min1, hor2, min2) * count + ((count - 1) * 2);
        int dopHorParty = fullMinParty / 60;
        int tempMinParty = dopHorParty * 60;
        return fullMinParty - tempMinParty;
    }

    public int givRemHorParty(int count, int hor1, int min1, int hor2, int min2) {
        int fullMinParty = givFullMin1Pallet(hor1, min1, hor2, min2) * count + ((count - 1) * 2);
        int fullHorParty = fullMinParty / 60;
        int remDayParty = fullHorParty / 24;
        int tempHorParty = remDayParty * 24;
        return fullHorParty - tempHorParty;
    }

    public int givRemDayParty(int count, int hor1, int min1, int hor2, int min2) {
        int fullMinParty = givFullMin1Pallet(hor1, min1, hor2, min2) * count + ((count - 1) * 2);
        int fullHopParty = fullMinParty / 60;
        return fullHopParty / 24;
    }

    public int givMinEnd(int hor2, int min2) {
        return (hor2 * 60) + min2;
    }

    public int givRemMinStart(int minStart) {
        int dopHorStart = minStart / 60;
        int tempMinStart = dopHorStart * 60;
        return minStart - tempMinStart;
    }

    public int givRemHorStart(int minStart) {
        int remHorStart;
        int tempHorStart = minStart / 60;
        if (tempHorStart >= 24) {
            int fullMinStart = tempHorStart * 60;
            int fullHorStart = fullMinStart / 60;
            int remDayStart = fullHorStart / 24;
            int horStart = remDayStart * 24;
            remHorStart = fullHorStart - horStart;
        } else {
            remHorStart = tempHorStart;
        }
        return remHorStart;
    }

    public int givRemMinEnd(int minEnd) {
        int dopHor = minEnd / 60;
        int tempMin = dopHor * 60;
        return minEnd - tempMin;
    }

    public int givRemHorEnd(int minEnd) {
        int remHorEnd;
        int tempHorEnd = minEnd / 60;
        if (tempHorEnd >= 24) {
            int fullMinEnd = tempHorEnd * 60;
            int fullHorEnd = fullMinEnd / 60;
            int remDayEnd = fullHorEnd / 24;
            int horEnd = remDayEnd * 24;
            remHorEnd = fullHorEnd - horEnd;
        } else {
            remHorEnd = tempHorEnd;
        }
        return remHorEnd;
    }

    public int givDeviationMinParty(int count, int deviationPallet) {
        int fullDeviationMinParty = count * deviationPallet;
        int fullDeviationHorParty = fullDeviationMinParty / 60;
        int remDeviationMinParty = fullDeviationHorParty * 60;
        return fullDeviationMinParty - remDeviationMinParty;
    }

    public int givDeviationHorParty(int count, int deviationPallet) {
        int fullDeviationMinParty = count * deviationPallet;
        return fullDeviationMinParty / 60;
    }

    public int givGofra(int tara, int count) {
        int gofra = 0;
        if ( tara == 1 ) gofra = count * 4;
        if ( tara == 2 ) gofra = count * 2;
        return gofra;
    }

    public int givPacking(int tara, int count) {
        int packing = 0;
        if ( tara == 1 ) packing = count * 36;
        if ( tara == 2 ) packing = count * 44;
        return packing;
    }
}