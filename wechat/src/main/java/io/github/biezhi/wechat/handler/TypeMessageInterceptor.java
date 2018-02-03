package io.github.biezhi.wechat.handler;

import cn.ieclipse.smartim.handler.MessageInterceptor;
import cn.ieclipse.smartim.model.IMessage;
import io.github.biezhi.wechat.model.WechatMessage;

public class TypeMessageInterceptor implements MessageInterceptor {
    
    @Override
    public boolean handle(IMessage message) {
        if (message instanceof WechatMessage) {
            WechatMessage wxMsg = (WechatMessage) message;
            boolean ret = false;
            switch (wxMsg.MsgType) {
                case WechatMessage.MSGTYPE_STATUSNOTIFY:
                    ret = true;
                    break;
                default:
                    break;
            }
            return ret;
        }
        return false;
    }
}
