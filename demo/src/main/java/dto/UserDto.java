package dto;

import com.example.springdataelasticdemo.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {
    List<User> userList;
}
