package sec10Decorator.lec51_stringdecorator;

import java.io.UnsupportedEncodingException;
import java.lang.invoke.MethodHandles;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class MagicString {

    private String string;
//sometimes we have classes like String that you cannot inherit from. So you need to expand its functionality. The only way to do it is aggregate the actual object (So stick that object in some other object) and have the other object pretend in a way that it is the inner object
    public MagicString(String string) {
        this.string = string;
    }

    public long getNumberOfVowels() {
        return string.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> "aeiou".contains(c.toString()))
                .count();
    }

    @Override
    public String toString() {
        return string;
    }

    // /////////////////////////////////////////////////////////////////
    // all this below is generated staff - alt+I - delegate methods
    public char charAt(int index) {
        return string.charAt(index);
    }

    public String substring(int beginIndex) {
        return string.substring(beginIndex);
    }

    public int indexOf(String str) {
        return string.indexOf(str);
    }

    @Deprecated(since = "1.1")
    public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
        string.getBytes(srcBegin, srcEnd, dst, dstBegin);
    }

    public String replaceFirst(String regex, String replacement) {
        return string.replaceFirst(regex, replacement);
    }

    public boolean endsWith(String suffix) {
        return string.endsWith(suffix);
    }

    public String trim() {
        return string.trim();
    }

    public String translateEscapes() {
        return string.translateEscapes();
    }

    public boolean equalsIgnoreCase(String anotherString) {
        return string.equalsIgnoreCase(anotherString);
    }

    public String toUpperCase(Locale locale) {
        return string.toUpperCase(locale);
    }

    public int offsetByCodePoints(int index, int codePointOffset) {
        return string.offsetByCodePoints(index, codePointOffset);
    }

    public Optional<String> describeConstable() {
        return string.describeConstable();
    }

    public int lastIndexOf(int ch) {
        return string.lastIndexOf(ch);
    }

    public int lastIndexOf(String str, int fromIndex) {
        return string.lastIndexOf(str, fromIndex);
    }

    public boolean startsWith(String prefix, int toffset) {
        return string.startsWith(prefix, toffset);
    }

    public boolean matches(String regex) {
        return string.matches(regex);
    }

    public String stripIndent() {
        return string.stripIndent();
    }

    public int codePointBefore(int index) {
        return string.codePointBefore(index);
    }

    public String toLowerCase(Locale locale) {
        return string.toLowerCase(locale);
    }

    public byte[] getBytes(Charset charset) {
        return string.getBytes(charset);
    }

    public String concat(String str) {
        return string.concat(str);
    }

    public char[] toCharArray() {
        return string.toCharArray();
    }

    public int compareTo(String anotherString) {
        return string.compareTo(anotherString);
    }

    public Stream<String> lines() {
        return string.lines();
    }

    public String repeat(int count) {
        return string.repeat(count);
    }

    public int indexOf(int ch, int fromIndex) {
        return string.indexOf(ch, fromIndex);
    }

    public IntStream chars() {
        return string.chars();
    }

    public boolean regionMatches(int toffset, String other, int ooffset, int len) {
        return string.regionMatches(toffset, other, ooffset, len);
    }

    public String substring(int beginIndex, int endIndex) {
        return string.substring(beginIndex, endIndex);
    }

    public String stripTrailing() {
        return string.stripTrailing();
    }

    public String strip() {
        return string.strip();
    }

    public boolean startsWith(String prefix) {
        return string.startsWith(prefix);
    }

    public String replaceAll(String regex, String replacement) {
        return string.replaceAll(regex, replacement);
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        string.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    public boolean contentEquals(CharSequence cs) {
        return string.contentEquals(cs);
    }

    public String toUpperCase() {
        return string.toUpperCase();
    }

    public <R> R transform(Function<? super String, ? extends R> f) {
        return string.transform(f);
    }

    public int length() {
        return string.length();
    }

    public int indexOf(String str, int fromIndex) {
        return string.indexOf(str, fromIndex);
    }

    public boolean contentEquals(StringBuffer sb) {
        return string.contentEquals(sb);
    }

    public boolean contains(CharSequence s) {
        return string.contains(s);
    }

    public String resolveConstantDesc(MethodHandles.Lookup lookup) {
        return string.resolveConstantDesc(lookup);
    }

    public String formatted(Object... args) {
        return string.formatted(args);
    }

    public int lastIndexOf(int ch, int fromIndex) {
        return string.lastIndexOf(ch, fromIndex);
    }

    public String toLowerCase() {
        return string.toLowerCase();
    }

    public int indexOf(int ch, int beginIndex, int endIndex) {
        return string.indexOf(ch, beginIndex, endIndex);
    }

    public String replace(char oldChar, char newChar) {
        return string.replace(oldChar, newChar);
    }

    public int codePointAt(int index) {
        return string.codePointAt(index);
    }

    public int codePointCount(int beginIndex, int endIndex) {
        return string.codePointCount(beginIndex, endIndex);
    }

    public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
        return string.regionMatches(ignoreCase, toffset, other, ooffset, len);
    }

    public int lastIndexOf(String str) {
        return string.lastIndexOf(str);
    }

    public byte[] getBytes() {
        return string.getBytes();
    }

    public String[] splitWithDelimiters(String regex, int limit) {
        return string.splitWithDelimiters(regex, limit);
    }

    public String indent(int n) {
        return string.indent(n);
    }

    public int indexOf(int ch) {
        return string.indexOf(ch);
    }

    public boolean isBlank() {
        return string.isBlank();
    }

    public CharSequence subSequence(int beginIndex, int endIndex) {
        return string.subSequence(beginIndex, endIndex);
    }

    public int indexOf(String str, int beginIndex, int endIndex) {
        return string.indexOf(str, beginIndex, endIndex);
    }

    public IntStream codePoints() {
        return string.codePoints();
    }

    public boolean isEmpty() {
        return string.isEmpty();
    }

    public String stripLeading() {
        return string.stripLeading();
    }

    public int compareToIgnoreCase(String str) {
        return string.compareToIgnoreCase(str);
    }

    public String replace(CharSequence target, CharSequence replacement) {
        return string.replace(target, replacement);
    }

    public String intern() {
        return string.intern();
    }

    public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
        return string.getBytes(charsetName);
    }
}



class Demo {
    public static void main(String[] args) {
        MagicString s = new MagicString("hello");
        System.out.println(s + " has " + s.getNumberOfVowels() + " vowels");
    }
}