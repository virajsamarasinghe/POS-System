package com.springbootacademy.batch12.pos.entity;


import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@TypeDefs(
        {
                @TypeDef(name = "json", typeClass = JsonType.class),
        })
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    @Id
    @Column(name = "order_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date date ;

    @Column(name = "total", length = 100, nullable = false)
    private double total;

    @OneToMany(mappedBy = "orders")
    private Set<OrderDetails> orderDetails;

    public Order(Customer customer, Date date, double total) {
        this.customer = customer;
        this.date = date;
        this.total = total;
    }
}
