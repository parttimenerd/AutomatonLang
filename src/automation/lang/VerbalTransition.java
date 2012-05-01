/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package automation.lang;

/**
 *
 * @author Johannes
 */
public class VerbalTransition {
   public final Tree tree;
   public final State from;
   public final State to;
   public final String condition;
   public final int line;

   public VerbalTransition(Tree tree, State from, State to, String condition, int line) {
      this.tree = tree;
      this.from = from;
      this.to = to;
      this.condition = condition;
      this.line = line;
   }
}
