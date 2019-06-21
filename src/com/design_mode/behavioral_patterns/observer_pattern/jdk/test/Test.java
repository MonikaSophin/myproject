package com.design_mode.behavioral_patterns.observer_pattern.jdk.test;

import com.design_mode.behavioral_patterns.observer_pattern.jdk.observer.CObserver;
import com.design_mode.behavioral_patterns.observer_pattern.jdk.observer.DObserver;
import com.design_mode.behavioral_patterns.observer_pattern.jdk.subject.NewsOffice;
import com.design_mode.behavioral_patterns.observer_pattern.model.Message;

public class Test {

    public static void main(String[] args){
        NewsOffice newsOffice = new NewsOffice();
        new CObserver(newsOffice);
        new DObserver(newsOffice);

        newsOffice.setMessage(new Message("兰陵笑笑生","金瓶梅","中国十大名著之一"));
        newsOffice.setMessage(new Message("金庸","天龙八部","武侠小说巅峰"));
    }
}
/**
 * 我是DObserver,从报社得到的消息是--书名是金瓶梅,描述为中国十大名著之一。
 * 我是CObserver,从报社得到的消息是--作者是兰陵笑笑生,书名为金瓶梅。
 * 我是DObserver,从报社得到的消息是--书名是天龙八部,描述为武侠小说巅峰。
 * 我是CObserver,从报社得到的消息是--作者是金庸,书名为天龙八部。
 *
 * 可以对比  输出的顺序被改变了
 *  Observable#notifyObservers()中 逆序调用Observer#update
 *
 *  for (int i = arrLocal.length-1; i>=0; i--)
 *             ((Observer)arrLocal[i]).update(this, arg);
 */
