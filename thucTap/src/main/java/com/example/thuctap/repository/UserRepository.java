package com.example.thuctap.repository;

import com.example.thuctap.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // truy van Danh Sach Admin
    @Query(value = "select * from UserDetail where RoleID = 1", nativeQuery = true)
    Page<User> getAllUser(Pageable pageable);

    // truy van danh sach Khach Hang
    @Query(value = "select * from UserDetail where RoleID = 2", nativeQuery = true)
    List<User> getAllClient();

    // update trạng thái của Admin
    @Query(value = "update UserDetail set Status= 0 where ID= :idUser", nativeQuery = true)
    User deleteUser(@Param("idUser") Long idUser);
}
