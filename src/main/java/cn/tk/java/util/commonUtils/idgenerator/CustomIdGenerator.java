package cn.tk.java.util.commonUtils.idgenerator;

/*
* @date: 2016/11/25
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description:
* 
*/
public class CustomIdGenerator {
    private static final long[] byteTable = createLookupTable();
    private static final long HSTART = 0xBB40E64DA205B064L;
    private static final long HMULT = 7664345821815920749L;

    private static final long[] createLookupTable() {
        long[] byteTable = new long[256];
        long h = 0x544B2FBACAAF1684L;
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 31; j++) {
                h = (h >>> 7) ^ h;
                h = (h << 11) ^ h;
                h = (h >>> 10) ^ h;
            }
            byteTable[i] = h;
        }
        return byteTable;
    }

    public static long hashCode(CharSequence cs) {
        long h = HSTART;
        final int len = cs.length();
        for (int i = 0; i < len; i++) {
            char ch = cs.charAt(i);
            h = (h * HMULT) ^ byteTable[ch & 0xff];
            h = (h * HMULT) ^ byteTable[(ch >>> 8) & 0xff];
        }
        h = h < 0 ? -h : h;
        return h;
    }

    public static long hashCode(String name, String cidType, String cidNo){
        String uniqueCustom = trimAndDefault(name) + trimAndDefault(cidType) + trimAndDefault(cidNo);
        return hashCode(uniqueCustom);
    }

    /*
    * @description: 字符串去空格然后给空字符串缺省值, 避免字符串为 null, 都换成空字符串
    */
    private static String trimAndDefault(String input)
    {
        input = input == null ? "" : input.trim();
        input = "".equals(input) ? "UNDEFINE" : input;
        return input;
    }
}
