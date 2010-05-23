#esjTrader make file to compile all .sj source code into SJ Java byte code

SJ = sessionjc
BUILD_DIR = build/
SRC_DIR = src/esjtrader/

all: TradePacket Server TraderCom Trader TradeListener

TradePacket:
	$(SJ) -cp $(BUILD_DIR) -d $(BUILD_DIR) $(SRC_DIR)utils/TradePacket.sj

Server:
	$(SJ) -cp $(BUILD_DIR) -d $(BUILD_DIR) $(SRC_DIR)server/Server.sj

TraderCom:
	$(SJ) -cp $(BUILD_DIR) -d $(BUILD_DIR) $(SRC_DIR)server/TraderCom.sj

Trader:
	$(SJ) -cp $(BUILD_DIR) -d $(BUILD_DIR) $(SRC_DIR)client/Trader.sj

TradeListener:
	$(SJ) -cp $(BUILD_DIR) -d $(BUILD_DIR) $(SRC_DIR)client/TradeListener.sj