package TestNGsessions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTest {
	@Test(priority=1)
	public void login() {
		Assert.assertTrue(false, null);
	}
}
