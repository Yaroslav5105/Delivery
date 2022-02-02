import com.yaroslav.delivery.converter.RouteConverter;
import com.yaroslav.delivery.dao.RouteDao;
import com.yaroslav.delivery.dto.RouteDto;
import com.yaroslav.delivery.model.RouteModel;
import com.yaroslav.delivery.service.RouteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RouteServiceTest {

    @Mock
    private RouteDao routeDao ;

    @Mock
    private RouteConverter routeConverter;

    @InjectMocks
    private RouteService routeService = new RouteService();

    @Test
    public void testSelectWay() {
        RouteDto routeDto = new RouteDto();
        RouteModel routeModel = new RouteModel();
        when(routeDao.selectRoute(5)).thenReturn(routeModel);
        when(routeConverter.convert(routeModel)).thenReturn(routeDto);
        assertEquals(routeDto, routeService.selectRoute(5));
    }

    @Test
    public void testFindAllRoutes() {
        List<RouteDto> routeDtos = new ArrayList<>();
        routeDtos.add(new RouteDto());
        List<RouteModel> routeModels = new ArrayList<>();
        when(routeDao.selectRoutes()).thenReturn(routeModels);
        when(routeConverter.convertList(routeModels)).thenReturn(routeDtos);

        assertEquals(routeDtos , routeService.findAllRoutes());
    }
    @Test
    public void testDelete() throws SQLException {
        when(routeDao.deleteRoute(1)).thenReturn(true);
        assertTrue(routeService.delete(1));
    }

    @Test
    public void testUpdate()  {
        RouteDto routeDto = new RouteDto();
        routeService.update(routeDto);
        Mockito.verify(routeDao).updateRoute(any(RouteModel.class));
    }
}