package com.my.java.base.bijiao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @Description: 优惠券使用限制
 * @Author: zhangyk
 * @Date: 15/12/26
 * @Time: 下午1:10
 */
public class CouponLimitModel implements Serializable {

    private static final long serialVersionUID = -1397083932110142881L;

    // 券的类型
    private int cardType;
    // 影院限制
    private Set<Integer> cinemaSet;
    // 商户限制
    private Set<Integer> merchantSet;
    // 影院组限制
    private Set<Integer> cinemaGroups;
    // 影片限制
    private Set<Integer> movieSet;
    // 新客限制
    @Deprecated
    private boolean newUser = false;
    // 新客限制 @NewCustomerEnum
    private int userType;
    // 电影版本限制
    private Set<Integer> movieDimTypeSet;
    // 价格限制 单位：分
    private int priceLimit = 0;
    // 平台限制 生效渠道
    private List<Integer> channelIds;
    // 会员卡限制
    private Set<Integer> memberCardSet;
    // 影厅限制
    private Set<String> hallSet;
    // 可用商品
    private Set<Integer> dealIds;
    // 供应商
    private Set<Integer> suppliers;
    // 场次时段限制
    private List<ShowTimeLimit> showTimeLimits;
    // 用户使用数量限制
    private int maxCountPerUser;
    // 特殊厅类型
    private Set<Integer> specialHallTypes;
    // 购买类型
    private Set<Integer> purchaseTypes;
    // 折扣卡Id
    private Set<Long> discountCardIds;
    // 演出用户类型限制
    private Set<Integer> showUserTypes;
    // 演出货源限制
    private Set<Integer> showThirdParties;
    // 演出品类限制
    private Set<Integer> showCategories;
    // 演出商品限制
    private Set<Integer> showPerformanceIds;
    // 演出排除商品限制
    private Set<Integer> showExcludePerformanceIds;
    // 城市限制（演出优惠码）
    private Set<Integer> cityIds;
    // 票档限制
    private Set<Integer> showTicketIds;
    // 关联的商品组
    private List<Integer> dealGroupIds;
    // 允许使用的演出项目组
    private List<Integer> showPerformanceGroupIds;
    // 不允许使用的演出项目组
    private List<Integer> showExcludePerformanceGroupIds;
    // 金额限制下限
    private int priceLimitLow;
    // 座位数限制类型
    private int seatLimitType;
    // 座位数限制数量
    private int seatLimitNum;
    // 最高优惠额
    private int maxDiscount;
    /***
     * 场次id限制
     */
    private Set<Integer> projectShowIds;
    // 不可用影片
    private Set<Integer> excludeMovieIds;
    /**
     * 定价券是否可以补差价，0：不可以；1：可以
     */
    private int fixCouponCanAddAmount;

    public List<ShowTimeLimit> getShowTimeLimits() {
        return showTimeLimits;
    }

    public void setShowTimeLimits(List<ShowTimeLimit> showTimeLimits) {
        this.showTimeLimits = showTimeLimits;
    }

    public Set<Integer> getCinemaGroups() {
        return cinemaGroups;
    }

    public void setCinemaGroups(Set<Integer> cinemaGroups) {
        this.cinemaGroups = cinemaGroups;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public Set<Integer> getCinemaSet() {
        return cinemaSet;
    }

    public void setCinemaSet(Set<Integer> cinemaSet) {
        this.cinemaSet = cinemaSet;
    }

    public Set<Integer> getMerchantSet() {
        return merchantSet;
    }

    public void setMerchantSet(Set<Integer> merchantSet) {
        this.merchantSet = merchantSet;
    }

    public Set<Integer> getMovieSet() {
        return movieSet;
    }

    public void setMovieSet(Set<Integer> movieSet) {
        this.movieSet = movieSet;
    }

    @Deprecated
    public boolean isNewUser() {
        return newUser;
    }

    @Deprecated
    public void setNewUser(boolean newUser) {
        this.newUser = newUser;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public Set<Integer> getMovieDimTypeSet() {
        return movieDimTypeSet;
    }

    public void setMovieDimTypeSet(Set<Integer> movieDimTypeSet) {
        this.movieDimTypeSet = movieDimTypeSet;
    }

    public int getPriceLimit() {
        return priceLimit;
    }

    public void setPriceLimit(int priceLimit) {
        this.priceLimit = priceLimit;
    }

    public Set<Integer> getMemberCardSet() {
        return memberCardSet;
    }

    public void setMemberCardSet(Set<Integer> memberCardSet) {
        this.memberCardSet = memberCardSet;
    }

    public Set<String> getHallSet() {
        return hallSet;
    }

    public void setHallSet(Set<String> hallSet) {
        this.hallSet = hallSet;
    }

    public List<Integer> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<Integer> channelIds) {
        this.channelIds = channelIds;
    }

    public Set<Integer> getDealIds() {
        return dealIds;
    }

    public void setDealIds(Set<Integer> dealIds) {
        this.dealIds = dealIds;
    }

    public Set<Integer> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Integer> suppliers) {
        this.suppliers = suppliers;
    }

    public int getMaxCountPerUser() {
        return maxCountPerUser;
    }

    public void setMaxCountPerUser(int maxCountPerUser) {
        this.maxCountPerUser = maxCountPerUser;
    }

    public Set<Integer> getSpecialHallTypes() {
        return specialHallTypes;
    }

    public void setSpecialHallTypes(Set<Integer> specialHallTypes) {
        this.specialHallTypes = specialHallTypes;
    }

    public Set<Integer> getPurchaseTypes() {
        return purchaseTypes;
    }

    public void setPurchaseTypes(Set<Integer> purchaseTypes) {
        this.purchaseTypes = purchaseTypes;
    }

