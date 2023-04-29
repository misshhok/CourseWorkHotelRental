package com.example.hotelrental.infrastructure.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import com.example.hotelrental.infrastructure.dao.security.User;
import com.example.hotelrental.infrastructure.mapper.UserMapper;
import com.example.hotelrental.infrastructure.repository.security.UserRepository;
import com.example.hotelrental.infrastructure.service.UserService;
import com.example.hotelrental.infrastructure.service.dto.user.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserMapper userMapper = UserMapper.INSTANCE;
  private final UserRepository userRepository;
  private final RoleServiceImpl roleService;
  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
  @Value("${admin.password}")
  private String adminPass;
  @Value("${admin.login}")
  private String adminUsername;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }

    return user;
  }

  public User findUserById(Long userId) {
    Optional<User> userFromDb = userRepository.findById(userId);
    return userFromDb.orElse(new User());
  }

  public List<User> allUsers() {
    return userRepository.findAll();
  }

  public boolean saveUser(User user) {
    User userFromDB = userRepository.findByUsername(user.getUsername());

    if (userFromDB != null) {
      return false;
    }

    user.setRoles(Collections.singleton(roleService.loadRoleByName("ROLE_USER")));
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.save(user);
    return true;
  }

  public boolean saveAdmin() {
    User admin = new User();
    admin.setUsername(adminUsername);
    admin.setPassword(adminPass);
    User userFromDB = userRepository.findByUsername(admin.getUsername());

    if (userFromDB != null) {
      return false;
    }

    admin.setRoles(Collections.singleton(roleService.loadRoleByName("ROLE_ADMIN")));
    admin.setPassword(passwordEncoder.encode(admin.getPassword()));
    userRepository.save(admin);
    return true;
  }

  public boolean deleteUser(Long userId) {
    if (userRepository.findById(userId).isPresent()) {
      userRepository.deleteById(userId);
      return true;
    }
    return false;
  }

  @Override
  public boolean registerUser(final CreateUserRequest createUserRequest) {
    return saveUser(userMapper.toEntity(createUserRequest));
  }
}
