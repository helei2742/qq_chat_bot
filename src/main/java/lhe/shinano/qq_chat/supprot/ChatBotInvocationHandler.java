package lhe.shinano.qq_chat.supprot;

import lhe.shinano.qq_chat.bot.ChatBot;
import lhe.shinano.qq_chat.dto.MessageInfo;
import lhe.shinano.qq_chat.interceptor.Interceptor;
import net.mamoe.mirai.event.events.FriendMessageEvent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class ChatBotInvocationHandler implements InvocationHandler {

    private final Object target;
    private final List<Interceptor> interceptors;

    public ChatBotInvocationHandler(Object target, List<Interceptor> interceptors) {
        this.target = target;
        this.interceptors = interceptors;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(!invokePreInterceptor(method, args)) {
            Object invoke = method.invoke(target, args);
            invokeAfterInterceptor(method, args);
            return invoke;
        }
        return null;
    }

    /**
     * ChatBot 中方法执行前执行拦截器的内容
     *
     * @param method method
     * @param args   args
     * @return 是否继续执行
     */
    private boolean invokePreInterceptor(Method method, Object[] args) {
        boolean b = true;

        for (Interceptor interceptor : interceptors) {
            switch (method.getName()) {
                case "whenGotFriendMessage":
                    b = interceptor.beforeGotFriendMessage((MessageInfo) args[0], (FriendMessageEvent) args[1]);
                    break;
                case "init":
                    b = interceptor.beforeBotInit();
                    break;
            }
            if (!b)break;
        }
        return false;
    }

    /**
     * ChatBot 中方法执行后执行拦截器的内容
     *
     * @param method method
     * @param args   args
     */
    private boolean invokeAfterInterceptor(Method method, Object[] args) {
        boolean b = true;

        for (Interceptor interceptor : interceptors) {
            switch (method.getName()) {
                case "whenGotFriendMessage":
                    b = interceptor.afterGotFriendMessage((MessageInfo) args[0], (FriendMessageEvent) args[1]);
                    break;
                case "init":
                    b = interceptor.afterBotInit();
                    break;
            }
            if (!b)break;
        }
        return false;
    }


    public static ChatBot warp(ChatBot target, List<Interceptor> interceptors) {
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(target.getClass());
//        enhancer.setCallback(new ChatBotInvocationHandler(target, interceptor));
//        return (AbstractChatBot) enhancer.create();
        Object o = Proxy.newProxyInstance(target.getClass().getSuperclass().getClassLoader(), target.getClass().getSuperclass().getInterfaces(), new ChatBotInvocationHandler(target, interceptors));
        return (ChatBot) o;
    }

}
