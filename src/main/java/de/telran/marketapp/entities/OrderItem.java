package de.telran.marketapp.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Table(name = "order_items")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    UUID id;

    @ManyToOne
    @JoinColumn(name="product_id")
    Product product;
    @ManyToOne
    @JoinColumn(name="order_id")
    Order order;
    Integer quantity;
    BigDecimal entirePrice;
    @CreationTimestamp
    OffsetDateTime created;
    @UpdateTimestamp
    OffsetDateTime updated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem user = (OrderItem) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


