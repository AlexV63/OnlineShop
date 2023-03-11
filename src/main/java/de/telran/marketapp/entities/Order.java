package de.telran.marketapp.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
public class Order {

    @Id
    @GeneratedValue
    UUID id;
    @ManyToOne
    @JoinColumn(name="user_id")
    User user;
    @OneToMany
    List<OrderItem> description;
    @CreationTimestamp
    OffsetDateTime created;
    @UpdateTimestamp
    OffsetDateTime updated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order user = (Order) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


