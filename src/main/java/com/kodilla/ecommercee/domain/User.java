package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Access(AccessType.FIELD)
    @Column(name = "USERNAME")
    private String username;

    @Access(AccessType.FIELD)
    @Column(name = "STATUS")
    private Boolean status;

    @Access(AccessType.FIELD)
    @Column(name = "USERKEY")
    private BigDecimal userKey = getUserKey();

    @OneToMany(targetEntity = Order.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Order> orders;

    @Access(AccessType.FIELD)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CART")
    private Cart cart;

    public User(@NotNull String username) {
        this.username = username;
    }
}
