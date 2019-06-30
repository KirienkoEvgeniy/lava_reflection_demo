package org.demo;

import java.lang.reflect.*;
import java.util.Arrays;

public class CodeAnalyzer implements ICodeAnalyzer {


    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        CodeAnalyzer codeAnalyzer =new CodeAnalyzer();
        codeAnalyzer.analyze(AnalyzableExample.class);

    }

    @Override
    public void analyze(Class<?> analyzableExample) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Constructor<AnalyzableExample> constructor = AnalyzableExample.class.getDeclaredConstructor(String.class, String.class);
        constructor.setAccessible(true);
        AnalyzableExample analyzableExampleConstructor = (AnalyzableExample) constructor.newInstance("User", "Pet");
        if (constructor.isAnnotationPresent(Analyzable.class)) {
            System.out.println("constructor name -> " + constructor.getName());
            System.out.println("Parameters name -> " +  Arrays.toString(constructor.getParameters()));
            System.out.println("Annotations name -> " +  Arrays.toString(constructor.getDeclaredAnnotations()));
            System.out.println();
        }

        Field[] fields = analyzableExampleConstructor.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(field ->{
            if(field.isAnnotationPresent(Analyzable.class)){
            try {
                System.out.println("Field - > " + field.getName());
                System.out.println("Annotations name -> " + Arrays.toString(field.getAnnotations()));
                System.out.println();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }}
        });

        Method[] declaredMethods = analyzableExampleConstructor.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            declaredMethod.setAccessible(true);
            if (declaredMethod.isAnnotationPresent(Analyzable.class)) {
                System.out.println("Method name -> " + declaredMethod.getName());
                Parameter[] parameters = declaredMethod.getParameters();
                System.out.println("Parameters name -> " +  Arrays.toString(declaredMethod.getParameters()));
                System.out.println("Annotations name -> " +  Arrays.toString(declaredMethod.getDeclaredAnnotations()));
                System.out.println();
        }
        }


    }
}
