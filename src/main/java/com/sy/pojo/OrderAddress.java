package com.sy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddress {
    private String orderId;
    private String addressId;
    private String addresseeName;
    private String addresseeTelephone;
    private String addresseeAddress;
}
