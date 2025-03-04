package com.opdevinit.rest_api_dio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opdevinit.rest_api_dio.DTO.AlterUserDataDTO;
import com.opdevinit.rest_api_dio.DTO.UserSaveDTO;
import com.opdevinit.rest_api_dio.model.Account;
import com.opdevinit.rest_api_dio.model.User;
import com.opdevinit.rest_api_dio.repository.UserRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserSaveDTO create(UserSaveDTO user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Email ja cadastrado!");
        }

        Random randon = new Random();
        int numbers = randon.nextInt(9999);
        int identityNumber = randon.nextInt(9);

        User newUser = new User(user, new Account(String.format("%d-%d", numbers,identityNumber), new BigDecimal(0.00)));
        
        
        userRepository.save(newUser);

        UserSaveDTO userReturnDto= new UserSaveDTO(newUser);
        return  userReturnDto;

    }

    public User update(Long id, AlterUserDataDTO dto) {
        return userRepository.findById(id).map(user -> {
            user.setName(dto.getName());
            user.setEmail(dto.getEmail());
            return userRepository.save(user);
        }).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!"));
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuário não encontrado!");
        }
        userRepository.deleteById(id);
    }
}
