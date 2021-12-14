import com.yaroslav.delivery.converter.UserConverter;
import com.yaroslav.delivery.dao.UserDao;
import com.yaroslav.delivery.dto.UserDto;
import com.yaroslav.delivery.model.UserModel;
import com.yaroslav.delivery.service.UserService;
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
public class UserServiceTest {

    @Mock
    private UserDao userDao;

    @Mock
    private UserConverter converter;

    @InjectMocks
    private UserService userService;

    @Test
    public void testSelectUser() {
        UserModel userModel = new UserModel();
        userModel.setMail("testEmail");
        UserDto userDto = new UserDto();
        when(userDao.selectUser(11)).thenReturn(userModel);
        when(converter.convert(userModel)).thenReturn(userDto);
        assertEquals(userDto, userService.selectUser(11));
    }

    @Test
    public void testDeleteUser() throws SQLException {
        when(userDao.deleteUser(1)).thenReturn(true);
        assertTrue(userService.delete(1));
    }

    @Test
    public void testListUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        userDtos.add(new UserDto());
        List<UserModel> userModels = new ArrayList<>();
        when(userDao.selectUsers(1, 5)).thenReturn(userModels);
        when(converter.convertList(userModels)).thenReturn(userDtos);
        assertEquals(userDtos, userService.findAllUsers(1));
    }

    @Test
    public void testUpdateUser()  {  //
        UserDto userDto = new UserDto();
        UserModel userModel = new UserModel();

        when(userDao.selectUser(3)).thenReturn(userModel);
        assertEquals(userModel , userDao.selectUser(3));
        userService.updateUser(userDto);
        when(userDao.selectUser(userDto.getId())).thenReturn(userModel);

    }

    @Test
    public void testAuthenticate() {

        when(userDao.selectUserAuthenticate("q@gmail.com", "123")).thenReturn(11);
        assertEquals(11, userService.authenticate("q@gmail.com", "123"));
    }

    @Test
    public void testSortIdUserforLarger() {
        List<UserDto> userDtos = new ArrayList<>();
        userDtos.add(new UserDto());
        List<UserModel> userModels = new ArrayList<>();

        when(userDao.sortIdUserForLarger(1, 5)).thenReturn(userModels);
        when(converter.convertList(userModels)).thenReturn(userDtos);

        assertEquals(userDtos, userService.sortIdUserforLarger(1));
    }

    @Test
    public void testSelectUserByEmail() {
        UserDto userDto = new UserDto();
        UserModel userModel = new UserModel();
        when(userDao.selectUserByEmail("Email")).thenReturn(userModel);
        when(converter.convert(userModel)).thenReturn(userDto);
        assertEquals(userDto, userService.selectUserByEmail("Email"));
    }

    @Test
    public void testCreateUser() throws SQLException {
        UserDto userDto = new UserDto();
        userService.createUser(userDto);
        Mockito.verify(userDao).insertUser(any(UserModel.class));
    }

}
