package com.bluemyth.framework.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;


public class CommonUtil {
    /**
     * 把对象转换为map
     *
     * @param object 参数object需含暴露get方法
     * @return Map
     */
    public static Map<String, Object> entityToMap(Object object) {
        Class<?> c = object.getClass();
        Field[] fields = c.getDeclaredFields();
        Map<String, Object> map = new HashMap<>();
        Arrays.asList(fields).forEach((field) -> {
            String fieldName = field.getName();
            String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            try {
                Object fieldValue = c.getDeclaredMethod(methodName).invoke(object);
                map.put(fieldName, fieldValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return map;
    }

    /**
     * @param c   传入Entity类型
     * @param obj obj需要有get(Object key)方法. 常见类型Map / JSONObject
     *            key的值要和model的字段名一致.value的值要和model的字段类型一致
     * @return T
     */

    public static <T> T mapToEntity(Class<T> c, Object obj) {
        Class<?> aClass = obj.getClass();
        if ("java.util.HashMap".equals(aClass.getName())) {
            aClass = aClass.getSuperclass();
        }
        try {
            Method getMethod = aClass.getDeclaredMethod("get", Object.class);
            T o = c.newInstance();
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                String fieldName = field.getName();
                String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Method setMethod = c.getDeclaredMethod(methodName, field.getType());
                Object value = getMethod.invoke(obj, fieldName);
                if (value != null) {
                    Class<?> valueClass = value.getClass();
                    if ("java.util.HashMap".equals(valueClass.getName())) {
                        value = mapToEntity(field.getType(), value);
                    }
                    setMethod.invoke(o, value);
                }
            }
            return o;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param dto dto实例
     * @param c   实体类型
     * @return 返回 T 实体
     */
    public static <T> T dtoToEntity(Object dto, Class<T> c) {
        return mapToEntity(c, entityToMap(dto));
    }


    public static Map<String, Object> entityToMapHanderDate(Object object) {
        Map<String, Object> map = entityToMap(object);
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        return entries.stream().map(entry -> {
            System.out.println("key:" + entry.getKey() + " --- " + "value:" + entry.getValue());
            if (Optional.ofNullable(entry.getValue()).isPresent()) {
                Class<?> aClass = entry.getValue().getClass();
                if ("java.sql.Timestamp".equals(aClass.getName()) || "java.util.Date".equals(aClass.getName())) {
                    Date date = (Date) entry.getValue();
                    entry.setValue(date.getTime());
                }
                return entry;
            } else {
                entry.setValue("");
                return entry;
            }
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void main(String[] args) {
        boolean present = Optional.ofNullable(null).isPresent();
        System.out.println(present);
    }
}
