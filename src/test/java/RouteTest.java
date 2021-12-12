import com.yaroslav.delivery.converter.RouteConverter;
import com.yaroslav.delivery.dao.RouteDao;
import com.yaroslav.delivery.dto.RouteDto;
import com.yaroslav.delivery.model.RouteModel;
import com.yaroslav.delivery.service.RouteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RouteTest {

    @Mock
    private RouteDao routeDao ;

    @Mock
    private RouteConverter routeConverter;

    @InjectMocks
    private RouteService routeService = new RouteService();

    @Test
    public void testSelectWay() {
        RouteDto routeDto = new RouteDto();
        when(routeService.selectRoute(5)).thenReturn(routeDto);
        assertEquals(routeDto, routeService.selectRoute(5));
    }

    @Test
    public void testFindAllRoutes() {
        List<RouteDto> routeDtos = new ArrayList<>();
        List<RouteModel> routeModels = new ArrayList<>();
        when(routeService.findAllRoutes()).thenReturn(routeDtos);
        when(routeConverter.convertList(routeModels)).thenReturn(routeDtos);
        assertEquals(routeDtos , routeService.findAllRoutes());
        assertEquals(routeDtos , routeConverter.convertList(routeModels));
    }
    @Test
    public void testDelete() throws SQLException {
        when(routeDao.deleteRoute(1)).thenReturn(true);
        assertEquals(true , routeDao.deleteRoute(1));
    }

    @Test
    public void testUpdate(){
        RouteModel routeModel = new RouteModel();
        when(routeDao.updateRoute(routeModel)).thenReturn(true);
        assertEquals(true , routeDao.updateRoute(routeModel));
    }

    @Test
    public void testInsertRoute(){
        RouteModel routeModel = new RouteModel();
        when(routeDao.insertRoute(routeModel)).thenReturn(routeModel);
        assertEquals(routeModel , routeDao.insertRoute(routeModel) );
    }
}
