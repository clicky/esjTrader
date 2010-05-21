package esjtrader.server;

import java.io.*;
import java.net.*;
import java.util.*;
import sessionj.runtime.*;
import sessionj.runtime.net.*;
import sessionj.runtime.transport.*;
import esjtrader.utils.TradePacket;

public class TraderCom {
    final private SJProtocol p_strader =
      new SJProtocol(
      ("H4sIAAAAAAAAAIVTPWgUQRR+90cuMWiMJkSMBvQuxh9usVDECJrkLiZx84Ob" +
       "IAiazO2Odxtnd8ed\nibmASMqzEQTByk5JYyWIpYhIQCstUthYxMJCCysRUj" +
       "izc3+Jx7qwy+zM+773zffee/ETEsyHFMOM\n2Z67mOErFLOM/FUrY8LAfFYs" +
       "5831jQsvXd67GYWIDi0OdvLYZxy69UV0F2lL3CbaiEcINrlgGiz5\nMBDKGh" +
       "wpZlBPJGBOmEWbWBwG9CpcC0BaDa5tg8tMR3dkkl8vvyikyFwqyaMWY+1a4f" +
       "GzKIBAdFGP\nrBSIxysIFTOUfj2nf3/Tp2IONomZDljnza2zvYc+D31rjUnJ" +
       "SeoxW96aQ49eBSlHZiongyVKS1RY\n3S/dysizTN0tlppzHc+yb9koT7BuM7" +
       "61J3361Y+HHYElcSJ2OHQ0OC1j5M1P/Z+uvn9gGFY/3vx9\nOCCNmHfgPkQC" +
       "UfvrLLrt3saWpG8/btyYWCgfiQkz6HJcFkiEHgsp6sgwLtj/1FRa2R+CagCd" +
       "J0/W\nn8/8KkuQVBelJZHyRAh4eonnfeSaxWZZw7QON0VFr0OnzbKYYtfCLi" +
       "crMsCSTYkEmMO+hhKMIVac\nRHSwqpSC0Lq37mTlPNHy5e277oVPMYiOQhvx" +
       "kDWKTO7549DKiz5mRY9YJXrxUiChfTkpvh3ijQqy\nrpr+gNCY0FEekwa145" +
       "AsiiwjnoV1iBGU59CpFBLkFjTVrKL14u//ZDkkZq8OZXOCNx06mK7VzMsz\n" +
       "IZhJsUYF0WiOs+TaJuK1ye7b6Hnaljp5Lui4XY6Kk0ccuuqToqZaDXPVTCGz" +
       "d8f8zRBk4jFhF/bn\nzbXND/dyVx6U1YC4yMHb725w33YL4u5iboKayN2M2m" +
       "UySQ+kVr9yiE/lLk/TUpB3918Sf/TCDwUA\nAA=="));
    
    public TraderCom(String setups, String transports, TradePacket tp,
                     String other, int flag)
          throws Exception {
        super();
        SJSessionParameters params =
          SJTransportUtils.createSJSessionParameters("d", "d");
        final SJService service =
          SJService.create(p_strader, tp.getHost(), tp.getPort());
        SJSocket s = null;
        try {
            s = service.request(params);
            if (flag == 1) {
                {
                    SJRuntime.outlabel("TRADE", s);
                    String msg = "TRADED (" + tp.getID() + "): " + "[" + other +
                    " - " + tp.getTicker() + ", " + tp.getTQuant() + " @ " +
                    tp.getPrice() + "]";
                    SJRuntime.send(msg, s);
                }
            } else {
                { SJRuntime.outlabel("NEGO", s); }
            }
        }
        finally {
            SJRuntime.close(s);
        }
    }
    
