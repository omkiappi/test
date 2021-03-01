package extentListerners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TEst {
	@Test
	public void loginPass() {
			System.out.println("Passed");
	}
	@Test
	public void loginFail() {
		Assert.fail("Failed");
  }
}
 