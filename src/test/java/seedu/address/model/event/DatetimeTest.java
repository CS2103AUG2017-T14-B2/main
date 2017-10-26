package seedu.address.model.event;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class DatetimeTest {

    @Test
    public void isValidTitle() {
        // invalid datetime
        assertFalse(Datetime.isValidDatetime("")); // empty string
        assertFalse(Datetime.isValidDatetime(" ")); // spaces only
        assertFalse(Datetime.isValidDatetime("123456789")); // numbers only
        assertFalse(Datetime.isValidDatetime("shakjhsa")); // characters only
        assertFalse(Datetime.isValidDatetime("test123")); // numbers and characters
        assertFalse(Datetime.isValidDatetime("1-09-2017 2010")); // invalid date format

        // valid datetime
        assertTrue(Datetime.isValidDatetime("02-09-2017 2015"));
    }
}
