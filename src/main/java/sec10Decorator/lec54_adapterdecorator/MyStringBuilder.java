package sec10Decorator.lec54_adapterdecorator;

import java.util.stream.IntStream;

// what if we want to inherit from StringBuilder? we cannot because its final class. what we can do instead is this below
class MyStringBuilder {

    private StringBuilder sb = new StringBuilder();

    public MyStringBuilder() {
        sb = new StringBuilder();
    }

    public MyStringBuilder(String str) {
        sb = new StringBuilder(str);
    }

    // adapter part
    public MyStringBuilder myConcat(String str) {
        return new MyStringBuilder(sb.toString().concat(str));
    }

    public MyStringBuilder myAppendLine(String str) {
        sb.append(str).append(System.lineSeparator());
        return this;
    }

    public String toString() {
        return sb.toString();
    }


    // decorator part - underlying methods delegated from original StringBuilder class
    public StringBuilder append(boolean b) {
        return sb.append(b);
    }

    public StringBuilder insert(int offset, long l) {
        return sb.insert(offset, l);
    }

    public StringBuilder append(CharSequence s) {
        return sb.append(s);
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        sb.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    public StringBuilder append(double d) {
        return sb.append(d);
    }

    public StringBuilder insert(int offset, String str) {
        return sb.insert(offset, str);
    }

    public StringBuilder reverse() {
        return sb.reverse();
    }

    public void ensureCapacity(int minimumCapacity) {
        sb.ensureCapacity(minimumCapacity);
    }

    public String substring(int start, int end) {
        return sb.substring(start, end);
    }

    public StringBuilder insert(int offset, char c) {
        return sb.insert(offset, c);
    }

    public StringBuilder insert(int index, char[] str, int offset, int len) {
        return sb.insert(index, str, offset, len);
    }

    public StringBuilder append(int i) {
        return sb.append(i);
    }

    public int codePointCount(int beginIndex, int endIndex) {
        return sb.codePointCount(beginIndex, endIndex);
    }

    public StringBuilder append(long lng) {
        return sb.append(lng);
    }

    public int lastIndexOf(String str) {
        return sb.lastIndexOf(str);
    }

    public IntStream codePoints() {
        return sb.codePoints();
    }

    public StringBuilder replace(int start, int end, String str) {
        return sb.replace(start, end, str);
    }

    public IntStream chars() {
        return sb.chars();
    }

    public int indexOf(String str, int fromIndex) {
        return sb.indexOf(str, fromIndex);
    }

    public int codePointBefore(int index) {
        return sb.codePointBefore(index);
    }

    public int compareTo(StringBuilder another) {
        return sb.compareTo(another);
    }

    public boolean isEmpty() {
        return sb.isEmpty();
    }

    public StringBuilder delete(int start, int end) {
        return sb.delete(start, end);
    }

    public StringBuilder insert(int offset, double d) {
        return sb.insert(offset, d);
    }

    public StringBuilder append(char[] str) {
        return sb.append(str);
    }

    public char charAt(int index) {
        return sb.charAt(index);
    }

    public void trimToSize() {
        sb.trimToSize();
    }

    public StringBuilder insert(int dstOffset, CharSequence s) {
        return sb.insert(dstOffset, s);
    }

    public StringBuilder repeat(CharSequence cs, int count) {
        return sb.repeat(cs, count);
    }

    public StringBuilder append(CharSequence s, int start, int end) {
        return sb.append(s, start, end);
    }

    public StringBuilder repeat(int codePoint, int count) {
        return sb.repeat(codePoint, count);
    }

    public StringBuilder append(float f) {
        return sb.append(f);
    }

    public StringBuilder insert(int offset, int i) {
        return sb.insert(offset, i);
    }

    public StringBuilder append(String str) {
        return sb.append(str);
    }

    public int lastIndexOf(String str, int fromIndex) {
        return sb.lastIndexOf(str, fromIndex);
    }

    public int offsetByCodePoints(int index, int codePointOffset) {
        return sb.offsetByCodePoints(index, codePointOffset);
    }

    public StringBuilder insert(int offset, boolean b) {
        return sb.insert(offset, b);
    }

    public StringBuilder insert(int offset, Object obj) {
        return sb.insert(offset, obj);
    }

    public int capacity() {
        return sb.capacity();
    }

    public StringBuilder append(StringBuffer sb) {
        return this.sb.append(sb);
    }

    public CharSequence subSequence(int start, int end) {
        return sb.subSequence(start, end);
    }

    public String substring(int start) {
        return sb.substring(start);
    }

    public StringBuilder insert(int dstOffset, CharSequence s, int start, int end) {
        return sb.insert(dstOffset, s, start, end);
    }

    public StringBuilder deleteCharAt(int index) {
        return sb.deleteCharAt(index);
    }

    public int length() {
        return sb.length();
    }

    public int codePointAt(int index) {
        return sb.codePointAt(index);
    }

    public StringBuilder append(Object obj) {
        return sb.append(obj);
    }

    public StringBuilder append(char c) {
        return sb.append(c);
    }

    public int indexOf(String str) {
        return sb.indexOf(str);
    }

    public StringBuilder appendCodePoint(int codePoint) {
        return sb.appendCodePoint(codePoint);
    }

    public StringBuilder insert(int offset, char[] str) {
        return sb.insert(offset, str);
    }

    public void setCharAt(int index, char ch) {
        sb.setCharAt(index, ch);
    }

    public StringBuilder append(char[] str, int offset, int len) {
        return sb.append(str, offset, len);
    }

    public StringBuilder insert(int offset, float f) {
        return sb.insert(offset, f);
    }

    public void setLength(int newLength) {
        sb.setLength(newLength);
    }
}


class Demo {
    public static void main(String[] args) {
        MyStringBuilder msb = new MyStringBuilder();

        // napriek tomu ze sme pouzili builder design pattern tak fluent API nefunguje. zisti preco
//        msb.append("hello").myAppendLine(" world");

        msb.append("hello");
        msb.myAppendLine(" world");
        System.out.println(msb.myConcat("and this too"));
    }
}
