package com.example.madricplus;
public class ActionData {

    private String name;
    private String subject;
    private String age;
    private String content;

    public ActionData() {}

    public ActionData(String name, String subject, String age, String content) {
        this.name = name;
        this.subject = subject;
        this.age = age;
        this.content = content;
    }

    public String getName() { return name; }
    public String getSubject() { return subject; }
    public String getAge() { return age; }
    public String getContent() { return content; }
}