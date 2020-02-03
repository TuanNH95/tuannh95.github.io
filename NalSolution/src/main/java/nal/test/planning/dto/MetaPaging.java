package nal.test.planning.dto;

public class MetaPaging {
    private int pageNum;
    private int limit;
    private int totalShow;
    private int totalRecords;

    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
    public int getTotalRecords() {
        return totalRecords;
    }
    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }
    public int getTotalShow() {
        return totalShow;
    }
    public void setTotalShow(int totalShow) {
        this.totalShow = totalShow;
    }
}
