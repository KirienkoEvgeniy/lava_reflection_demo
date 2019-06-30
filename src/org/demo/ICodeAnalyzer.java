package org.demo;

import java.lang.reflect.InvocationTargetException;

public interface ICodeAnalyzer {

    void analyze(Class<?> analyzableEx) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException;

}