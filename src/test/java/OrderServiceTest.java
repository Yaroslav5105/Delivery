import com.yaroslav.delivery.converter.OrderConverter;
import com.yaroslav.delivery.dao.OrderDao;
import com.yaroslav.delivery.dto.OrderDto;
import com.yaroslav.delivery.model.OrderModel;
import com.yaroslav.delivery.service.OrderService;
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
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    private OrderDao orderDao;

    @Mock
    private OrderConverter converter;

    @InjectMocks
    private OrderService orderService ;

    @Test
    public void testSelectOrderr() {
        OrderModel orderModel = new OrderModel();
        OrderDto orderDto = new OrderDto();
        when(orderDao.selectOrder(3)).thenReturn(orderModel);
        when(converter.convert(orderModel)).thenReturn(orderDto);
        assertEquals(orderDto, orderService.selectOrder(3));
    }

    @Test
    public void testDeleteOrder() throws SQLException {
        when(orderDao.deleteOrder(30)).thenReturn(true);
        assertEquals(true , orderService.delete(30));
    }

    @Test
    public void testListOrders() {
        List<OrderModel> orderModels = new ArrayList<>();
        List<OrderDto> orderDtos = new ArrayList<>();
        orderDtos.add(new OrderDto());

        when(orderDao.selectOrders(1, 5)).thenReturn(orderModels);
        when(converter.convertList(orderModels)).thenReturn(orderDtos);
        assertEquals(orderDtos, orderService.findAllOrders(1));
    }

    @Test
    public void testCountPrder() {
        OrderDto orderDto = new OrderDto(300, 20, 100);
        assertEquals(1440, orderService.countOrder(orderDto));
    }


    @Test
    public void testUpdateOrder() throws SQLException {  //

        OrderDto orderDto = new OrderDto();
        orderService.updateOrder(orderDto);
        Mockito.verify(orderDao).updateOrder(any(OrderModel.class));
    }

    @Test
    public void testSelectOrder() {
        OrderModel orderModel = new OrderModel();
        OrderDto orderDto = new OrderDto();
        when(orderDao.selectOrder(1)).thenReturn(orderModel);
        when(converter.convert(orderModel)).thenReturn(orderDto);
        assertEquals( orderDto, orderService.selectOrder(1));
    }

    @Test
    public void testListUserOrders() {
        List<OrderDto> orderDtos = new ArrayList<>();
        List<OrderModel> orderModels = new ArrayList<>();
        orderDtos.add(new OrderDto());
        when(orderDao.selectOrdersByUser(1)).thenReturn(orderModels);
        when(converter.convertList(orderModels)).thenReturn(orderDtos);

        assertEquals( orderDtos , orderService.findAllOrdersByUserId(1020));
    }

    @Test
    public void testPayment() throws SQLException {

        OrderDto orderDto = new OrderDto();
        orderService.payment(orderDto);
        Mockito.verify(orderDao).updatePayment(any(OrderModel.class));
    }

    @Test
    public void testFindOrderFromLargerSort() { //
        List<OrderModel> orderModels = new ArrayList<>();
        List<OrderDto> orderDto = new ArrayList<>();
        when(orderDao.selectOrderSortFromLarger(1, 5)).thenReturn(orderModels);
        when(converter.convertList(orderModels)).thenReturn(orderDto);
        assertEquals(orderDto, orderService.findOrderFromLargerSort(1));
    }

    @Test
    public  void testCreateOrder() throws SQLException {
        OrderDto orderDto = new OrderDto();
        orderService.createOrder(orderDto);
        Mockito.verify(orderDao).insertOrder(any(OrderModel.class));
    }
}
