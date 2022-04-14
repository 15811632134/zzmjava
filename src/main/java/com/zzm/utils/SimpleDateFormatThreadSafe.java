//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zzm.utils;

import java.text.AttributedCharacterIterator;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class SimpleDateFormatThreadSafe extends SimpleDateFormat {
    private static final long serialVersionUID = 5448371898056188202L;
    ThreadLocal<SimpleDateFormat> localSimpleDateFormat;

    public SimpleDateFormatThreadSafe() {
        this.localSimpleDateFormat = new ThreadLocal<SimpleDateFormat>() {
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat();
            }
        };
    }

    public SimpleDateFormatThreadSafe(final String pattern) {
        super(pattern);
        this.localSimpleDateFormat = new ThreadLocal<SimpleDateFormat>() {
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat(pattern);
            }
        };
    }

    public SimpleDateFormatThreadSafe(final String pattern, final DateFormatSymbols formatSymbols) {
        super(pattern, formatSymbols);
        this.localSimpleDateFormat = new ThreadLocal<SimpleDateFormat>() {
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat(pattern, formatSymbols);
            }
        };
    }

    public SimpleDateFormatThreadSafe(final String pattern, final Locale locale) {
        super(pattern, locale);
        this.localSimpleDateFormat = new ThreadLocal<SimpleDateFormat>() {
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat(pattern, locale);
            }
        };
    }

    public Object parseObject(String source) throws ParseException {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).parseObject(source);
    }

    public String toString() {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).toString();
    }

    public Date parse(String source) throws ParseException {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).parse(source);
    }

    public Object parseObject(String source, ParsePosition pos) {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).parseObject(source, pos);
    }

    public void setCalendar(Calendar newCalendar) {
        ((SimpleDateFormat)this.localSimpleDateFormat.get()).setCalendar(newCalendar);
    }

    public Calendar getCalendar() {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).getCalendar();
    }

    public void setNumberFormat(NumberFormat newNumberFormat) {
        ((SimpleDateFormat)this.localSimpleDateFormat.get()).setNumberFormat(newNumberFormat);
    }

    public NumberFormat getNumberFormat() {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).getNumberFormat();
    }

    public void setTimeZone(TimeZone zone) {
        ((SimpleDateFormat)this.localSimpleDateFormat.get()).setTimeZone(zone);
    }

    public TimeZone getTimeZone() {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).getTimeZone();
    }

    public void setLenient(boolean lenient) {
        ((SimpleDateFormat)this.localSimpleDateFormat.get()).setLenient(lenient);
    }

    public boolean isLenient() {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).isLenient();
    }

    public void set2DigitYearStart(Date startDate) {
        ((SimpleDateFormat)this.localSimpleDateFormat.get()).set2DigitYearStart(startDate);
    }

    public Date get2DigitYearStart() {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).get2DigitYearStart();
    }

    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition pos) {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).format(date, toAppendTo, pos);
    }

    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).formatToCharacterIterator(obj);
    }

    public Date parse(String text, ParsePosition pos) {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).parse(text, pos);
    }

    public String toPattern() {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).toPattern();
    }

    public String toLocalizedPattern() {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).toLocalizedPattern();
    }

    public void applyPattern(String pattern) {
        ((SimpleDateFormat)this.localSimpleDateFormat.get()).applyPattern(pattern);
    }

    public void applyLocalizedPattern(String pattern) {
        ((SimpleDateFormat)this.localSimpleDateFormat.get()).applyLocalizedPattern(pattern);
    }

    public DateFormatSymbols getDateFormatSymbols() {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).getDateFormatSymbols();
    }

    public void setDateFormatSymbols(DateFormatSymbols newFormatSymbols) {
        ((SimpleDateFormat)this.localSimpleDateFormat.get()).setDateFormatSymbols(newFormatSymbols);
    }

    public Object clone() {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).clone();
    }

    public int hashCode() {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).hashCode();
    }

    public boolean equals(Object obj) {
        return ((SimpleDateFormat)this.localSimpleDateFormat.get()).equals(obj);
    }
}
