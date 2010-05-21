package esjtrader.server;

import java.io.*;
import java.net.*;
import java.util.*;

import sessionj.runtime.*;
import sessionj.runtime.net.*;
import sessionj.runtime.transport.*;

import esjtrader.utils.TradePacket;

public class TraderCom
{
	private final noalias protocol p_strader
	{
		cbegin.!{TRADE: !<String>, NEGO:}
	}
	
	public TraderCom(String setups, String transports, TradePacket tp, String other, int flag) throws Exception
	{
		SJSessionParameters params = SJTransportUtils.createSJSessionParameters("d", "d");
		final noalias SJService service = SJService.create(p_strader, tp.getHost(), tp.getPort());
		final noalias SJSocket s;
		try(s)
		{
			s = service.request(params);
			if(flag == 1)
			{
				s.outbranch(TRADE)
				{				
					String msg = "TRADED (" + tp.getID() + "): " + "[" + other + " - " +
						tp.getTicker() + ", " + tp.getTQuant() + " @ " + tp.getPrice() + "]";
					s.send(msg);
				}
			}
			else
			{
				s.outbranch(NEGO)
				{}
			}
		}
		finally{}
	}
}