package seedu.address.model;

import java.util.Objects;

import seedu.address.commons.core.AliasSettings;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.alias.exceptions.DuplicateAliasException;
import seedu.address.model.alias.exceptions.UnknownCommandException;

/**
 * Represents User's preferences.
 */
public class UserPrefs {

    private GuiSettings guiSettings;
    private AliasSettings aliasSettings;
    private String addressBookFilePath = "data/addressbook.xml";
    private String addressBookName = "MyAddressBook";
    private String accountFilePath = "data/account.xml";
    private String eventBookFilePath = "data/eventbook.xml";
    private String eventBookName = "MyEventBook";

    public UserPrefs() {
        this.setGuiSettings(500, 500, 0, 0);
        this.setAliasSettings();
    }

    public GuiSettings getGuiSettings() {
        return guiSettings == null ? new GuiSettings() : guiSettings;
    }

    public AliasSettings getAliasSettings() {
        return aliasSettings == null ? new AliasSettings() : aliasSettings;
    }

    public void updateLastUsedGuiSetting(GuiSettings guiSettings) {
        this.guiSettings = guiSettings;
    }

    public void setGuiSettings(double width, double height, int x, int y) {
        guiSettings = new GuiSettings(width, height, x, y);
    }

    public void setAliasSettings() {
        aliasSettings = new AliasSettings();
    }

    public String getAddressBookFilePath() {
        return addressBookFilePath;
    }

    public void setAddressBookFilePath(String addressBookFilePath) {
        this.addressBookFilePath = addressBookFilePath;
    }

    public String getAddressBookName() {
        return addressBookName;
    }

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public String getEventBookFilePath() {
        return eventBookFilePath;
    }

    public void setEventBookFilePath(String eventBookFilePath) {
        this.eventBookFilePath = eventBookFilePath;
    }

    public String getEventBookName() {
        return eventBookName;
    }

    public void setEventBookName(String eventBookName) {
        this.eventBookName = eventBookName;
    }

    public void setAlias(String command, String alias) throws DuplicateAliasException, UnknownCommandException {
        try {
            aliasSettings.setAlias(command, alias);
        } catch (DuplicateAliasException e) {
            throw new DuplicateAliasException(e.getMessage());
        } catch (UnknownCommandException e) {
            throw new UnknownCommandException(e.getMessage());
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof UserPrefs)) { //this handles null as well.
            return false;
        }

        UserPrefs o = (UserPrefs) other;

        return Objects.equals(guiSettings, o.guiSettings)
                && Objects.equals(addressBookFilePath, o.addressBookFilePath)
                && Objects.equals(addressBookName, o.addressBookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings, addressBookFilePath, addressBookName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gui Settings : " + guiSettings.toString());
        sb.append("\nLocal data file location : " + addressBookFilePath);
        sb.append("\nAddressBook name : " + addressBookName);
        return sb.toString();
    }

    public String getAccountFilePath() {
        return accountFilePath;
    }

    public void setAccountFilePath(String accountFilePath) {
        this.accountFilePath = accountFilePath;
    }
}
