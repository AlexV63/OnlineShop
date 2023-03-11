package de.telran.marketapp.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table(name = "product_tags")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
public class ProductTag {

    @Id
    @GeneratedValue
    UUID id;
    String name;
    String description;
    @ManyToMany
    @JoinTable(name = "products_product_tags",
    joinColumns = {@JoinColumn(name = "product_tag_id")},
    inverseJoinColumns = {@JoinColumn(name = "product_id")})
    List<Product> products;

    @CreationTimestamp
    OffsetDateTime created;
    @UpdateTimestamp
    OffsetDateTime updated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTag user = (ProductTag) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


