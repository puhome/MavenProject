package com.brzt.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLSyntaxErrorException;

public class StudentTest {

    @Test
    public  void  test()
    {
        try {
            Class cs=Class.forName("com.brzt.annotation.Student");

            /**
             * 获取类的注解
             */
            Annotation[] annotation=cs.getAnnotations();
            for(Annotation a :annotation)
            {
                System.out.println(a);
            }

            /**
             * 获取类指定的注解
             */
            StudentTable studentTable= (StudentTable) cs.getAnnotation(StudentTable.class);
            System.out.println(studentTable.value());

//            Field field=cs.getDeclaredField("name");
//            StudentField studentField=field.getAnnotation(StudentField.class);
//            System.out.println(studentField.columName());

            Method[] methods=cs.getDeclaredMethods();
            for(Method m:methods)
            {
                boolean annotationPresent = m.isAnnotationPresent(StudentField.class);
                if(annotationPresent) {
                    System.out.println(m.getAnnotation(StudentField.class).columName());
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
        }
    }
}