    public Set<Long> getDiscountCardIds() {
        return discountCardIds;
    }

    public void setDiscountCardIds(Set<Long> discountCardIds) {
        this.discountCardIds = discountCardIds;
    }

    public Set<Integer> getShowUserTypes() {
        return showUserTypes;
    }

    public void setShowUserTypes(Set<Integer> showUserTypes) {
        this.showUserTypes = showUserTypes;
    }

    public Set<Integer> getShowThirdParties() {
        return showThirdParties;
    }

    public void setShowThirdParties(Set<Integer> showThirdParties) {
        this.showThirdParties = showThirdParties;
    }

    public Set<Integer> getShowCategories() {
        return showCategories;
    }

    public void setShowCategories(Set<Integer> showCategories) {
        this.showCategories = showCategories;
    }

    public Set<Integer> getShowPerformanceIds() {
        return showPerformanceIds;
    }

    public void setShowPerformanceIds(Set<Integer> showPerformanceIds) {
        this.showPerformanceIds = showPerformanceIds;
    }

    public Set<Integer> getShowExcludePerformanceIds() {
        return showExcludePerformanceIds;
    }

    public void setShowExcludePerformanceIds(Set<Integer> showExcludePerformanceIds) {
        this.showExcludePerformanceIds = showExcludePerformanceIds;
    }

    public Set<Integer> getCityIds() {
        return cityIds;
    }

    public void setCityIds(Set<Integer> cityIds) {
        this.cityIds = cityIds;
    }

    public Set<Integer> getShowTicketIds() {
        return showTicketIds;
    }

    public void setShowTicketIds(Set<Integer> showTicketIds) {
        this.showTicketIds = showTicketIds;
    }

    public List<Integer> getDealGroupIds() {
        return dealGroupIds;
    }

    public void setDealGroupIds(List<Integer> dealGroupIds) {
        this.dealGroupIds = dealGroupIds;
    }

    public List<Integer> getShowPerformanceGroupIds() {
        return showPerformanceGroupIds;
    }

    public void setShowPerformanceGroupIds(List<Integer> showPerformanceGroupIds) {
        this.showPerformanceGroupIds = showPerformanceGroupIds;
    }

    public List<Integer> getShowExcludePerformanceGroupIds() {
        return showExcludePerformanceGroupIds;
    }

    public void setShowExcludePerformanceGroupIds(List<Integer> showExcludePerformanceGroupIds) {
        this.showExcludePerformanceGroupIds = showExcludePerformanceGroupIds;
    }

    public int getPriceLimitLow() {
        return priceLimitLow;
    }

    public void setPriceLimitLow(int priceLimitLow) {
        this.priceLimitLow = priceLimitLow;
    }

    public int getSeatLimitType() {
        return seatLimitType;
    }

    public void setSeatLimitType(int seatLimitType) {
        this.seatLimitType = seatLimitType;
    }

    public int getSeatLimitNum() {
        return seatLimitNum;
    }

    public void setSeatLimitNum(int seatLimitNum) {
        this.seatLimitNum = seatLimitNum;
    }

    public int getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(int maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public Set<Integer> getProjectShowIds() {
        return projectShowIds;
    }

    public void setProjectShowIds(Set<Integer> projectShowIds) {
        this.projectShowIds = projectShowIds;
    }

    public Set<Integer> getExcludeMovieIds() {
        return excludeMovieIds;
    }

    public void setExcludeMovieIds(Set<Integer> excludeMovieIds) {
        this.excludeMovieIds = excludeMovieIds;
    }

    public int getFixCouponCanAddAmount() {
        return fixCouponCanAddAmount;
    }

    public void setFixCouponCanAddAmount(int fixCouponCanAddAmount) {
        this.fixCouponCanAddAmount = fixCouponCanAddAmount;
    }

    @Override
    public String toString() {
        return "CouponLimitModel{" +
                "cardType=" + cardType +
                ", cinemaSet=" + cinemaSet +
                ", merchantSet=" + merchantSet +
                ", cinemaGroups=" + cinemaGroups +
                ", movieSet=" + movieSet +
                ", newUser=" + newUser +
                ", userType=" + userType +
                ", movieDimTypeSet=" + movieDimTypeSet +
                ", priceLimit=" + priceLimit +
                ", channelIds=" + channelIds +
                ", memberCardSet=" + memberCardSet +
                ", hallSet=" + hallSet +
                ", dealIds=" + dealIds +
                ", suppliers=" + suppliers +
                ", maxCountPerUser=" + maxCountPerUser +
                ", specialHallTypes=" + specialHallTypes +
                ", purchaseTypes=" + purchaseTypes +
                ", discountCardIds=" + discountCardIds +
                ", showUserTypes=" + showUserTypes +
                ", showThirdParties=" + showThirdParties +
                ", showCategories=" + showCategories +
                ", showPerformanceIds=" + showPerformanceIds +
                ", showExcludePerformanceIds=" + showExcludePerformanceIds +
                ", cityIds=" + cityIds +
                ", showTicketIds=" + showTicketIds +
                ", dealGroupIds=" + dealGroupIds +
                ", showPerformanceGroupIds=" + showPerformanceGroupIds +
                ", showExcludePerformanceGroupIds=" + showExcludePerformanceGroupIds +
                ", priceLimitLow=" + priceLimitLow +
                ", seatLimitType=" + seatLimitType +
                ", seatLimitNum=" + seatLimitNum +
                ", maxDiscount=" + maxDiscount +
                ", projectShowIds=" + projectShowIds +
                ", fixCouponCanAddAmount=" + fixCouponCanAddAmount +
                ", excludeMovieIds=" + excludeMovieIds +
                '}';
    }
}
