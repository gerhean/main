package seedu.address.logic.comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.model.internship.InternshipApplication;
import seedu.address.testutil.InternshipApplicationBuilder;
import seedu.address.testutil.TypicalInternshipApplications;

/**
 * Comparator for sorting InternshipApplication by Priority.
 */
public class PriorityComparatorTest {

    @Test
    public void equals() {
        PriorityComparator priorityComparator1 = new PriorityComparator();
        PriorityComparator priorityComparator2 = new PriorityComparator();

        // same object -> returns true
        assertEquals(priorityComparator1, priorityComparator1);

        // same kind of object -> returns true
        assertEquals(priorityComparator1, priorityComparator2);
    }

    @Test
    public void compare_internshipApplication_correct() {
        PriorityComparator priorityComparator = new PriorityComparator();
        InternshipApplication google = TypicalInternshipApplications.GOOGLE;
        InternshipApplication facebook = TypicalInternshipApplications.FACEBOOK;

        InternshipApplication google1 = new InternshipApplicationBuilder(google)
                .withPriority(1).build();
        InternshipApplication google2 = new InternshipApplicationBuilder(google)
                .withPriority(3).build();
        InternshipApplication facebook1 = new InternshipApplicationBuilder(facebook)
                .withPriority(1).build();
        InternshipApplication facebook2 = new InternshipApplicationBuilder(facebook)
                .withPriority(5).build();

        // same object
        assertEquals(0, priorityComparator.compare(google, google));

        // only same priority
        assertEquals(0, priorityComparator.compare(google1, facebook1));

        // only priority is different
        assertTrue(priorityComparator.compare(google1, google2) < 0);
        assertTrue(priorityComparator.compare(google2, google1) > 0);

        // everything is different
        assertTrue(priorityComparator.compare(google1, facebook2) < 0);
        assertTrue(priorityComparator.compare(facebook2, google2) > 0);
    }

    @Test
    public void compare_unsortedList_listSorted() {
        PriorityComparator priorityComparator = new PriorityComparator();
        InternshipApplication google = TypicalInternshipApplications.GOOGLE;
        InternshipApplication facebook = TypicalInternshipApplications.FACEBOOK;

        InternshipApplication google1 = new InternshipApplicationBuilder(google)
                .withPriority(1).build();
        InternshipApplication google2 = new InternshipApplicationBuilder(google)
                .withPriority(3).build();
        InternshipApplication facebook1 = new InternshipApplicationBuilder(facebook)
                .withPriority(2).build();
        InternshipApplication facebook2 = new InternshipApplicationBuilder(facebook)
                .withPriority(4).build();

        ArrayList<InternshipApplication> unsorted = new ArrayList<>();
        Collections.addAll(unsorted, google2, google1, facebook1, facebook2);
        unsorted.sort(priorityComparator);

        ArrayList<InternshipApplication> sorted = new ArrayList<>();
        Collections.addAll(sorted, google1, facebook1, google2, facebook2);

        assertEquals(sorted, unsorted);
    }
}