/*
 * NAME: Cindy Huynh
 * DATE: 4/5/19
 */

import java.util.*;

/**
 * This class creates node objects that can have children and value.
 *
 * @author Cindy Huynh
 * @since 4/5/19
 */
public class Node {
  private int value = 0;
  private List<Node> children = new ArrayList<>();
  private Node parent = null;

  public Node(int value) {
      this.value = value;
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

  private void setParent(Node parent) {
      this.parent = parent;
  }

}
