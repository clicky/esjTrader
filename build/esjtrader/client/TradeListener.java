package esjtrader.client;

import java.io.*;
import java.net.*;
import java.util.*;
import sessionj.runtime.*;
import sessionj.runtime.net.*;
import sessionj.runtime.transport.*;
import java.util.*;
import sessionj.runtime.*;
import sessionj.runtime.net.*;

public class TradeListener {
    final public SJProtocol p_t =
      new SJProtocol(
      ("H4sIAAAAAAAAAIVTTWgTQRR++aM/Fq3VlojVgqa1RUnwoIgRtOmPbd3a0rQI" +
       "gqaT3TGZOrs77kzb\nBER6rBdBEDx5U3rxJIhHEZGCnvTQg5ce6sGDHjyJ0I" +
       "MzO0mT1rAu7DI7877vffO9917+hBj3IMEx\n58R1FpKizDBPql+9yk5ksZiV" +
       "y5y5vnHplSO6t8IQMqDJxnYee1xAl7GAllBqURCaGnIpxaaQTOmS\nB/2BrP" +
       "6RZgb9hHzmmFkk1BLQb1ThKR+U2oGndsFVppN7Mqmvm1+QUlQuneRxU3btRu" +
       "HJ8zCARHQy\nl5YL1BUVhI4Z7H0zZ3x/26NjjjaImfJZc+b2+e5jXwa/tUSU" +
       "5GbmcqJuLSBuVEHakenKSbrEWIlJ\nq/uUW0l1lqy5xRNzju1a5A5BeYoNws" +
       "X2gd6zr388avctiVK5I6C9zmkVo25+5v90tf0jGVj5dPv3\ncZ80ZN6DBxDy" +
       "RR2usRjEuYstRd82kL01Mb96IiLNYMtRVSAZeiqoqBlcIP/UVFnZF4CqA12k" +
       "T9df\nTP9aVSClLsxKMuVAAHjcyXvIMYuNkgZJzTREhW9CB+HDmGHHwo6gZR" +
       "VgqZ5EEizgUF0FxhAvTiKW\nrgplIKUerBlZOY81fX33vmv+cwTCo9BKXWSN" +
       "IlO43ji0iKKHedGlVoldvuJLaFtult92+YYlWeeO\nfp8wO2GgPKZ1asehuS" +
       "izDLkWNiBCUV5Ah1ZIkVNI6V6VnRf98GdYQGx2ZnB4hAfP5Qw2MVnCjew8\n" +
       "FwCblGtUkK1m24sOMZHYme2ejfiz1sTpC37P7bN1nDoS0FmbFT3Xepyrfkql" +
       "3XsmcJoiE49Jx7CX\nM9e2Pt4fufZwVY+Ig2y8+/pZ4RGnIK8vJ8cvi9pN6l" +
       "2uksQhsbIpIHp95OoUK/l59/8F1JBvDhEF\nAAA="));
    
    public TradeListener(String s, String t, int p) throws Exception {
        super();
        SJSessionParameters params =
          SJTransportUtils.createSJSessionParameters(s, t);
        SJServerSocket ss = null;
        try {
            ss = SJServerSocketImpl.create(p_t, p, params);
            while (true) {
                SJSocket s_t = null;
                try {
                    s_t = ss.accept();
                    {
                        String _sjbranch_$0 = SJRuntime.inlabel(s_t);
                        if (_sjbranch_$0.equals("TRADE")) {
                            {
                                String msg = (String) SJRuntime.receive(s_t);
                                System.out.println(msg);
                            }
                        } else
                                  if (_sjbranch_$0.equals("NEGO")) {
                                      {  }
                                  } else {
                                      throw new SJIOException(
                                        "Unexpected inbranch label: " +
                                        _sjbranch_$0);
                                  }
                    }
                }
                finally {
                    SJRuntime.close(s_t);
                }
            }
        }
        finally {
            { if (ss != null) ss.close(); }
        }
    }
    
    public static void main(String[] args) throws Exception {
        String setups = args[0];
        String transports = args[1];
        int port = Integer.parseInt(args[2]);
        new TradeListener(setups, transports, port);
    }
    
