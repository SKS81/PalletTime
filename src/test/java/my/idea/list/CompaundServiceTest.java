package my.idea.list;

import my.idea.list.service.CompaundService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompaundServiceTest {

    CompaundService service = new CompaundService();

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
    public void remMinParty_Test() {
        int expected_1 = 0;
        int actual_1 = service.givRemMinParty(1, 0, 0, 0, 0);
        assertEquals(expected_1, actual_1);

        int expected_2 = 4;
        int actual_2 = service.givRemMinParty(3, 1, 0, 2, 0);
        assertEquals(expected_2, actual_2);

        int expected_3 = 58;
        int actual_3 = service.givRemMinParty(15, 0,0, 0, 30);
        assertEquals(expected_3, actual_3);
    }

    @Test
    public void remHorParty_Test() {
        int expected_1 = 0;
        int actual_1 = service.givRemHorParty(1, 0, 0, 0, 0);
        assertEquals(expected_1, actual_1);

        int expected_2 = 5;
        int actual_2 = service.givRemHorParty(5, 1, 0, 2, 0);
        assertEquals(expected_2, actual_2);

        int expected_3 = 3;
        int actual_3 = service.givRemHorParty(50, 23,30, 0, 30);
        assertEquals(expected_3, actual_3);
    }

    @Test
    public void remDayParty_Test() {
        int expected_1 = 0;
        int actual_1 = service.givRemDayParty(15, 9, 45, 10, 16);
        assertEquals(expected_1, actual_1);

        int expected_2 = 0;
        int actual_2 = service.givRemDayParty(16, 22, 50, 23, 45);
        assertEquals(expected_2, actual_2);

        int expected_3 = 3;
        int actual_3 = service.givRemDayParty(30, 21,30, 23, 55);
        assertEquals(expected_3, actual_3);
    }

    @Test
    public void minEnd_Test() {
        int expected_1 = 0;
        int actual_1 = service.givMinEnd(0, 0);
        assertEquals(expected_1, actual_1);

        int expected_2 = 25;
        int actual_2 = service.givMinEnd(0, 25);
        assertEquals(expected_2, actual_2);

        int expected_3 = 60;
        int actual_3 = service.givMinEnd(1, 0);
        assertEquals(expected_3, actual_3);

        int expected_4 = 61;
        int actual_4 = service.givMinEnd(1, 1);
        assertEquals(expected_4, actual_4);

        int expected_5 = 248;
        int actual_5 = service.givMinEnd(4,8);
        assertEquals(expected_5, actual_5);
    }

    @Test
    public void remMinStart_Test() {
        int expected_1 = 0;
        int actual_1 = service.givRemMinStart(0);
        assertEquals(expected_1, actual_1);

        int expected_2 = 12;
        int actual_2 = service.givRemMinStart(72);
        assertEquals(expected_2, actual_2);

        int expected_3 = 5;
        int actual_3 = service.givRemMinStart(185);
        assertEquals(expected_3, actual_3);

        int expected_4 = 24;
        int actual_4 = service.givRemMinStart(24);
        assertEquals(expected_4, actual_4);
    }

    @Test
    public void remHorStart_Test() {
        int expected_1 = 0;
        int actual_1 = service.givRemHorStart(59);
        assertEquals(expected_1, actual_1);

        int expected_2 = 1;
        int actual_2 = service.givRemHorStart(61);
        assertEquals(expected_2, actual_2);

        int expected_3 = 5;
        int actual_3 = service.givRemHorStart(300);
        assertEquals(expected_3, actual_3);

        int expected_4 = 9;
        int actual_4 = service.givRemHorStart(2000);
        assertEquals(expected_4, actual_4);
    }

    @Test
    public void remMinEnd_Test() {
        int expected_1 = 0;
        int actual_1 = service.givRemMinEnd(0);
        assertEquals(expected_1, actual_1);

        int expected_2 = 1;
        int actual_2 = service.givRemMinEnd(61);
        assertEquals(expected_2, actual_2);

        int expected_3 = 5;
        int actual_3 = service.givRemMinEnd(125);
        assertEquals(expected_3, actual_3);

        int expected_4 = 38;
        int actual_4 = service.givRemMinEnd(38);
        assertEquals(expected_4, actual_4);
    }

    @Test
    public void remHorEnd_Test() {
        int expected_1 = 0;
        int actual_1 = service.givRemHorEnd(35);
        assertEquals(expected_1, actual_1);

        int expected_2 = 1;
        int actual_2 = service.givRemHorEnd(60);
        assertEquals(expected_2, actual_2);

        int expected_3 = 3;
        int actual_3 = service.givRemHorEnd(200);
        assertEquals(expected_3, actual_3);

        int expected_4 = 17;
        int actual_4 = service.givRemHorEnd(2500);
        assertEquals(expected_4, actual_4);
    }

    @Test
    public void deviationMinParty_Test() {
        int expected_1 = 48;
        int actual_1 = service.givDeviationMinParty(16, 3);
        assertEquals(expected_1, actual_1);

        int expected_2 = 2;
        int actual_2 = service.givDeviationMinParty(61, 2);
        assertEquals(expected_2, actual_2);

        int expected_3 = 20;
        int actual_3 = service.givDeviationMinParty(50, 4);
        assertEquals(expected_3, actual_3);
    }

    @Test
    public void deviationHorParty_Test() {
        int expected_1 = 0;
        int actual_1 = service.givDeviationHorParty(16, 3);
        assertEquals(expected_1, actual_1);

        int expected_2 = 1;
        int actual_2 = service.givDeviationHorParty(51, 2);
        assertEquals(expected_2, actual_2);

        int expected_3 = 3;
        int actual_3 = service.givDeviationHorParty(54, 4);
        assertEquals(expected_3, actual_3);
    }

    @Test
    public void gofra_Test() {
        int expected_1 = 12;
        int actual_1 = service.givGofra(1, 3);
        assertEquals(expected_1, actual_1);

        int expected_2 = 10;
        int actual_2 = service.givGofra(2, 5);
        assertEquals(expected_2, actual_2);
    }

    @Test
    public void packing_Test() {
        int expected_1 = 360;
        int actual_1 = service.givPacking(1, 10);
        assertEquals(expected_1, actual_1);

        int expected_2 = 660;
        int actual_2 = service.givPacking(2, 15);
        assertEquals(expected_2, actual_2);
    }
}