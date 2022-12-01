package my.idea.list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PalletServiceTest {

    PalletTimeService service = new PalletTimeService();

    @ParameterizedTest
    @CsvFileSource(files="src/test/resources/data.csv")
    public void fullMin_1_Pallet_CSVFileTest(int expectedFullMin1Pallet, int hor1, int min1, int hor2, int min2) {
        int actualFullMin1Pallet = service.givFullMin1Pallet(hor1, min1, hor2, min2);
        Assertions.assertEquals(expectedFullMin1Pallet, actualFullMin1Pallet);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "31,31",
            "59,59",
            "1,61",
            "23,83",
            "0,60",
            "0,120",
            "2,182",
    })
    public void remMin_1_Pallet_CSVTest(int expectedRemMin1Pallet, int fullMin1Pallet) {
        int actualRemMin1Pallet = service.givRemMin1Pallet(fullMin1Pallet);
        Assertions.assertEquals(expectedRemMin1Pallet, actualRemMin1Pallet);
    }

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "0,30",
            "0,59",
            "1,60",
            "1,61",
            "1,90",
            "2,120",
            "2,170",
    })
    public void remHor_1_Pallet_CSVTest(int expectedRemHor1Pallet, int fullMin1Pallet) {
        int actualRemHor1Pallet = service.givRemHor1Pallet(fullMin1Pallet);
        Assertions.assertEquals(expectedRemHor1Pallet, actualRemHor1Pallet);
    }








    @Test
    public void minEnd_Test() {
        int expected0_minEnd = 0;
        int actual0_minEnd = service.givMinEnd(0, 0);
        Assertions.assertEquals(expected0_minEnd, actual0_minEnd);

        int expected1_minEnd = 25;
        int actual1_minEnd = service.givMinEnd(0, 25);
        Assertions.assertEquals(expected1_minEnd, actual1_minEnd);

        int expected2_minEnd = 60;
        int actual2_minEnd = service.givMinEnd(1, 0);
        Assertions.assertEquals(expected2_minEnd, actual2_minEnd);

        int expected3_minEnd = 61;
        int actual3_minEnd = service.givMinEnd(1, 1);
        Assertions.assertEquals(expected3_minEnd, actual3_minEnd);

        int expected4_minEnd = 248;
        int actual4_minEnd = service.givMinEnd(4,8);
        Assertions.assertEquals(expected4_minEnd, actual4_minEnd);
    }
}