/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package automatonlang;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Johannes
 */
public class Tree {

   public static final class Mode {

      public static final int FINITE = 0;
      public static final int MEALY = 1;
      public static final int DEF_MODE = FINITE;
   }

   public static final class DistributionMode {

      public static final int RANDOM = 4;
      public static final int CIRCULAR = 5;
      public static final int DEF_MODE = CIRCULAR;
   }
   private State start;
   private int mode;
   private int counter = 0;
   private HashMap<String, State> states = new HashMap<String, State>();
   private ArrayList<Transition> transitions = new ArrayList<Transition>();
   private int distribution_mode = DistributionMode.DEF_MODE;
   public static final int DISTR_RANDOM = 4;
   public static final int DISTR_CIRCULAR = 5;
   public static final int DISTR_DEF_MODE = DISTR_CIRCULAR;
   private int paint_height = 500;
   private int paint_width = 500;
   private ArrayList<VerbalTransition> verbtransitions = new ArrayList<VerbalTransition>();

   public Tree() {
      this(Mode.DEF_MODE);
   }

   public Tree(int mode) {
      this.mode = mode;
   }

   public State getStart() {
      return start;
   }

   public void setStart(State start) {
      this.start = start;
   }

   public int getMode() {
      return mode;
   }

   public String serialize() {
      redistributeStates();
      String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n"
              + "<!--Created with AutomationLang--><structure>&#13;\n";
      if (mode == Mode.FINITE) {
         str += "<type>fa</type>&#13;\n";
      } else if (mode == Mode.MEALY) {
         str += "<type>mealy</type>&#13;\n";
      }
      str += "<automaton>&#13;\n";
      for (Map.Entry<String, State> entry : states.entrySet()) {
         State state = entry.getValue();
         str += state.serialize();
      }
      for (Transition transition : transitions) {
         str += transition.serialize();
      }
      str += "</automaton>&#13;</structure>";
      return str;
   }

   public void serialize(String filename) throws IOException {
      FileWriter writer = new FileWriter(filename);
      writer.write(serialize());
   }

   public int getCounter() {
      counter++;
      return counter;
   }

   public HashMap<String, State> getStates() {
      return states;
   }

   public ArrayList<Transition> getTransitions() {
      return transitions;
   }

   public State createState(String label, boolean final_state) {
      State state = new State(label, this, final_state);
      states.put(label, state);
      return state;
   }

   public Transition createTransition(State from, State to, String word, String output) {
      Transition transition = new Transition(this, from, to, word, output);
      transitions.add(transition);
      return transition;
   }

   public VerbalTransition createVerbalTransition(State from, State to, String condition, int line) {
      VerbalTransition transition = new VerbalTransition(this, from, to, condition, line);
      verbtransitions.add(transition);
      return transition;
   }

   public Transition createTransition(String from, String to, String word, String output) {
      return createTransition(getState(from), getState(to), word, output);
   }

   public void redistributeStates() {
      if (states.isEmpty()) {
         return;
      }
      if (distribution_mode == DISTR_CIRCULAR) {
         double radius = (paint_height - 20) / 2;
         double fac = 2 * Math.PI / states.size();
         double num = 0;
         for (Map.Entry<String, State> entry : states.entrySet()) {
            State state = entry.getValue();
            if (state.getX() == -1 && state.getY() == -1) {
               state.setPosition((int) ((radius * -Math.cos(fac * num)) + radius) + 10, (int) ((radius * Math.sin(fac * num)) + radius) + 10);
            }
            num++;
         }
      } else if (distribution_mode == DISTR_RANDOM) {
         for (Map.Entry<String, State> entry : states.entrySet()) {
            State state = entry.getValue();
            if (state.getX() == -1 && state.getY() == -1) {
               state.setPosition((int) (Math.random() * (paint_width - 20)) + 10,
                       (int) (Math.random() * (paint_height - 20)) + 10);
            }
         }
      }
   }

   public TestReturn test(String phrase) {
      if (start != null) {
         TestReturn ret = start.test(phrase);
         return ret;
      }
      return new TestReturn(false, phrase);
   }

   public State getState(String label) {
      return (State) states.get(label);
   }

   public int getDistribution_mode() {
      return distribution_mode;
   }

   public int getPaintHeight() {
      return paint_height;
   }

   public int getPaintWidth() {
      return paint_width;
   }

   public void setDistributionMode(int distribution_mode) {
      this.distribution_mode = distribution_mode;
   }

   public void setMode(int mode) {
      this.mode = mode;
   }

   public void setPaintHeight(int paint_height) {
      this.paint_height = paint_height;
   }

   public void setPaintWidth(int paint_width) {
      this.paint_width = paint_width;
   }

   public ArrayList<VerbalTransition> getVerbalTransitions() {
      return verbtransitions;
   }

   public static class TestReturn {

      public final boolean succeeded;
      public final String text;

      public TestReturn(boolean succeeded, String text) {
         this.succeeded = succeeded;
         this.text = text;
      }
   }

   public static class Error {

      public final int line;
      public final int offset;
      public final String msg;

      public Error(int line, int offset, String msg) {
         this.line = line;
         this.offset = offset;
         this.msg = msg;
      }
   }
}
