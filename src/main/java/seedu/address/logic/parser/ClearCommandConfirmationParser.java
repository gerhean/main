package seedu.address.logic.parser;

import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.parser.exceptions.ParseException;

public class ClearCommandConfirmationParser extends InternshipDiaryParser {
    private static final String CANCEL_CLEAR_COMMAND = "Internship diary is not cleared. No data will be lost.";

    @Override
    public Command parseCommand(String userInput) throws ParseException {
        if (userInput.trim().toLowerCase().equals("yes")) {
            return new ClearCommand();
        } else {
            throw new ParseException(CANCEL_CLEAR_COMMAND);
        }
    }
}