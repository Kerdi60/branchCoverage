import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    when(mq.size()).thenReturn(0);
    assertEquals(-1, c.countNumberOfOccurrences(""));
  }

  @Test
  public void isContain() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(10);
    when(mq.contains("deneme")).thenReturn(false);
    c = new Compute(mq);
    assertEquals(0, c.countNumberOfOccurrences("deneme"));

  }

  @Test
  public void normal() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(10);
    when(mq.contains("deneme")).thenReturn(true);
    for (int i = 0; i < 10; i++) {
      if (i % 2 == 0)
        when(mq.getAt(i)).thenReturn("deneme");
    }
    c = new Compute(mq);
    assertEquals(5, c.countNumberOfOccurrences("deneme"));
  }
}