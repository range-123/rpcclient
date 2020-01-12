package com.sun.vip;

import java.lang.reflect.Proxy;

/**
 * @program: rpcclient
 * @description: 客户端
 * @author: fz
 * @create: 2020-01-12 16:33
 */
public class RpcClient {
    public  <T> T clientProxy(final Class<T> interfaceCls,final String host,final int port){
         return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls}, new RemotoInvocation(host, port));
    }
}