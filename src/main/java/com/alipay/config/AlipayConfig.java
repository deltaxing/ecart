
package com.alipay.config;

public class AlipayConfig {
	// 商户appid
	public static String APPID = "2017100909212929";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC9zE/JSBupf5tW2Rz/Zp5KYLtgVgVqxzfZp1UMWgdKcwNqMnQfGRYZS4yRYbBkRgmgd8oMLKLPVWNFsfUpVocpKWM4d+JbocT5OGMmucC8lslZzzfjvXS2XDYAiM312Ubihk6GepzIRwxwRbki42+QRCkQ8sQxrxKvK7+gVX+UQdHR9junkEn78IQinNXpAbPbk0c1tXMQExRUB9aa+fKdpnypM5amqAkt8/Sc/cN4udUDKNomwka4uYjaBgXNPo9PFgIRSfhqif0A9YJNoLSDqd8lXv51EMcnsLpdOQ9fS7DUzivui2k/Bp5RS06o/oLTsE1kRDpu6Prk/FD0NFD5AgMBAAECggEBAKCp9BxKCwiHecKh1Vcp0fLaQaOCDeHetBtt96OWDjfqdkiOXxf4D2noNxzWGhA37WxGGuYFXuitunRD+Wk90vp4C4LAkP/KR8hEAELG2S2LYvTAYepJ9SNtmVUIeXiUrdmRoaVa457x7ciYbOjoqAbye+TZ7FS2g9V+7h7WYUHopHlzQBn89bOuM8sYDjImhGdQm/otl4UQVuzp1WusflQQUenUmun2M4D1kmYAKfdgJ2upG6VNWDjn9e1pgmdsxue89s8nWxC4gLSQe4LPmoed/f4dT8JHcDo3iByt+BMzRon3+TZ5pZFbtHfEs0u/IcYTj3jsq7jNOioMWDswyIUCgYEA3IBehlwkjh8VTPcK1l9EkSGHA83wVHSngi7IZ7VffNELdcAxQ6rWgMSobiBM8djuncWUKHQ4YYqDkthfpRXsfVEAx69rpvMQ5zASafxT13NgTrTNxmCqj1JQrNovteCcb7DMLsaETo/EbAf8snUxfq+Foncjt6Wxxs+RjkndQx8CgYEA3FqM+OV0EbCfNe1yFmEFhWnr1e+a6qBGe+b+jSpz1PsAat1ebTggC/5mMhWzfaWGRWdEGZwpsZ3c7Ko4mozci8kxHHFV5xLn8U43ev9ygKzZ5i1WO2+zjPMzMrVk+zlUzm1TWfKhDcca7Xjtnf7OQB6yaR70N7qDlU5J6IebQOcCgYA2iSVX09hSskthYsRyatOZlZJAFaI4MTXw08NLKye3xjgwYl2M3+b3qCwEOMbvFflGWkSfkMcVEN4j5pIZUYfRIsSvnqpge0OV+mTDg930rpuGO9+dDfGBSxma9sfQEwJ9+Vs2wnCcwaASHBOay7N3ItBJc3AJDtkeU94rNAeefwKBgFfSnyz0Bnamdk3//OB+erzZomz5ujyY9H6dagbJTLEt+NSetevB2sPs+L4teAQz3Hf82F98pgFscYjBrx2p1py/6xry8NHP7zF1gxc6iGBQg+gBWcUGmAEtTNKBCWY3S12apQXMdfQPzuOmts2pqHpVwbWz6JHtfFQdh8dthKsxAoGBANrODb/5BRTIbIBR0jstPKanCiP0WdB73uAsMx3qKe3pX3SJhbt8y97AS9gSY/tJpHsfOiGVveM6cCuk1EHMM4iYea6qObXmfrmOPjA5hCnBh02HxYH4rubGuajFOi6kxaZU89i8wKhcRb7NW/ohojBwZrIrJbBbzSKvaq6SpG3i";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "https://www.gocoxing.cn/ecart/pay/notify_url_zfb.jsp";//"http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	public static String return_url = "https://www.gocoxing.cn/ecart/pay/return_url_zfb.jsp";//"http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/return_url.jsp";
	// 请求网关地址
	public static String URL = "https://openapi.alipay.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoD0wtmOxhQviwlIWostygamuRzj8ThtJILdp4eQqL2Kjf6cX2ioGDWd6s6voSN/xs13qS6apD21ZKEdvuOq+nM+85Jxi1A6YPo8hvOAga/dC2zky4PEyRy4fMOlp08prpyJC8vB6hPV8FsiiDjB+PosBTY87tqZki1z0GTy3daiXT/vYzQokwotsaFUNNCLaNGBTx2uqIqQ5GACdEcKaLKtbZrWoILw/HcaTr8S/8DKEkuMN4DVLtQOhVscMl0VptxfWFKBBygMrbEHCA4nsE7wN1C6hikN4Ndrq/DeP/KKakeUn/tn+E9+mYtf6PQQQV9SZlY0M5bT2gHgpd8PczQIDAQAB";
	                                 //demo //MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjrEVFMOSiNJXaRNKicQuQdsREraftDA9Tua3WNZwcpeXeh8Wrt+V9JilLqSa7N7sVqwpvv8zWChgXhX/A96hEg97Oxe6GKUmzaZRNh0cZZ88vpkn5tlgL4mH/dhSr3Ip00kvM4rHq9PwuT4k7z1DpZAf1eghK8Q5BgxL88d0X07m9X96Ijd0yMkXArzD7jg+noqfbztEKoH3kPMRJC2w4ByVdweWUT2PwrlATpZZtYLmtDvUKG/sOkNAIKEMg3Rut1oKWpjyYanzDgS7Cg3awr1KPTl9rHCazk15aNYowmYtVabKwbGVToCAGK+qQ1gT3ELhkGnf3+h53fukNqRH+wIDAQAB";
	                          //sfshop      //MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoD0wtmOxhQviwlIWostygamuRzj8ThtJILdp4eQqL2Kjf6cX2ioGDWd6s6voSN/xs13qS6apD21ZKEdvuOq+nM+85Jxi1A6YPo8hvOAga/dC2zky4PEyRy4fMOlp08prpyJC8vB6hPV8FsiiDjB+PosBTY87tqZki1z0GTy3daiXT/vYzQokwotsaFUNNCLaNGBTx2uqIqQ5GACdEcKaLKtbZrWoILw/HcaTr8S/8DKEkuMN4DVLtQOhVscMl0VptxfWFKBBygMrbEHCA4nsE7wN1C6hikN4Ndrq/DeP/KKakeUn/tn+E9+mYtf6PQQQV9SZlY0M5bT2gHgpd8PczQIDAQAB
	                            //on web    //MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAj2loMvw06Q7ENphqLI/L/zMq+GbybavY6/zrmMvI3Jbk/U2D/CYRnBwPM0iLvOu1Y/sILeDtsQc7jeKPBYwOWnbO0eXYe6WnEuKSzj1zR+Za2Z4aBBKx/oIp99qvAE6oTk+LtQB5adcvrlLEiiyjD5Ilips+lr7A01AnWeIJ2hlXnDDmWUiMLCFzb6XXovuT2Hl/DqJBO3EAgMlfXSdtpWB41ppXIepIrdmL0hq/Vgvv6sAuqBYqjg+1gaEo6sq9Ev8JRqgCkQJsmhkwz206EBAtAkV4WCQN3tFEvtUBxiCRuNaoObPD+e7S1VTjFzCEyOKIl/RTQpRqhC0SvdyyxQIDAQAB
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
	
	
}
