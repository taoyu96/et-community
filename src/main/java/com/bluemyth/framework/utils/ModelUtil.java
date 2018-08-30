package com.bluemyth.framework.utils;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiaot on 2017/5/4.
 */
public class ModelUtil {

    public static void main(String[] args) {

    }

    /**
     * 设置实体属性的值
     * @param entity
     * @param fieldName
     * @param val
     */
    public static void setFieldVaule(Object entity, String fieldName, Object val) {
        try {
            Class cl = entity.getClass();
            Field field = cl.getDeclaredField(fieldName);
            field.setAccessible(true);
            Class type = field.getType();
            field.set(entity, formatVal(type, val));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 格式属性
     * @param type
     * @param value
     * @return
     */
    public static Object formatVal(Class type, Object value) {
        if (value != null) {
            if (value.getClass().equals(type)) return value;

            if (String.class.equals(type)) {
                return  value.toString();
            }else if (BigDecimal.class.equals(type)) {
                return new BigDecimal(StringUtils.isNotBlank(value.toString()) ?  value.toString() : "0");
            } else if (double.class.equals(type) || Double.class.equals(type)) {
                return Double.parseDouble(value.toString());
            } else if (int.class.equals(type) || Integer.class.equals(type)) {
                return Integer.parseInt(value.toString());
            } else if (Date.class.equals(type)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String val= value.toString();
                try {
                    Date d = new Date();
                    if (StringUtils.isNotBlank(value.toString())) {
                        if ( val.indexOf("/") > 0) val = val.replaceAll("/", "-");
                        d = (Date) simpleDateFormat.parseObject(StringUtils.trimToNull(val));
                    }
                    Constructor<? extends String> constructor = type.getConstructor(long.class);
                    return constructor.newInstance(d.getTime());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return val;
            }

        }
        return null;
    }

    /**
     * 将fromEntTity不空的元素，填充到EntTity相对应的元素
     * fromEntTity，EntTity,t2可以为不同的实体实例
     *
     * @param toEntTity
     * @param fromEntTity
     * @param <T>
     * @return T EntTity
     */
    public static <T> T copyInfo(Object fromEntTity, T toEntTity) {
        try {
            Class clazz = fromEntTity.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(fromEntTity);
                if (value != null) {
                    Class clazzTo = toEntTity.getClass();
                    Field[] fieldsTo = clazzTo.getDeclaredFields();
                    for (Field fieldTo : fieldsTo) {
                        fieldTo.setAccessible(true);
                        if (StringUtils.equalsIgnoreCase(field.getName(), fieldTo.getName())
                                && StringUtils.equals(field.getType().getName(), fieldTo.getType().getName())) {
                            fieldTo.set(toEntTity, value);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return toEntTity;
    }

    /**
     * 将t1不空的元素填充到t2，返回t2
     * t1,t2为相同的实体实例
     *
     * @param t1
     * @param t2
     * @return t2
     */
    public static <T> T fillModel(T t1, T t2) {
        if (t1 == null) return t2;
        try {
            Class clazz = t1.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(t1);
                if (value != null) {
                    if (value instanceof String
                            && StringUtils.isNotEmpty(value.toString())) {
                        field.set(t2, value);
                    } else {
                        field.set(t2, value);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return t2;
    }


    /**
     * model判空
     *
     * @param ob
     * @return
     */
    public static boolean isEmpty(Object ob) {
        if (ob == null) return true;
        try {
            Class clazz = ob.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(ob);
                if (value != null) {
                    return false;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static boolean isNotEmpty(Object ob) {
        return !isEmpty(ob);
    }

}
