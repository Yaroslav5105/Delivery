import com.yaroslav.delivery.converter.PriceConverter;
import com.yaroslav.delivery.dao.PriceDao;
import com.yaroslav.delivery.dto.PriceDto;
import com.yaroslav.delivery.model.PriceModel;
import com.yaroslav.delivery.service.PriceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PriceTest {

    @Mock
    PriceDao priceDao;

    @Mock
    PriceConverter converter;

    @InjectMocks
    PriceService priceService = new PriceService();

    @Test
    public void testFindPrice(){
        List<PriceModel> priceModels = new ArrayList<>();
        List<PriceDto> priceDtos = new ArrayList<>();

        when(priceService.findPrices()).thenReturn(priceDtos);
        when(converter.convertList(priceModels)).thenReturn(priceDtos);

        assertEquals(priceDtos , priceService.findPrices());
        assertEquals(priceDtos , converter.convertList(priceModels));
    }
}
