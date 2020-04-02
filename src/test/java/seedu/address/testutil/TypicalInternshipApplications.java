package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.testutil.TypicalInterviews.NUS;
import static seedu.address.testutil.TypicalInterviews.ONLINE;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.InternshipDiary;
import seedu.address.model.internship.ApplicationDate;
import seedu.address.model.internship.InternshipApplication;
import seedu.address.model.status.Status;

/**
 * A utility class containing a list of {@code InternshipApplication} objects to be used in tests.
 */
public class TypicalInternshipApplications {

    public static final InternshipApplication GOOGLE = new InternshipApplicationBuilder().withCompany("Google")
        .withRole("Software Engineer").withAddress("1600 Amphitheatre Parkway")
        .withPhone("94351253").withEmail("larry@google.com")
        .withStatus(Status.APPLIED)
        .withApplicationDate(new ApplicationDate(LocalDate.of(2020, 3, 23)))
        .withPriority(10)
        .withLastStage(Status.WISHLIST)
        .build();
    public static final InternshipApplication FACEBOOK = new InternshipApplicationBuilder().withCompany("Facebook")
        .withRole("Product Management").withAddress("1 Hacker Way, Menlo Park")
        .withPhone("99751354").withEmail("mark@google.com")
        .withStatus(Status.INTERVIEW)
        .withApplicationDate(new ApplicationDate(LocalDate.of(2020, 3, 25)))
        .withPriority(8)
        .withLastStage(Status.APPLIED)
        .build();

    public static final InternshipApplication GOOGLE_WITH_INTERVIEW = new InternshipApplicationBuilder()
        .withCompany("Google")
        .withRole("Software Engineer").withAddress("1600 Amphitheatre Parkway")
        .withPhone("94351253").withEmail("larry@google.com")
        .withStatus(Status.APPLIED)
        .withApplicationDate(new ApplicationDate(LocalDate.of(2019, 12, 1)))
        .withPriority(10)
        .withInterview(new InterviewBuilder().build())
        .withInterview(new InterviewBuilder(NUS).build())
        .buildWithInterviews();
    public static final InternshipApplication FACEBOOK_WITH_INTERVIEW = new InternshipApplicationBuilder()
        .withCompany("Facebook")
        .withRole("Product Management").withAddress("1 Hacker Way, Menlo Park")
        .withPhone("99751354").withEmail("mark@google.com")
        .withStatus(Status.REJECTED)
        .withApplicationDate(new ApplicationDate(LocalDate.of(2009, 11, 11)))
        .withPriority(8)
        .withInterview(new InterviewBuilder().build()).withInterview(new InterviewBuilder(ONLINE).build())
        .buildWithInterviews();

    // Manually added - Internship's details found in {@code CommandTestUtil}
    public static final InternshipApplication AMY = new InternshipApplicationBuilder()
        .withCompany(VALID_COMPANY_AMY).withPhone(VALID_PHONE_AMY).withRole(VALID_ROLE_AMY)
        .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withApplicationDate(VALID_DATE_AMY)
        .withPriority(VALID_PRIORITY_AMY).withStatus(VALID_STATUS_AMY).withLastStage(VALID_LAST_STAGE_AMY)
        .build();
    public static final InternshipApplication BOB = new InternshipApplicationBuilder()
        .withCompany(VALID_COMPANY_BOB).withPhone(VALID_PHONE_BOB).withRole(VALID_ROLE_BOB)
        .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withApplicationDate(VALID_DATE_BOB)
        .withPriority(VALID_PRIORITY_BOB).withStatus(VALID_STATUS_BOB).withLastStage(VALID_LAST_STAGE_BOB)
        .build();

    private TypicalInternshipApplications() {
    } // prevents instantiation

    /**
     * Returns an {@code InternshipDiary} with all the typical internship applications.
     */
    public static InternshipDiary getTypicalInternshipDiary() {
        InternshipDiary diary = new InternshipDiary();
        for (InternshipApplication application : getTypicalInternshipApplications()) {
            diary.loadInternshipApplication(application);
        }
        return diary;
    }

    /**
     * Returns an {@code InternshipDiary} with all the typical internship applications including interviews.
     */
    public static InternshipDiary getTypicalInternshipDiaryWithInterviews() {
        InternshipDiary diary = new InternshipDiary();
        for (InternshipApplication application : getTypicalInternshipApplicationsWithInterviews()) {
            diary.loadInternshipApplication(application);
        }
        return diary;
    }

    public static List<InternshipApplication> getTypicalInternshipApplications() {
        return new ArrayList<>(Arrays.asList(GOOGLE, FACEBOOK));
    }

    public static List<InternshipApplication> getTypicalInternshipApplicationsWithInterviews() {
        return new ArrayList<>(Arrays.asList(GOOGLE_WITH_INTERVIEW, FACEBOOK_WITH_INTERVIEW));
    }
}
