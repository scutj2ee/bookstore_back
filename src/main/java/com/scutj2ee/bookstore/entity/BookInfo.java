package com.scutj2ee.bookstore.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BookInfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.book_id
     *
     * @mbg.generated
     */
    private Integer bookId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.book_category_id
     *
     * @mbg.generated
     */
    private Integer bookCategoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.store_id
     *
     * @mbg.generated
     */
    private Integer storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.outline
     *
     * @mbg.generated
     */
    private String outline;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.detail
     *
     * @mbg.generated
     */
    private String detail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.press
     *
     * @mbg.generated
     */
    private String press;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.publish_date
     *
     * @mbg.generated
     */
    private Date publishDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.size
     *
     * @mbg.generated
     */
    private String size;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.version
     *
     * @mbg.generated
     */
    private String version;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.author
     *
     * @mbg.generated
     */
    private String author;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.translator
     *
     * @mbg.generated
     */
    private String translator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.isbn
     *
     * @mbg.generated
     */
    private String isbn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.price
     *
     * @mbg.generated
     */
    private BigDecimal price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.pages
     *
     * @mbg.generated
     */
    private Integer pages;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.catalog
     *
     * @mbg.generated
     */
    private String catalog;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.market_price
     *
     * @mbg.generated
     */
    private BigDecimal marketPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.member_price
     *
     * @mbg.generated
     */
    private BigDecimal memberPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.deal_mount
     *
     * @mbg.generated
     */
    private Integer dealMount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.look_mount
     *
     * @mbg.generated
     */
    private Integer lookMount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.discount
     *
     * @mbg.generated
     */
    private BigDecimal discount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.image_url
     *
     * @mbg.generated
     */
    private String imageUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.store_mount
     *
     * @mbg.generated
     */
    private Integer storeMount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.store_time
     *
     * @mbg.generated
     */
    private Date storeTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.pack_style
     *
     * @mbg.generated
     */
    private String packStyle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.is_shelf
     *
     * @mbg.generated
     */
    private Integer isShelf;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table book_info
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.book_id
     *
     * @return the value of book_info.book_id
     *
     * @mbg.generated
     */
    public Integer getBookId() {
        return bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.book_id
     *
     * @param bookId the value for book_info.book_id
     *
     * @mbg.generated
     */
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.book_category_id
     *
     * @return the value of book_info.book_category_id
     *
     * @mbg.generated
     */
    public Integer getBookCategoryId() {
        return bookCategoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.book_category_id
     *
     * @param bookCategoryId the value for book_info.book_category_id
     *
     * @mbg.generated
     */
    public void setBookCategoryId(Integer bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.store_id
     *
     * @return the value of book_info.store_id
     *
     * @mbg.generated
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.store_id
     *
     * @param storeId the value for book_info.store_id
     *
     * @mbg.generated
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.name
     *
     * @return the value of book_info.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.name
     *
     * @param name the value for book_info.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.outline
     *
     * @return the value of book_info.outline
     *
     * @mbg.generated
     */
    public String getOutline() {
        return outline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.outline
     *
     * @param outline the value for book_info.outline
     *
     * @mbg.generated
     */
    public void setOutline(String outline) {
        this.outline = outline == null ? null : outline.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.detail
     *
     * @return the value of book_info.detail
     *
     * @mbg.generated
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.detail
     *
     * @param detail the value for book_info.detail
     *
     * @mbg.generated
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.press
     *
     * @return the value of book_info.press
     *
     * @mbg.generated
     */
    public String getPress() {
        return press;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.press
     *
     * @param press the value for book_info.press
     *
     * @mbg.generated
     */
    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.publish_date
     *
     * @return the value of book_info.publish_date
     *
     * @mbg.generated
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.publish_date
     *
     * @param publishDate the value for book_info.publish_date
     *
     * @mbg.generated
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.size
     *
     * @return the value of book_info.size
     *
     * @mbg.generated
     */
    public String getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.size
     *
     * @param size the value for book_info.size
     *
     * @mbg.generated
     */
    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.version
     *
     * @return the value of book_info.version
     *
     * @mbg.generated
     */
    public String getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.version
     *
     * @param version the value for book_info.version
     *
     * @mbg.generated
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.author
     *
     * @return the value of book_info.author
     *
     * @mbg.generated
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.author
     *
     * @param author the value for book_info.author
     *
     * @mbg.generated
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.translator
     *
     * @return the value of book_info.translator
     *
     * @mbg.generated
     */
    public String getTranslator() {
        return translator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.translator
     *
     * @param translator the value for book_info.translator
     *
     * @mbg.generated
     */
    public void setTranslator(String translator) {
        this.translator = translator == null ? null : translator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.isbn
     *
     * @return the value of book_info.isbn
     *
     * @mbg.generated
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.isbn
     *
     * @param isbn the value for book_info.isbn
     *
     * @mbg.generated
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.price
     *
     * @return the value of book_info.price
     *
     * @mbg.generated
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.price
     *
     * @param price the value for book_info.price
     *
     * @mbg.generated
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.pages
     *
     * @return the value of book_info.pages
     *
     * @mbg.generated
     */
    public Integer getPages() {
        return pages;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.pages
     *
     * @param pages the value for book_info.pages
     *
     * @mbg.generated
     */
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.catalog
     *
     * @return the value of book_info.catalog
     *
     * @mbg.generated
     */
    public String getCatalog() {
        return catalog;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.catalog
     *
     * @param catalog the value for book_info.catalog
     *
     * @mbg.generated
     */
    public void setCatalog(String catalog) {
        this.catalog = catalog == null ? null : catalog.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.market_price
     *
     * @return the value of book_info.market_price
     *
     * @mbg.generated
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.market_price
     *
     * @param marketPrice the value for book_info.market_price
     *
     * @mbg.generated
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.member_price
     *
     * @return the value of book_info.member_price
     *
     * @mbg.generated
     */
    public BigDecimal getMemberPrice() {
        return memberPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.member_price
     *
     * @param memberPrice the value for book_info.member_price
     *
     * @mbg.generated
     */
    public void setMemberPrice(BigDecimal memberPrice) {
        this.memberPrice = memberPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.deal_mount
     *
     * @return the value of book_info.deal_mount
     *
     * @mbg.generated
     */
    public Integer getDealMount() {
        return dealMount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.deal_mount
     *
     * @param dealMount the value for book_info.deal_mount
     *
     * @mbg.generated
     */
    public void setDealMount(Integer dealMount) {
        this.dealMount = dealMount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.look_mount
     *
     * @return the value of book_info.look_mount
     *
     * @mbg.generated
     */
    public Integer getLookMount() {
        return lookMount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.look_mount
     *
     * @param lookMount the value for book_info.look_mount
     *
     * @mbg.generated
     */
    public void setLookMount(Integer lookMount) {
        this.lookMount = lookMount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.discount
     *
     * @return the value of book_info.discount
     *
     * @mbg.generated
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.discount
     *
     * @param discount the value for book_info.discount
     *
     * @mbg.generated
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.image_url
     *
     * @return the value of book_info.image_url
     *
     * @mbg.generated
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.image_url
     *
     * @param imageUrl the value for book_info.image_url
     *
     * @mbg.generated
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.store_mount
     *
     * @return the value of book_info.store_mount
     *
     * @mbg.generated
     */
    public Integer getStoreMount() {
        return storeMount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.store_mount
     *
     * @param storeMount the value for book_info.store_mount
     *
     * @mbg.generated
     */
    public void setStoreMount(Integer storeMount) {
        this.storeMount = storeMount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.store_time
     *
     * @return the value of book_info.store_time
     *
     * @mbg.generated
     */
    public Date getStoreTime() {
        return storeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.store_time
     *
     * @param storeTime the value for book_info.store_time
     *
     * @mbg.generated
     */
    public void setStoreTime(Date storeTime) {
        this.storeTime = storeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.pack_style
     *
     * @return the value of book_info.pack_style
     *
     * @mbg.generated
     */
    public String getPackStyle() {
        return packStyle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.pack_style
     *
     * @param packStyle the value for book_info.pack_style
     *
     * @mbg.generated
     */
    public void setPackStyle(String packStyle) {
        this.packStyle = packStyle == null ? null : packStyle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.is_shelf
     *
     * @return the value of book_info.is_shelf
     *
     * @mbg.generated
     */
    public Integer getIsShelf() {
        return isShelf;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.is_shelf
     *
     * @param isShelf the value for book_info.is_shelf
     *
     * @mbg.generated
     */
    public void setIsShelf(Integer isShelf) {
        this.isShelf = isShelf;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_info
     *
     * @mbg.generated
     */
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