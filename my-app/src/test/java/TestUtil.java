import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() {
    c = new Util();
  }

  @Test
  public void oneLength() {
    assertFalse(c.compute(1));
  }

  @Test
  public void evenLength() {
    assertFalse(c.compute(1, 2, 3, 4));
    assertFalse(c.compute());
  }

  @Test(expected = RuntimeException.class)
  public void runTime() throws RuntimeException {
    c.compute(1, 0, 1);
  }

  @Test
  public void Divides() {
    assertTrue(c.compute(1, 2, 3, 4, 5));
    assertFalse(c.compute(7, 9, 10));
  }

}