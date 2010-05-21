package esjtrader.client;

import java.util.*;
import sessionj.runtime.*;
import sessionj.runtime.net.*;
import sessionj.runtime.transport.*;
import esjtrader.utils.TradePacket;

public class Trader {
    final private static SJProtocol p_client =
      new SJProtocol(
      ("H4sIAAAAAAAAAI1US0wTURR9bal8JIr8xFBBpCCIaaMJxoiJUCxKGYRQiUhU" +
       "eJ15ttPOz5lXKIkh\nLHFjQmLiypgYDBtWGuPSEE1IdKULYlzoAmNc6MKVLl" +
       "j4Pv1CGWzS6Zu+e84979z77uov4LZM4LWQ\nZcm6FvfhOQNZPvrKV+FQGOFr" +
       "ZDklrm9ceK5hz6YTOARQqiI1gkwLg3ohDmegP4llxd+vKwoSMWHq\nSZmgw5" +
       "aVbXFmwD8OxuwWY7IiYdAhZOB+BvJn4f4COM3Uui0TfeqROJFCc/EkS6Xhle" +
       "vRh8tOAAii\nztCVuaii4zSCx/S1vRoXfrxu5jGNRWJGGOuUuHXWc/Rj37dy" +
       "F5VcZuiWTE+NQYOQAXFHRtM7PSnD\nSBnE6nbqlo/u+XJuWd5xTdUl+Y4MIw" +
       "oSZAtvHWw7/fLngypmSYlC/sGgKs9pGkNPfmpvutz/RwJg\n4f3tP02M1CHe" +
       "BfPAwUTV5lgEWUsgidJXdoZvhaYXj7uIGcZsCS0QCT1hU9T+AIrKO2pKrWy3" +
       "QeWB\nziuP1p+N/l6kIKrOaaRIypM24DEkJs1dOsmlwAgGh3N9xJwLhwQYQQ" +
       "o1r82GWNB1g3MmQk8n10J/\nBV6KiC7NUWmujEBjD4UjSRwxoSbGivli52ag" +
       "KMo5Capl6xIykCYhDStzNECi1wYSMAY1eU1yBVqx\nYWj0ZKUCovVQrtbpfX" +
       "fp57U39dMfXMA5ACoUHUoDUMS6OQjKccxEVkxXpJRxsZdJqJwtI88q8nUS\n" +
       "srqsfkaY9jZP7SAoi5Es/bqEMgWp5goVqEX9/DqRywG8C18xKLkavDxi2Rcm" +
       "TA5ezMpuG8wwWcMo\nuQmqmtRkEeJswzRvNDyu8HadY8Xdr/I4uoVBXe4q87" +
       "HDp02mL+nvMdafdnOO9yfapTspR02ukejC\nQwImMHBMEOKmbQNo1JRVMk1m" +
       "0nRLTcvfX2yO1fLGTMgamZqt20UXYLxDJIgfwc2kt9hlYNFvu1pW\n58e+RL" +
       "jJ1dl4Vu+gllS7n3xCnb2VIlehQRUVljiMTVmLkhJj4JI1TJJ6tidVoIiukC" +
       "ZD5pS4svnu\nXnDo/mKOjqr1UXgjsuLYhCSMZScDmb6MQjGBMPcuOXuzFoN9" +
       "gfEb4aDw/xVCWUvzW4rCW9KFbttR\nHvrSRR9nUoUbDHfgHy/utMxZBwAA"));
    
    public Trader(final String setups, final String transports, String server,
                  int port, final int port_t, String trader_id)
          throws Exception {
        super();
        SJSocket s = null;
        SJSessionParameters params =
          SJTransportUtils.createSJSessionParameters(setups, transports);
        final SJService service = SJService.create(p_client, server, port);
        try {
            s = service.request(params);
            Scanner scanner = new Scanner(System.in);
            String activity = "";
            String ticker = "";
            int quant = 0;
            double price = 0.0;
            System.out.println("WELCOME TO esjTRADER.\nENTER ACTIVITY:\n");
            {
                for (boolean _sjrecursion_s_X = true; _sjrecursion_s_X; ) {
                    _sjrecursion_s_X = SJRuntime.recursionEnter("X", s);
                    System.out.println("BUY | SELL | NEG");
                    activity = scanner.nextLine();
                    System.out.println("ENTER TICKER NAME:");
                    ticker = scanner.nextLine();
                    System.out.println("ENTER QUANTITY (integer):");
                    quant = Integer.parseInt(scanner.nextLine());
                    System.out.println("ENTER PRICE (double):");
                    price = Double.parseDouble(scanner.nextLine());
                    TradePacket tp =
                      new TradePacket(trader_id, activity, ticker, price,
                                      quant);
                    tp.setConnection("localhost", port_t);
                    if (activity.equalsIgnoreCase("BUY") ||
                          activity.equalsIgnoreCase("SELL")) {
                        {
                            SJRuntime.outlabel("BUYSEL", s);
                            SJRuntime.send(tp, s);
                            int x = SJRuntime.receiveInt(s);
                            System.out.println("Trade ID: " + x + "\n");
                            _sjrecursion_s_X = SJRuntime.recurse("X", s);
                        }
                    } else {
                        {
                            SJRuntime.outlabel("NEGO", s);
                            SJRuntime.send(new TradePacket(), s);
                            SJRuntime.send(0, s);
                            _sjrecursion_s_X = SJRuntime.recurse("X", s);
                        }
                    }
                }
            }
        }
        finally {
            SJRuntime.close(s);
        }
    }
    
