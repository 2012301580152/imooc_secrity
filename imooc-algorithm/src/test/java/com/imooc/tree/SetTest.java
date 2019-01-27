package com.imooc.tree;

import com.sun.deploy.util.StringUtils;
import sun.misc.ASCIICaseInsensitiveComparator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName SetTest
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/26 14:42
 * @Version 1.0
 */
public class SetTest {
    public static void main(String[] args) throws IOException {
//        Set<String> s = new TreeSet<>(new ASCIICaseInsensitiveComparator());
//        s.add("hello");
//        s.add("Hello");
//        s.add("你好");
//        s.add("HELLO");
//        System.out.println(s.size());
//        System.out.println(((TreeSet<String>) s).last());

        Map testMap = new HashMap();
        testMap.put("test", "rfrj");

        testMap.put("fwe", "fhreucfh");

        for (int i = 0; i < 10000000; i++) {
            testMap.put("fe"+ i, "ferhfu");
        }

        String [] words = getWords("text2.txt");

        Map<String, List<String>> map = computeAdjacentWords(words);

        printHighChangeables(map, 3);

//        words[0].sub


    }

    private static String[] getWords(String filepath) {
        String encoding = "UTF-8";
        File file = new File(filepath);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        FileInputStream in = null;
        String[] result = null;

        try {
            in = new FileInputStream(file);
            in.read(filecontent);
            String a =  new String(filecontent, encoding);
            result = StringUtils.splitString(a, "\r\n");


            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }
    public static void printHighChangeables(Map<String, List<String>> adjWords, int minWords) {
        int max = 0;

        List<Map.Entry<String,List<String>>> list = new ArrayList<Map.Entry<String,List<String>>>(adjWords.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<String,List<String>>>() {
            //升序排序
            public int compare(Map.Entry<String,List<String>> o1,
                               Map.Entry<String,List<String>> o2) {
                return Integer.compare(o1.getValue().size(),o2.getValue().size());
            }

        });

        for (Map.Entry<String, List<String>> entry:list){
            List<String> words = entry.getValue();

            String outStr = "";
            "x".hashCode();

            if(words.size()>=minWords) {
                outStr += entry.getKey() +  "(" + words.size()+"):";

                for (String w: words) {
                    outStr += " "+ w;
                }
                System.out.println(outStr);
                max = max > words.size()?max:words.size();
            }
        }

        System.out.println(max);

    }

    private static boolean oneCharOff(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int diffs = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)){
                if (++diffs>1){
                    return false;
                }
            }
        }
        return diffs == 1;
    }

    public static Map<String, List<String>> computeAdjacentWords(String[] theWords) {
        Map<String, List<String>> adjWords = new TreeMap<>();

        Map<Integer, List<String>> wordByLength = new TreeMap<>();



//        String[] words = new String[theWords.size()];
//
//        theWords.toArray(words);
        String[] words = theWords;
        for (String w : words) {
            update(wordByLength, w.length(), w);
        }

        for (List<String> groupsWords : wordByLength.values()) {
            String[] mywords = new String[groupsWords.size()];
            groupsWords.toArray(mywords);

            for (int i = 0; i < mywords.length; i++){
                for (int j = i+1; j < mywords.length; j++) {
                    if (oneCharOff(mywords[i], mywords[j])){
                        update(adjWords, mywords[i], mywords[j]);
                        update(adjWords, mywords[j], mywords[i]);
                    }
                }
            }
        }

//        for (int i = 0; i < words.length; i++){
//            for (int j = i + 1; j < words.length; j++) {
//                if (oneCharOff(words[i], words[j])){
//                    update(adjWords, words[i], words[j]);
//                    update(adjWords, words[j], words[i]);
//                }
//
//            }
//        }

        return adjWords;
    }

    private static <T> void update(Map<T, List<String>> m, T key, String value) {
        List<String> lst = m.get(key);
        if (lst == null) {
            lst = new ArrayList<>();
            m.put(key, lst);
        }
        lst.add(value);
    }
}
