package cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
/**
 * @author devdws
 * @version Id: Cachefresh.java, v 0.1  2019/7/23 19:11 devdws Exp $$
 */

public class Cachefresh {

    class CacheBO {

        private Map<String, String> itmMap = new ConcurrentHashMap<String, String>();

        //金额指针
        private Map<String, String> amtMap = new ConcurrentHashMap<String, String>();


    }


    public void fresh() {


        CacheBuilder.newBuilder()
                .concurrencyLevel(8)
                .initialCapacity(10)
                .maximumSize(10000)
                .build(new AccountItemCacheLoader())
        ;

    }


    public static class AccountItemCacheLoader extends CacheLoader<String, CacheBO> {


        public CacheBO load(String s) throws Exception {
            return null;
        }
    }

}
