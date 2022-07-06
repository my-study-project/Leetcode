package com.js;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class Test {
    public static void changeNum(int[] array, int i, int j) {
        int temp = 0;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 原数组输入
        String inputString = sc.nextLine();
        String[] strList = inputString.split(" ");
        try {
            int[] ints = Arrays.stream(strList).mapToInt(Integer::valueOf).toArray();
            int flag = 0, result = 0;
            for (int i = 0; i < ints.length - 1; i++) {
                for (int j = i + 1; j > 0; j--) {
                    if (flag == 0) {
                        if (ints[i] < ints[j]) {
                            changeNum(ints, i, j);
                            result++;
                        }
                        flag = 1;

                    } else {
                        if (ints[i] > ints[j]) {
                            changeNum(ints, i, j);
                            result++;
                        }
                        flag = 0;
                    }
                }
            }
            for (int i = 0; i < ints.length; i++) {
                System.out.println(ints[i] + " ");
            }
        } catch (Exception e) {
            System.out.println("[]");

        }
    }

    public void sort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];
        while (end > start) {
            //从后往前比较
            while (end > start && a[end] >= key) {
                //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            }
            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while (end > start && a[start] <= key) {
                //如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            }
            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if (start > low) sort(a, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        if (end < high) sort(a, end + 1, high);//右边序列。从关键值索引+1 到最后一个
    }


    public void test(String[] args) throws Exception {
        ReentrantLock lock = new ReentrantLock();
        boolean b = lock.tryLock();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("","");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>(8);
        concurrentHashMap.put("", "");
//        byte[] bytes = null;
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        List<Map<Integer, String>> maps = new ArrayList<>();
//        Map<Integer, String> map1 = new HashMap<>();
//        map1.put(2, "100");
//        map1.put(1, "200");
//        Map<Integer, String> map2 = new HashMap<>();
//        map2.put(2, "300");
//        map2.put(1, "400");
//        maps.add(map2);
//        maps.add(map1);
//
//        for (Map<Integer, String> tempMap : maps) {
//            Map<Integer, String> integerStringMap = sortByKey(tempMap);
//            List<String> collect = integerStringMap.values().stream().collect(Collectors.toList());
//            String join = String.join(",", collect) + "\n";
//            os.write(join.getBytes(StandardCharsets.UTF_8));
//        }
//        os.flush();
//        File file = new File("/Users/mac/Desktop/a.txt");
//        //建立输出字节流
//        FileOutputStream fos = new FileOutputStream(file);
//        bytes = os.toByteArray();
//        fos.write(bytes);
//
//        os.close();
    }

    public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }


}
