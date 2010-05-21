package esjtrader.server;

import java.io.*;
import java.net.*;
import java.util.*;
import sessionj.runtime.*;
import sessionj.runtime.net.*;
import sessionj.runtime.transport.*;
import esjtrader.utils.TradePacket;

public class Server
{
    final public SJProtocol
      p_body =
      new SJProtocol(
      ("H4sIAAAAAAAAAIVUTUwTQRR+bfkpyEGxVQwIQYqCJO0JY8JBfixCWYSwEpGY" +
       "1OnupN2y3Vl3p9Am\nhnjUI4lXY2JIuHDz4NEQPXnTgzEe9IAxXLx78OCbnW" +
       "2BQtYmnd3pe9/3vnnvm+7+hmbXgesudV2D\nWcUkr9rUTYqtfFMzS1QrOyJ4" +
       "D3/IaiA/oTCEFIiYJMfholKDp8rcMFNqRiE5ao5VHBgMIFYYsyXn\nWub16l" +
       "7mj+JxNuWYXuUwdEjqAVJ1KPKrMiTQospQQJUjqQ3im7WCYeqPYRMiyDHQwC" +
       "FWlitSjQsW\nCd9qVXfu519shwEQEbeZWc2bjPsImTMx+HZZOXjXJ3O6T8lZ" +
       "8Fiz2t8bPZc/T/xsiwgxUZu5Bsf6\nHLqUGki2c9GPjFVsu2LjtIYDjjtr5R" +
       "xiaYXG8wox1wJwk6eiwqvQabi3qU0tnVrcrIoEXbSOIJjD\neaVI1omUOUPc" +
       "wjyxxyqio02oFFDqORFPinjSjze3ftt7f+HRpwiEp6HdZESfJhpnziy08YJD" +
       "3QIz\n9Yp9a9yT0LERxfUsfsNIFq/r9wh9mx1ROwvRAlaZYjqtebNTKjSJlU" +
       "/JxmMbIfH0B4emu+k7C26w\ne9D81Finp3VzNAA2j+8kT6dYqVS2DI3wugP7" +
       "vnS9bE+M3PQceKYk80SIQ/xw7tLn0t5+O13xjOHz\nv4Lxtp4Q7N9VwRGqD8" +
       "ijFM1d4RBaQeLeBrcuOkYJrVc7/1bv9q83+0sxeU3XDEvnMNAo+hgmMYdJ\n" +
       "8ggtnvT+oApe9oeR/t3Npe852eTOer438rRVLo2++kqHxzs0qcIiJXp8yip3" +
       "DCuPU+YQMSyORXsa\ni5pEozPoM+pktZ39j0/Sc8+fHdIJtVcEvJu6Re4QTP" +
       "Oq4+0Vm0WirVEue1feeBjj0DK5/EBNK0cm\nFPS3p+JdOukngY37U750YjZi" +
       "0yeWq5XjgX/kZhHOwAUAAA=="));
    final public SJProtocol
      p_sc =
      new SJProtocol(
      ("H4sIAAAAAAAAAIVUTUwTQRQeWio/clB+hASEIKAgSXvCGDnIj0UoizSsRCQm" +
       "ON2dtFu2M+vuFLaJ\nIR7xSGLiyZgYDBduHjwaoomJNz0Y40EPGOPFgzcPHn" +
       "yzs21pqWuTTnfy3ve+b9/7Xvd/oohjowsO\ncRyD0WyUFyziRMVVPqkJdYqk" +
       "DXoTbmsakp+6EEKujc4HoI6ArpiP3z5P/tqWoOEgKhmq5qpTUETL\nGKbO0b" +
       "BShMc8UKwEj1XAx4FpoIpJnCyVJRoXXJJkp0Hdu5V+tCu1dVjMLKRNxn2EzJ" +
       "kcerms/HjV\nJ3O6a+QselXXtD+Xes5+mPzWFBaSGy3mGBz4OepSiqBYnhtm" +
       "LOlHxl3LcqH9FwN6skS0vP2ProRN\nnOKos9wTr7qaUHCKmKIFQwGFFcYsWX" +
       "M98Wz1IPFb8WrWp5heuIe2UNgVZ8hyLVA4ElBojqZsTLVM\nLYsEGWuqJiq0" +
       "iloN5xqxCNUJ5WZBJOjCARjAHLUpWbyB5ZvOYiezgK3xklIEUk+LeFTEo348" +
       "0vD5\n4PWZu+/DKDSDmk2G9RmscWbPoSaesYmTYabuWlcnPAktm41wnoJvCI" +
       "p1lPR7Bf3WHlE7hxozwDLN\ndFKcR6tUaGKajklnwJzR4IOvHNXfiF9fdIKX" +
       "AAZOjA1Sq5tjAbAFeMZpMs1yuTw1NMxLlun72PWk\neXD0sjfekzmZJ0IcdZ" +
       "SNKZdI7o7fTkf8dnoO/Y9gcOgxwb4/RY3mspXEQxskrHBUtwKFe6vWKWkb\n" +
       "OdiN4vvv9O5+f3G41C6tuW5Q+A8YqBZdgRmchyT5ChFPen8Qg5f9ZrR/f2vp" +
       "S0o2ubWU7408TvO5\nsaefyMhEiyZVUJwjlVNWuW3QNEyZo7BBOZD2VJOaWC" +
       "Oz4DNir2l7h+/ux+cfbpfLCbVDAt5NnCy3\nMaR57PD3Ii5JrK0TLnuX37zT" +
       "ztGJqeXbalw5MqGgVVdhl477SWC7/Cn3HJuNuJwTx4hbGfgL2JQN\nvzMGAA" +
       "A="));
    public HashMap
      map =
      new HashMap(
      );
    
