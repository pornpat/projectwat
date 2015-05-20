package camt.se331.shoppingcart.entity;

import camt.se331.watduangdee.entity.Product;
import camt.se331.watduangdee.entity.Qanda;
import camt.se331.watduangdee.service.QandaService;
import camt.se331.watduangdee.service.QandaServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Asus N46V on 20/5/2558.
 */
public class QandaTest {

    QandaService qandaService;

    @Before
    public void setUp(){
        qandaService = mock(QandaServiceImpl.class);
    }

    @Test
    public void testGetQandaUsingMock() {
        Qanda qanda = mock(Qanda.class);
        when(qanda.getId()).thenReturn(1l);
        when(qanda.getQuestion()).thenReturn("what time is it?");
        when(qanda.getAnswer()).thenReturn("3.33AM!!");
    }

    @Test
    public void testAddQandaUsingMock(){
        qandaService.addQanda(new Qanda(1l, "some question", "some answer"));
        when(qandaService.addQanda(new Qanda(1l, "some question", "some answer"))).thenReturn(new Qanda(1l, "some question", "some answer"));
        assertThat(qandaService.addQanda(new Qanda(1l, "some question", "some answer")), is(new Qanda(1l,"some question", "some answer")));
    }

}
