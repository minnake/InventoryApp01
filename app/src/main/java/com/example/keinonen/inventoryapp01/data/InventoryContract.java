package com.example.keinonen.inventoryapp01.data;

import android.provider.BaseColumns;

public final class InventoryContract {

    private InventoryContract(){
    }

    public static final class InventoryEntry implements BaseColumns {
        public final static String TABLE_NAME = "inventory";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PRODUCT_NAME = "name";
        public final static String COLUMN_PRODUCT_PRICE = "price";
        public final static String COLUMN_PRODUCT_QUANTITY = "quantity";
        public final static String COLUMN_PRODUCT_SUPPLIER = "supplier";
        public final static String COLUMN_PRODUCT_PHONENUMBER = "phone number";

        public final static int SUPPLIER_UNKNOWN = 0;
        public final static int SUPPLIER_EBAY = 1;
        public final static int SUPPLIER_MARKET = 2;
    }
}
