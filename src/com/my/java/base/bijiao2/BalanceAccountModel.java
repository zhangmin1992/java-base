package com.my.java.base.bijiao2;

import java.io.Serializable;
import java.util.List;

public class BalanceAccountModel implements Serializable, Comparable<BalanceAccountModel> {

    private long userId;
    private int amount;
    private int coinType;
    private int expireType;
    private long expireTime;
    private long createTime;
    private int accountType;
    private String name;
    private List<Integer> cityIds;
    private List<Integer> cinemas;
    private List<Integer> cinemaGroups;

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCoinType() {
        return coinType;
    }

    public void setCoinType(int coinType) {
        this.coinType = coinType;
    }

    public int getExpireType() {
        return expireType;
    }

    public void setExpireType(int expireType) {
        this.expireType = expireType;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getCityIds() {
        return cityIds;
    }

    public void setCityIds(List<Integer> cityIds) {
        this.cityIds = cityIds;
    }

    public List<Integer> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<Integer> cinemas) {
        this.cinemas = cinemas;
    }

    public List<Integer> getCinemaGroups() {
        return cinemaGroups;
    }

    public void setCinemaGroups(List<Integer> cinemaGroups) {
        this.cinemaGroups = cinemaGroups;
    }

    @Override
    public String toString() {
        return "BalanceAccountModel{" +
                "userId=" + userId +
                ", amount=" + amount +
                ", coinType=" + coinType +
                ", expireType=" + expireType +
                ", expireTime=" + expireTime +
                ", accountType=" + accountType +
                ", name='" + name + '\'' +
                ", cityIds=" + cityIds +
                ", cinemas=" + cinemas +
                ", cinemaGroups=" + cinemaGroups +
                '}';
    }

    @Override
    public int compareTo(BalanceAccountModel model) {
        if (this == model) {
            return 0;
        }
        if (model.getAmount() != this.getAmount()) {
            return model.getAmount() - this.getAmount();
        }
        if (model.getCreateTime() > this.getCreateTime()) {
            return -1;
        }else {
            return 1;
        }

//        return model.getAmount() - this.getAmount();
    }
}
