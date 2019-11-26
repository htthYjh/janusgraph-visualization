package com.fenglex.janus.util;

import cn.hutool.core.date.DateUtil;
import com.fenglex.janus.entity.GraphProperty;
import org.apache.tinkerpop.gremlin.structure.Property;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @Author: haifeng
 * @Date: 2019/11/26 14:32
 */
public class PropertyUtil {

    public static GraphProperty convertProperty(Property<Object> property) {
        GraphProperty graphProperty = new GraphProperty();
        String key = property.key();
        graphProperty.setKey(key);
        Object value = property.value();
        if (value instanceof Set) {
            List list = (List) value;
            for (Object o : list) {
                if (o instanceof Date) {
                    String dateTime = DateUtil.formatDateTime((Date) o);
                    graphProperty.addValue(dateTime);
                } else {
                    graphProperty.addValue(o.toString());
                }
            }
        } else if (value instanceof List) {
            Set set = (Set) value;
            for (Object o : set) {
                if (o instanceof Date) {
                    String dateTime = DateUtil.formatDateTime((Date) o);
                    graphProperty.addValue(dateTime);
                } else {
                    graphProperty.addValue(o.toString());
                }
            }
        }
        return graphProperty;
    }
}
