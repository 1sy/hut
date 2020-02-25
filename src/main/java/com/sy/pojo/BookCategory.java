package com.sy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCategory {
    //编号和ID 并不相同，ID为主键自动生成，  -- 编号则是可以在不重复的情况下赋值，但是又显得无意义，之后想通了可以做修改
    private Integer categoryId;
    private Integer categoryType;
    private String categoryName;

}
