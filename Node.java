/*
 * NAME: Cindy Huynh
 * DATE: 4/5/19
 */

import java.util.*;

/**
 * This class creates node objects that can have children and value and label.
 *
 * @author Cindy Huynh
 * @since 4/5/19
 */
public class Node {
  private int value = 0;
  private String label = "";
  private List<Node> children = new ArrayList<>();
  private Node parent = null;

  public Node(int value, String label) {
    this.value = value;
    this.label = label;
  }

  public void addChild(Node child) {
    child.setParent(this);
    this.children.add(child);
  }

  public List<Node> getChildren() {
    return children;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public void setParent(Node parent) {
    this.parent = parent;
  }

  public void printTree() {
    Queue<Node> queue = new LinkedList<>();
    queue.add(this);

    while (!queue.isEmpty()) {

      for (int i = 0; i < queue.size(); i++) {
        Node curr = queue.remove();

        if (curr.getValue() > 1) {
          System.out.println(curr.getLabel() + " " + curr.getValue());

          for (int j = 0; j < curr.getChildren().size(); j++) {
            queue.add(curr.getChildren().get(j));
          }
        }
      }
    }
  }

}
