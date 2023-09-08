import java.util.Scanner;
class event {
  int number;
  int startDate;
  int endDate;
  event (int num, int startDate, int duration) {
    this.number = num;
    this.startDate = startDate;
    this.endDate = startDate + duration;
  }
  int getNum () { return this.number; }
  int getStart () { return this.startDate; }
  int getEnd () { return this.endDate; }
}

public class Assignment6 {

  static int partition (event e [], int low, int high) {
    event pivot = e[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      if (e[j].getEnd() <= pivot.getEnd()) {
        i++;
        event tmp = e[i];
        e[i] = e[j];
        e[j] = tmp;
      }
    }
    event tmp = e[i + 1];
    e[i + 1] = e[high];
    e[high] = tmp;
    return (i + 1);
  }

  static void sort (event [] e, int low, int high) {
    if (low < high) {
      int pi = partition(e, low, high);
      sort(e, low, pi-1);
      sort(e, pi+1, high);
    }
  }

  static int compatibleEvents (event [] e) {
    int numEv = 1;
    int k = 0;
    int n = e.length;
    for (int i = 1; i < n; i++) {
      if (e[i].getStart() >= e[k].getEnd()) {
        numEv++;
        k = i;
      }
    }
    return numEv;
  }

  public static void main (String [] args) {
    Scanner sc = new Scanner(System.in);
    int numOfEvents = sc.nextInt();
    event [] ev = new event[numOfEvents];
    for (int i = 0; i < numOfEvents; i++) {
      ev[i] = new event((i + 1), sc.nextInt(), sc.nextInt());
    }

    sort(ev, 0, numOfEvents - 1);

    System.out.println(compatibleEvents(ev));
    sc.close();
  }
}
