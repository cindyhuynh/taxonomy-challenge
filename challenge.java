/*
 * NAME: Cindy Huynh
 * DATE: 4/5/19
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This program generates information of the taxonomy level and number of reads.
 * It shows the total number of "reads" that fall under a certain term in the
 * taxonomy.
 *
 * @author Cindy Huynh
 * @since 4/5/19
 */
public class challenge {
  /**
   * Main method that drives this program
   *
   * @param args the command line argument
   */
  public static void main(String args[]) {

    String[] alphabet = {"A", "B", "C","D",
        "E", "F", "G", "H", "I", "J", "K","L" ,"M",
        "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    HashMap<String, Node> map = new HashMap<>();

    //create a new node and inserting into hashmap for each alphabet for easy
    //access
    for (int i = 0; i < alphabet.length; i++) {
      map.put(alphabet[i], new Node(0));
    }

    //building the tree by linking all the nodes with their respective children
    Node root = map.get("A");
    root.addChild(map.get("B"));
    root.addChild(map.get("C"));
    root.addChild(map.get("D"));
    root.addChild(map.get("E"));

    Node D_node = map.get("D");
    D_node.addChild(map.get("F"));
    D_node.addChild(map.get("G"));
    D_node.addChild(map.get("H"));
    D_node.addChild(map.get("I"));

    Node G_node = map.get("G");
    G_node.addChild(map.get("J"));
    G_node.addChild(map.get("K"));
    G_node.addChild(map.get("L"));
    G_node.addChild(map.get("M"));

    Node L_node = map.get("L");
    L_node.addChild(map.get("O"));
    L_node.addChild(map.get("P"));
    L_node.addChild(map.get("Q"));
    L_node.addChild(map.get("N"));

    Node Q_node = map.get("Q");
    Q_node.addChild(map.get("R"));
    Q_node.addChild(map.get("S"));
    Q_node.addChild(map.get("T"));
    Q_node.addChild(map.get("U"));

    Node T_node = map.get("T");
    T_node.addChild(map.get("V"));
    T_node.addChild(map.get("W"));
    T_node.addChild(map.get("X"));
    T_node.addChild(map.get("Y"));

    Node V_node = map.get("V");
    V_node.addChild(map.get("Z"));

    //reading the input file to extract value corresponding with each letter
    File file = new File("input.txt");

    try {
      Scanner scanner = new Scanner(file);

      while(scanner.hasNextLine()) {

        if (scanner.hasNext()) {
          String letter = scanner.next();

          if (scanner.hasNextInt()) {
            int val = scanner.nextInt();

            //setting the value from input file to the designated letter in the
            //hash map
            map.get(letter).setValue(val);
          }

        } else {
          break;
        }
      }

      } catch(FileNotFoundException e) {
        System.out.println("\nFile not found!!");
      }

      //changing the values of the nodes on each level
      valChange(root);

      //printing the classification report with the letter and the value
      //separated by a tab
      for (Map.Entry<String, Node> obj : map.entrySet()) {
        String letter = obj.getKey();
        Node node = obj.getValue();

        if (node.getValue() > 1) {
          System.out.println(letter + " " + node.getValue());
        }
      }
  }

  /**
   * Recursive method to change the values of each node to the updated values of
   * all children plus itself.
   *
   * @param n the node to update value
   */
  public static void valChange(Node n) {

    if (n.getChildren().size() == 0) {
      return;
    }

    int value = n.getValue();

    //adding up all the values for all children
    for (int i = 0; i < n.getChildren().size(); i++) {
      valChange(n.getChildren().get(i));
      value = n.getChildren().get(i).getValue() + value;
    }
    //setting the new value to the sum of all children
    n.setValue(value);
  }

}
