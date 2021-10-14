package com.my.java.base.bijiao;

import java.io.Serializable;
import java.util.Set;

public class ShowTimeLimit implements Serializable {
    private static final long serialVersionUID = 1840741948085175335L;
    // 开始时间(时段时间限制)
    private int startTime;
    // 结束时间(时段时间限制)
    private int endTime;
    // 周几限制
    private Set<Integer> weekSet;
    // 法定节假日限制
    private boolean holidayLimit;
    // 调休日限制
    private boolean shiftdayLimit;
    // 开始日期(天级时间限制)
    private long startDate;
    // 结束日期(天级时间限制)
    private long endDate;

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public Set<Integer> getWeekSet() {
        return weekSet;
    }

    public void setWeekSet(Set<Integer> weekSet) {
        this.weekSet = weekSet;
    }

    public boolean isHolidayLimit() {
        return holidayLimit;
    }

    public void setHolidayLimit(boolean holidayLimit) {
        this.holidayLimit = holidayLimit;
    }

    public boolean isShiftdayLimit() {
        return shiftdayLimit;
    }

    public void setShiftdayLimit(boolean shiftdayLimit) {
        this.shiftdayLimit = shiftdayLimit;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ShowTimeLimit{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", weekSet=" + weekSet +
                ", holidayLimit=" + holidayLimit +
                ", shiftdayLimit=" + shiftdayLimit +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
