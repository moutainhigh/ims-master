package com.yianju.ims.server.process.service.core.dynamic;

import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/***
 * 动态类加载器管理
 */
@Service
public class DynamicClassLoaderManager {

    /**
     * classLoader集合
     */
    private volatile Map<String, DynamicClassLoader> classLoaderMap = new ConcurrentHashMap<String, DynamicClassLoader>();

    private static DynamicClassLoaderManager instance = new DynamicClassLoaderManager();

    private DynamicClassLoaderManager(){}

    public static DynamicClassLoaderManager getInstance(){
        return instance;
    }

    public Map<String, DynamicClassLoader> getClassLoaderMap() {
        return classLoaderMap;
    }

    /**
     * 添加
     * @param key
     * @param dynamicClassLoader
     */
    public void addClassLoader(String key,DynamicClassLoader dynamicClassLoader) {
        classLoaderMap.put(key,dynamicClassLoader);
    }

    /**
     * 删除
     * @param key
     */
    public void removeClassLoader(String key){
        DynamicClassLoader dynamicClassLoader = classLoaderMap.get(key);
        if(dynamicClassLoader ==null){
            return;
        }
        classLoaderMap.remove(key);
    }

    /**
     * 获取类加载器
     * @param key
     * @return
     */
    public DynamicClassLoader getDynamicClassLoader(String key){
        return classLoaderMap.get(key);
    }

    /**
     * 部署
     * @param key
     * @param jarUrl
     */
    public void deploy(String key,String jarUrl) throws MalformedURLException {

        try {
            DynamicClassLoader dynamicClassLoader = new DynamicClassLoader(new URL[]{new URL("file:" + jarUrl)},this.getClass().getClassLoader());
            this.classLoaderMap.put(key,dynamicClassLoader);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 解除部署
     * @param key
     */
    public void unDeploy(String key){
        this.classLoaderMap.remove(key);
    }
}
