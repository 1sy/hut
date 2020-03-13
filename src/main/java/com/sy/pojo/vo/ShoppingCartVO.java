package com.sy.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartVO {
    private ShoppingItemVO shoppingItem;
    private String buyNumber;
}
