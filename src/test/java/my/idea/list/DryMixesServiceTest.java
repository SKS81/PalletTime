package my.idea.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DryMixesServiceTest {

    DryMixesService service = new DryMixesService();

    @Test
    public void remHorEnd_Test() {
        int expected_1 = 0;
        int actual_1 = service.givRemHorEnd(23, 0, 55, 5);
        Assertions.assertEquals(expected_1, actual_1);

        int expected_2 = 1;
        int actual_2 = service.givRemHorEnd(23, 30, 120, 0);
        Assertions.assertEquals(expected_2, actual_2);

        int expected_3 = 2;
        int actual_3 = service.givRemHorEnd(23, 28, 160, 2);
        Assertions.assertEquals(expected_3, actual_3);

        int expected_4 = 5;
        int actual_4 = service.givRemHorEnd(0, 34, 300, 6);
        Assertions.assertEquals(expected_4, actual_4);

        int expected_5 = 17;
        int actual_5 = service.givRemHorEnd(16, 30, 27, 3);
        Assertions.assertEquals(expected_5, actual_5);
    }

    @Test
    public void remMinEnd_Test() {
        int expected_1 = 40;
        int actual_1 = service.givRemMinEnd(1, 10, 30, 0);
        Assertions.assertEquals(expected_1, actual_1);

        int expected_2 = 33;
        int actual_2 = service.givRemMinEnd(0, 30, 120, 3);
        Assertions.assertEquals(expected_2, actual_2);

        int expected_3 = 15;
        int actual_3 = service.givRemMinEnd(17, 30, 160, 5);
        Assertions.assertEquals(expected_3, actual_3);
    }

    @Test
    public void minEnd_Test() {
        int expected_1 = 1456;
        int actual_1 = service.givMinEnd(23, 45, 30, 1);
        Assertions.assertEquals(expected_1, actual_1);

        int expected_2 = 103;
        int actual_2 = service.givMinEnd(0, 30, 70, 3);
        Assertions.assertEquals(expected_2, actual_2);

        int expected_3 = 725;
        int actual_3 = service.givMinEnd(10, 10, 110, 5);
        Assertions.assertEquals(expected_3, actual_3);
    }

    @Test
    public void minStart_Test() {
        int expected_1 = 1415;
        int actual_1 = service.givMinStart(23, 35);
        Assertions.assertEquals(expected_1, actual_1);

        int expected_2 = 10;
        int actual_2 = service.givMinStart(0, 10);
        Assertions.assertEquals(expected_2, actual_2);

        int expected_3 = 687;
        int actual_3 = service.givMinStart(11, 27);
        Assertions.assertEquals(expected_3, actual_3);
    }

    @Test
    public void KGOneMin_Test() {
        String expected_1 = String.format("%.2f", 5.00);
        String actual_1 = service.givKGOneMin(50, 10);
        Assertions.assertEquals(expected_1, actual_1);

        String expected_2 = String.format("%.2f", 10.29);
        String actual_2 = service.givKGOneMin(72, 7);
        Assertions.assertEquals(expected_2, actual_2);

        String expected_3 = String.format("%.2f", 0.25);
        String actual_3 = service.givKGOneMin(15, 61);
        Assertions.assertEquals(expected_3, actual_3);
    }

    @Test
    public void TimeOneKG_Test() {
        float expected_1 = 258.46155F;
        float actual_1 = service.givTimeOneKG(13, 56);
        Assertions.assertEquals(expected_1, actual_1);

        float expected_2 = 20.0F;
        float actual_2 = service.givTimeOneKG(6, 2);
        Assertions.assertEquals(expected_2, actual_2);

        float expected_3 = 38.181816F;
        float actual_3 = service.givTimeOneKG(11, 7);
        Assertions.assertEquals(expected_3, actual_3);
    }

    @Test
    public void RemHorTime_Test() {
        int expected_1 = 0;
        int actual_1 = service.givRemHorTime(59);
        Assertions.assertEquals(expected_1, actual_1);

        int expected_2 = 1;
        int actual_2 = service.givRemHorTime(74);
        Assertions.assertEquals(expected_2, actual_2);

        int expected_3 = 3;
        int actual_3 = service.givRemHorTime(180);
        Assertions.assertEquals(expected_3, actual_3);
    }

    @Test
    public void RemMinTime_Test() {
        int expected_1 = 30;
        int actual_1 = service.givRemMinTime(210);
        Assertions.assertEquals(expected_1, actual_1);

        int expected_2 = 0;
        int actual_2 = service.givRemMinTime(60);
        Assertions.assertEquals(expected_2, actual_2);

        int expected_3 = 27;
        int actual_3 = service.givRemMinTime(27);
        Assertions.assertEquals(expected_3, actual_3);
    }
}