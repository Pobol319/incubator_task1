package com.incubator.project.connection;

import java.sql.Connection;
import java.util.concurrent.atomic.AtomicReference;

public class ProxyConnectionFactory {
    private static final AtomicReference<ProxyConnectionFactory> instance = new AtomicReference<>();
    private ProxyConnection proxyConnection;

    ProxyConnectionFactory() {
        createProxyConnection();
    }

    public static ProxyConnectionFactory getInstance() {
        if (instance.get() == null) {
            instance.compareAndSet(null, new ProxyConnectionFactory());
        }
        return instance.get();
    }

    private void createProxyConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.create();
        proxyConnection = new ProxyConnection(connection);
    }

    public ProxyConnection getConnection() {
        return proxyConnection;
    }

}
