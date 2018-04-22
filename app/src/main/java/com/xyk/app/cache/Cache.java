package com.xyk.app.cache;

import com.xyk.app.domian.Admin;
import com.xyk.app.util.MD5Util;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private Cache() {
        //no instance
    }

    private static Map<String, Admin> admins = new ConcurrentHashMap<>(2);

    public static boolean checkAdmin(String sessionKey) {
        if (!StringUtils.isEmpty(sessionKey) && admins.containsKey(sessionKey)) {
            return true;
        }
        return false;
    }

    public static String login(Admin admin) {
        String origin = admin.name + "a" + System.currentTimeMillis() + MD5Util.md5(admin.pwd);
        String sessionKey = Base64Utils.encodeToString(origin.getBytes());
        admins.put(sessionKey, admin);
        return sessionKey;
    }
}
