package com.sh.lynn.huang.wdaccount.been;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "BANK_CARD_RECORD".
 */
public class BankCardRecord {

    private Long id;
    /** Not-null value. */
    private String userName;
    /** Not-null value. */
    private String cardID;
    private String money;
    private String descripe;
    private java.util.Date time;
    private Integer type;

    public BankCardRecord() {
    }

    public BankCardRecord(Long id) {
        this.id = id;
    }

    public BankCardRecord(Long id, String userName, String cardID, String money, String descripe, java.util.Date time, Integer type) {
        this.id = id;
        this.userName = userName;
        this.cardID = cardID;
        this.money = money;
        this.descripe = descripe;
        this.time = time;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getUserName() {
        return userName;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /** Not-null value. */
    public String getCardID() {
        return cardID;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDescripe() {
        return descripe;
    }

    public void setDescripe(String descripe) {
        this.descripe = descripe;
    }

    public java.util.Date getTime() {
        return time;
    }

    public void setTime(java.util.Date time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
