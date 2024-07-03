package com.chenyue.experiment.other;

import java.util.HashMap;
import java.util.Random;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/6/4
 * @description 马尔科夫链
 */
public class RandomWalk {

    public static void main(String[] args) {
        Pizza pizza = new Pizza(new int[]{2,2,2,2,2,2,2,4,4,4});
        Hamburger hamburger = new Hamburger(new int[]{1, 1, 3,3,3,3,3,3,2,2});
        Hotdog hotdog = new Hotdog(new int[]{4,4,4,4,4,1,1,1,1,1});
        HashMap<String, Object> map = new HashMap<>(3);
        map.put("pizza", pizza);
        map.put("hotdog", hotdog);
        map.put("hamburger", hamburger);
        Random random = new Random(System.currentTimeMillis());
        String name = "hamburger";
        int sum = 10000;
        for (int day = 0; day < sum; day++) {
            switch (name) {
                case "pizza":
                    Pizza o = (Pizza) map.get(name);
                    name = o.getNext(random);
                    break;
                case "hotdog":
                    Hotdog hotdog1 = (Hotdog) map.get(name);
                    name = hotdog1.getNext(random);
                    break;
                case "hamburger":
                    Hamburger hamburger1 = (Hamburger) map.get(name);
                    name = hamburger1.getNext(random);
                    break;
                default: break;
            }
        }
        System.out.printf("Prob{pizza}:%f, Prob{hotdog}: %f, Prob{Hamburger}: %f", (pizza.count * 1.0 / sum), (hotdog.count * 1.0 / sum), (hamburger.count * 1.0 / sum));
    }

    public static class Pizza {
        public int[] prob = new int[10];
        public int count = 0;

        public Pizza(int[] prob) {
            this.prob = prob;
        }

        public String getNext(Random random) {
            this.count++;
            int i = prob[random.nextInt(10)];
            if (i == 1) {
                return "pizza";
            }else  if (i == 2) {
                return "hotdog";
            } else if (i == 3) {
                return "pizza";
            }else {
                return "hamburger";
            }
        }
    }

    public static class Hamburger {
        public int[] prob;
        public int count = 0;
        public Hamburger(int[] prob) {
            this.prob = prob;
        }

        public String getNext(Random random) {
            this.count++;
            int i = prob[random.nextInt(10)];
            if (i == 1) {
                return "hamburger";
            }else  if (i == 2) {
                return "hotdog";
            } else if (i == 3) {
                return "pizza";
            }else {
                return "hamburger";
            }
        }
    }

    public static class Hotdog {
        public int[] prob = new int[10];
        public int count = 0;

        public Hotdog(int[] prob) {
            this.prob = prob;
        }

        public String getNext(Random random) {
            this.count++;
            int i = prob[random.nextInt(10)];
            if (i == 1) {
                return "hotdog";
            }else  if (i == 2) {
                return "hotdog";
            } else if (i == 3) {
                return "pizza";
            }else {
                return "hamburger";
            }
        }
    }

    public enum State {
        Hotdog(2), Pizza(3), Hamburger(4), Self(1);
        public final int flag;

        State(int flag) {
            this.flag = flag;
        }
    }
}
