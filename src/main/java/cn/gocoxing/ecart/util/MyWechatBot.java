package cn.gocoxing.ecart.util;

import io.github.biezhi.wechat.WeChatBot;
import io.github.biezhi.wechat.api.annotation.Bind;
import io.github.biezhi.wechat.api.constant.Config;
import io.github.biezhi.wechat.api.enums.MsgType;
import io.github.biezhi.wechat.api.model.WeChatMessage;
import io.github.biezhi.wechat.utils.StringUtils;

public class MyWechatBot extends WeChatBot {
    
    public MyWechatBot(Config config) {
        super(config);
    }
    
    @Bind(msgType = MsgType.TEXT)
    public void handleText(WeChatMessage message) {
        if (StringUtils.isNotEmpty(message.getName())) {
            System.out.println("接收到 ["+ message.getName() +"] 的消息: " + message.getText() );
            //this.sendMsg(message.getFromUserName(), "自动回复: " + message.getText());
        }
    }
    
    @Override
    protected void other() {
    	// TODO Auto-generated method stub
    	//super.other();
    }
    
    public static void main(String[] args) {
        new MyWechatBot(Config.me().autoLogin(true)).start();
    }
    
}