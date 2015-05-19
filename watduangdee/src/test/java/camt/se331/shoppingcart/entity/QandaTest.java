package camt.se331.shoppingcart.entity;

import camt.se331.watduangdee.entity.Qanda;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Asus N46V on 20/5/2558.
 */
public class QandaTest {

    @Test
    public void testGetQandaUsingMock() {
        Qanda qanda = mock(Qanda.class);
        when(qanda.getId()).thenReturn(1l);
        when(qanda.getQuestion()).thenReturn("what time is it?");
        when(qanda.getAnswer()).thenReturn("3.33AM!!");
    }
}
