package com.swasth.smartlaundry.constraints;

import java.io.Serializable;

public class CommonConstants implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5193241110336092393L;

	public static final String USERTYPE_PREFIX = "ut_";
	public static final String USER_PREFIX = "cust_";
	public static final String SHOP_PREFIX = "sh_";
	public static final String EMP_PREFIX = "emp_";// employee
	public static final String ITEMS_PREFIX = "it_";
	public static final String ADDRESS_PREFIX = "ad_";
	public static final String ORDER_PREFIX = "uo_";
	public static final String ORDERGRID_PREFIX = "ug_";
	public static final String EMP_ORDER_HIS_PREFIX = "eoh_";
	public static final String EMP_ORDERGRID_PREFIX = "eug_";
	public static final String USER_ORDER_ITEM_PREFIX = "uoi_";
	public static final String TRANSACTION_PREFIX = "ot_";
	public static final String PRICING_MAPPING_PREFIX = "ipm_";
	public static final String ADMIN_PREFIX = "adm_";
	public static final String SHOP_VERIFICATION_PREFIX = "sv_";
	public static final String PRICING_KG_MAPPING_PREFIX = "ipkg_";
	public static final int NOTIFICATION_OTHER = 1;
	public static final int NOTIFICATION_ORDER = 2;


	public static enum OrderStatus {
		shipped, processing, arrived, pickup, ongoing, completed, delivered, assigned, cancelled, packed
	}

	public static enum PaymentTypes {
		online, cash
	}

	public CommonConstants() {

	}
}
