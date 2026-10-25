package az.shopery.product_ms.repository;

import az.shopery.product_ms.model.entity.ShopEntity;
import az.shopery.product_ms.model.entity.UserEntity;
import az.shopery.product_ms.utils.enums.ShopStatus;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<ShopEntity, UUID> {
    Optional<ShopEntity> findByUserAndStatus(UserEntity userEntity, ShopStatus shopStatus);
}
