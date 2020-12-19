package club.adren.lib.utils;


import java.util.Collection;
import java.util.Iterator;

/**
 * Creator: adren
 * CreTime: 2020/12/8
 * Descrip:
 */
public class StringUtils {

    public static String join(Collection collection, String separator) {
        return collection == null ? null : join(collection.iterator(), separator);
    }

    public static String join(Iterator iterator, String separator) {
        if (iterator == null) {
            return null;
        } else if (!iterator.hasNext()) {
            return "";
        } else {
            Object first = iterator.next();
            if (!iterator.hasNext()) {
                return ObjectUtils.toString(first);
            } else {
                StringBuilder buf = new StringBuilder(256);
                if (first != null) {
                    buf.append(first);
                }

                while(iterator.hasNext()) {
                    if (separator != null) {
                        buf.append(separator);
                    }

                    Object obj = iterator.next();
                    if (obj != null) {
                        buf.append(obj);
                    }
                }

                return buf.toString();
            }
        }
    }
}
