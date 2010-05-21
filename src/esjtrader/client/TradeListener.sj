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

public class TradeListener
{
	public final noalias protocol p_t
	{
		sbegin.?{TRADE: ?(String), NEGO:}
	}
	
	public TradeListener(String s, String t, int p) throws Exception
	{
		SJSessionParameters params = SJTransportUtils.createSJSessionParameters(s, t);
		final noalias SJServerSocket ss;
		try(ss)
		{
			ss = SJServerSocketImpl.create(p_t, p, params);
			while(true)
			{
				noalias SJSocket s_t;
			
				try(s_t)
				{
					s_t = ss.accept();
					
					s_t.inbranch()
					{
						case TRADE:
						{
							String msg = (String)s_t.receive();
							System.out.println(msg);
						}
						case NEGO:{}
					}
				}
				finally{}
			}
		}
		finally{}
	}
	
	public static void main(String[] args) throws Exception
	{
		String setups = args[0];
		String transports = args[1];
		int port = Integer.parseInt(args[2]);
		
		new TradeListener(setups, transports, port);
	}
}