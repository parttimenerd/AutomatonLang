/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package automation.lang;

import automation.lang.Tree.TestReturn;
import java.util.ArrayList;

/**
 *
 * @author Johannes
 */
public class State {

   private String label;
   private Tree tree;
   private final int id;
   private ArrayList<Transition> transitions = new ArrayList<Transition>();
   private boolean final_state;
   private boolean initial_state;
   private double x = -1;
   private double y = -1;

   public State(String label, Tree tree, boolean initial_state, boolean final_state) {
      this.label = label;
      this.tree = tree;
      this.id = tree.getCounter();
      this.final_state = final_state;
      this.initial_state = initial_state;
   }

   public State(String label, Tree tree, boolean final_state) {
      this(label, tree, tree.getStates().isEmpty() ? true : false, final_state);
   }

   public String getLabel() {
      return label;
   }

   public Tree getTree() {
      return tree;
   }

   public int getId() {
      return id;
   }

   public ArrayList<Transition> getTransitions() {
      return transitions;
   }

   public void addTransition(Transition transition) {
      transitions.add(transition);
   }

   public String serialize() {
      int _x = (int) (this.x % 1 > 0 ? this.x * tree.getPaintWidth() : this.x);
      int _y = (int) (this.y % 1 > 0 ? this.y * tree.getPaintHeight() : this.y);
      String str = "<state id=\"" + id + "\" name=\"" + label + "\">&#13;";
      str += "<x>" + _x + ".0</x>"
              + "&#13;<y>" + _y + ".0</y>&#13;";
      if (final_state) {
         str += "<final/>&#13;";
      }
      if (initial_state) {
         str += "<initial/>&#13;";
      }
      str += "</state>&#13;\n";
      return str;
   }

   public TestReturn test(String phrase) {
      TestReturn ret = new TestReturn(false, "");
      if (phrase == null || phrase == "") {
         return new TestReturn(final_state, "");
      } else {
         for (Transition transition : transitions) {
            if (phrase.startsWith(transition.getWord())) {
               String new_phrase = phrase.substring(transition.getWord().length());
               if ((new_phrase == null || new_phrase.length() == 0) && transition.getTo().isFinal_state()) {
                  return new TestReturn(true, transition.getWord());
               } else {
                  TestReturn obj = transition.getTo().test(new_phrase);
                  if (obj.succeeded) {
                     ret = new TestReturn(true, transition.getWord() + obj.text);
                     break;
                  }
               }
            }
         }
      }
      return ret;
   }

   public boolean isFinal_state() {
      return final_state;
   }

   public boolean isInitial_state() {
      return initial_state;
   }

   public void setPosition(double x, double y) {
      this.x = x;
      this.y = y;
   }

   public int getX() {
      return (int) (this.x % 1 > 0 ? this.x * tree.getPaintWidth() : this.x);
   }

   public int getY() {
      return (int) (this.y % 1 > 0 ? this.y * tree.getPaintWidth() : this.y);
   }

   public void setX(double x) {
      this.x = x;
   }

   public void setY(double y) {
      this.y = y;
   }

   public void setFinal_state(boolean final_state) {
      this.final_state = final_state;
   }
}
