package esjtrader.utils;

import java.io.Serializable;

public class TradePacket implements Serializable {
    final private static int HASH_PRIME = 1000003;
    private String trader_id;
    private int trade_id;
    private String trade_activity;
    private String ticker_id;
    private double trade_price;
    private int trade_quant;
    private double trade_nprice;
    private int trade_nquant = 0;
    private String nt = "";
    private boolean settled = false;
    private int quant_change = 0;
    private String hostname;
    private int port;
    
    public TradePacket(String trader, String activity, String ticker,
                       double price, int quant) {
        super();
        trader_id = trader;
        trade_activity = activity.toUpperCase();
        ticker_id = ticker.toUpperCase();
        trade_price = price;
        trade_quant = quant;
    }
    
    public TradePacket() { super(); }
    
    public void trade(TradePacket tp) {
        int tp_q = tp.getQuant();
        System.out.println("yehhh" + tp_q);
        if (trade_quant < tp_q) { tp_q = trade_quant; }
        if (trade_activity.equalsIgnoreCase("SELL")) { tp_q *= -1; }
        quant_change = tp_q;
        if (trade_quant == quant_change * -1 || quant_change == trade_quant) {
            settled = true;
        }
        trade_price = tp.getPrice();
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof TradePacket)) { return false; }
        TradePacket tm = (TradePacket) o;
        if (trade_id == tm.getID() && trade_activity.equals(tm.getActivity()) &&
              ticker_id.equals(tm.getTicker())) {
            return true;
        }
        return false;
    }
    
    public int hashCode() {
        int result = 17;
        result = HASH_PRIME * result + ticker_id.hashCode();
        result = HASH_PRIME * result + trade_activity.hashCode();
        result += trade_id;
        return result;
    }
    
    public void setConnection(String h, int p) {
        hostname = h;
        port = p;
    }
    
    public String getHost() { return hostname; }
    
    public int getPort() { return port; }
    
    public String getTrader() { return trader_id; }
    
    public void setID(int id) { trade_id = id; }
    
    public int getID() { return trade_id; }
    
    public String getActivity() { return trade_activity; }
    
    public String getTicker() { return ticker_id; }
    
    public double getPrice() { return trade_price; }
    
    public int getTQuant() { return quant_change; }
    
    public void setNT(String s) { nt = s; }
    
    public String getNT() { return nt; }
    
    public int getQuant() { return trade_quant; }
    
    public void settleTrade() { settled = true; }
    
    public boolean isSettled() { return settled; }
    
    final public static String jlc$CompilerVersion$jl = "2.3.0";
    final public static long jlc$SourceLastModified$jl = 1272602546000L;
    final public static String jlc$ClassType$jl =
      ("H4sIAAAAAAAAALVZfWwcRxWfO9t3dnyxfRcndWI7jt1EqXFjF5SiBCOBMYns" +
       "9JI4thPooei83ps7\nr7O3u92dO59DFTVEatJCkWgSUpDbUlGEQPkDWhX+QQ" +
       "WJlvIpUJBa+KMVahFUKkUgIRqhFvHezNzX\n7vr8gc7SrPdm37z5ve83uzff" +
       "JU2OTYYd6jiaaSwOs2WLOvxqzi9SlTnDM8emFNuhqXFdcZxZeJBU\n5/6rnf" +
       "l+9AsTQRJIkJhhjuma4swu2GYuszC7oDkFm+yxTH05o5tMcvTw+Nid7y/9+v" +
       "Kx7gbSniDt\nmjHDFKap46bBaIElSCRLs/PUdsZSKZpKkKhBaWqG2pqia+eB" +
       "0DRgY0fLGArL2dSZpo6p55Ew5uQs\navM9i5NxElFNw2F2TmWm7TDSEV9U8s" +
       "pIjmn6SFxz2GichNIa1VPOA+QCCcZJU1pXMkC4I16UYoRz\nHDmK80C+RQOY" +
       "dlpRaXFJ4znNSDHS515RknjvfUAAS8NZyhbM0laNhgITJCYg6YqRGZlhtmZk" +
       "gLTJ\nzMEujOxalSkQNVuKek7J0CQjXW66KfEIqFq4WnAJI9vdZJwT2GyXy2" +
       "YV1joZinzw6NR7e8DigDlF\nVR3xh2DRbteiaZqmNjVUKhbezg1fm7w/1xMk" +
       "BIi3u4gFzdi+H56Ov/3jPkHT7UNzkvtiUn3/oz29\nt8b+3NKAMJot09HQFa" +
       "ok51adkk9GCxZ4944SR3w4XHz4k+mf3f/Qd+k7QdI8SUKqqeeyxiRpoUZq\n" +
       "XN6H4T6uGVTMnkynHcomSaPOp0Im/w3qSGs6RXU0wb2lsAV+X7AIIWEYARjf" +
       "IuIPfxNG2mZtJUXR\nOpQNO4uMDDi2OkLhDudtLgOYpYqogFzblgIBEKjHHV" +
       "w6eOKEqcPapPrtt3754JH7HrkiTIXuJfEw\n0l3agmsCdFveggQCnPc2dESh" +
       "qDHbVpYxQAoXb/V+7RXlSVA7iO9o5ymXLrjUiFdY9JGa+WO8HH2T\ncKeAcy" +
       "TVzofe3vX133/n5SBp8M0h8dLkUdPOKjq6QTFoYnI79xPwnr1uH/bb+++PHn" +
       "/+1V+9flfZ\nmxnZ6wky70oMkgG37m1TpSlIQmX2N/4z8Y+rTYdfCJJGiDzI" +
       "PUwBj4FA3u3eoypYRouJB2VpiJPW\ntEfwLQwUtFQhMF4j/L4dTNGM5oCxT7" +
       "rbbrzgwyheYsKFwFydLhl4Wrt9KXTPaz9qfZkrpZgB2ytS\n5QxlIp6iZReZ" +
       "tSmF+defmLp6/d3Ln2uACLYs7hYBRkJWbl7X1AIsuaM6BFGCFHrW354b7fjy" +
       "AecH\n3AtatGw2x5R5nULKVnTdXKKpJOM5K1qRH3laAmVF5sFxIVMmdWAk1G" +
       "EF8uDBPglkuKvz2lcHV17D\nFGNxfe0AjE0caRP/vQ3qApcL9xgWORjnh/jF" +
       "8Sa6KVvLQh7Jy0T3ld3P/uX5t6Y7hU+JanCnJyFX\nrhEVgRul1UIl9dfagV" +
       "O/NNR/88L0G/MiU8aqlXrEyGXvffoPdPCTEdUn+EMpE8whHOcA7If/72Gk\n" +
       "AUqZ+LEvgNfBknYI1w7hAHsxNXSW7Q5Z8ZywYGRw5uyxuSsD3PRCn2W1lS4j" +
       "eDko9jm8LqquKq++\nA8Z+6dX7/bwaL/01xVhTxo8HKuCRQtWPQmlFG5/BKL" +
       "q7ZtI7ig1FOSdoD/774nO/vR4JkmCChDXn\nqGYoOrq8c0JkOZ9S6mJx/sXT" +
       "T93+DXuD27acVhBYT8FbFM4oFRnv0Kv5aOh7T2eDJJwgHbwdUgx2\nRtFzGL" +
       "4JaGiccTkZJ1urnlc3J6ISj5bSZo/bxSu2dSe0sj/CPVLjfbMrh6GOR2C0SG" +
       "u3uKzNi1S0\nHKmT0IllqB178xvPvnfx8qEglqimPAIHnVRE9Ikc9pMP37ze" +
       "23rtT1/keYC0f2ocmR7jm/fx64Dw\n4QYG0NFEjIQtW8srDPQQcniPWmBky8" +
       "TYzERyanry+BHustwFifCfIyVREPouGK1SlFaPKBbenPZu\nz710GjZqEeU6" +
       "qaVKQdJGiM8+qLatcp+t/vsk8PIZRpo5T8myBvQ+9HPJss2f5VnJsk2wVFTI" +
       "Vhpb\nXgMr6qRdMm73ZzwnGbeAvs+tR/4eGB2SZ4c/T1XybBVgwawqLWUdfx" +
       "XshBGVXKP+XNPVXB/IQdys\nodheGNsk123+XDXJNSK4GusBi9W+U7Lt9Ger" +
       "u9iuB20XjO2S7XZ/tqZkGxTMapipX+ZyUvzvZWZL\nZmForplOU+6CFZ43TZ" +
       "0qRm1F7JSb7PTfpFBUBNdAUl2AFEHXUASy6pZsu/3Zfr4YYgumw4rZroY6\n" +
       "YtJzSfG/l+UFybLRMu0qU3ERZMkj5aomKlag2NOImq2Zw6XDM/QA2Gz0rnbY" +
       "443G5c/+M/Kw8tLZ\noKyNH8ZQNK0DOs1TvVQLY3yvGHA7ULMWHudH3nI1ap" +
       "j5xOD+u1v/Cg3yKr1/VE5OUzjfG7PFWsEP\nBcqGDwV9LlndeKL57lMNC9rP" +
       "g7xKicLmOclXLxqtLmdb7GqgXGndVS3MAIxBaetBl625SSvs6epS\nAuWi0L" +
       "Z2H/MlqF08vt2R05g3tRRfeLXSVSrYemceqZJhD4xxKcP4pmTw6bVFS7G2XE" +
       "9ABaYQr8L/\ncpwy54a94hFkxS1Ii8w9p6QgpzYmyLr7yW9iHlCchXEzJVIL" +
       "pz24epPpo/AhGAmJM7ExnPJ0XspA\nB9dGfJORrZB1oRM0wCIQS9xXPB7j4b" +
       "nKdLUoWEfmpChzdVL5C1AeMpRNmOJAOMRJhzakcSxxVMKk\ndYL5ooA5Vczo" +
       "m3AM7KEWJczFOsF8BZI+wOQviezN6hOBmhKouamUsU7n/R2kPXw/92l/p61k" +
       "452p\nxoxNGZOYWZ2U+0eAmynC3YwHYL+wLEEu1wnkm9DXAsixyr5+kz5wQU" +
       "K9UCeo70hn5eeFzQLFFu+S\nBHqpTkD/BWUBg7/U0XPakQ3hxPJ1ReK8Uiec" +
       "H0iFniqdETbppI9JoI9tOvqH1kQbCInoPzFbI/qH\nPNE/5IcZWT8uMT9eH+" +
       "UG2kX0C7ib8VRkeEOCvFEnkF3CU/8vB8DQX5E4V+qEsx+ylDgs8lLl7wFr\n" +
       "Q8Uz3TMS6jN1gvohhq/8ZsTJFgm8baz7zSMIV/GZBt+/d3m+rYovgOrArbm7" +
       "fmpFf8E/PJS+0oXj\npDmd0/XKt28V9yHLpmmNSxgW7+IsDvVeRtpd34vAaf" +
       "l/BBg4KMgOgUQlMpw4zI+tKwXyP11TOnFc\nHgAA");
}
