package test.training;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import main.training.Environments;

import org.junit.Test;


public class EnumerationTest {

	@Test
	public void itShouldNeedSSHForRemoteEnvironments() {
		assertTrue(Environments.PRODUCTION.needsSSH());
		assertTrue(Environments.UAT.needsSSH());
		assertFalse(Environments.TESTING.needsSSH());
		assertFalse(Environments.STAGING.needsSSH());
	}
	
	@Test
	public void itShouldNeedRootAccessForNotHomeDirectories() {
		assertTrue(Environments.PRODUCTION.rootAccess());
		assertTrue(Environments.UAT.rootAccess());
		assertTrue(Environments.TESTING.rootAccess());
		assertFalse(Environments.STAGING.rootAccess());
	}
}
