package com.dglee.service.mybio.server.model;
/*
 * Created by 이동기 on 2022-03-21
 */

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

//해당 클래스는 DB Table 과 매핑되는 코어한 클래스이기 때문에, 불변성 보장을 위해 @Setter 는 쓰지 않는다.
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Builder
@ToString
@Table(name = "users", schema = "public")
public class User implements Serializable {

    @Id
    @Column(name="create_no",nullable = false)
    private Long create_no;

    @Column(name = "user_id",nullable = false)
    private String userId;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

}
