import com.yaroslav.delivery.converter.OrderConverter;
import com.yaroslav.delivery.dao.OrderDao;
import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.model.OrderModel;
import com.yaroslav.delivery.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest {

    @Mock
    private OrderDao orderDao;

    @Mock
    private OrderConverter converter;

    @InjectMocks
    private OrderService orderService = new OrderService();

    @Test
    public void testGetListOrder() {
        OrderModel orderModel = new OrderModel();
        OrderDto orderDto = new OrderDto();
        when(orderDao.selectOrder(3)).thenReturn(orderModel);
        when(converter.convert(orderModel)).thenReturn(orderDto);
        assertEquals(orderDto, orderService.selectOrder(3));
    }

    @Test
    public void testListOrders() {
        List<OrderModel> orderModels = new ArrayList<>(3);
        when(orderDao.selectOrders(1, 5)).thenReturn(orderModels);
        assertEquals(orderModels, orderDao.selectOrders(1, 5));
    }

    @Test
    public void testCountPrder() {
        OrderDto orderDto = new OrderDto(300, 20, 100);
        assertEquals(1440, orderService.countOrder(orderDto));
    }

    @Test
    public void testDeleteOrder() throws SQLException {
        when(orderDao.deleteOrder(30)).thenReturn(true);
        assertTrue(orderDao.deleteOrder(30));
    }

    @Test
    public void testUpdateOrder() throws SQLException {
        OrderModel orderModel1 = new OrderModel();
        when(orderDao.updateOrder(orderModel1)).thenReturn(true);
        assertTrue(orderDao.updateOrder(orderModel1));
    }

    @Test
    public void testSelectOrder() {
        OrderModel orderModel = new OrderModel();
        when(orderDao.selectOrder(1)).thenReturn(orderModel);
        assertEquals(orderModel, orderDao.selectOrder(1));
    }

    @Test
    public void testLIstIserOrders() {
        List<OrderDto> orderDtos = new ArrayList<>();
        List<OrderModel> orderModels = new ArrayList<>();

        when(orderService.findAllOrdersByUserId(100)).thenReturn(orderDtos);
        when(converter.convertList(orderModels)).thenReturn(orderDtos);

        assertEquals(orderModels, orderService.findAllOrdersByUserId(100));
    }

    @Test
    public void testPayment() throws SQLException {
        OrderModel orderModel = new OrderModel();
        when(orderDao.updatePayment(orderModel)).thenReturn(true);

        assertTrue(orderDao.updatePayment(orderModel));
    }

    @Test
    public void testFindOrderFromLargerSort() {
        List<OrderModel> orderModels = new ArrayList<>();
        when(orderDao.selectOrderSortFromLarger(1, 5)).thenReturn(orderModels);

        assertEquals(orderModels, orderDao.selectOrderSortFromLarger(1, 5));
    }
}
