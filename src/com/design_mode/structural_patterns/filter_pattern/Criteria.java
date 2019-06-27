package com.design_mode.structural_patterns.filter_pattern;

import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/27
 * @description:
 * 2.为筛选标准创建一个接口。
 */
public interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}
