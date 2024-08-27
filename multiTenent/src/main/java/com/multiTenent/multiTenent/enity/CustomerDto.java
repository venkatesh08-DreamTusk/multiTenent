package com.multiTenent.multiTenent.enity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private String name;

    private Long store;

    private String emailId;

    private String password;
}
