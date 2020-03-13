package com.sy.pojo.vo;

import java.io.Serializable;

public class BookVO implements Serializable {

    //关于首页 可以把所有数据存到 zset  用redis提供的进行排序

    //但是这样的话也可能要存好几份  因为权值只能有一个  但是首页需要 按三个不同的属性排序

}
