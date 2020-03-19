package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.commons.core.Messages.MESSAGE_INTERNSHIP_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalInternshipApplications.getTypicalInternshipDiary;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import seedu.address.logic.comparator.CompanyComparator;
import seedu.address.logic.comparator.DateComparator;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.internship.InternshipApplication;

/**
 * Contains integration tests (interaction with the Model) for {@code SortCommand}.
 */
public class SortCommandTest {
    private Model model = new ModelManager(getTypicalInternshipDiary(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalInternshipDiary(), new UserPrefs());

    @Test
    public void equals() {
        Comparator<InternshipApplication> companyComparator = new CompanyComparator();
        Comparator<InternshipApplication> dateComparator = new DateComparator();

        SortCommand sortCompanyCommand = new SortCommand(companyComparator);
        SortCommand sortDateCommand = new SortCommand(dateComparator);

        // same object -> returns true
        assertEquals(sortCompanyCommand, sortCompanyCommand);

        // same values -> returns true
        SortCommand sortCompanyCommandCopy = new SortCommand(companyComparator);
        assertEquals(sortCompanyCommand, sortCompanyCommandCopy);

        // different types -> returns false
        assertNotEquals(1, sortCompanyCommand);

        // null -> returns false
        assertNotEquals(null, sortCompanyCommand);

        // different person -> returns false
        assertNotEquals(sortCompanyCommand, sortDateCommand);
    }

    @Test
    public void execute_anyComparator_sameNumberOfInternshipApplicationFound() {
        int initialModelSize = model.getFilteredInternshipApplicationList().size();
        String expectedMessage = String.format(MESSAGE_INTERNSHIP_LISTED_OVERVIEW, initialModelSize);
        Comparator<InternshipApplication> companyComparator = new CompanyComparator();
        SortCommand command = new SortCommand(companyComparator);
        expectedModel.updateFilteredInternshipApplicationList(companyComparator);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }
}
