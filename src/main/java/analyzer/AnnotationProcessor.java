package analyzer;

import excel.ExcelWriter;
import org.reflections.Reflections;
import sorters.Sorter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Class to work with annotations.
 * @version 1.8
 * @author B.Zhuk.
 *
 */
public class AnnotationProcessor {

    public static final String MAX_ARRAY = "Max Element";

    /**
     * Launches the process of processing arrays of different lengths for each of the sorters, for each of the fillers.
     * Starts the record of the results in excel file.
     * @param SIZE_LIST -l ist of sizes of input arrays.
     */
    public void make( List<Long> SIZE_LIST){
        HashMap<String, List<Long>> resultMap = new HashMap();
        HashMap<String,List<int[]>> initiateFillers = initiateFillers("fillers.Fillers", SIZE_LIST);
        Set<HashMap.Entry<String,List<int[]>>> elementSet = initiateFillers.entrySet();
        for (HashMap.Entry<String, List<int[]>> element : elementSet) {
            String name = element.getKey();
            List<int[]> arrayList = element.getValue();
            resultMap.put(MAX_ARRAY, SIZE_LIST);
            Reflections reflections = new Reflections("sorters");
            Set<Class<? extends Sorter>> classes = reflections.getSubTypesOf(Sorter.class);
            for (Class<? extends Sorter> cl : classes) {
                if (!Modifier.isAbstract(cl.getModifiers())) {
                    System.out.println(cl.getSimpleName());
                    List<Long> timeList = loadService(cl, arrayList);
                    resultMap.put(cl.getSimpleName(), timeList);
                }
            }
            try {
                ExcelWriter.sheetWriter(name, resultMap);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Launches service (Sorter) for array processing.
     * @param clazz - the class in which the sorting method is called.
     * @param arrayList - list of arrays of different lengths of one filler.
     * @return - the list contains the sorting time for each array.
     */
    List<Long> loadService(Class<?> clazz, List<int[]> arrayList) {
        List<Long> timeList = new ArrayList<>();
        try {
            if (clazz.isAnnotationPresent(Service.class)) {
                Object serviceOBj = clazz.newInstance();
                Class[] paramTypes = new Class[]{int[].class};
                Method method = clazz.getMethod("sort", paramTypes);

                for (int[] array : arrayList) {
                Long startTime = System.nanoTime();
                method.invoke(serviceOBj, array);
                Long endTime = System.nanoTime();
                timeList.add(endTime - startTime);
                }
            }
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (InstantiationException e) {
            System.out.println(e);
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        } catch (InvocationTargetException e) {
            System.out.println(e);
        }
        return timeList;
    }


    /**
     * Initiates arrays from each filler.
     * @param className - name of Filler.
     * @param maxArray - array length.
     * @return Map<String, int[]> where String - name Filler, int[] - his array.
     */
    HashMap<String, List<int[]>> initiateFillers(String className, List<Long> maxArray) {
        HashMap<String, List<int[]>> initiateMap = new HashMap<>();
        int maxInt;

        try {
            Class<?> loader = Class.forName(className);
            Object serviceOBj = loader.newInstance();
            Method[] methods = loader.getMethods();
            for (Method method : methods) {
                List<int[]> list = new ArrayList<>();
                if (method.isAnnotationPresent(Init.class)) {
                    Class[] paramTypes = new Class[]{int.class};
                    String type = method.getName();
                    loader.getMethod(type, paramTypes);
                    for (Long max: maxArray) {
                        maxInt =(int)max.longValue();
                        int[] array = (int[]) method.invoke(serviceOBj, maxInt);
                        list.add(array);
                    }
                    initiateMap.put(type, list);
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (InstantiationException e) {
            System.out.println(e);
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        } catch (InvocationTargetException e) {
            System.out.println(e);
        }
        return initiateMap;
    }

}

