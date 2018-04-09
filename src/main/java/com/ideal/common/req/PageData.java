package com.ideal.common.req;

import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * Created by xingxiao on 2017/11/13 0013.
 */
public class PageData extends HashMap{
    private static final long serialVersionUID = 1L;
    Map map = null;
    HttpServletRequest request;

    public PageData(HttpServletRequest request, int type) {
        this.request = request;
        if (type != 0 && type != 2) {
            if (type == 1 || type == 2) {
                try {
                    String str = IOUtils.toString(request.getInputStream());
                    System.out.println(str);
                } catch (IOException var12) {
                    var12.printStackTrace();
                }
            }
        } else {
            Map properties = request.getParameterMap();
            Map returnMap = new HashMap();
            Iterator entries = properties.entrySet().iterator();
            String name = "";

            for(String value = ""; entries.hasNext(); returnMap.put(name, value)) {
                Map.Entry entry = (Map.Entry)entries.next();
                name = (String)entry.getKey();
                Object valueObj = entry.getValue();
                if (valueObj == null) {
                    value = "";
                } else if (!(valueObj instanceof String[])) {
                    value = valueObj.toString();
                } else {
                    String[] values = (String[])valueObj;

                    for(int i = 0; i < values.length; ++i) {
                        value = values[i] + ",";
                    }

                    value = value.substring(0, value.length() - 1);
                }
            }

            this.map = returnMap;
        }

    }

    public PageData() {
        this.map = new HashMap();
    }

    public Object get(Object key) {
        Object obj = null;
        if (this.map.get(key) instanceof Object[]) {
            Object[] arr = (Object[])this.map.get(key);
            obj = this.request == null ? arr : (this.request.getParameter((String)key) == null ? arr : arr[0]);
        } else {
            obj = this.map.get(key);
        }

        return obj;
    }

    public String getString(Object key) {
        return (String)this.get(key);
    }

    public Object put(Object key, Object value) {
        return this.map.put(key, value);
    }

    public Object remove(Object key) {
        return this.map.remove(key);
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object key) {
        return this.map.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return this.map.containsValue(value);
    }

    public Set entrySet() {
        return this.map.entrySet();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set keySet() {
        return this.map.keySet();
    }

    public void putAll(Map t) {
        this.map.putAll(t);
    }

    public void rename(String fromKey, String toKey) {
        if (this.map.containsKey(fromKey)) {
            this.map.put(toKey, this.map.get(fromKey));
            this.map.remove(fromKey);
        }

    }

    public int size() {
        return this.map.size();
    }

    public Collection values() {
        return this.map.values();
    }
}
