package com.scutj2ee.bookstore.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BookInfo implements Serializable {
    private Integer bookId;
    private Integer bookCategoryId;
    private Integer storeId;
    private String name;
    private String outline;
    private String detail;
    private String press;
    private Date publishDate;
    private String size;
    private String version;
    private String author;
    private String translator;
    private String isbn;
    private Double price;
    private Integer pages;
    private String catalog;
    private Double marketPrice;
    private Double memberPrice;
    private Integer dealMount;
    private Integer lookMount;
    private Double discount;
    private String imageUrl;
    private Integer storeMount;
    private Date storeTime;
    private String packStyle;
    private Integer isShelf;

    private static final long serialVersionUID = 1L;

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

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bookId=").append(bookId);
        sb.append(", bookCategoryId=").append(bookCategoryId);
        sb.append(", storeId=").append(storeId);
        sb.append(", name=").append(name);
        sb.append(", outline=").append(outline);
        sb.append(", detail=").append(detail);
        sb.append(", press=").append(press);
        sb.append(", publishDate=").append(publishDate);
        sb.append(", size=").append(size);
        sb.append(", version=").append(version);
        sb.append(", author=").append(author);
        sb.append(", translator=").append(translator);
        sb.append(", isbn=").append(isbn);
        sb.append(", price=").append(price);
        sb.append(", pages=").append(pages);
        sb.append(", catalog=").append(catalog);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", memberPrice=").append(memberPrice);
        sb.append(", dealMount=").append(dealMount);
        sb.append(", lookMount=").append(lookMount);
        sb.append(", discount=").append(discount);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", storeMount=").append(storeMount);
        sb.append(", storeTime=").append(storeTime);
        sb.append(", packStyle=").append(packStyle);
        sb.append(", isShelf=").append(isShelf);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}