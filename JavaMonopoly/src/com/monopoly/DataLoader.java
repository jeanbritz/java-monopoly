package com.monopoly;

import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.monopoly.models.ChanceCard;
import com.monopoly.models.Property;

public class DataLoader {

	Connection conn;
	String filePath = System.getProperty("user.dir") + "\\src\\com\\monopoly\\data\\data.mdb";
	
	
	
	public DataLoader() {
				
	}

	private Connection getConnection() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String db = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=";
			db += filePath;
			conn = DriverManager.getConnection(db, "", "");
			
		} catch (Exception e) {
			e.printStackTrace();
			closeDb();
		} 
		return conn;
	}
	
	private void closeDb() {
		if(conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void showMessage(String text) {
		JOptionPane.showMessageDialog(null, text);
	}
	
	public ArrayList<ChanceCard> getChanceCards() {
		conn = getConnection();
		String query = "select * from Cards";
		ArrayList<ChanceCard> result = new ArrayList<ChanceCard>();
		ChanceCard rec = null;
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				rec = new ChanceCard();
				rec.setId(rs.getInt(ChanceCard.CC_ID));
				rec.setGroup(rs.getString(ChanceCard.CC_GROUP));
				rec.setType(rs.getString(ChanceCard.CC_TYPE));
				rec.setMessage(rs.getString(ChanceCard.CC_MESSAGE));
				rec.setConsequence(rs.getString(ChanceCard.CC_CONSEQUENCE));
				result.add(rec);
			}
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
		closeDb();
		
		
		return result;
		
	}
	
	public ArrayList<Property> getPropertyCards() {
		conn = getConnection();
		String query = "select * from Properties";
		ArrayList<Property> result = new ArrayList<Property>();
		Property rec = null;
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				rec = new Property();
				rec.setId(rs.getInt(Property.P_ID));
				rec.setName(rs.getString(Property.P_NAME));
				rec.setCost(rs.getInt(Property.P_COST));
				rec.setType(rs.getString(Property.P_TYPE));
				rec.setHouseCost(rs.getInt(Property.P_HOUSE_COST));
				rec.setMortage(rs.getString(Property.P_MORTAGE));
				rec.setRgb(rs.getString(Property.P_RGB_COLOUR));
				int x = rs.getInt(Property.P_BOARD_POS_X);
				int y = rs.getInt(Property.P_BOARD_POS_Y);
				rec.setBoardLocation(new Point(x, y));
				result.add(rec);
			}
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
		closeDb();
		
		
		return result;
		
	}
		
	public static void main (String [] args) {
		DataLoader loader = new DataLoader();
		loader.getPropertyCards();
	}
}
