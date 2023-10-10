package com.example.thuctap.bean;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "UserDetail")
public class User{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "Name")
    private String nameUser;

    @Column(name = "NumberPhone")
    private String numberPhone;

    @Column(name = "Sex")
    private Boolean sex;

    @Column(name = "Birthday")
    private Date birthday;

    @Column(name = "Address")
    private String address;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String passwordAdmin;

    @Column(name = "Status")
    private Integer status;

    @ManyToOne()
    @JoinColumn(name = "RoleID")
    private Role role;

    public String detailStatus() {
        if (this.status == 1) {
            return "Đang Làm Việc";
        } else {
            return "Đã Nghỉ";
        }
    }
}
