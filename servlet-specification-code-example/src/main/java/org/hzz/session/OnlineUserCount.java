package org.hzz.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class OnlineUserCount implements HttpSessionListener{
    private static final AtomicInteger totalUser = new AtomicInteger(0);
    private static final AtomicInteger onlineUser = new AtomicInteger(0);
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("================User Login=====================");
        if(se.getSession().isNew()){
            totalUser.incrementAndGet();
            onlineUser.incrementAndGet();
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("=============User Logout===================");
        onlineUser.decrementAndGet();
    }

    public static int getTotalUser() {
        return totalUser.get();
    }

    public static int getOnlineUser() {
        return onlineUser.get();
    }
}
