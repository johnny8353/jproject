package com.johnny.javase.enumeration;

/**
 * 类 编 号：
 * 类 名 称：EnumImp
 * 内容摘要：Enum的实现原理
 * 完成日期：2016年8月3日
 * 编码作者：JohnnyHuang 黄福强
 */
public class EnumImp{
    public static final EnumImp MON  = new EnumImp("MON", 0);
    public static final EnumImp TUE = new EnumImp("TUE", 0);
    public static final EnumImp WED = new EnumImp("WED", 0);
    public static final EnumImp THU = new EnumImp("THU", 0);
    public static final EnumImp FRI = new EnumImp("FRI", 0);
    public static final EnumImp SAT = new EnumImp("SAT", 0);
    public static final EnumImp SUN = new EnumImp("SUN", 0);
	private final String name;
	private final int ordinal;
	public String toString() {
        return name;
    }
	public static EnumImp[] values(){
		return new EnumImp[]{MON,TUE,WED};
	}
	public final boolean equals(Object other) {
        return this==other;
    }
	public final int hashCode() {
        return super.hashCode();
    }
	protected EnumImp(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    

}
