package com.sh.lynn.huang.wdaccount.been;

import com.sh.lynn.huang.wdaccount.dao.DaoSession;
import de.greenrobot.dao.DaoException;

import com.sh.lynn.huang.wdaccount.dao.InvestRecordDao;
import com.sh.lynn.huang.wdaccount.dao.PlatformDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "INVEST_RECORD".
 */
public class InvestRecord {

    private Long id;
    private double money;
    private java.util.Date tenderTime;
    private Integer calInteresttype;
    private Integer during;
    private String tenderType;
    private String tenderState;
    private Double rate;
    private String desc;
    private String fundsName;
    private String fundsCode;
    private String funds_pf;
    private String p2p_pj_name;
    private long platformId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient InvestRecordDao myDao;

    private Platform platform;
    private Long platform__resolvedKey;


    public InvestRecord() {
    }

    public InvestRecord(Long id) {
        this.id = id;
    }

    public InvestRecord(Long id, double money, java.util.Date tenderTime, Integer calInteresttype, Integer during, String tenderType, String tenderState, Double rate, String desc, String fundsName, String fundsCode, String funds_pf, String p2p_pj_name, long platformId) {
        this.id = id;
        this.money = money;
        this.tenderTime = tenderTime;
        this.calInteresttype = calInteresttype;
        this.during = during;
        this.tenderType = tenderType;
        this.tenderState = tenderState;
        this.rate = rate;
        this.desc = desc;
        this.fundsName = fundsName;
        this.fundsCode = fundsCode;
        this.funds_pf = funds_pf;
        this.p2p_pj_name = p2p_pj_name;
        this.platformId = platformId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getInvestRecordDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public java.util.Date getTenderTime() {
        return tenderTime;
    }

    public void setTenderTime(java.util.Date tenderTime) {
        this.tenderTime = tenderTime;
    }

    public Integer getCalInteresttype() {
        return calInteresttype;
    }

    public void setCalInteresttype(Integer calInteresttype) {
        this.calInteresttype = calInteresttype;
    }

    public Integer getDuring() {
        return during;
    }

    public void setDuring(Integer during) {
        this.during = during;
    }

    public String getTenderType() {
        return tenderType;
    }

    public void setTenderType(String tenderType) {
        this.tenderType = tenderType;
    }

    public String getTenderState() {
        return tenderState;
    }

    public void setTenderState(String tenderState) {
        this.tenderState = tenderState;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFundsName() {
        return fundsName;
    }

    public void setFundsName(String fundsName) {
        this.fundsName = fundsName;
    }

    public String getFundsCode() {
        return fundsCode;
    }

    public void setFundsCode(String fundsCode) {
        this.fundsCode = fundsCode;
    }

    public String getFunds_pf() {
        return funds_pf;
    }

    public void setFunds_pf(String funds_pf) {
        this.funds_pf = funds_pf;
    }

    public String getP2p_pj_name() {
        return p2p_pj_name;
    }

    public void setP2p_pj_name(String p2p_pj_name) {
        this.p2p_pj_name = p2p_pj_name;
    }

    public long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(long platformId) {
        this.platformId = platformId;
    }

    /** To-one relationship, resolved on first access. */
    public Platform getPlatform() {
        long __key = this.platformId;
        if (platform__resolvedKey == null || !platform__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlatformDao targetDao = daoSession.getPlatformDao();
            Platform platformNew = targetDao.load(__key);
            synchronized (this) {
                platform = platformNew;
            	platform__resolvedKey = __key;
            }
        }
        return platform;
    }

    public void setPlatform(Platform platform) {
        if (platform == null) {
            throw new DaoException("To-one property 'platformId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.platform = platform;
            platformId = platform.getId();
            platform__resolvedKey = platformId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}