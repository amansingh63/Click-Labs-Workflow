package com.click_labs.click_labsworkflow.util;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;

/**
 * Developer: Saurabh Verma
 * Dated: 03-03-2017.
 */
public final class EditTextUtil {
    /**
     * Filter on editText to block space character
     */
    private static InputFilter ignoreAllWhiteSpaces = new InputFilter() {
        @Override
        public CharSequence filter(final CharSequence source,
                                   final int start,
                                   final int end,
                                   final Spanned dest,
                                   final int dstart,
                                   final int dend) {
            String blockCharacterSet = " ";
            if (source != null && blockCharacterSet.contains("" + source)) {
                return "";
            }
            return null;
        }
    };

    /**
     * Empty Constructor
     * not called
     */
    private EditTextUtil() {
    }

    /**
     * @param editText instance of that edittext on which no space functionality want
     */
    public static void setIgnoreAllWhiteSpaces(final EditText editText) {
        editText.setFilters(new InputFilter[]{ignoreAllWhiteSpaces});
    }
    public static void setIgnoreFirstWhiteSpace(final EditText editText) {
        editText.setFilters(new InputFilter[]{ignoreFirstWhiteSpace});
    }



    private static InputFilter ignoreFirstWhiteSpace = new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end,
                                   Spanned dest, int dstart, int dend) {

            for (int i = start; i < end; i++) {
                if (Character.isWhitespace(source.charAt(i))) {
                    if (dstart == 0)
                        return "";
                }
            }
            return null;
        }
    };
}
