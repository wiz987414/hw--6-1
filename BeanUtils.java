import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    static void assign(Object to, Object from) {
        Class<?> destination = to.getClass();
        Class<?> source = from.getClass();
        Method[] destinationMethodsList = destination.getMethods();
        Map<Method, Method> invokeMap = new HashMap<>();
        for (Method checkGetter : source.getMethods()) {
            if ((checkGetter.getName().startsWith("get") || checkGetter.getName().startsWith("is"))
                    && checkGetter.getParameterCount() == 0
                    && checkGetter.getReturnType() != void.class) {
                Method compatibleSetter = getCompatibleMethod(checkGetter, destinationMethodsList);
                if (compatibleSetter != null) {
                    invokeMap.put(compatibleSetter, checkGetter);
                    for (int i = 0; i < destinationMethodsList.length; i ++)
                        if (destinationMethodsList[i] == compatibleSetter)
                            destinationMethodsList[i] = null;
                }
            }
        }
        for (Method invoke : invokeMap.keySet())
            try {
                invoke.invoke(to, invokeMap.get(invoke).invoke(from));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getMessage(), e.getCause());
            }
    }

    private static Method getCompatibleMethod(Method getterMethod, Method[] destnationList) {
        Method rezultSetter = null;
        for (Method checkSetter : destnationList) {
            if (checkSetter != null) {
                if (checkSetter.getName().startsWith("set")
                        // Possible names compatible
                        //&& checkSetter.getName().contains(getterMethod.getName().substring(2, getterMethod.getName().length()))
                        && checkSetter.getParameterCount() == 1
                        && checkSetter.getReturnType() == void.class) {
                    if (checkSetter.getParameterTypes()[0] == getterMethod.getReturnType()) {
                        rezultSetter = checkSetter;
                    } else {
                        Class<?> checkGetterClass = getterMethod.getReturnType();
                        while (checkGetterClass != null) {
                            checkGetterClass = checkGetterClass.getSuperclass();
                            if (checkSetter.getParameterTypes()[0] == checkGetterClass) {
                                rezultSetter = checkSetter;
                            }
                        }
                    }
                }
            }
        }
        return rezultSetter;
    }
}