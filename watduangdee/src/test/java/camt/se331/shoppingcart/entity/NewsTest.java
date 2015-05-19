package camt.se331.shoppingcart.entity;

import camt.se331.watduangdee.entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

/**
 * Created by Asus N46V on 20/5/2558.
 */
public class NewsTest {

    @Before
    public void setUp(){

    }

    @Test
    public void testGetNewsUsingMock(){
        Product product = mock(Product.class);
        when(product.getId()).thenReturn(1l);
        when(product.getName()).thenReturn("some title");
        when(product.getDescription()).thenReturn("some description");
        when(product.getDate()).thenReturn("20-05-2558");
    }

    @Test
    public void testGetNewsUsingMockObject(){
        Product p1 = Mockito.mock(Product.class);
        Product p2 = Mockito.mock(Product.class);

        when(p1.getId()).thenReturn(1l);
        when(p2.getId()).thenReturn(2l);

        verify(p1, times(1)).getId();
        verify(p2, times(1)).getId();
    }

}
