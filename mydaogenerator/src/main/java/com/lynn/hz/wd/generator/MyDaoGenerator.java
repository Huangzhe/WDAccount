package com.lynn.hz.wd.generator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

public class MyDaoGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.sh.lynn.huang.wdaccount.been");

        addPlatform(schema);
       // addCustomerOrder(schema);F:\develop\workspace_c\priateProject\WDAccount\app\src\main\java-gen
        schema.setDefaultJavaPackageDao("com.sh.lynn.huang.wdaccount.dao");
        new DaoGenerator().generateAll(schema, "F:\\develop\\workspace_c\\priateProject\\WDAccount\\app\\src\\main\\java-gen");
    }

    private static void addPlatform(Schema schema) {

        //平台表
        Entity platform = schema.addEntity("Platform");

        platform.addIdProperty();
        platform.addStringProperty("name").notNull();
        platform.addStringProperty("address");
        platform.addStringProperty("userName");
        platform.addStringProperty("password");
        platform.addDateProperty("rechargeTime");
        platform.addStringProperty("balance");
        platform.addStringProperty("password2");
        platform.addStringProperty("describe");

//充值记录
        Entity moneyRecord = schema.addEntity("MoneyRecord");
        moneyRecord.addIdProperty();
        moneyRecord.addDoubleProperty("money").notNull();
        moneyRecord.addDateProperty("time");
        moneyRecord.addStringProperty("cardNum");
        Property platformId =    moneyRecord.addLongProperty("platformId").notNull().getProperty();
        moneyRecord.addToOne(platform,platformId);
//投资记录
        Entity tenderRecord = schema.addEntity("TenderRecord");
        tenderRecord.addIdProperty();
        tenderRecord.addDoubleProperty("money").notNull();
        tenderRecord.addDateProperty("tenderTime");

        tenderRecord.addIntProperty("calInteresttype");
        tenderRecord.addIntProperty("during");
        tenderRecord.addStringProperty("tenderType");
        tenderRecord.addStringProperty("tenderState");

        tenderRecord.addDoubleProperty("rate");
        tenderRecord.addDoubleProperty("reword");


        Property platformId2 =    tenderRecord.addLongProperty("platformId").notNull().getProperty();
        tenderRecord.addToOne(platform,platformId2);

        ToMany platformToMoner = platform.addToMany(moneyRecord, platformId);

        ToMany platformToTender = platform.addToMany(tenderRecord, platformId2);

    }
    private static void addMoneyRecord(Schema schema) {
        Entity platform = schema.addEntity("MoneyRecord");
        platform.addIdProperty();
        platform.addDoubleProperty("money").notNull();
        platform.addDateProperty("time");
        platform.addStringProperty("platformId");

    }
    private static void addCustomerOrder(Schema schema) {
        Entity customer = schema.addEntity("Customer");
        customer.addIdProperty();
        customer.addStringProperty("name").notNull();

        Entity order = schema.addEntity("Order");
        order.setTableName("ORDERS"); // "ORDER" is a reserved keyword
        order.addIdProperty();
        Property orderDate = order.addDateProperty("date").getProperty();
        Property customerId = order.addLongProperty("customerId").notNull().getProperty();
        order.addToOne(customer, customerId);

        ToMany customerToOrders = customer.addToMany(order, customerId);
        customerToOrders.setName("orders");
        customerToOrders.orderAsc(orderDate);
    }
}
