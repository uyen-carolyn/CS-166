import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;

import java.io.*; 
import java.util.*; 

public class Decrypt {

  public static void main(String[] args) {
    // order of letters by highest freq to lowest
    char[] commonLetters = {
      "e", "t", "a", "o", "i", "n",
      "s", "r", "h", "d", "l", "u",
      "c", "m", "f", "y", "w", "g",
      "p", "b", "v", "k", "x", "q",
      "j", "z"
    };

    char[]

    // convert file of ciphertext into string to be decrypt
    File file = new File("cipher.txt");
    String s = FileUtils.readFileToString(file).toLowerCase();

    String results = ""; 

    // count frequencies of letters 
    Map<Character, Integer> map = new TreeMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      Integer val = map.get(c);
      if (val != null) {
        map.put(c, new Integer(val + 1));
      }
      else {
        map.put(c, 1);
        }
     }

     // sort map in descending order
     List < Map.Entry < Character, Integer > > list = new LinkedList < Map.Entry < Character, Integer > > (map.entrySet());
     Collections.sort(list, new Comparator < Map.Entry < String, Integer > > () {
      public int compare(Map.Entry < String, Integer > o1, Map.Entry < String, Integer > o2) {
        return (o2.getValue()).compareTo(o1.getValue());
       }
      });

      Map < Character, Integer > sortedMap = new TreeMap < Character, Integer > ();
      for (Map.Entry < Character, Integer > aa: list) {
        sortedMap.put(aa.getKey(), aa.getValue());
      }

      // map frequencies to common letters
      Map < String, Character> alphabetMap = new TreeMap < String, Character > (); 
      for (int i = 0; i < commonLetters.length; i++) {
        alphabetMap.put(i, ""); 
      }

      Iterator itr = alphabetMap.keySet().iterator();

      while (itr.hasNext()) {
        String key =  itr.next().toString();
        String value = sortedMap.get(key).toString();
      }

      // decrypt by comparing ciphertext letters to alphabet map
      for (int i = 0; i < s.length; i++) {
        for (Character key : alphabetMap.keySet()) {
          if (s.charAt(i).equals(alphabetMap.getValue()) {
            results = results + alphabetMap.getKey();  
          }
        }
      }     
       
      return results; 
  }
}
