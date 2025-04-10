package com.ohgiraffers.section02.enumtype;

public enum Subjects {

    JAVA,
    MySQL,
    JDBC,
    HTML,
    CSS,
    JAVASCRIPT;

    Subjects() {
        System.out.println("Normal Constructor is called...");
    }

    public String toString() {
        return "@@@@" + this.name() + "@@@@";
    }

    public enum BackEnd {JAVA, MYSQL, JDBC, JAVASCRIPT};
    public enum FrontEnd {HTML, JAVASCRIPT, CSS};

}
