package com.yianju.ims.server.process.service.core.dynamic;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态类加载器
 */
public class DynamicClassLoader extends URLClassLoader {


    private static boolean closable = false;
    private List<JarURLConnection> cachedJarFiles;

    public List<JarURLConnection> getCachedJarFiles() {
        return cachedJarFiles;
    }

    static {
        // 1.7之后可以直接调用close方法关闭打开的jar，需要判断当前运行的环境是否支持close方法，如果不支持，需要缓存，避免卸载模块后无法删除jar
        try {
            URLClassLoader.class.getMethod("close");
            closable = true;
        } catch (NoSuchMethodException e) {
        } catch (SecurityException e) {
        }
    }


    public DynamicClassLoader(URL[] urls, ClassLoader parent) {
        super(new URL[] {}, parent);
        init(urls);
    }

    public DynamicClassLoader(URL[] urls) {
        super(new URL[] {});
        init(urls);
    }

    public DynamicClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(new URL[] {}, parent, factory);
        init(urls);
    }

    private void init(URL[] urls) {
        cachedJarFiles = new ArrayList<JarURLConnection>();
        if (urls != null) {
            for (URL url : urls) {
                this.addURL(url);
            }
        }
    }

    @Override
    protected void addURL(URL url) {
        if (!closable) {
            try {
                // 打开并缓存文件url连接
                URLConnection uc = url.openConnection();
                if (uc instanceof JarURLConnection) {
                    uc.setUseCaches(true);
                    ((JarURLConnection) uc).getManifest();
                    cachedJarFiles.add((JarURLConnection) uc);
                }
            } catch (Exception e) {
            }
        }
        super.addURL(url);
    }

    public void close() throws IOException {
        if (closable) {
            try {
                close();
            } catch (IOException ioe) {
            }
        } else {
            for (JarURLConnection conn : cachedJarFiles) {
                conn.getJarFile().close();
            }
            cachedJarFiles.clear();
        }
    }


}
