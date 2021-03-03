package com.ticketing.implementation;

import com.ticketing.mapper.MapperUtil;
import com.ticketing.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    MapperUtil mapperUtil;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void deleteByUserName() {

          userService.deleteByUserName("mike@cybertek.com");

//        verify(userRepository).deleteByUserName("mike@cybertek.com");
          verify(userRepository,times(2)).deleteByUserName("mike@mai.com");
          verify(userRepository,atLeastOnce()).deleteByUserName("mike@mail.com");
          verify(userRepository,atMost(5)).deleteByUserName("mike@mail.com");
    }
}