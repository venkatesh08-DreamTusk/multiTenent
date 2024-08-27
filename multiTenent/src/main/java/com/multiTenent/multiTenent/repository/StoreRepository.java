package com.multiTenent.multiTenent.repository;

import com.multiTenent.multiTenent.enity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
    Optional<Store> findByTenantId(String tenantId);
}
