package com.sun.vip;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: rpcclient
 * @description:
 * @author: fz
 * @create: 2020-01-12 16:37
 */
public class RemotoInvocation implements InvocationHandler {
    private String host;
    private int port;

    public RemotoInvocation(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RequstObject object =new RequstObject();
        object.setClassName(method.getDeclaringClass().getName());
        object.setMethodName(method.getName());
        object.setParametes(args);
        RpcNetTransport rpcNetTransport =new RpcNetTransport(host,port);
        rpcNetTransport.send(object);

        return null;
    }
}