    public Server(String setups,
                  String transports,
                  int port,
                  String address_s)
          throws Exception {
        super();
        final SJProtocol p_sel =
          new SJProtocol(
          ("H4sIAAAAAAAAALVUTUwTQRSetiCgRCoCSsAqUhTE0BjFaDBRUBDqIoRKRKPC" +
           "dHdsl+6fu1MoiSEe\n8WJi4tWYGBMvnDTGoyGamOhJD8R40APGeNCzHjg4b6" +
           "btllKXizTp/Oy8971vvvfeLP5C5Y6Nwg5x\nHNU0prvonEWcLtiKVSwaI/QS" +
           "W07Kb5dPPTNo84of+SRUoRM9TmyHogZpGs/gSJqqWuSsqWlEpgyp\nJ2Ojdk" +
           "9UfiSQkfj5OHK5nFQ1haJ2Kece4U6RvHtkjTtEai2KBKMZn2ZUIJYIcr8i9v" +
           "Ry4sETP0LM\no94ytbmEZtKsh7DpbXs5Lv14tVfYNJWwGeGok/Lq8eY9H3u/" +
           "VQWAcqVlOircmqLdUs5JKDKaPenJ\nWFbGYlIfALW64KzLVcsJjxu6qag3VR" +
           "zXiKQ6dLWm7ciLn/eCXJIyjX2hKFigNNjAzQ9vDOd+b+xD\nd97f+B3ioD75" +
           "FppHPk6qzkWRVCNFFICv7ohdj04t7A8wMazZMpagMmZ6yCOpY0RO2/9Ia0DD" +
           "cYp2\nuUnl14hFJRwnGtykzQNYMk1LYKaij68uRf9IQpe4qczBLQIZGP1C4Q" +
           "4PoCEjbmNDThYThHQf9PDr\nK+nlv4pqVeccsYihEINqc2CgQAlj5kzRzoKE" +
           "DWInOYytnjxTxKjucHXPnpdXfF563TD1IYD8A2ir\nZmJlAMvUtIdQFU3axE" +
           "mampKxTp/hFKpnK9kYZH8/A6vP8+eAWWkL2A6hyiSLctZUSC4ftYKhho1E\n" +
           "RJQ2K1QUvvOVorKL/edHHO8uZgkn6gwppWa3h9swW+MEK0xdTxuqjGm+ZPYu" +
           "7364Ndx5gqd3my7s\n4IiierezxCsgmj8rpwPzHjZvSJhV6DrC2foEjKBbSr" +
           "BoZAYTFPkmGHCo6D0YtVWdNXfu/vdDT74/\nXxmrE6WZUg32iLUWk17jE77A" +
           "jMQVyjn1Fq8I3PpNZ8vi/NiXuBC5Nm/PU95vpPXuR59Ix5lqWbAw\nsE7WZj" +
           "lGbdVIsCxTFFANyoI2FwfVsEwGWZ0Re1J+uvLudv+FuwsuHLDtBPcm4kxTGz" +
           "MzHp29j7AZ\nxXKKUKFdevZaHUVb+savxPqlggx5tXqM9dL6egLfUDbL+9fl" +
           "BjbtMEQyRUmD3U7ebLDaVaJvhH1B\nxedoFs41uZCeWPC5CYZ9MByB4Shnft" +
           "Il6CUMzMf+e8TMJuNvsmB8v/0vsoumPagIAAA="));
        SJSessionParameters params =
          SJTransportUtils.
            createSJSessionParameters(
            setups,
            transports);
        final SJSelector sel =
          SJRuntime.
            selectorFor(
            p_sel);
        try {
            SJServerSocket ss =
              null;
            try {
                ss =
                  SJServerSocketImpl.
                    create(
                    p_sc,
                    port,
                    params);
                {
                    SJServerSocket _sjtmp_ss =
                      null;
                    _sjtmp_ss =
                      ss;
                    ss =
                      null;
                    sel.
                      registerAccept(
                      _sjtmp_ss);
                }
            }
            finally {
                {
                    if (ss !=
                          null)
                        ss.
                          close();
                }
            }
            int trade_id =
              0;
            while (true) {
                SJSocket s_sc =
                  null;
                try {
                    s_sc =
                      sel.
                        select();
                    {
                        sessionj.types.sesstypes.SJSessionType _sjtmp$1 =
                          s_sc.
                            remainingSessionType();
                        if (_sjtmp$1.
                              typeEquals(
                              _sjtypecase$2)) {
                            {
                                for (boolean _sjrecursion_s_sc_X =
                                       true;
                                     _sjrecursion_s_sc_X;
                                     ) {
                                    _sjrecursion_s_sc_X =
                                      SJRuntime.
                                        recursionEnter(
                                        "X",
                                        s_sc);
                                    {
                                        SJSocket _sjtmp_s_sc =
                                          null;
                                        _sjtmp_s_sc =
                                          s_sc;
                                        s_sc =
                                          null;
                                        sel.
                                          registerInput(
                                          _sjtmp_s_sc);
                                    }
                                }
                            }
                            ;
                        } else
                                  if (_sjtmp$1.
                                        typeEquals(
                                        _sjtypecase$3)) {
                                      {
                                          String _sjbranch_$0 =
                                            SJRuntime.
                                              inlabel(
                                              s_sc);
                                          if (_sjbranch_$0.
                                                equals(
                                                "BUYSEL")) {
                                              {
                                                  TradePacket tp =
                                                    (TradePacket)
                                                      SJRuntime.
                                                        receive(
                                                        s_sc);
                                                  tp.
                                                    setID(
                                                    ++trade_id);
                                                  SJRuntime.
                                                    send(
                                                    trade_id,
                                                    s_sc);
                                                  String msg =
                                                    tp.
                                                      getActivity() +
                                                  " (" +
                                                  trade_id +
                                                  "): [" +
                                                  tp.
                                                    getTrader() +
                                                  " - " +
                                                  tp.
                                                    getTicker() +
                                                  ", " +
                                                  tp.
                                                    getQuant() +
                                                  " @ " +
                                                  tp.
                                                    getPrice() +
                                                  "]";
                                                  System.
                                                    out.
                                                    println(
                                                    msg);
                                                  this.
                                                    addToMap(
                                                    tp);
                                                  TradePacket tp_m =
                                                    this.
                                                      findMatch(
                                                      tp);
                                                  if (tp_m !=
                                                        null) {
                                                      System.
                                                        out.
                                                        println(
                                                        tp.
                                                          getQuant());
                                                      tp.
                                                        trade(
                                                        tp_m);
                                                      if (tp.
                                                            isSettled()) {
                                                          System.
                                                            out.
                                                            println(
                                                            "COMPLETE: " +
                                                            tp.
                                                              getID());
                                                          this.
                                                            removeFromMap(
                                                            tp);
                                                      }
                                                      System.
                                                        out.
                                                        println(
                                                        tp.
                                                          getQuant());
                                                      tp_m.
                                                        trade(
                                                        tp);
                                                      if (tp_m.
                                                            isSettled()) {
                                                          System.
                                                            out.
                                                            println(
                                                            "COMPLETE: " +
                                                            tp_m.
                                                              getID());
                                                          this.
                                                            removeFromMap(
                                                            tp_m);
                                                      }
                                                      TraderCom tc1 =
                                                        new TraderCom(
                                                        setups,
                                                        transports,
                                                        tp,
                                                        tp_m.
                                                          getTrader(),
                                                        1);
                                                      TraderCom tc2 =
                                                        new TraderCom(
                                                        setups,
                                                        transports,
                                                        tp_m,
                                                        tp.
                                                          getTrader(),
                                                        1);
                                                  }
                                                  {
                                                      SJSocket _sjtmp_s_sc =
                                                        null;
                                                      _sjtmp_s_sc =
                                                        s_sc;
                                                      s_sc =
                                                        null;
                                                      sel.
                                                        registerInput(
                                                        _sjtmp_s_sc);
                                                  }
                                              }
                                          } else
                                                    if (_sjbranch_$0.
                                                          equals(
                                                          "NEGO")) {
                                                        {
                                                            {
                                                                SJSocket _sjtmp_s_sc =
                                                                  null;
                                                                _sjtmp_s_sc =
                                                                  s_sc;
                                                                s_sc =
                                                                  null;
                                                                sel.
                                                                  registerInput(
                                                                  _sjtmp_s_sc);
                                                            }
                                                        }
                                                    } else {
                                                        throw new SJIOException(
                                                          "Unexpected inbranch label: " +
                                                          _sjbranch_$0);
                                                    }
                                      }
                                      ;
                                  } else
                                            if (_sjtmp$1.
                                                  typeEquals(
                                                  _sjtypecase$4)) {
                                                TradePacket tp =
                                                  (TradePacket)
                                                    SJRuntime.
                                                      receive(
                                                      s_sc);
                                                tp.
                                                  setID(
                                                  ++trade_id);
                                                SJRuntime.
                                                  send(
                                                  trade_id,
                                                  s_sc);
                                                {
                                                    SJSocket _sjtmp_s_sc =
                                                      null;
                                                    _sjtmp_s_sc =
                                                      s_sc;
                                                    s_sc =
                                                      null;
                                                    sel.
                                                      registerInput(
                                                      _sjtmp_s_sc);
                                                }
                                                ;
                                            } else
                                                      if (_sjtmp$1.
                                                            typeEquals(
                                                            _sjtypecase$5)) {
                                                          {
                                                              SJSocket _sjtmp_s_sc =
                                                                null;
                                                              _sjtmp_s_sc =
                                                                s_sc;
                                                              s_sc =
                                                                null;
                                                              sel.
                                                                registerInput(
                                                                _sjtmp_s_sc);
                                                          }
                                                          ;
                                                      } else {
                                                          throw new SJIOException(
                                                            "Typecase given an unexpected type: " +
                                                            _sjtmp$1);
                                                      }
                    }
                }
                finally {
                    SJRuntime.
                      close(
                      s_sc);
                }
            }
        }
        finally {
            if (sel !=
                  null)
                sel.
                  close();
        }
    }
    
