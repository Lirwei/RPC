package io.rpc.common.utils;

import java.util.stream.IntStream;

/**
 * 附带的序列化和反序列化工具类
 */
public class SerializationUtils {

    private static final String PADDING_STRING = "0";

    // 序列化类型最大长度约定为16
    public static final int MAX_SERIALIZATION_TYPE_COUNT = 16;

    /**
     * 为长度不足16的字符串后面补"0"
     *
     * @param str 原始字符串
     * @return 补"0"后的字符串
     */
    public static String paddingString(String str) {
        str = transNullToEmpty(str);
        if (str.length() >= MAX_SERIALIZATION_TYPE_COUNT) return str;
        int paddingCount = MAX_SERIALIZATION_TYPE_COUNT - str.length();
        StringBuilder paddingString = new StringBuilder(str);
        IntStream.range(0, paddingCount).forEach(index -> paddingString.append(PADDING_STRING));
        return paddingString.toString();
    }

    /**
     * 字符串去"0"操作
     *
     * @param str 原始字符串
     * @return 去"0"后的字符串
     */
    public static String subString(String str) {
        str = transNullToEmpty(str);
        return str.replace(PADDING_STRING, "");
    }

    public static String transNullToEmpty(String str) {
        return str == null ? "" : str;
    }

}
