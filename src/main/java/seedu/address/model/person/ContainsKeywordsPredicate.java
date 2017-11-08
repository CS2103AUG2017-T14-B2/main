package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code ReadOnlyPerson}'s {@code Name, Address, Group or other field} matches any of the keywords given.
 */
public class ContainsKeywordsPredicate implements Predicate<ReadOnlyPerson> {
    private static char predicateType;
    private final List<String> keywords;

    public ContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    public static void setPredicateType(char predicateType) {
        ContainsKeywordsPredicate.predicateType = predicateType;
    }

    @Override
    public boolean test(ReadOnlyPerson person) {
        if (predicateType == 'n') {
            return keywords.stream()
                    .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getName().fullName, keyword));
        } else if (predicateType == 'a') {
            return keywords.stream()
                    .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getAddress().value, keyword));
        } else if (predicateType == 'm') {
            return (keywords.stream()
                    .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getAsText(), keyword)));
        //@@ author tingtx
        } else if (predicateType == 'g') {
            return (person.getGroup().value.equals(keywords.get(0).toString()));
        }
        //@@author
        return false;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ContainsKeywordsPredicate // instanceof handles nulls
                && this.keywords.equals(((ContainsKeywordsPredicate) other).keywords)); // state check
    }

}
