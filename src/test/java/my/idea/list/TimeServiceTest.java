package my.idea.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class TimeServiceTest {

    PalletTimeService service = new PalletTimeService();

    @ParameterizedTest
    @CsvFileSource(files="src/test/resources/data.csv")
    public void point_1_PlusAllTime_CSVFileTest(int expectedDay, int expectedHor, int expectedMin, int expectedSec, int hor1, int hor2, int min1, int min2, int sec1, int sec2) {
        int actualSec = service.getRemSec(sec1, sec2);
        Assertions.assertEquals(expectedSec, actualSec);
        int actualMin = service.getRemMin(sec1, sec2, min1, min2);
        Assertions.assertEquals(expectedMin, actualMin);
        int actualHor = service.getRemHor(sec1, sec2, min1, min2, hor1, hor2);
        Assertions.assertEquals(expectedHor, actualHor);
        int actualDay = service.getRemDay(sec1, sec2, min1, min2, hor1, hor2);
        Assertions.assertEquals(expectedDay, actualDay);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0,0,0,0,0,0,0,0",
            "362720,15,55,33,47,21,16,7,3",
            "362720,55,15,47,33,16,21,3,7",
    })
    public void point_2_MinusAllTime_CSVTest(int expectedTime, int sec21, int sec22, int min21, int min22, int hor21, int hor22, int day21, int day22) {
        int actualTime = service.getDifferenceSec(sec21, sec22, min21, min22, hor21, hor22, day21, day22);
        Assertions.assertEquals(expectedTime, actualTime);
    }

    @Test
    public void point_3_2_ConvMinToSec_Test() {
        int expectedSec = 600;
        int actualSec = service.convMinToSec(10);
        Assertions.assertEquals(expectedSec, actualSec);
    }

    @Test
    public void point_3_3_ConvHorToSec_Test() {
        int expectedSec = 10800;
        int actualSec = service.convHorToSec(3);
        Assertions.assertEquals(expectedSec, actualSec);
    }

    @Test
    public void point_3_3_ConvHorToMin_Test() {
        int expectedSec = 720;
        int actualSec = service.convHorToMin(12);
        Assertions.assertEquals(expectedSec, actualSec);
    }

    @Test
    public void point_3_4_ConvDayToSec_Test() {
        int expectedSec = 86400;
        int actualSec = service.convDayToSec(1);
        Assertions.assertEquals(expectedSec, actualSec);
    }

    @Test
    public void point_3_4_ConvDayToMin_Test() {
        int expectedSec = 2880;
        int actualSec = service.convDayToMin(2);
        Assertions.assertEquals(expectedSec, actualSec);
    }

    @Test
    public void point_3_4_ConvDayToHor_Test() {
        int expectedSec = 168;
        int actualSec = service.convDayToHor(7);
        Assertions.assertEquals(expectedSec, actualSec);
    }
}