package com.click_labs.click_labsworkflow.database;


import com.click_labs.click_labsworkflow.constants.PaperDbConstant;

import io.paperdb.Paper;

/**
 * Developer: Saurabh Verma
 * Dated: 19-02-2017.
 */
public final class CommonData implements PaperDbConstant {
    /**
     * Empty Constructor
     * not called
     */
    private CommonData() {
    }

    /**
     * Save access token.
     *
     * @param accessToken the access token
     */
//======================================== Access Token ============================================
    public static void saveAccessToken(final String accessToken) {
        Paper.book().write(PAPER_ACCESS_TOKEN, "bearer " + accessToken);
    }

    /**
     * Gets access token.
     *
     * @return the access token
     */
    public static String getAccessToken() {
        return Paper.book().read(PAPER_ACCESS_TOKEN);
    }


    //======================================== Clear Data ===============================================

    /**
     * Delete paper.
     */
    public static void clearData() {
        Paper.book().destroy();
        ;
    }

    public static void saveUserDesignation(String designation) {
        Paper.book().write(DESIGNATION, designation);
    }

    public static String getUserDesignation() {
        return Paper.book().read(DESIGNATION);
    }
}
