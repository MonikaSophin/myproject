package com.design_mode.behavioral_patterns.state_pattern;

/**
 * @author: XueYing.Cao
 * @date: 2019/7/2
 * @description:
 * 步骤4.
 * 使用 Context 来查看当状态 State 改变时的行为变化。
 */
public class Test {

    public static void main(String[] args) {
        Context context = new Context();

        State state = new StartState();
        state.doAction(context);
        System.out.println(context.getState());

        //
        state = new StopState();
        state.doAction(context);
        System.out.println(context.getState());
    }
}
/**output:
 * Player is in start state
 * Start State
 * Player is in stop state
 * Stop State
 */