/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package automatonlang;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;

/**
 *
 * @author Johannes
 */
public class Utils {

   public static ArrayList<String> range(String begin, String end, boolean include_end) {
      return range(begin, end, 1, include_end);
   }

   public static ArrayList<String> range(String begin, String end, int increment, boolean include_end) {
      //TODO Implement real string range
      ArrayList<String> list = new ArrayList<String>();
      if (!"".equals(begin) && !"".equals(end)) {
         char b = begin.charAt(begin.length() - 1);
         char e = end.charAt(end.length() - 1);
         String b_rest = "";
         if (!include_end) {
            e -= 1;
         }
         if (b > e) {
            char t = b;
            b = e;
            e = t;
            b_rest = end.length() > 1 ? end.substring(0, end.length() - 1) : "";
         } else {
            b_rest = begin.length() > 1 ? begin.substring(0, begin.length() - 1) : "";
         }
         for (char i = b; i <= e; i += increment) {
            list.add(b_rest + i);
         }
      }
      return list;
   }

   public static CommonTokenStream saveCodeInFileAndGetTokenStream(String code, String file) throws IOException {
      FileWriter writer = new FileWriter(file);
      writer.write(code);
      writer.close();
      CharStream cs = new ANTLRFileStream(file);
      AutomatonLangLexer lexer = new AutomatonLangLexer(cs);
      CommonTokenStream tokens = new CommonTokenStream();
      tokens.setTokenSource(lexer);
      return tokens;
   }

   /*
    * public static void main(String[] args) { ArrayList<String> list =
    * range("a", "z", false); for (String string : list) {
    * System.out.println(string); }
   }
    */
}
