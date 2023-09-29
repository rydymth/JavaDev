class node {
  Integer data;
  node next;
  node () {
    this.next = null;
    this.data = null;
  }

  node (int c)
  {
    this.data = c;
  }
}

class linkedList {
  node head;
  void addNode (Integer data)
  {
    node newNode = new node(data);
    if (head == null)
      head = newNode;
    else
    {
      node tmp = head;
      while(tmp.next != null)
        tmp = tmp.next;
      tmp.next = newNode;
    }
  }
}

public class H {

}
