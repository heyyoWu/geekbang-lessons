package org.geektimes.cache.redis;

import org.geektimes.cache.AbstractCache;

import java.io.Serializable;
import java.util.Iterator;

import javax.cache.CacheException;
import javax.cache.CacheManager;
import javax.cache.configuration.Configuration;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class LettuceCache<K extends Serializable, V extends Serializable> extends AbstractCache<K, V> {

    private final StatefulRedisConnection<K, V> redisConnection;

    public LettuceCache(CacheManager cacheManager, String cacheName,
                        Configuration<K, V> configuration, StatefulRedisConnection<K, V> redisConnection) {
        super(cacheManager, cacheName, configuration);
        this.redisConnection = redisConnection;
    }

    @Override
    protected V doGet(K key) throws CacheException, ClassCastException {
        RedisCommands<K, V> redisCommands = redisConnection.sync();
        return redisCommands.get(key);
    }

    @Override
    protected V doPut(K key, V value) throws CacheException, ClassCastException {
        RedisCommands<K, V> redisCommands = redisConnection.sync();
        return redisCommands.getset(key, value);
    }

    @Override
    protected V doRemove(K key) throws CacheException, ClassCastException {
        RedisCommands<K, V> redisCommands = redisConnection.sync();
        V oldValue = redisCommands.get(key);

        redisCommands.del(key);

        return oldValue;
    }

    @Override
    protected void doClear() throws CacheException {

    }

    @Override
    protected Iterator<Entry<K, V>> newIterator() {
        return null;
    }

    @Override
    protected void doClose() {
        this.redisConnection.close();
    }
}