    public void
      removeFromMap(
      TradePacket tp) {
        HashMap tmap =
          (HashMap)
            map.
              get(
              tp.
                getTicker());
        ArrayList list =
          (ArrayList)
            tmap.
              get(
              tp.
                getActivity());
        list.
          remove(
          tp);
    }
    
    public TradePacket
      findMatch(
      TradePacket tp) {
        HashMap t_map =
          (HashMap)
            map.
              get(
              tp.
                getTicker());
        String find =
          tp.
            getActivity().
            equals(
            "BUY")
          ? "SELL"
          : "BUY";
        ArrayList list =
          (ArrayList)
            t_map.
              get(
              find);
        if (list.
              isEmpty()) {
            return null;
        }
        double price =
          tp.
            getPrice();
        Iterator it =
          list.
            iterator();
        while (it.
                 hasNext()) {
            TradePacket tp_m =
              (TradePacket)
                it.
                  next();
            if (tp_m.
                  getPrice() ==
                  price) {
                return tp_m;
            }
        }
        return null;
    }
    
    public void
      addToMap(
      TradePacket tp) {
        HashMap t_map =
          (HashMap)
            map.
              get(
              tp.
                getTicker());
        if (t_map ==
              null ||
              t_map.
                isEmpty()) {
            t_map =
              new HashMap(
                );
            t_map.
              put(
              "BUY",
              new ArrayList(
                ));
            t_map.
              put(
              "SELL",
              new ArrayList(
                ));
            map.
              put(
              tp.
                getTicker(),
              t_map);
        }
        ArrayList list =
          (ArrayList)
            t_map.
              get(
              tp.
                getActivity());
        if (list ==
              null) {
            list =
              new ArrayList(
                );
            t_map.
              put(
              tp.
                getActivity(),
              list);
        }
        list.
          add(
          tp);
    }
    
