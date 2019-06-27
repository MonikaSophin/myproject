package com.design_mode.structural_patterns.filter_pattern;

import java.util.List;

/**
 * @author: XueYing.Cao
 * @date: 2019/6/27
 * @description:
 * 3.
 * 任意两种筛选条件的组合，从而筛选出 满足两个条件中任意一个条件的person
 */
public class OrCriteria implements Criteria {
    
    private Criteria criteria;
    private Criteria otherCriteria;


    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaItems = criteria.meetCriteria(persons);
        List<Person> otherCriteriaItems = otherCriteria.meetCriteria(persons);

        for (Person person : firstCriteriaItems) {
            if (!otherCriteriaItems.contains(person)) {
                otherCriteriaItems.add(person);
            }
        }
        return otherCriteriaItems;
    }
}
