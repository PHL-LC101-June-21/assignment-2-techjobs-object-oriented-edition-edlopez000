package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job testJobber1 = new Job();
        Job testJobber2 = new Job();

        assertNotEquals(testJobber1, testJobber2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJobber3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJobber3.getName() instanceof String);
        assertTrue(testJobber3.getEmployer() instanceof Employer);
        assertTrue(testJobber3.getLocation() instanceof Location);
        assertTrue(testJobber3.getPositionType() instanceof PositionType);
        assertTrue(testJobber3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", testJobber3.getName());
        assertEquals("ACME", testJobber3.getEmployer().getValue());
        assertEquals("Desert", testJobber3.getLocation().getValue());
        assertEquals("Quality control", testJobber3.getPositionType().getValue());
        assertEquals("Persistence", testJobber3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job testJobberTwin1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJobberTwin2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(testJobberTwin2.equals(testJobberTwin2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJobber1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testToString = testJobber1.toString();
        assertEquals('\n', testJobber1.toString().charAt(0));
        assertEquals('\n', testJobber1.toString().charAt(testToString.length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJobber = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testToString = testJobber.toString();

        assertEquals("\n" + "ID: " + testJobber.getId() + "\n" +
                "Name: " + testJobber.getName() + "\n" +
                "Employer: " + testJobber.getEmployer().getValue() + "\n" +
                "Location: " + testJobber.getLocation().getValue() + "\n" +
                "Position Type: " + testJobber.getPositionType().getValue() + "\n" +
                "Core Competency: " + testJobber.getCoreCompetency().getValue() + "\n", testToString);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testJobber = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String testToString = testJobber.toString();

        assertEquals("\n" + "ID: " + "Data not available" + "\n" +
                "Name: " + "Data not available" + "\n" +
                "Employer: " + "Data not available" + "\n" +
                "Location: " + "Data not available" + "\n" +
                "Position Type: " + "Data not available" + "\n" +
                "Core Competency: " + "Data not available" + "\n", testToString);
    }
}
