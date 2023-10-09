package com.example.thuctap.service;

import com.example.thuctap.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminService {
    Page<User> getAllAdmin(Pageable pageable);

    User detailAdmin(Long idUser);

    User addAdmin(User user);

    User updateAdmin(User user);

    User deleteAdmin(Long idUser);
}
