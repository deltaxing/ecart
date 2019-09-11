package cn.gocoxing.ecart.index;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;

import cn.gocoxing.ecart.common.model.EcGoods;
import cn.gocoxing.ecart.common.model.EcGoodsInCart;

import cn.gocoxing.ecart.util.*;
import io.github.biezhi.wechat.api.constant.Config;
import com.alibaba.fastjson.*;
/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * IndexController
 */
public class IndexController extends Controller {
	public void index() {
		render("/index/index.html");
	}
	
	public void Getutf() {
		String str = getPara("WIDsubject");
		renderText(str);
	}
	
	public void GetGoodsInCart() {
		String CartID = getPara("CartID");
		List<EcGoodsInCart> goods = EcGoodsInCart.dao.find("select *, 11 as xing from ec_goods_in_cart gic left join ec_goods g on gic.GoodsID = g.GoodsID "
				+ " where gic.CartID = ? ", CartID);
		double TotalPrice = 0;
		for(int i = 0; i < goods.size(); i++) {
			TotalPrice += goods.get(i).getGoodsPrice() == null  ? 0 : goods.get(i).getGoodsPrice() * goods.get(i).getQuantity();
		}
		
		Map<String,Object> res = new HashMap<String,Object>();
		res.put("TotalPrice", TotalPrice);
		res.put("GoodsList", goods);
		
//		Logger  logger = Logger.getLogger(this.getClass());
//		logger.setLevel(Level.INFO);
//		logger.info("Loger.info xing");
//		logger.warn("logger.warn xing");
		
		renderJson(res);
	}
	
	public void PutInGoods() {
		try {
			long Barcode = getParaToLong("Barcode");
			String CartID = getPara("CartID");
			List<EcGoods> goods = EcGoods.dao.find("select GoodsID from ec_goods g "
					+ " where g.Barcode = ? ", Barcode);
			int goodsID = 0;
			if(goods.size()>0) {
				goodsID = goods.get(0).getGoodsID();
			}else {
				String res = HttpKit.get("http://api.jisuapi.com/barcode2/query?appkey=739c7e01ca35adf7&barcode="+Barcode);
				JSONObject jsonRes = JSON.parseObject(res);
				if(!jsonRes.getString("msg").equals("ok")) {
					
					EcGoodsInCart newGoodsInChart = new EcGoodsInCart();
					newGoodsInChart.setCartID(CartID)
					.setGoodsID(1014)
					.setQuantity(1.0)
					.setGoodsStatus(1)
					.setPutInTime(new Date());
					
					if(!newGoodsInChart.save())
						renderText("EcGoodInChartSaveFailed");
					//renderText("success");
					
					renderText("GoodsNotFound");
					return;
				}
				JSONObject jsObject = jsonRes.getJSONObject("result");
				String strPrice = jsObject.getString("price").replace("￥", "");
				if(strPrice.isEmpty()) 
					strPrice = "0.1";
				
				EcGoods newGoods = new EcGoods();
				newGoods.setGoodsName(jsObject.getString("name"))
				.setGoodsPrice(Double.parseDouble(strPrice))
				.setGoodsPic(jsObject.getString("pic"))
				.setGoodsUnit(jsObject.getString("packagetype"))
				.setBarcode(Barcode);
				if(!newGoods.save()) {
					renderText("EcGoodsSaveFailed");
				};
				goodsID = newGoods.getGoodsID();
			}
			
			EcGoodsInCart newGoodsInChart = new EcGoodsInCart();
			newGoodsInChart.setCartID(CartID)
			.setGoodsID(goodsID)
			.setQuantity(1.0)
			.setGoodsStatus(1)
			.setPutInTime(new Date());
			
			if(!newGoodsInChart.save())
				renderText("EcGoodInChartSaveFailed");
			renderText("success");
			
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			renderText(errors.toString());
		}
		
	}
	
	public void SendEmail() {
		try {
			new email().main(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		renderText("success");
	};
	
	private MyWechatBot myWechatBot;
	public void LoginMyWechat() {
		//System.setProperty("user.dir", getRequest().getServletContext().getRealPath("/"));
		myWechatBot = new MyWechatBot(Config.me()
				.assetsDir(getRequest().getServletContext().getRealPath("/")+ "/assets")
				.autoLogin(true)
				.showTerminal(true));
		
		final String xing = "hhehehe";
		new Thread("MyWechatBotLoginThread") {
			public void run() {
				System.out.println(xing);
				//myWechatBot.api().login(true);
				myWechatBot.start();
				new File(myWechatBot.config().assetsDir() + "/qrcode.png").delete();
			};
		}.start();
		
		while(!new File(myWechatBot.config().assetsDir() + "/qrcode.png").exists()) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("heheddd");
		render("/util/loginWechatBot.html");
	}
	
}


// http://api.jisuapi.com/barcode2/query?appkey=739c7e01ca35adf7&barcode=6900067110206