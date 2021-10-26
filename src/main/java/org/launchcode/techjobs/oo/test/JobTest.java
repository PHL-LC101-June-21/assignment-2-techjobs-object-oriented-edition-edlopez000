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

        assertTrue(testJobber3 instanceof Job);
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

        assertTrue(testJobberTwin2.equals(testJobberTwin2));
    }
}
