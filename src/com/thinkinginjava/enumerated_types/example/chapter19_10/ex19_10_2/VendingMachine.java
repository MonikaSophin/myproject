package com.thinkinginjava.enumerated_types.example.chapter19_10.ex19_10_2;

import com.thinkinginjava.util.Generator;
import com.thinkinginjava.util.TextFile;

import java.util.EnumMap;
import java.util.Iterator;

import static com.thinkinginjava.util.Print.*;
import static com.thinkinginjava.enumerated_types.example.chapter19_10.ex19_10_2.Input.*;

/**
 * @author: XueYing.Cao
 * @date: 2019/4/16
 * @description:
 */
enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
    private Input[] values;
    Category(Input ... values) { this.values = values; }
    private static EnumMap<Input, Category> categories =
            new EnumMap<>(Input.class);
    static {
        for (Category c : Category.class.getEnumConstants()) {
            for (Input type : c.values)
                categories.put(type, c);
        }
    }
    public static Category categorize(Input input) {
        return categories.get(input);
    }
}

public class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;
    enum StateDuration {
        TRANSIENT
    }

    enum State {
        RESTING {
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY {
            void next(Input input) {
                switch(Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if(amount < selection.amount())
                            print("Insufficient money for " + selection);
                        else state = DISPENSING;
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT) {
            void next() {
                print("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            void next() {
                if(amount > 0) {
                    print("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL { void output() { print("Halted"); } };

        private boolean isTransient = false;
        State() {}
        State(StateDuration trans) { isTransient = true; }
        void next(Input input) {
            throw new RuntimeException("Only call " +
                    "next(Input input) for non-transient states");
        }
        void next() {
            throw new RuntimeException("Only call next() for " +
                    "StateDuration.TRANSIENT states");
        }
        void output() {
            print(amount);
            print("------");
        }
    }

    public static void run(Generator<Input> gen) {
        while (state != State.TERMINAL) {
            state.next(gen.next());
            while (state.isTransient)
                state.next();
            state.output();
        }
    }

    public static void main(String[] args) {
      //  Generator<Input> gen = new RandomInputGenerator();
        String fileName = "src\\com\\thinkinginjava\\enumerated_types\\example\\chapter19_10\\file\\VendingMachineInput.txt";
        Generator<Input> gen = new FileInputGenerator(fileName);
        run(gen);
    }
}

class RandomInputGenerator implements Generator {
    @Override
    public Object next() { return Input.randomSelection(); }
}

class FileInputGenerator implements Generator<Input> {
    private Iterator<String> input;
    public FileInputGenerator(String fileName) {
        this.input = new TextFile(fileName, ";").iterator();
    }
    @Override
    public Input next() {
        if (!input.hasNext())
            return null;
        return Enum.valueOf(Input.class, input.next().trim());
    }
}
/**output:
 * 25
 * ------
 * 50
 * ------
 * 75
 * ------
 * here is your CHIPS
 * 0
 * ------
 * 100
 * ------
 * 200
 * ------
 * here is your TOOTHPASTE
 * 0
 * ------
 * 25
 * ------
 * 35
 * ------
 * Your change: 35
 * 0
 * ------
 * 25
 * ------
 * 35
 * ------
 * Insufficient money for SODA
 * 35
 * ------
 * 60
 * ------
 * 70
 * ------
 * 75
 * ------
 * Insufficient money for SODA
 * 75
 * ------
 * Your change: 75
 * 0
 * ------
 * Halted
 */