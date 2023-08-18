
        else if (res(x + 1, y + 1, x1, x2 + 1) == 0 )
      {
          System.out.print("YES");
          break;
        }
        else if (res(x + 1, y + 1, x1 + 1, x2 + 1) == 0 )
      {
          System.out.print("YES");
          break;
        }
        else if (res(x + 1, y + 1, x1 - 1, x2) == 0 )
      {
          System.out.print("YES");
          break;
        }
        else if (res(x + 1, y + 1, x1, x2 - 1) == 0 )
      {
          System.out.print("YES");
          break;
        }
        else if (res(x + 1, y + 1, x1 - 1, x2 - 1) == 0 )
      {
          System.out.print("YES");
          break;
        }
        else if (res(x + 1, y + 1, x1 + 1, x2 - 1) == 0 )
      {
          System.out.print("YES");
          break;
        }
        else if (res(x + 1, y + 1, x1 - 1, x2 + 1) == 0 )
      {
          System.out.print("YES");
          break;
        }
