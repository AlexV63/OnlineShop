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

@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue
    UUID id;
    String name;
    String description;
    BigDecimal price;

    @ManyToMany
    @JoinTable(name = "products_product_tags",
            inverseJoinColumns = {@JoinColumn(name = "product_tag_id")},
            joinColumns = {@JoinColumn(name = "product_id")})
    List<ProductTag> productTags;

    @CreationTimestamp
    OffsetDateTime created;
    @UpdateTimestamp
    OffsetDateTime updated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product user = (Product) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