    public static void
      main(
      String[] args)
          throws Exception {
        String setups =
          args[0];
        String transports =
          args[1];
        int port =
          Integer.
            parseInt(
            args[2]);
        String address_s =
          args[3];
        new Server(
          setups,
          transports,
          port,
          address_s);
    }
    
    final private static sessionj.types.sesstypes.SJSessionType
      _sjtypecase$2 =
      SJRuntime.
        decodeType(
        ("H4sIAAAAAAAAAIVUTUwTQRR+bfkpyEGxVQwIQYqCJO0JY8JBfixCWYSwEpGY" +
         "1OnupN2y3Vl3p9Am\nhnjUI4lXY2JIuHDz4NEQPXnTgzEe9IAxXLx78OCbnW" +
         "2BQtYmnd3pe9/3vnnvm+7+hmbXgesudV2D\nWcUkr9rUTYqtfFMzS1QrOyJ4" +
         "D3/IaiA/oTCEFIiYJMfholKDp8rcMFNqRiE5ao5VHBgMIFYYsyXn\nWub16l" +
         "7mj+JxNuWYXuUwdEjqAVJ1KPKrMiTQospQQJUjqQ3im7WCYeqPYRMiyDHQwC" +
         "FWlitSjQsW\nCd9qVXfu519shwEQEbeZWc2bjPsImTMx+HZZOXjXJ3O6T8lZ" +
         "8Fiz2t8bPZc/T/xsiwgxUZu5Bsf6\nHLqUGki2c9GPjFVsu2LjtIYDjjtr5R" +
         "xiaYXG8wox1wJwk6eiwqvQabi3qU0tnVrcrIoEXbSOIJjD\neaVI1omUOUPc" +
         "wjyxxyqio02oFFDqORFPinjSjze3ftt7f+HRpwiEp6HdZESfJhpnziy08YJD" +
         "3QIz\n9Yp9a9yT0LERxfUsfsNIFq/r9wh9mx1ROwvRAlaZYjqtebNTKjSJlU" +
         "/JxmMbIfH0B4emu+k7C26w\ne9D81Finp3VzNAA2j+8kT6dYqVS2DI3wugP7" +
         "vnS9bE+M3PQceKYk80SIQ/xw7tLn0t5+O13xjOHz\nv4Lxtp4Q7N9VwRGqD8" +
         "ijFM1d4RBaQeLeBrcuOkYJrVc7/1bv9q83+0sxeU3XDEvnMNAo+hgmMYdJ\n" +
         "8ggtnvT+oApe9oeR/t3Npe852eTOer438rRVLo2++kqHxzs0qcIiJXp8yip3" +
         "DCuPU+YQMSyORXsa\ni5pEozPoM+pktZ39j0/Sc8+fHdIJtVcEvJu6Re4QTP" +
         "Oq4+0Vm0WirVEue1feeBjj0DK5/EBNK0cm\nFPS3p+JdOukngY37U750YjZi" +
         "0yeWq5XjgX/kZhHOwAUAAA=="));
    final private static sessionj.types.sesstypes.SJSessionType
      _sjtypecase$3 =
      SJRuntime.
        decodeType(
        ("H4sIAAAAAAAAAI1UTUwTQRR+tPzbAyBFEv5CgAhiWj1ATDjIj0UoixBWIhIT" +
         "nO5O2i3bnXV3Cm1i\niEc9kng1JoaECzcPHg3Rkzc9GONBDxjixbsHD87P9p" +
         "ey2qRvdnbe97733vdmj35Bg+vAmItd1yBW\nOkLzNnYjfCuf1PiilXCQpaXu" +
         "sv2WBvJXFwDIOXDZBzdbExXYhA7DvYVtbOnYomaeO+gKNGiIgSlc\nVNJoB0" +
         "Wz1DCjC8hNLSN7ihGN+hCp8qiaqY4HTRmmTmFUKcCjAhQtwqMVcM40VMXELU" +
         "mksUY5lyTZ\nb1IP7yWfH8gmhG1i5pMmoR5C+syMvFlXfr4dkD49NXxWRNQt" +
         "7c9kb9+nmR8tQZ5ys01cgzJ+Ct1K\nASTbseqdTOVsO2cDk62d9yrCDyNerx" +
         "qavh6/63r4MQiBeWg1CdLnkUaJswgtNOVgN0VMPWffnBZN\nCu02M9vG/gEW" +
         "LFwsXARU4wpKYLNMuUVoTjGWOaJjBYImSlDokGqZyEpGZTksORh+8p1C/Z3Y" +
         "7RXX\nX7k1rGFjB9earAkf2DJ7Rkk8RzKZrGVoiBbVH/jc/aJ1ePyGUP9CRv" +
         "rxIwrhUjel8lLwR7AHQTvn\n8rWNrQ5c8U8465wzbLIjl0qjJkTz2sgna8Qn" +
         "sEKILWNux19tHsd/KyJmfYLoeZ5afSFRW2QKYgD4\nU2sNLfn7ULkKheJKRf" +
         "5DFVbkGVW8EnmMrspsQsxhg0LdBgvcXzXoq46RYVNbEHm//+D09clap6xu\n" +
         "27DY7RyqVqYCM7zEnKROjSL1QT8G4f1+fPBob+1bQk5SR9FfzHXMymYmXn7B" +
         "Y9MhTWZhoQyuHGWV\nOoaVZKNMIWhYlJH2VpOaSMML7DJhZ0s7PPnwOLb07G" +
         "kpHM92lMN7sJumDmJugp1dfL5ZRdo2prJ3\n2d0HnRQaZ9fvqzGlTCG/aVHZ" +
         "x/PspeHYdk/lgTPa8M0IN1dz5x34JcTX694a/q8x5K97uOnjJsLN\nNZHjZF" +
         "kqfwECA2SjgAYAAA=="));
    final private static sessionj.types.sesstypes.SJSessionType
      _sjtypecase$4 =
      SJRuntime.
        decodeType(
        ("H4sIAAAAAAAAAIVUTUwTQRR+bfkXE0VAEhCClAiStCeMCQf5sQhlEdJKRGJS" +
         "p7uTdst2Z92dwjYx\nxKMeSbwaE0PChZsHj4boyZsejPGgB4zx4t2DB9/sbF" +
         "tbYG3S2Zm+933v6/fe7MEvaHZsGHOo4+jM\nLMR42aJOTBzlLp1MUZXqW/QO" +
         "HjMqyE8oDODaMBkAW8Y9ydE5ViyWTF0lHPMkx9Cnvucd0YnrYQgp\ncKYo80" +
         "SIQ49iMaOcMxiPezxx8fOUGywwLUONApG8Wc3rhsZhTKnAfdoqPF4HF5VGGi" +
         "qJlWULVOWi\nliyy25rev5t7tidd6Klo9hEyZ2b09Zry882QzOk/IWfFY82o" +
         "f64NXPo48709IiS3WczRhVcc+mpm\nlLhuxFf9yJRrWS42bTTQE1M73rGHsA" +
         "MhD3s1uOEl+xRHIwbJcrhY89NTlk4qJEsNYV+QKIUxS3Ju\nJl9uHCZ/Kx5n" +
         "U5ZpZSGtyRMYsVwLFY4HEC2aWZuYav6kmbwSgJs9ERXegC7duUkt9Iya3CiL" +
         "BE1M\nD0EwhwtKgWwR+U8XiJNfJtZUVSmg1PMiHhPxmB9vbv1y+Lb3wYcIhO" +
         "ehw2BEmycqZ/YitPO8TZ08\nMzTXujHtSejcbsP1HH7DSNZT1e8R+tb+o3YR" +
         "2vJYZY5ptNKPLqnQIGYuLqcKZwSij79xaLqduLXi\nCLWAja88/3vjcQCO3X" +
         "i//YLjbK1TYtOLCescQutIPNgw6au2XsSxrbxAdgf3frw6SnXLzm/qJl7P\n" +
         "kcZbX4eJLmGSNLzFkz4cVMHLfjcxfLCT+pqVE9FVzfccTZil4uSLz3R8ulOV" +
         "KkxSpPUmprmtmzk0\nkUNENzkWHWgsahCVLmAbqZ1R94/eP0osPX1SoxNqRw" +
         "W8nzoFbhNM86rjzReHVaJuUi69K23f7+bQ\nMrt2L51Q6jrV4T8HjvksDpfF" +
         "Mu6eFvgL6B1XJ9oFAAA="));
    final private static sessionj.types.sesstypes.SJSessionType
      _sjtypecase$5 =
      SJRuntime.
        decodeType(
        ("H4sIAAAAAAAAAIVUTUwTQRR+bfmXg1aqJCCEUCJI0p4wJhzkxyKURQgrEYkJ" +
         "Tncn7Zbtzro7hW1i\niEc9kng1JoaECzcPHg3Rkzc9GONBDxjjxbsHD77Z2b" +
         "ZQYG3S6U7f+7739Xvvdf83NLsODLvUdQ1m\nFVO8YlM3Ja7ySc0uU40am/Qu" +
         "Xtc1kK9IFMBzYCwEtoDPJE+nWalUtgyNcMyTHP2fu190JEdvRCGi\nwLmSzB" +
         "MhDgnFZmYlbzKe9nnS4utxL1ygKkONApG8WSsYps5hWKnCA9oaPH0MLioNNl" +
         "QSJ8sVqcZF\nLVlkp1Xdu5d/vitdSFQ1BwiZMzn0ZkX59bZf5vSckrPos65r" +
         "f6/3Xvk0+aM9JiS32cw1hFccuutm\nlLlhppeCyLhn2577CLYB8NOBa+HNKz" +
         "tnuBMzSY7D5bo3fhU1q5AcNYUVQyHECmO25NzIvlo7yP5R\nfM6mHNMrQlqT" +
         "J86Y7dmocCSEaM7KOcTSCqfN19UQ3NSpqOgaxA33FrWppVOLmxWRoItJIAjm" +
         "cFEp\nkk0if+kscQsLxB6vKQWUekHEUyKeCuLNrV8P3l16+DEG0RnoMBnRZ4" +
         "jGmTMH7bzgULfATN2zb074\nEjq32vA8j+8okiVq+n3CwNojauegrYBVpplO" +
         "q/2IS4UmsfJpOSHYb0g++c6h6U7m9mKt8fUB+M/2\n4gCc2N6g/YKjs94p8Z" +
         "DAhFUOkVUk7muY2iXHKOEIVv8Mdvp2f74+XO6Snd8wLFy1wcYNPoZJzmOS\n" +
         "NLzFlz4QVsHPfj86sL+9/C0nJyJey/cdzVjl0tjLL3RkolOTKixSosdNVLlj" +
         "WHk0kUPMsDgW7W0s\nahKNzmIbqbOu7R1+eJyZf/a0TifUJgW8h7pF7hBM86" +
         "vjFovLEtE2KJfelbcedHFomVq5r2aUIx0K\n2yQVR/Xk8AtsJOhyz4neiMuA" +
         "OIa9swL/AFmFmE/aBQAA"));
    final public static String
      jlc$CompilerVersion$jl =
      "2.3.0";
    final public static long
      jlc$SourceLastModified$jl =
      1272602290000L;
    final public static String
      jlc$ClassType$jl =
      ("H4sIAAAAAAAAANVZbWwUxxme+/Dd2TgBGxsoXzbmKHbA50AwpbiIGBfHds7g" +
       "+AwBN+kxtzv2Ld7b\nXXZnzweKUkI/gFRKVAWatmoaFVGhNvmRErVN1SotTd" +
       "KUNFVVKpGoatIfSVuqNlX506IqTfvOzO7d\n3t75KEj5wUk7Nzvzzsz7+bwz" +
       "s8++h+osEyUsYlmKrh1M0MMGsXipZw4SiVqJ1MgYNi0iD6jYsiag\nIy0d+E" +
       "DZ+92mY0NBFJhEzZreryrYmsiauj2dncgqVsFE7YauHp5WderMWDHH1tXvz7" +
       "5+fGRZCM2f\nRPMVLUUxVaQBXaOkQCdRY47kMsS0+mWZyJOoSSNEThFTwapy" +
       "BAh1DRa2lGkNU9sk1jixdDXPCJst\n2yAmX9NtTKJGSdcsatoS1U2LogXJgz" +
       "iPe2yqqD1JxaJ9SRSZUogqW4fQwyiYRHVTKp4GwkVJV4oe\nPmPPIGsH8gYF" +
       "2DSnsETcIeEZRZMpavOPKEocvxcIYGg0R2hWLy4V1jA0oGbBkoq16Z4UNRVt" +
       "Gkjr\ndBtWoWjpnJMCUczA0gyeJmmKlvjpxkQXUNVztbAhFLX6yfhMYLOlPp" +
       "t5rLU70vifR8f+1Q4WB55l\nIqmM/wgMWukbNE6miEk0iYiB1+zEqeH99vIg" +
       "QkDc6iMWNP1rfrAneeUnbYJmWRWa3dwX09L7m5ev\nuNT/bn2IsREzdEthrl" +
       "AmObfqmNPTVzDAuxcVZ2SdCbfzp+M/33/0O+SvQRQbRhFJV+2cNozqiSYP\n" +
       "OPUo1JOKRkTr7qkpi9BhFFZ5U0Tn76COKUUlTB11UDcwzfJ6wUAIReEJwHMB" +
       "id8CVlBUD56cJ2bC\nOkjRSsuUegjUTCwTs8fiPT1FggKb7PbZQADkWO6PKR" +
       "UccEhXYVxaOvfOaw/tvPfkCWEh5lUOGxQt\nLk6fENMnxPQoEODzLmS+J3TT" +
       "b5r4MIuJwiOXVnz1VfwUaBoktpQjhAsUmA2zEgZtrAkZA6WAG4Ya\nBn9ISy" +
       "1Hryz92m+//UoQharCRrLYOKibOawyy7tx0uws5+8Bh4n73bba2n9/dPT5y7" +
       "98q7PkwBTF\nK+KqciSLiw6/3k1dIjLgTmn6J/899I8n6j7+vSAKQ7AB3FAM" +
       "TgKxu9K/Rll89LlYw2QJJdG8qQrB\nGygoaNYjMCsbeX0+mCIGD8QNOup42G" +
       "JWsM4mVjQL9wFztfhk4Eh27bORO9/48bxXuFJc0JvvQccU\noSKEmkouMmES" +
       "Au1vfWXsidPvHf9UCILWMIRbUBQx7IyqSAUYsrg86pgEMvOsv53vW/BYt/V9" +
       "7gX1\nSi5nU5xRCaA0VlV9lshpymGqyQOJHIlAWY0ZQDQAx7QKEwl1GIE8eH" +
       "AVzEgsaTn15a6vv8FQxeD6\nWgQ8hjmnYf6+EFIBl4utkRCwy9rXWZWwNmYq" +
       "OUCNvANrX1p59k/PvzPeItxJYP/qCvj1jhH4z+0x\nz2D6WVVrBU798rpVzz" +
       "48/nZG4GJzuT53anau9+k3SdfdjVKVmA9BhuKyFLioawKs7CqqwY1jRw0L\n" +
       "S2rYWZCIweCRs7qChXpLyfiAhjPCjI1dqQdHDpzo4PYXSuXrFYsez/JbahAU" +
       "ikxFOVUMVlxfE1wG\nWa4uxZ7y0D8fOf/r041BFJxEUcUaVDSsMteydgk0qZ" +
       "KlfFMceXHPN679ir7NFVkKX8bY8kIl8O7F\nHmTZcjnfFHnu6VwQRSfRAr7T" +
       "wBrdi1Wbhckk7BWsAacxiW4r6y/P+yLJ9RXhabnfnzzL+oGjZHyo\nM2pWj1" +
       "XBijg8rQ5WtPqwIhAwWKWfFavAhXLYcB3EE/9D2MqOYk55O0JgrE3XNxYgJt" +
       "Uhw5a0duCL\nb943uu/+HuHbG2pOsQtkk30WOz2sbX+x9bIWZBgZsQ565A9a" +
       "lKLOpDulozz2KmqpkZToEvseNuoT\nQkf/Fb8P2MN0w15Exm4e0HMGpHmz/R" +
       "4CjoEpkQ1XX8N8cBsvO0QoBCmYh7kha4sXGC6mM7p82FXn\nsqK8pq1RJUfY" +
       "LtvREVdsgMfrbtDuHT7VFOWAIeNEsk1XkrTkmDXAvTik4gyk/pIaBKCPJHGG" +
       "qCyr\nrakxcVLXDTHnzMiZyQsj15ICYpgMjLEhGN9ZY7xHwT626qSsosruHK" +
       "tr2t2B2mjq3P3Tp84yT3HQ\nk2WkrhrLD2sZE9wk61+fudraGuN2VB0FqNKs" +
       "WJ8kBuwBiUbVwyKVgSgYBgN4ehKmExzCq/YAp6g8\neTr9ddHfXXhp0YHfhF" +
       "BwEDWoOpYHMd91oHpI98TKwqauYGy/m7PQOBtzto5BmKy1yD+f0DGoh9th\n" +
       "FMvCKgO6TIQXMFa2Ayfxo3+gKLxr5z3MrWpZD9yKFDNdufZ6awwbhTqcNiBS" +
       "cramSPyUJuZou7zk\nqYb4ui3cA+blBN1EGUqBrnhwYJ4br8MdOH0Fd4GSsK" +
       "mi9vmUnwaCfRQF9vGkUwzB0qaYKRL2DOyF\nnZgIFcPs2QdaIHJ37Nmf2pn0" +
       "MFcrcFLgI5V6Y2MzjoCkOlusUArlHfxtkBUjLtbYVbCG1Xe5QBM2\n0pbEXs" +
       "Y8OMK4ruX3qR1kWqmIVmbvj9aKltKgreqTr35r7OoJV1jXmuOusPt4KLDaA5" +
       "VezZrTrOCM\nz7Aix6ex+IhtxQTGElafc6RC7j9F52ofobb2fmx9b/eGjRu3" +
       "bt7afsjGlnLI1inpNEwlD0DebvGb\nh3aO1+3/H6i1p2E1+GcIEN/Yvq0d3N" +
       "IBcsjdEHmMqLNjaJM13A+/RCLR0dXX5WRZxC35mUpLhrgl\nKYo6nIHzCd7A" +
       "rreVreg6cS3zeNgVh4BbQZd33ZQuT86lS1Z8jhWf96vwLtZ6/NZRzKabUszj" +
       "N66Y\nTbeYYnpvSjGnb1wxvSXFcHBaJQ5WqHSwEqccjrYr5rpK4we74/uuNn" +
       "4Bv/ygC5cbKOR93ehWSZ6o\nFUdVE3XX3CaN8gvF0tY4lNretXb9vD8HUXiO" +
       "a5Ymp3GcUNssIkSM37/gG75/afPJ6uenKb/svlBW\n+UWQH1TE2abinrR8UF" +
       "/5iabBLGeUK21Z2bnmDniOOY55zHeu4TbzmKz6WdiTgf0UyDEsez8LbmGS\n" +
       "nJ4ng6aeG3WOSN1OwrsTMnBeV2Q+wTMer/BOX9nyzTJZuuE56chy8sOU5Tnw" +
       "Owg8eRRTid9aKmLk\nTfK9Bp4zDt9nPky+f0hRDMvyhO6cQ5+5aXWzZy08Lz" +
       "hsv1CN7Tn2XHEBEzXvVyov1fkNq9g1nQ/F\nrwZ/tCjOLw3DGQAZJwzLv0ZU" +
       "fmwo+4bAeWwoSvQReNquI9G6qvdA21jxmouQr19vpxlRiTYtLrv5\n7vVi6S" +
       "InKMir3C4NqLpG2HWf2yfulhQ9Ufy4A52FqvydEfzxteb2JNdPrutEl+GMLj" +
       "F2qtwFiquY\nQk3bstfNfKafQdDnsKLVcMWLFa54scB0KNIkO88uqfhgJj7r" +
       "SB2XDnS+ZDRdFF7ifnqJJlFsylZV\n772Ppx4xTDKlcO6i4hbI4H9/BDH9Xw" +
       "PYNpNXOIvvCsIrAA1FQtbwF+4Vvy+g/wGw+sQWMxwAAA==");
}
