package com.design_mode.b_observer_pattern.myself.test;

import com.design_mode.b_observer_pattern.model.Message;
import com.design_mode.b_observer_pattern.myself.observer.impl.AObserver;
import com.design_mode.b_observer_pattern.myself.observer.impl.BObserver;
import com.design_mode.b_observer_pattern.myself.subject.impl.Newspaper;

public class Test {

    public static void main(String[] args){
        Newspaper newspaper = new Newspaper();
        new AObserver(newspaper);
        new BObserver(newspaper);

        newspaper.setMessage(new Message("施耐庵","西游记","中国四大名著之一"));
        newspaper.setMessage(new Message("罗贯中","三国演义","中国四大名著之一"));
    }
}
/**
 * 我是AObserver,从报社得到的消息是--作者是施耐庵,书名为西游记。
 * 我是BObserver,从报社得到的消息是--书名是西游记,描述为中国四大名著之一。
 * 我是AObserver,从报社得到的消息是--作者是罗贯中,书名为三国演义。
 * 我是BObserver,从报社得到的消息是--书名是三国演义,描述为中国四大名著之一。
 */