package rosenfeld.boggle;

import org.junit.Assert;
import org.junit.Test;

public class LocationTest {

    @Test
    public void locationGetters() {
        // given
        Location location = new Location(2, 3);

        // when
        int row = location.getRow();
        int col = location.getCol();

        // then
        Assert.assertEquals(2, row);
        Assert.assertEquals(3, col);
    }

    @Test
    public void locationSetters() {
        // given
        Location location = new Location(2, 3);

        // when
        location.setRow(10);
        location.setCol(5);
        int row = location.getRow();
        int col = location.getCol();

        // then
        Assert.assertEquals(10, row);
        Assert.assertEquals(5, col);    }
}
