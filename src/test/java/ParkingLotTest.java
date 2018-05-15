import org.junit.Test;
import tdd.practice.Parkinglot;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jxzhong on 2018/5/15.
 */
public class ParkingLotTest {

    @Test
    public void should_get_1_available_place_when_parking_lot_is_empty_and_1_total_place() throws Exception {
        //given
        Parkinglot parkinglot = new Parkinglot(1);
        //when
        int availableNum = parkinglot.getAvailableNums();

        //then
        assertEquals(availableNum, 1);
    }


}
