package my.idea.list.service;

public class DryMixesService {

    public int givRemMinTime(int time) {
        int dopHorTime = time / 60;
        int tempMinTime = dopHorTime * 60;
        return time - tempMinTime;
    }

    public int givRemHorTime(int time) {
        return time / 60;
    }

    public float givTimeOneKG(float quantity, float time) {
        return time / quantity * 60;
    }

    public String givKGOneMin(float quantity, float time) {
        float KGOneMin = quantity / time;
        return String.format("%.2f",KGOneMin);
    }

    public int givMinStart(int hor1, int min1) {
        int minFromHor = hor1 * 60;
        return minFromHor + min1;
    }

    public int givMinEnd(int hor1, int min1, int time, int deviationPallet) {
        return givMinStart(hor1, min1) + time + deviationPallet;
    }

    public int givRemMinEnd(int hor1, int min1, int time, int deviationPallet) {
        int dopHorTime = givMinEnd(hor1, min1, time, deviationPallet) / 60;
        int tempMinTime = dopHorTime * 60;
        return givMinEnd(hor1, min1, time, deviationPallet) - tempMinTime;
    }

    public int givRemHorEnd(int hor1, int min1, int time, int deviationPallet) {
        int remHorEnd;
        int dopHorTime = givMinEnd(hor1, min1, time, deviationPallet) / 60;
        if (dopHorTime >= 24) {
            int fullMinStart = dopHorTime * 60;
            int fullHorStart = fullMinStart / 60;
            int remDayStart = fullHorStart / 24;
            int horStart = remDayStart * 24;
            remHorEnd = fullHorStart - horStart;
        } else {
            remHorEnd = dopHorTime;
        }
        return remHorEnd;
    }
}