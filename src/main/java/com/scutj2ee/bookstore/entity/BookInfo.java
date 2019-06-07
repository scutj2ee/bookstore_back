package com.scutj2ee.bookstore.entity;

import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/1 10:42
 * @ Description：书本详情实体类
 * @ Modified By：
 */

public class BookInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer bookId;
    /**
     * 书本类目id
     */
    private Integer bookCategoryId;
    private BookCategory bookCategory;
    private String name;
    /**
     * 简介
     */
    private String outline;
    /**
     * 商品详情
     */
    private String detail;
    /**
     * 出版社
     */
    private String press;
    private Date publishDate;
    private String size;
    private String version;
    private String author;
    /**
     * 翻译者
     */
    private String translator;
    private String isbn;
    private Double price;
    /**
     * 总页数
     */
    private Integer pages;
    /**
     * 目录
     */
    private String catalog;
    /**
     * 市场价\定价
     */
    private Double marketPrice;
    /**
     * 会员价格
     */
    private Double memberPrice;
    /**
     * 成交量
     */
    private Integer dealMount;
    /**
     * 浏览量
     */
    private Integer lookMount;
    /**
     * 折扣
     */
    private BigDecimal discount;
    /**
     * 版面图片
     */
    private String imageUrl;
    /**
     * 库存数量
     */
    private Integer storeMount;
    /**
     * 入库时间
     */
    private Date storeTime;
    /**
     * 封装方式
     */
    private String packStyle;
    /**
     * 是否上架
     */
    private Integer isShelf;

    public BookInfo(){

    }

    public BookInfo(Integer bookId, Integer bookCategoryId, BookCategory bookCategory, String name, String outline, String detail, String press, Date publishDate, String size, String version, String author, String translator, String isbn, Double price, Integer pages, String catalog, Double marketPrice, Double memberPrice, Integer dealMount, Integer lookMount, BigDecimal discount, String imageUrl, Integer storeMount, Date storeTime, String packStyle, Integer isShelf) {
        this.bookId = bookId;
        this.bookCategoryId = bookCategoryId;
        this.bookCategory = bookCategory;
        this.name = name;
        this.outline = outline;
        this.detail = detail;
        this.press = press;
        this.publishDate = publishDate;
        this.size = size;
        this.version = version;
        this.author = author;
        this.translator = translator;
        this.isbn = isbn;
        this.price = price;
        this.pages = pages;
        this.catalog = catalog;
        this.marketPrice = marketPrice;
        this.memberPrice = memberPrice;
        this.dealMount = dealMount;
        this.lookMount = lookMount;
        this.discount = discount;
        this.imageUrl = imageUrl;
        this.storeMount = storeMount;
        this.storeTime = storeTime;
        this.packStyle = packStyle;
        this.isShelf = isShelf;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(Integer bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(Double memberPrice) {
        this.memberPrice = memberPrice;
    }

    public Integer getDealMount() {
        return dealMount;
    }

    public void setDealMount(Integer dealMount) {
        this.dealMount = dealMount;
    }

    public Integer getLookMount() {
        return lookMount;
    }

    public void setLookMount(Integer lookMount) {
        this.lookMount = lookMount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStoreMount() {
        return storeMount;
    }

    public void setStoreMount(Integer storeMount) {
        this.storeMount = storeMount;
    }

    public Date getStoreTime() {
        return storeTime;
    }

    public void setStoreTime(Date storeTime) {
        this.storeTime = storeTime;
    }

    public String getPackStyle() {
        return packStyle;
    }

    public void setPackStyle(String packStyle) {
        this.packStyle = packStyle;
    }

    public Integer getIsShelf() {
        return isShelf;
    }

    public void setIsShelf(Integer isShelf) {
        this.isShelf = isShelf;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "bookId=" + bookId +
                ", bookCategoryId=" + bookCategoryId +
                ", name='" + name + '\'' +
                ", outline='" + outline + '\'' +
                ", detail='" + detail + '\'' +
                ", press='" + press + '\'' +
                ", publishDate=" + publishDate +
                ", size='" + size + '\'' +
                ", version='" + version + '\'' +
                ", author='" + author + '\'' +
                ", translator='" + translator + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", catalog='" + catalog + '\'' +
                ", marketPrice=" + marketPrice +
                ", memberPrice=" + memberPrice +
                ", dealMount=" + dealMount +
                ", lookMount=" + lookMount +
                ", discount=" + discount +
                ", imageUrl='" + imageUrl + '\'' +
                ", storeMount=" + storeMount +
                ", storeTime=" + storeTime +
                ", packStyle='" + packStyle + '\'' +
                ", isShelf=" + isShelf +
                '}';
    }
}