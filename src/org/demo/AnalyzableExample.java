package org.demo;


public class AnalyzableExample {

    @MyFirstAnnotation
    private String name;

    @MyFirstAnnotation
    @Analyzable(autor = "user1", description = "ver1")
    private String lastName;

    @Analyzable(autor = "user1", description = "ver1")
    private AnalyzableExample(String value1, String value2) {
        this.name = value1;
        this.lastName = value2;
    }

    @MyFirstAnnotation
    @Analyzable(autor = "user1", description = "ver1")
    private void getValue(Integer value3) {
        System.out.println();
    }


//    @MyFirstAnnotation
    @Analyzable(autor = "user1", description = "ver1")
    private Integer getValueNew(String value1) {
        return null;
    }

}
