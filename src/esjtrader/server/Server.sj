//$ sessionjc -cp build/ src/esjtrader/server/Server.sj -d build/
//$ sessionj -cp build/ esjtrader.server.Server s a 8888 localhost

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
	public protocol p_body rec X [?{BUYSEL: ?(TradePacket).!<int>.#X, NEGO: ?(TradePacket).?(int).#X}];
	public protocol p_sc sbegin.@(p_body)
	
	public HashMap map = new HashMap();
	
	public Server(String setups, String transports, int port, String address_s) throws Exception
	{
		protocol p_sel
		{
			@(p_body),
			?{BUYSEL: ?(TradePacket).!<int>.@(p_body), NEGO: ?(TradePacket).?(int).@(p_body)},
			?(TradePacket).!<int>.@(p_body),
			?(TradePacket).?(int).@(p_body)
		}
		
		SJSessionParameters params = SJTransportUtils.createSJSessionParameters(setups, transports);
		final noalias SJSelector sel = SJRuntime.selectorFor(p_sel);
		
		try(sel)
		{
			noalias SJServerSocket ss;
			
			try(ss)
			{
				ss = SJServerSocketImpl.create(p_sc, port, params);
				sel.registerAccept(ss);
			}
			finally{}
			
			int trade_id = 0;
			
			while(true)
			{
				noalias SJSocket s_sc;
				
				try(s_sc)
				{
					s_sc = sel.select();
					
					typecase(s_sc)
					{
						when(@(p_body))
						{
							s_sc.recursion(X)
							{
								sel.registerInput(s_sc);
							}
						}
						when(?{BUYSEL: ?(TradePacket).!<int>.@(p_body), NEGO: ?(TradePacket).?(int).@(p_body)})
						{
							s_sc.inbranch()
							{
								case BUYSEL:
								{
									TradePacket tp = (TradePacket)s_sc.receive();
									tp.setID(++trade_id);
									s_sc.send(trade_id);
									
									String msg = tp.getActivity() + " (" + trade_id + 
										"): [" + tp.getTrader() + " - " + tp.getTicker() + 
										", " + tp.getQuant() + " @ " + tp.getPrice() + "]";
									System.out.println(msg);
									
									addToMap(tp);
									TradePacket tp_m = findMatch(tp);
									if(tp_m != null)
									{
										System.out.println(tp.getQuant());
										tp.trade(tp_m);
										if(tp.isSettled())
										{
											System.out.println("COMPLETE: " + tp.getID());
											removeFromMap(tp);
										}
										System.out.println(tp.getQuant());
										tp_m.trade(tp);
										if(tp_m.isSettled())
										{
											System.out.println("COMPLETE: " + tp_m.getID());
											removeFromMap(tp_m);
										}
										
										TraderCom tc1 = new TraderCom(setups, transports, tp, tp_m.getTrader(), 1);
										TraderCom tc2 = new TraderCom(setups, transports, tp_m, tp.getTrader(), 1);
										//tc1 = null;
										//tc2 = null;
									}
									
									sel.registerInput(s_sc);
								}
								case NEGO: { sel.registerInput(s_sc); }
							}
						}
						when(?(TradePacket).!<int>.@(p_body))
						{
							TradePacket tp = (TradePacket)s_sc.receive();
							tp.setID(++trade_id);
							s_sc.send(trade_id);
							sel.registerInput(s_sc);
						}
						when(?(TradePacket).?(int).@(p_body))
						{
							sel.registerInput(s_sc);
						}
					}
				}
				finally{}
			}
		}
		finally{}
	}
	
	public void removeFromMap(TradePacket tp)
	{
		HashMap tmap = (HashMap)map.get(tp.getTicker());
		ArrayList list = (ArrayList)tmap.get(tp.getActivity());
		list.remove(tp);
	}
	
	public TradePacket findMatch(TradePacket tp)
	{
		HashMap t_map = (HashMap)map.get(tp.getTicker());
		String find = (tp.getActivity()).equals("BUY") ? "SELL" : "BUY";
		ArrayList list = (ArrayList)t_map.get(find);
		
		if(list.isEmpty())
		{
			return null;
		}
		
		double price = tp.getPrice();
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			TradePacket tp_m = (TradePacket)it.next();
			if(tp_m.getPrice() == price)
			{
				return tp_m;
			}
		}
		
		return null;
	}
	
	public void addToMap(TradePacket tp)
	{
		HashMap t_map = (HashMap)map.get(tp.getTicker());
		
		if(t_map == null || t_map.isEmpty())
		{
			t_map = new HashMap();
			t_map.put("BUY", new ArrayList());
			t_map.put("SELL", new ArrayList());
			
			map.put(tp.getTicker(), t_map);
		}
		
		ArrayList list = (ArrayList)t_map.get(tp.getActivity());
		if(list == null)
		{
			list = new ArrayList();
			t_map.put(tp.getActivity(), list);
		}
		list.add(tp);
	}
	
	public static void main(String[] args) throws Exception
	{
		String setups = args[0];
		String transports = args[1];
		int port = Integer.parseInt(args[2]);
		String address_s = args[3];
		
		new Server(setups, transports, port, address_s);
	}
}