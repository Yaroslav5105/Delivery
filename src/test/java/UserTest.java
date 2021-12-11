import com.yaroslav.delivery.converter.OrderConverter;
import com.yaroslav.delivery.dao.UserDao;
import com.yaroslav.delivery.model.UserModel;
import com.yaroslav.delivery.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

    @Mock
    private UserDao userDao;

    @Mock
    private OrderConverter converter;

    @InjectMocks
    private UserService userService;

    @Test
    public void testDeleteUser() {
        UserModel userModel = new UserModel();
        when(userDao.selectUser(111)).thenReturn(userModel);

        assertEquals(userModel , userDao.selectUser(111));
    }
}
