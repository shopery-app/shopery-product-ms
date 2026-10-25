package az.shopery.product_ms.repository;

import az.shopery.product_ms.model.entity.UserEntity;
import az.shopery.product_ms.utils.enums.UserStatus;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmailAndStatus(String email, UserStatus status);
}