    final public static String jlc$CompilerVersion$jl = "2.3.0";
    final public static long jlc$SourceLastModified$jl = 1272600658000L;
    final public static String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAJVYb2wcRxWf++M7/7niP3HcNHbi/Lk0sdLcNaiNQo2aOI7d" +
       "2D0nrs9JW6Ny3tud\nuxtnbnfZmbPPoapSECS0UgVq0kCh9EtRBeoHSFX4AC" +
       "qgNgQoCBEkt0Jq+RAElWgR+UIDCoU3M3t7\nd3uXizhp52Zn3nvz5s17v/dm" +
       "X/kQtTEHJRhmjFjmUoKv2pjJ1souYZ2zRHp6VnMYNsapxtg8TGT0\nxY/JiR" +
       "/0fuFIEAUWUJ9pjVGisfmCY5XyhfkCYWUHbbEtupqnFnclNsi4b/uNld+cmR" +
       "4Moe4F1E3M\nNNc40cctk+MyX0CxIi5mscPGDAMbC6jXxNhIY4dolJwCQsuE" +
       "hRnJmxovOZjNYWbRZUHYx0o2duSa\nlcEUiumWybhT0rnlMI56UkvaspYscU" +
       "KTKcL4aApFcgRTg30OPYGCKdSWo1oeCAdSlV0kpcTkpBgH\n8k4Cajo5TccV" +
       "lvBJYhocDfs5vB3HHwQCYI0WMS9Y3lJhU4MB1KdUopqZT6a5Q8w8kLZZJViF" +
       "o403\nFQpE7bamn9TyOMPRBj/drJoCqg5pFsHC0Xo/mZQEZ7bRd2Y1p3UsEv" +
       "vPU7MfbYETB50NrFOhfwSY\nNvuY5nAOO9jUsWK8Xkqcm3q0NBRECIjX+4gV" +
       "zdiOHx1Pvf/TYUUz2ITmmPTFjH5j39CmK2N/7ggJ\nNdptixHhCnU7l6c668" +
       "6Mlm3w7gFPophMVCZ/NveLR09/D/8tiNqnUES3aKloTqEObBrjbj8K/RQx\n" +
       "sRo9lssxzKdQmMqhiCXfwRw5QrEwRxv0bY0XZL9sI4Si8ATguR+pX49owAHn" +
       "Hc3AwvWwiZ0EW+Jo\nB3P0JIaemHGSOiXY5Ek/XVmI/sRKIAC7GvJHGAV3PG" +
       "JRYM/oL1/99eMTD37lrDov4WOuUhxt9lZJ\nqFUSdaugQECKXyccUhlszHG0" +
       "VTFffvLKpm9c1l4A84MZGDmF5S4DK2HRAtMnW+LIeDUKp6CngZNk\n9P7T72" +
       "98/g/fvRREoaZYkvIGJy2nqFHhDpXg6XOX88+AF8X9vtxs7b8/NfPq2lvv7q" +
       "p6NUfxhmBr\n5BTBss1vfsfSsQFgVBV/4d9H/vFs26deC6IwRCBgENfAcyCg" +
       "N/vXqAua0QoAib2EUqgr17DxTg4G\nWqnZsGhjst8NR9EODwQTusd1u9tFIy" +
       "Z7RdOnvAiOq9+3Bwlv178Yufvtn3RdkkapIGF3DWSmMVdx\n1Vt1kXkHYxh/" +
       "9+uzz57/8MxnQhDJtq3cgqOIXcpSopeB5fb6UBQ7MIRnfXBxtOeZPeyH0gs6" +
       "SLFY\n4lqWYoBujVJrBRsZLrGrtwYnJTyBsWJZgDlAzAwFQcocdmAZPLgJkC" +
       "Q29J97buRbbwuosaW9BkDH\nkNQ0JN/XQXjKfYk1EgqLxfhu1oh1sw4pApQs" +
       "u1j3tc0v/eXVq3P9yp1UQtjegMm1PCopyPPosoV9\ntrZaQVK/uXvrK0/MvZ" +
       "dVYNlXb88Js1S898V38MjBmN4k9EOQtspylzsCoh3xLFAJYdcC66oWmCjr\n" +
       "2BZwKbXcJKK8v3rugI4n1QnGRtKPTS+e3SaPXtlTms1rkmrl/c3nyg2qOOie" +
       "lmgyKTI2RB23ALqr\nQbf49DsPzTzycFLZZ29LEUfBOIaUU+U/P2UeeH39mh" +
       "kUcRZhS54BUyjIOEe7UhWR7oGKV9VLT6fV\nVCWh3nXrDVQXJo//88mLvzsf" +
       "g4UXUJSwSWJqVAQDO6rwr0my9Yk49frxb1//LX9PHn0VcIT6Q+XG\njHFCq8" +
       "HC/WvLvZHvv1gMougC6pEFk2byExoticBegJKHjbuDKXRb3Xx9+aJy9agHqE" +
       "P+CKhZ1g91\n4RprhwW16LfXott/1e9j8QhUEy8qqfaNW0UbMrGz5QGRxzSO" +
       "DbscCNiC7bBkHpbtNuWdQQ5LCxOL\nsXgZgsPO8Ir/D3oH55RMTopYVMGuq0" +
       "nwDMj4mQYnjfvO2HOHhHAHrpDh8tqnL5p86Ko8mKhb2or6\nsoqqUHNQsJss" +
       "Why0q6VUz8kyuovwAYXWeoFQQ2h2P8jY3tL7XMiKpl9+OH/uJREtLgoJZL+z" +
       "GuFV\nvVj8uFm0DJIjEpoh5m9079j72gfP9CioqcIveP6tBVTH7ziETr/12Y" +
       "82SzEBXcg46qLzfg8Mdray\nyCGcJw0GEfF/ZwuuGqb76IXL35m9drZihmMS" +
       "jEdaME+ZWQc8uNBs0VaqHmrKBRHfR9hhbEOZCRUZ\nXVWJEQ5UA2bA4xpHOa" +
       "Kxwoxmj1YUtVF9Knbn26J//PkbA4u/D6HgJOqklmZMarKGQR1QPGBWgEqx\n" +
       "bB84KFWIrbS71WkQhK339JcC09MpLYtpjbZTqL0Aq4xbUDaiENWyQpVDZTt8" +
       "6V+HIazm58YOT7DW\nTjyHdewlznrz3duCbQb6cKOBUC+WTKLLm6CSMby24Y" +
       "XO+O790om6iopuvg5ChLFUKhdtBsVP/4mj\n8NGJB2BCEhyX7VaVIVE1Qyov" +
       "RMInNt3sjiST85lHrsW+rL35WMWP9nKwtmXvoXgZ0yYZbk/LEJ2R\nN8UqRI" +
       "fSB0Z23tX1V6gnb1Iq97qDcxiuxaa3e1lDa/93DT3s26tfn97lwYdCBfLLoI" +
       "RuhfYNF+B6\nptF6jO906hWVRhv06ljx7IRnn+sg+5rWsY3QLiEd6k4mvym0" +
       "rngar73yuqOc6mIofi3444G4rODD\nWQhG15713wsaPwfU3fKlnp3eru6AZ/" +
       "gWu9rdtDI7KJrVcgBJN/78TXY+VcloEYrNvLqOJkVTU2QF\nFXmTem+cWiYW" +
       "+FyZU9UesRLe5xeYbCzXxLup9JNr1USSz/KoEk2tJsX7lwBLdKFOk8JcVRnl" +
       "lmcr\nXvdJSVD7hotQC0mKPbbiuhsGly1iSLqv1qabGmPVjYBNb6u7LItcua" +
       "HhS5f6HqNvu7K46w2791fK\neSrfTKIp1J4rUVpb6dT0I7aDc0QqHVV1jy3/" +
       "LsDu/Rd3OGHVkZo+pwifB8jxCMXAN6WzPF0O/A+x\nrkMT7BMAAA==");
}
