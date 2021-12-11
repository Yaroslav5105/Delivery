import com.yaroslav.delivery.converter.UserConverter;
import com.yaroslav.delivery.dao.UserDao;
import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.model.UserModel;
import com.yaroslav.delivery.service.UserService;
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
public class UserTest {

    @Mock
    private UserDao userDao;

    @Mock
    private UserConverter converter;

    @InjectMocks
    private UserService userService;

    @Test
    public void testSelcetUser() {
        UserModel userModel = new UserModel();
        when(userDao.selectUser(111)).thenReturn(userModel);
        assertEquals(userModel, userDao.selectUser(111));
    }

    @Test
    public void testDeleteUser() throws SQLException {
        when(userDao.deleteUser(1)).thenReturn(true);
        assertEquals(true, userDao.deleteUser(1));
    }

    @Test
    public void testListUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        List<UserModel> userModels = new ArrayList<>();
        when(userService.findAllUsers(1)).thenReturn(userDtos);
        when(converter.convertList(userModels)).thenReturn(userDtos);

        assertEquals(userDtos , converter.convertList(userModels));
        assertEquals(userDtos, userService.findAllUsers(1));
    }

    @Test
    public void testUpdateUser() throws SQLException {
        UserModel userModel = new UserModel();
        when(userDao.updateUser(userModel)).thenReturn(true);
        assertEquals(true , userDao.updateUser(userModel));
    }

    @Test
    public void testAuthenticate(){
        when(userService.authenticate("q@gmail.com" , "123")).thenReturn(11);
        assertEquals(11 , userService.authenticate("q@gmail.com" , "123"));
    }

    @Test
    public void testSortIdUserforLarger(){
        List<UserDto> userDtos = new ArrayList<>();
        List<UserModel> userModels = new ArrayList<>();

        when(userService.sortIdUserforLarger(1)).thenReturn(userDtos);
        when(converter.convertList(userModels)).thenReturn(userDtos);

        assertEquals(userDtos , userService.sortIdUserforLarger(1));
        assertEquals(userDtos , converter.convertList(userModels));
    }

    @Test
    public void testSelectUserByEmail(){
        UserDto userDto = new UserDto();
        when(userService.selectUserByEmail("Email")).thenReturn(userDto);
        assertEquals(userDto , userService.selectUserByEmail("Email"));
    }

    @Test
    public void testCreateUser() throws SQLException {
        UserModel userModel = new UserModel();
        when(userDao.insertUser(userModel)).thenReturn(true);
        assertEquals(true , userDao.insertUser(userModel));
    }

}
