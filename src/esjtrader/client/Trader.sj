//$ sessionjc -cp build/ src/esjtrader/client/Trader.sj -d build/

package esjtrader.client;

import java.util.*;

import sessionj.runtime.*;
import sessionj.runtime.net.*;
import sessionj.runtime.transport.*;

import esjtrader.utils.TradePacket;

public class Trader
{
	private static final noalias protocol p_client
	{
		^(esjtrader.server.Server.p_sc)
	}
	
	public Trader(final String setups, final String transports, String server, int port, final int port_t, String trader_id) throws Exception
	{	
		final noalias SJSocket s;
		SJSessionParameters params = SJTransportUtils.createSJSessionParameters(setups, transports);
		final noalias SJService service = SJService.create(p_client, server, port);
		
		try(s)
		{
			s = service.request(params);
			
			Scanner scanner = new Scanner(System.in);
			String activity = "";
			String ticker = "";
			int quant = 0;
			double price = 0.0;
			
			System.out.println("WELCOME TO esjTRADER.\nENTER ACTIVITY:\n");
			
			s.recursion(X)
			{
				System.out.println("BUY | SELL | NEG");
				activity = scanner.nextLine();
				System.out.println("ENTER TICKER NAME:");
				ticker = scanner.nextLine();
				System.out.println("ENTER QUANTITY (integer):");
				quant = Integer.parseInt(scanner.nextLine());
				System.out.println("ENTER PRICE (double):");
				price = Double.parseDouble(scanner.nextLine());
				
				TradePacket tp = new TradePacket(trader_id, activity, ticker, price, quant);
				tp.setConnection("localhost", port_t);
				
				if(activity.equalsIgnoreCase("BUY") || activity.equalsIgnoreCase("SELL"))
				{
					s.outbranch(BUYSEL)
					{
						//System.out.print("out next: ");
						s.send(tp);
						//System.out.println("blah");
						int x = s.receiveInt();
						System.out.println("Trade ID: " + x + "\n");
						//System.out.print("out next222: ");
						s.recurse(X);
					}
				}
				else
				{
					s.outbranch(NEGO)
					{
						s.send(new TradePacket());
						s.send(0);
						s.recurse(X);
					}
				}
			}
		}
		finally{}
	}
	
	public static void main(String[] args) throws Exception
	{
		String setups = args[0];
		String transports = args[1];
		
		String server = args[2];
		int port = Integer.parseInt(args[3]);
		int port_t = Integer.parseInt(args[4]);
		
		String trader_id = args[5];
		
		new Trader(setups, transports, server, port, port_t, trader_id);
	}
}