    final public static String jlc$CompilerVersion$jl = "2.3.0";
    final public static long jlc$SourceLastModified$jl = 1272601509000L;
    final public static String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAIVXf2xbxR0/O46dtGb50bTr2rTpj5S1K3XWbSDWTKJpmtAE" +
       "pwlx+oNMzDm/d7Yv\nPb/39u6e41QMlU1aOyYhIVrYpjH+YapA/AFFwD8TG4" +
       "JSbYCmdVJAk2CaOk1Ig2n8M7qpY/ve3fN7\njm1cSz6f776/7nvf7+f7vec+" +
       "Ru3cRSlOOKe2tZgSyw7harRzi8QQPJWZnMEuJ+Yow5zPwUbWWPiM\nHn+h5/" +
       "tHoigyj3ote4RRzOeKru0VinNFyisu2ubYbLnAbOFLbJBxYOeNpbfPTm5uQ1" +
       "3zqItaGYEF\nNUZtS5CKmEfJEinliMtHTJOY86jHIsTMEJdiRk8DoW2BYk4L" +
       "FhaeS/gs4TYrS8Je7jnEVTqri2mU\nNGyLC9czhO1ygbrTi7iMhzxB2VCacj" +
       "GcRvE8Jczk30UPomgatecZLgDhhnT1FENK4tC4XAfyNRTM\ndPPYIFWW2Clq" +
       "mQIN1HMEJx68BwiANVEiomgHqmIWhgXUq01i2CoMZYRLrQKQttseaBFo0+cK" +
       "BaIO\nBxuncIFkBdpYTzejt4CqU7lFsgi0vp5MSYI721R3ZzW3NR1P/vfhmU" +
       "+3wY2DzSYxmLQ/Dkxb65hm\nSZ64xDKIZrzupc5P3Of1RxEC4vV1xJpmZNcr" +
       "x9If/npA02xuQjOtYjFr3Lijf8vVkb92tkkzOhyb\nUxkKq06ubnXG3xmuOB" +
       "DdGwKJcjNV3fzN7Jv3nXmW/D2KOiZQ3LCZV7ImUCexzFF/noB5mlpEr07n\n" +
       "85yICRRjailuq//gjjxlRLqjHeYOFkU1rzgIoQR8I/Ddh/TnFjkIlJxzsUnc" +
       "UbuU4osCbeeuMURg\nplaHOHHL8FNLU5Eiv7AUicBp+uszi0EYHrEZEGeNi9" +
       "d+98DYPT86p+9JxpZvDERRoCGlNaQCDSgS\nUaLXySDUThpxXbwsk6Py0NUt" +
       "P72CnwSXw9E5PU3UySJLMTkC09daYsdomHkTMMMQGFmj78yHm372\nx2cuR1" +
       "FbU/xIB4vjtlvCTIZANWF6fXX1OxA5g/Xx20z3Px6eenHlrfd3h5Es0GBDgj" +
       "VyygTZUe96\n1zaICQAUin/iP0f++Vj7N1+KohhkHeCOwBAtkMRb63WsSpTh" +
       "KujIs7Sl0dp8w8HXCHDQUs2B5ZhU\n8y64ig74QgKh2/xQ65OD3OyRQ6+OIL" +
       "iuvrozKEi7/oP4V9/91drLyilV9OuqgckMETqXesIQmXMJ\ngfX3fzLz2IWP" +
       "z367DbLXcXRYCBR3vByjRgVYvrg6/eQJTBlZH10a7n5kH39ZRUEnLZU8gXOM" +
       "AFxj\nxuwlYmaFwqueGmxUkATOSuYA2gAlswwEaXc4kTJEcBPwSG3sO//4np" +
       "+/K+HFUf7aADa2K0vb1f91\nUBPUuaSOlMZfub63urs5zB15Bq5TR8IrEZqw" +
       "EQhnXFoCnCn7QPjo1qf/9uK12T4dd7pa7GwA7Foe\nXTHUxa11pCO3t9KgqN" +
       "/Yu/25B2c/yGkk7V3t+DHLK93+1Htkz8Gk0QQf2qCmVdSBd0XkuCdwVTXX\n" +
       "fWesC101VjGII7FUWblFwkFfGCAAnaf0VSf3ZO6fXDi3Q8WIdrxyWzDsC2b7" +
       "tQ0HbkZVaTDPRd9o\nCUXjssRDygobsD7M2IUfv3fv1MkTQ9pn+1uKOAoOM5" +
       "WckP/ChHXXq+tXrKhM0jhfDJyaRlEuBNqd\nror0L1n+1bPMZEZvVSvwbTc/" +
       "QKiYPvCvhy79/kISFM+jBOXj1MJMZhI/qsGzSXWuE3H61WO/uP6O\n+ECFQ4" +
       "hW0vz+SmOpOY5rgPTOlXJP/PmnSlGUmEfdqsPCljiOmSdRYR56JD7qL6bRLa" +
       "v2V/c7urgP\nB2jcX58VNWrrcTJW4+2YpJbzjlpo/J/+fCa/EhLlH12Fe6Hy" +
       "OVC63W13Ezg0FsR0KpGII9nGFfOA\nGnfoiI0KUC1dLFDCcWkZy0YVdTpZrp" +
       "EhwIrgDl3PErREZAftR50C4YhKrymI18G66w4iIyUjQ2jg\nuLLyrUuW6L+m" +
       "7ijht8WyNw3RGfoVBi5UDY+LdreUGsRb1vArRUSjvlGkzJSWHQQZO1sGoo9o" +
       "iczF\nE4XzT8vE8UFKVohbQwAI7eKDx6ySbdI8VRAPkHCja9f+lz56pFsjUQ" +
       "jjkAQ3FxCuf+kQOvPWdz7d\nqsREDCnjXh/lDwS48OUWHhk9RAq0wSESCm5t" +
       "wVXDdIA9ceWXM5+cq7phVmH1V1owT3si50I0F5tp\nbWXroaZckP29lB8mDv" +
       "SoxBJsWVdYuFEMzIDXNZFyBPPiFHaGq5Y6aHVN9/fbE3967fUNC39oQ9Fx\n" +
       "tIbZ2BzHqhlCndCFEF6EdrPi3HVQmZBckr1Ht0wRELY+sF8JzEymcY6wGmsn" +
       "UEcRtIzaJpT6NoZz\n0pTDFSd2+d+HIcXmZkcOj4GcXS2j2DKb+e72FjxTMI" +
       "e3EOR8ybOood6QWsbAysYn1wzuvVOF0NqS\npptbhSXSU2FDkEODZ/4sUOzo" +
       "2N3TTkURnFTjdl0+UVg+dQwiGRFbPu91pSr32ZOfJH+I37i/GkVf\nB2gRtr" +
       "OPkTJhvthyo5Ap9ZisomPXiYG/jN9x8Xthp1PVD9KCbl8m6caG57l+RBo7ri" +
       "7sft3p+a3q\nX4OHXgJeW3mPsVq0rZnHHZfkqbI7obHXUT8e9FX1rw5oDfVE" +
       "2Sc0obQvIJQLy06TxkwXikrk/xcd\nn9K1EAAA");
}
