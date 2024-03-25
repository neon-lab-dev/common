package com.neonlab.common.dto;


import com.neonlab.common.entities.User;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class UserDto {

    private String Id;
    private String name;// need to create one utility class for this name in common repo
    private String email;
    private String primaryPhoneNo;// can't be null
    private String secondaryPhoneNo;//optional


    public static UserDto parse(User user){
        var mapper = new ModelMapper();
        return  mapper.map(user, UserDto.class);
    }

}
