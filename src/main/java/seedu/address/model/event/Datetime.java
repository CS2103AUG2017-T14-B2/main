package seedu.address.model.event;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a Event's Datetime in the event book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDatetime(String)}
 */
public class Datetime {

    public static final String MESSAGE_DATETIME_CONSTRAINTS =
            "Event datetime should be in dd-mm-yyyy hhmm format";
    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String DATETIME_VALIDATION_REGEX =
            //"^((0[1-9])|([012][0-9])|(3[01]))-([0]{0,1}[1-9]|1[012])-\\d\\d\\d\\d (([0-1][0-9])|(2[0-3]))[0-5][0-9]$";
            "[^\\s].*";

    public final String value;

    /**
     * Validates given datetime.
     *
     * @throws IllegalValueException if given datetime string is invalid.
     */
    public Datetime(String datetime) throws IllegalValueException {
        requireNonNull(datetime);
        if (!isValidDatetime(datetime)) {
            throw new IllegalValueException(MESSAGE_DATETIME_CONSTRAINTS);
        }
        this.value = datetime;
    }

    /**
     * Returns true if a given string is a valid event datetime.
     */
    public static boolean isValidDatetime(String test) {
        return test.matches(DATETIME_VALIDATION_REGEX);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Datetime // instanceof handles nulls
                && this.value.equals(((Datetime) other).value)); // state check
    }

    @Override
    public String toString() {
        return value;
    }
}
