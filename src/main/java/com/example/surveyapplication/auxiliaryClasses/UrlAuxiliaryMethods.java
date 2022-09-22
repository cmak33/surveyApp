package com.example.surveyapplication.auxiliaryClasses;

import javax.servlet.http.HttpServletRequest;

public class UrlAuxiliaryMethods {
    public static String getPreviousPageUrl(HttpServletRequest request){
        return request.getHeader("Referer");
    }

    public static String getPreviousPageRedirect(HttpServletRequest request){
        return String.format("redirect:%s",getPreviousPageUrl(request));
    }
}
