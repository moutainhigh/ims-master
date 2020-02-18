package com.yianju.ims.util;

import com.yianju.ims.entity.Result;
import com.yianju.ims.entity.ResultCode;
import org.apache.commons.lang3.Validate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * bean属性验证
 */
public class BeanPropertyValidateUtil {

    /**
     * 验证对象的属性是否为空
     * @param bean 对象实例
     * @param fields 对象属性
     * @return
     */
    public static Result getEmptyFields(Object bean,String... fields){

        // 验证对象是否为空
        if(fields.length<1){
            if(bean instanceof String){
                if(bean == null || "".equals(bean)){
                    return new Result(ResultCode.VALIFIELD_NULL);
                }
            }
            if(bean==null){
                return new Result(ResultCode.VALIBEAN_NULL);
            }
        }

        Class<?> clz = bean.getClass();

        List<Field> fieldsList = getAllFieldsList(clz);

        // 不存在的属性
        Set<String> noFileds = new HashSet<>();
        // 为空属性
        Set<String> nullFileds = new HashSet<>();

        for (int i=0;i<fields.length;i++) {
            String filed = fields[i];

            // 输入属性是否存在与对象中标记
            boolean flag = false;
            // 获取输入属性对应的值
            for (Field f:fieldsList){

                // 获取输入的属性
                String name = f.getName();
                if(name.equals(filed)){
                    boolean accessible = f.isAccessible();
                    f.setAccessible(true);
                    try {
                        Object o = f.get(bean);
                        if(o==null || "".equals(o)){
                            nullFileds.add(filed);
                        }
                        f.setAccessible(accessible);
                        flag = true;
                    } catch (IllegalAccessException e) {
                        noFileds.add(filed);
                    }
                }
            }

            if(!flag){
                noFileds.add(filed);
            }

        }


        // 构造返回对象
        if(noFileds.size()==0 && nullFileds.size()==0){
            return new Result(ResultCode.SUCCESS);
        }

        String noFiledsString = "";
        if(noFileds.size()>0){
            noFiledsString = noFileds.toString();
        }

        String nullFiledsString = "";
        if(nullFileds.size()>0){
            nullFiledsString = nullFileds.toString();
            System.out.println();
        }

        String message = "";
        if(!"".equals(noFiledsString)){
            message = "不存在的属性：" + noFiledsString;
        }

        if(!"".equals(nullFiledsString)){
            if(!"".equals(message)){
                message = message + "," +"为空的属性:" + nullFiledsString;
            }else{
                message = "为空的属性:" + nullFiledsString;
            }
        }


        return new Result(ResultCode.FAIL,message);
    }

    private static boolean getField(Object bean,String filed){
        // 查看此类或者父类中是否存在属性
        Class<?> clz = bean.getClass();
        return false;
    }


    public static List<Field> getAllFieldsList(final Class<?> cls) {
        Validate.isTrue(cls != null, "The class must not be null");
        final List<Field> allFields = new ArrayList<Field>();
        Class<?> currentClass = cls;
        while (currentClass != null) {
            final Field[] declaredFields = currentClass.getDeclaredFields();
            for (final Field field : declaredFields) {
                allFields.add(field);
            }
            currentClass = currentClass.getSuperclass();
        }
        return allFields;
    }
}
