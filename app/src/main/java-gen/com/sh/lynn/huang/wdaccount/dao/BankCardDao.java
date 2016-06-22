package com.sh.lynn.huang.wdaccount.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.sh.lynn.huang.wdaccount.been.BankCard;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BANK_CARD".
*/
public class BankCardDao extends AbstractDao<BankCard, Void> {

    public static final String TABLENAME = "BANK_CARD";

    /**
     * Properties of entity BankCard.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property CardID = new Property(0, String.class, "cardID", false, "CARD_ID");
        public final static Property CardNum = new Property(1, String.class, "cardNum", false, "CARD_NUM");
        public final static Property Balance = new Property(2, String.class, "balance", false, "BALANCE");
        public final static Property BankName = new Property(3, String.class, "bankName", false, "BANK_NAME");
        public final static Property BillTime = new Property(4, java.util.Date.class, "billTime", false, "BILL_TIME");
        public final static Property CardType = new Property(5, Integer.class, "cardType", false, "CARD_TYPE");
    };


    public BankCardDao(DaoConfig config) {
        super(config);
    }
    
    public BankCardDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BANK_CARD\" (" + //
                "\"CARD_ID\" TEXT NOT NULL ," + // 0: cardID
                "\"CARD_NUM\" TEXT NOT NULL ," + // 1: cardNum
                "\"BALANCE\" TEXT," + // 2: balance
                "\"BANK_NAME\" TEXT," + // 3: bankName
                "\"BILL_TIME\" INTEGER," + // 4: billTime
                "\"CARD_TYPE\" INTEGER);"); // 5: cardType
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BANK_CARD\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, BankCard entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getCardID());
        stmt.bindString(2, entity.getCardNum());
 
        String balance = entity.getBalance();
        if (balance != null) {
            stmt.bindString(3, balance);
        }
 
        String bankName = entity.getBankName();
        if (bankName != null) {
            stmt.bindString(4, bankName);
        }
 
        java.util.Date billTime = entity.getBillTime();
        if (billTime != null) {
            stmt.bindLong(5, billTime.getTime());
        }
 
        Integer cardType = entity.getCardType();
        if (cardType != null) {
            stmt.bindLong(6, cardType);
        }
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public BankCard readEntity(Cursor cursor, int offset) {
        BankCard entity = new BankCard( //
            cursor.getString(offset + 0), // cardID
            cursor.getString(offset + 1), // cardNum
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // balance
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // bankName
            cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)), // billTime
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5) // cardType
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, BankCard entity, int offset) {
        entity.setCardID(cursor.getString(offset + 0));
        entity.setCardNum(cursor.getString(offset + 1));
        entity.setBalance(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setBankName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setBillTime(cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)));
        entity.setCardType(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(BankCard entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(BankCard entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
