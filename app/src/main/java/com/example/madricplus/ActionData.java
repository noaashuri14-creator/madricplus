package com.example.madricplus;

import java.util.ArrayList;
import java.util.HashMap;

public class ActionData {

    public static HashMap<String, ArrayList<String>> categories = new HashMap<>();

    static {

        categories.put("כבוד", new ArrayList<>());
        categories.put("צחוק", new ArrayList<>());
        categories.put("עזרה לזולת", new ArrayList<>());
        categories.put("אהבת הארץ", new ArrayList<>());
        categories.put("מנהיגות", new ArrayList<>());
        categories.put("גיבוש", new ArrayList<>());
        categories.put("אחריות", new ArrayList<>());
        categories.put("ערכים", new ArrayList<>());
        categories.put("שיתוף פעולה", new ArrayList<>());
        categories.put("הקשבה", new ArrayList<>());
        categories.put("יוזמה", new ArrayList<>());

        categories.get("כבוד").add("הקשבה לחבר | 10+ | לא להפריע בזמן דיבור");
        categories.get("צחוק").add("משחק הומור | 8+ | משחק קבוצתי מצחיק");
    }
}