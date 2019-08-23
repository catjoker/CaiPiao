package com.BASofttech.caipiao.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 所有随机数彩票的计算
 */
public class RandomCalculate {

    public String printCP(String type) {
        SecureRandom r = new SecureRandom();
        List<Integer> list = redBall(type, r);
        ArrayList<Integer> blueBall = blueBall(type, r);
        StringBuffer sb = new StringBuffer();
        String printBall = printFormat(type, sb, list, blueBall);
        list.clear();
        blueBall.clear();
        return printBall;
    }

    //打印排序
    private String printFormat(String type, StringBuffer sb, List<Integer> redBall, ArrayList<Integer> blueBall) {
        for (int i = 0; i < redBall.size(); i++) {
            if (i == redBall.size() - 1) {
                if (Constant.DCB_NAME.equals(type)) {
                    sb.append(redBall.get(i) + " + ");
                } else {
                    sb.append(redBall.get(i) + " ");
                }
            } else {
                // 如果所得的数加上空格长度还不到3那么就在这个数前面加个0,蓝球同此
                if ((redBall.get(i) + " ").length() < 3) {
                    sb.append("0" + redBall.get(i) + " ");
                } else {
                    sb.append(redBall.get(i) + " ");
                }
            }
        }
        switch (type) {
            case Constant.SEVEN_NAME:
                break;
            default:
                for (int i = 0; i < blueBall.size(); i++) {
                    if ((blueBall.get(i) + " ").length() < 3) {
                        sb.append("0" + blueBall.get(i) + " ");
                    } else {
                        sb.append(blueBall.get(i) + " ");
                    }
                }
                break;
        }
        return sb.toString();
    }

    //红球
    private List<Integer> redBall(String type, SecureRandom r1) {
        HashSet<Integer> set = new HashSet<>();
        switch (type) {
            case Constant.DCB_NAME:
                while (set.size() < 6) {
                    set.add(getRandom(r1, 33));
                }
                break;
            case Constant.DLT_NAME:
                while (set.size() < 5) {
                    set.add(getRandom(r1, 35));
                }
                break;
            case Constant.SEVEN_NAME:
                while (set.size() < 7) {
                    set.add(getRandom(r1, 30));
                }
                break;
        }
        return orderList(set);
    }

    //排序
    private ArrayList<Integer> orderList(HashSet<Integer> set) {
        ArrayList<Integer> list = new ArrayList();
        for (Integer i : set) {
            list.add(i);
        }
        Collections.sort(list);
        return list;
    }

    private ArrayList<Integer> blueBall(String type, SecureRandom r) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        switch (type) {
            case Constant.DCB_NAME:
                list.add(getRandom(r, 16));
                Collections.sort(list);
                break;
            case Constant.DLT_NAME:
                while (set.size() < 2) {
                    set.add(getRandom(r, 12));
                }
                list = orderList(set);
                break;
            case Constant.SEVEN_NAME:
                break;
        }
        return list;
    }

    private int getRandom(SecureRandom r, int randomNum) {
        return r.nextInt(randomNum) + 1;
    }
}
