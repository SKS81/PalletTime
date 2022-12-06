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
        int expected_1 = 0;
        int actual_1 = service.givMinEnd(0, 0);
        Assertions.assertEquals(expected_1, actual_1);

        int expected_2 = 25;
        int actual_2 = service.givMinEnd(0, 25);
        Assertions.assertEquals(expected_2, actual_2);

        int expected_3 = 60;
        int actual_3 = service.givMinEnd(1, 0);
        Assertions.assertEquals(expected_3, actual_3);

        int expected_4 = 61;
        int actual_4 = service.givMinEnd(1, 1);
        Assertions.assertEquals(expected_4, actual_4);

        int expected_5 = 248;
        int actual_5 = service.givMinEnd(4,8);
        Assertions.assertEquals(expected_5, actual_5);
    }

    @Test
    public void deviationMinParty_Test() {
        int expected_1 = 48;
        int actual_1 = service.givDeviationMinParty(16, 3);
        Assertions.assertEquals(expected_1, actual_1);

        int expected_2 = 2;
        int actual_2 = service.givDeviationMinParty(61, 2);
        Assertions.assertEquals(expected_2, actual_2);

        int expected_3 = 20;
        int actual_3 = service.givDeviationMinParty(50, 4);
        Assertions.assertEquals(expected_3, actual_3);
    }

    @Test
    public void deviationHorParty_Test() {
        int expected_1 = 0;
        int actual_1 = service.givDeviationHorParty(16, 3);
        Assertions.assertEquals(expected_1, actual_1);

        int expected_2 = 1;
        int actual_2 = service.givDeviationHorParty(51, 2);
        Assertions.assertEquals(expected_2, actual_2);

        int expected_3 = 3;
        int actual_3 = service.givDeviationHorParty(54, 4);
        Assertions.assertEquals(expected_3, actual_3);
    }
}