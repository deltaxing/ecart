package cn.gocoxing.ecart.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseEcMarket<M extends BaseEcMarket<M>> extends Model<M> implements IBean {

	public M setMarketID(java.lang.Integer MarketID) {
		set("MarketID", MarketID);
		return (M)this;
	}
	
	public java.lang.Integer getMarketID() {
		return getInt("MarketID");
	}

	public M setMarketName(java.lang.String MarketName) {
		set("MarketName", MarketName);
		return (M)this;
	}
	
	public java.lang.String getMarketName() {
		return getStr("MarketName");
	}

}
