package com.multiTenent.multiTenent.service;

import com.multiTenent.multiTenent.enity.Store;
import com.multiTenent.multiTenent.repository.StoreRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StoreService {

    @Autowired
    public StoreRepository storeRepository;

    public Store addStore(Store store) {
        return  storeRepository.save(store);
    }

    public Long getStoreId(String tenantId) throws Exception {

      Optional<Store> store =  storeRepository.findByTenantId(tenantId);
      if(store.isPresent()){
          return store.get().getId();
      }else {
          throw new Exception("Id Not Found or Invalid Tenant Id");
      }
    }
}