    public static void main(String[] args) throws Exception {
        String setups = args[0];
        String transports = args[1];
        String server = args[2];
        int port = Integer.parseInt(args[3]);
        int port_t = Integer.parseInt(args[4]);
        String trader_id = args[5];
        new Trader(setups, transports, server, port, port_t, trader_id);
    }
    
    final public static String jlc$CompilerVersion$jl = "2.3.0";
    final public static long jlc$SourceLastModified$jl = 1272600884000L;
    final public static String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAJVYfWwcRxWfu7Pv/HHFH3HcNHbsfFyamDR3TUWrUCOS2LUb" +
       "O+fY8TlfJsXe2527\nW2dud7s7a5+jqkoBNWkREahJWypKEWpVAZEoqQp/gA" +
       "pVWwIUhAiSWyG1/BEElWgR+YdGKBTezOzt\n7u2dL8XSjWdn3rx57817v/dm" +
       "Ln6IGi0TJS1sWaquLSTpsoEt3urZBSxTK5kZn5JMCyvDRLKsGZiY\nk+c/Vo" +
       "/8qONL+8MoNIs6NX0fUSVrpmDqdr4wU1Ctkok2GjpZzhOdOhyreNy75cbSb8" +
       "+M90RQ2yxq\nU7UMlagqD+saxSU6i+JFXMxi09qnKFiZRR0axkoGm6pE1FNA" +
       "qGuwsaXmNYnaJramsaWTRUbYadkG\nNvme5cE0isu6ZlHTlqluWhS1pxekRS" +
       "llU5Wk0qpFB9MomlMxUawH0cMonEaNOSLlgbA7XdYixTmm\nRtk4kLeoIKaZ" +
       "k2RcXtJwUtUUivqDK1yNEweAAJbGipgWdHerBk2CAdQpRCKSlk9lqKlqeSBt" +
       "1G3Y\nhaL1qzIFoiZDkk9KeTxH0bog3ZSYAqpmbha2hKK1QTLOCc5sfeDMfK" +
       "c1GY3/5/GpjzbCiYPMCpYJ\nkz8Ki/oCi6ZxDptYk7FYeN1Onh87bveGEQLi" +
       "tQFiQbNv608Op9//eb+g6alBM8l9cU6+cU/vhiv7\n/tIcYWI0GbqlMleo0J" +
       "yf6pQzM1gywLu7XY5sMlme/MX0L4+f/j7+exg1jaGorBO7qI2hZqwpw04/\n" +
       "Bv20qmExOpnLWZiOoQbCh6I6/wZz5FSCmTkaoW9ItMD7JQMhFINfCH4nkPi7" +
       "hTUUNc+YkoLNpLVA\nUZ9lyikMPT6UkomKNZpyCUqM2aeWQiHQozcYUwQccL" +
       "9OgHJOfvHqbx4aOfDYWXFCzKscMSi61WWf\nFOyTgj0KhTjfNcz3hG32maa0" +
       "zGKi9MiVDd+8LD0LlgaNLfUU5gqFlhpYC4vuqgsZw17AjUFPAn+Y\nk7tOv7" +
       "/+mT9+780witSEjbQ7OKqbRYmwky/HSaezXXAGHCYRdNtae//j8YmXV956d7" +
       "vnwBQlquKq\neiWLi81Bu5u6jBXAHY/9U//e/88nGj/7Shg1QLAB3FAJnARi" +
       "ty+4R0V8DJaxhukSSaPWXJXiLRQM\ntORTmLVx3m+Do2iCH8QNmnA8rIs1bL" +
       "KDNZ3CfeC4ugI6cCS7/uXonW//rPVNbpQy6LX50DGDqQih\nDs9FZkyMYfzd" +
       "p6eeuPDhmS9EIGgNQ7gFRVHDzhJVLsGSWyujjmmgMM/64NJg+7md1o+5FzSr" +
       "xaJN\npSzBgNISIfoSVuYoh6kOHyRyJAJjxbOAaACOcwQYCXMYoUXw4BqYkV" +
       "zXdf7JgW+9zVDF4PbqBhmj\nXNIo/14DqYDrxfZICthl4zt4Y1Vj25SpFgE6" +
       "Fh1s+0bf8399+ep0l/ApkQC2VGGwf41IAvxQWg1m\npE31duDUb+zYdPHh6f" +
       "eyAhw7K406otnFu597Bw/sjcs1Aj8CaYp9pLhCJa701hBrB1yDlCPaMcga\n" +
       "zyAjJRkbDCi5vBtY0Hd5bgC4eFIcaHwg88D4/NnN3BOEeT0ruk0qKMjuT0Ra" +
       "qhLURJ+pCz2jLJND\niFIdIN2L0PmvvnNo4tjRlLDjrrosDoIRFc7HW39hTN" +
       "vz6toVLcyCMmotuIZOo7BFKdqeLrN0Dp59\nil5mPCOmyon2jpsr4G2sPvSv" +
       "Ry79/kIcNp5FMdUaVTWJsMixDgqwrJGEAyxOvXr429d/R9/jLuKh\nExO/t1" +
       "SdV45IPuDcvbLYEX3puWIYxWZROy+kJI0ekYjNUGAWSiFr2BlMo1sq5ivLGp" +
       "HDB1307Q1G\nim/bIC42+KzdwKhZv8kPhf8Vfx+zH4NA9iGSbeewXjQgQ5sb" +
       "78egtESxYpRCIYMtu48v7uftZuG7\nEQpbMxNTFDNMdRHoAdYsXp2WKBQdcy" +
       "KHlgOmxz1L09aoWsSsYHa8j4NviAdcGvw2ETh210OSzEOo\nAJXLK5+7pNHe" +
       "q/ysYk4VzEpRD5WhPCFgSl7fmGh7Xa6u383JToYICbSXCypRmGSfBx5b6jqk" +
       "g3ax\nzItH8+efZwHkABjLDLd7kODJZSUOa0VdUXMqh3YAiRttW3e98sG5do" +
       "FSHnxDMNycgTd+2xA6/dYX\nP+rjbEIy4zHloPtuFx+21bHI8BDOq1UGYZBw" +
       "e51VvkX3kqcuvzB17WzZDIc4jn+6zuJpLNvmKscQ\nIVIWCjQPO0TaHU9LWU" +
       "zY6W6twzit64bgeXL8u7OvjV9PC+tmdWVZnKwjoHETCSdtmjUh7gq17FLP\n" +
       "mkM1VwFOdarWfdiAohkihSyL3A8+J8FiyDE+X94vWYUJyRh0RUWV1YYz3xj7" +
       "02uvd8//IYLCo6iF\n6JIyKvEyDTVDfYStAlTBJWPPXi5CfIlVRe2sMgJma1" +
       "35OUPHtj5px1BTAXYZ1hUsDoSJMgSSJE7/\nmaKGgyP3T1r1DyIDitYy3d11" +
       "1kxAH+5mAE5FW1NlfqcVPPpX1j3bktixmx9ma1HQzVSAHnM69r/A\nna8eAg" +
       "jnw6u4HuNxwvMS1sFAcIyi0DH+tdPgs3e5aOddJZg1LXGTYPdMLBAR20snug" +
       "Awhw4fz4yk\nP7mQ2K2q/CZky1VHV1IlIfvgMP5gqXKCrzvK202i6EFe0SNw" +
       "AjGZNqx24eWV15lj1+KPSm88UBZk\nF1zcqG7sJHgRkxplyc66IDrBr/1eXo" +
       "1k9gxsu6P1b3BjWOUy1OEMTmNqm5rrAPyWJP3ft6T+gK5B\neToWew5FCuqv" +
       "wjzfihRd9ZpRuWiwMjG3mJWCcqP1uDcV9tsGv0nngCdr3lSq8nGY9ROsOVC/" +
       "gK1+\nv+CXWeFUlyKJa+Gfdif4/awhCzjk2LLy4af6XafiuYbL2OJqdBv8+m" +
       "+i0Y6ahfZe1pwrhYT7fn0V\nrce46lB0RAnW8uJdgZfFX/Oq4rAgr1G+DxNd" +
       "wyx7ludE8a7qSfcdDSar62v2/RUhH9/LF0UBy6Ny\nJNWbZN/PQE0lM3FqXL" +
       "tEWViqe7bs8x7O6VEA5CIUr2Vw4v/vhMFFXVU43Qv+YsBnrIoRZlPxBsJS\n" +
       "47qqt0rxoiZvvjK//XWj49fCa8qvXrE0asrZhPhrUl8/apg4p3JpY6JCFRh6" +
       "EdQOPsSAGL5q8geC\n8IeAMy4hG3iJe8l3SqH/AT5p9ASuFQAA");
}
