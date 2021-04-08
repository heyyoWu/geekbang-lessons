package org.geektimes.cache.redis;

import org.geektimes.cache.AbstractCacheManager;

import java.net.URI;
import java.util.Properties;

import javax.cache.Cache;
import javax.cache.configuration.Configuration;
import javax.cache.spi.CachingProvider;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.ByteArrayCodec;
import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.codec.StringCodec;

/**
 * {@link javax.cache.CacheManager} based on Lettuce
 */
public class LettuceCacheManager extends AbstractCacheManager {

    private final RedisClient redisClient;

    public LettuceCacheManager(CachingProvider cachingProvider, URI uri, ClassLoader classLoader, Properties properties) {
        super(cachingProvider, uri, classLoader, properties);
        this.redisClient = RedisClient.create(uri.toString());
    }

    @Override
    protected <K, V, C extends Configuration<K, V>> Cache doCreateCache(String cacheName, C configuration) {
        // RedisCodec redisCodec = new ByteArrayCodec();
        RedisCodec redisCodec = new StringCodec();
        StatefulRedisConnection<K, V> redisConnection = redisClient.connect(redisCodec);
        return new LettuceCache(this, cacheName, configuration, redisConnection);
    }

    @Override
    protected void doClose() {
        redisClient.shutdown();
    }
}
