package com.example.thuctap.service.impl;

import com.example.thuctap.bean.User;
import com.example.thuctap.repository.UserRepository;
import com.example.thuctap.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UserRepository repository;

    @Override
    public Page<User> getAllAdmin(Pageable pageable) {
        return repository.getAllUser(pageable);
    }

    @Override
    public User detailAdmin(Long idUser) {
        return repository.findById(idUser).orElse(null);
    }

    @Override
    public User addAdmin(User user) {
        User user1 = User.builder()
                .nameUser(user.getNameUser())
                .numberPhone(user.getNumberPhone())
                .role(user.getRole())
                .sex(user.getSex())
                .birthday(user.getBirthday())
                .address(user.getAddress())
                .status(1)
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
        return repository.save(user1);
    }

    @Override
    public User updateAdmin(User user) {
        User user1 = repository.findById(user.getIdUser()).orElse(null).builder()
                .idUser(user.getIdUser())
                .nameUser(user.getNameUser())
                .role(user.getRole())
                .sex(user.getSex())
                .birthday(user.getBirthday())
                .address(user.getAddress())
                .status(user.getStatus())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
        return repository.save(user1);
    }

    @Override
    public User deleteAdmin(Long idUser) {
        return repository.deleteUser(idUser);
    }
}
