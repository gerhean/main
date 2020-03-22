package seedu.address.logic.commands.interviewsubcommands;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.InterviewCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.internship.InternshipApplication;

import static java.util.Objects.requireNonNull;

public class InterviewListCommand extends InterviewCommand {
    public static final String MESSAGE_SUCCESS = "listed all interviews in %1$s";

    Index index;

    public InterviewListCommand(Index index) {
        this.index = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        InternshipApplication internshipToList = super.getInternshipApplication(model, index);
        // Todo: change interviews into observable list and make it show here.
        return new CommandResult(String.format(MESSAGE_SUCCESS, internshipToList));
    }
}
