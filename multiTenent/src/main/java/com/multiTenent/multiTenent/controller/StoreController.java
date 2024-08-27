package com.multiTenent.multiTenent.controller;

import com.multiTenent.multiTenent.enity.Store;
import com.multiTenent.multiTenent.enity.StoreDto;
import com.multiTenent.multiTenent.response.ApiResponse;
import com.multiTenent.multiTenent.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/tenant/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    private UUID uuid(){
        UUID id = UUID.randomUUID();
        return id;
    }

    @PostMapping
    public ApiResponse<Store> addStore(@RequestBody StoreDto storeDto){
        Store store = Store.builder()
                .name(storeDto.getName())
                .tenantId(uuid().toString())
                .build();
        try {
            Store newStore = storeService.addStore(store);
            return ApiResponse.<Store>builder()
                    .status(true)
                    .data(newStore)
                    .error(null)
                    .build();
        }catch (Exception e){
            return ApiResponse.<Store>builder()
                    .status(true)
                    .data(null)
                    .error(e.getMessage())
                    .build();

        }
    }
}
