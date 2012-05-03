/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package automatonlang;

/**
 *
 * @author Johannes
 */
public class Transition {

   private Tree tree;
   private State from;
   private State to;
   private String word;
   private String output;

   public Transition(Tree tree, State from, State to, String word, String output) {
      this.tree = tree;
      this.from = from;
      this.to = to;
      this.word = word;
      this.output = output;
      this.from.addTransition(this);
   }

   public String serialize() {
      String str = "<transition>&#13;";
      str += "<from>" + from.getId() + "</from>&#13;";
      str += "<to>" + to.getId() + "</to>&#13;";
      str += "<read>" + word + "</read>&#13;";
      if (tree.getMode() == Tree.Mode.MEALY) {
         str += "<transout>" + output + "</transout>&#13";
      }
      str += "</transition>&#13;\n";
      return str;
   }

   public State getFrom() {
      return from;
   }

   public State getTo() {
      return to;
   }

   public String getWord() {
      return word;
   }

   public String getOutput() {
      return output;
   }
}
