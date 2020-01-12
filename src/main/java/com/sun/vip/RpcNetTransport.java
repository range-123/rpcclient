package com.sun.vip;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @program: rpcclient
 * @description:
 * @author: fz
 * @create: 2020-01-12 16:48
 */
public class RpcNetTransport {
    private String host;
    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }
    public Object send(RequstObject requstObject){
        ObjectOutputStream oos = null;
        ObjectInputStream  ois = null;
        Socket socket =null;
        Object result = null;
        try {
            socket = new Socket(host,port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(requstObject);
            oos.flush();

            ois = new ObjectInputStream(socket.getInputStream());
            result=  ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
           return result;
    }
}