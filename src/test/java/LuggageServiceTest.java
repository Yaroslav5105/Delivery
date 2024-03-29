import com.yaroslav.delivery.converter.LuggageConverter;
import com.yaroslav.delivery.dao.LuggageDao;
import com.yaroslav.delivery.dto.LuggageDto;
import com.yaroslav.delivery.model.LuggageModel;
import com.yaroslav.delivery.service.LuggageService;
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
public class LuggageServiceTest {

    @Mock
    LuggageDao luggageDao;

    @Mock
    LuggageConverter converter;

    @InjectMocks
    LuggageService luggageService;

    @Test
    public void testFindAllLuggages(){
        List<LuggageDto> luggageDtos =new ArrayList<>();
        List<LuggageModel> luggageModels =new ArrayList<>();
        when(luggageDao.selectLuggage()).thenReturn(luggageModels);
        when(converter.convertList(luggageModels)).thenReturn(luggageDtos);
        assertEquals(luggageDtos , luggageService.findAllLuggages());
    }
}
