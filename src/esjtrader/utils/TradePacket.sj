//$ sessionjc src/esjtrader/utils/TradePacket.sj -d build/

package esjtrader.utils;

import java.io.Serializable;

public class TradePacket implements Serializable
{
	private static final int HASH_PRIME = 1000003;
	
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
	
	public TradePacket(String trader, String activity, String ticker, double price, int quant)
	{
		trader_id = trader;
		trade_activity = activity.toUpperCase();
		ticker_id = ticker.toUpperCase();
		trade_price = price;
		trade_quant = quant;
	}
	
	public TradePacket(){}
	
	public void trade(TradePacket tp)
	{
		int tp_q = tp.getQuant();
		
		System.out.println("yehhh"+tp_q);
		
		if(trade_quant < tp_q)
		{
			tp_q = trade_quant;
		}
		
		if(trade_activity.equalsIgnoreCase("SELL"))
		{
			tp_q *= -1;
		}
		
		quant_change = tp_q;
		
		if(trade_quant == (quant_change * -1) || quant_change == trade_quant)
		{
			settled = true;
		}
		
		trade_price = tp.getPrice();
	}
	
	public boolean equals(Object o)
	{
		if(!(o instanceof TradePacket))
		{
			return false;
		}	
    TradePacket tm = (TradePacket)o;
    if(trade_id == tm.getID() && trade_activity.equals(tm.getActivity()) && ticker_id.equals(tm.getTicker()))
		{
			return true;
		}
		return false;
  }
  
  public int hashCode()
	{
		int result = 17;
		result = HASH_PRIME * result + ticker_id.hashCode();
		result = HASH_PRIME * result + trade_activity.hashCode();
		result += trade_id;
		return result;
  }
	
	public void setConnection(String h, int p)
	{
		hostname = h;
		port = p;
	}
	
	public String getHost()
	{
		return hostname;
	}
	
	public int getPort()
	{
		return port;
	}
	
	public String getTrader()
	{
		return trader_id;
	}
	
	public void setID(int id)
	{
		trade_id = id;
	}
	
	public int getID()
	{
		return trade_id;
	}
	
	public String getActivity()
	{
		return trade_activity;
	}
	
	public String getTicker()
	{
		return ticker_id;
	}
	
	public double getPrice()
	{
		return trade_price;
	}
	
	public int getTQuant()
	{
		return quant_change;
	}
	
	public void setNT(String s)
	{
		nt = s;
	}
	
	public String getNT()
	{
		return nt;
	}
	
	public int getQuant()
	{
		return trade_quant;
	}
	
	public void settleTrade()
	{
		settled = true;
	}
	
	public boolean isSettled()
	{
		return settled;
	}
}