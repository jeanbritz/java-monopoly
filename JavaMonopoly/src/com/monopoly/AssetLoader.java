package com.monopoly;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.monopoly.models.ChanceCard;
import com.monopoly.models.Property;
/**
 * 
 * @author BritzJ
 * @version 1.0
 * @since 1.0
 */
public class AssetLoader {

	static Connection conn;
	private static final String ASSET_FOLDER = System.getProperty("user.dir") + File.separatorChar +"assets";
		
	protected AssetLoader() {
				
	}
	
	/**
	 * 
	 * @return
	 */
	private static Connection getConnection() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String db = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=";
			db += ASSET_FOLDER + File.separatorChar + "data.mdb";
			conn = DriverManager.getConnection(db, "", "");
			
		} catch (Exception e) {
			e.printStackTrace();
			closeConnection();
			System.exit(-1);
		} 
		return conn;
	}
	
	/**
	 * 
	 */
	private static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				showMessage(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	public static void showMessage(String text) {
		JOptionPane.showMessageDialog(null, text);
	}
	
	/**
	 * 
	 * @return
	 */
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
		} finally {
			closeConnection();
			try {
				rs.close();
			} catch (SQLException e) {
				showMessage(e.getMessage());
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static Vector<Property> getPropertyCards() {
		conn = getConnection();
		String query = "select * from Properties";
		Vector<Property> result = new Vector<Property>();
		String mortage = null;
		Property rec = null;
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				mortage = rs.getString(Property.P_MORTAGE);
				if(mortage != null) {
					rec = new Property();
					rec.setId(rs.getInt(Property.P_ID));
					rec.setName(rs.getString(Property.P_NAME));
					rec.setCost(rs.getInt(Property.P_COST));
					rec.setType(rs.getString(Property.P_TYPE));
					rec.setHouseCost(rs.getInt(Property.P_HOUSE_COST));
					rec.setMortage(mortage);
					rec.setRgb(rs.getString(Property.P_RGB_COLOUR));
					int x = rs.getInt(Property.P_BOARD_POS_X);
					int y = rs.getInt(Property.P_BOARD_POS_Y);
					rec.setBoardLocation(new Point(x, y));
					result.add(rec);
				}
			}
		} catch (SQLException e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
		closeConnection();
		
		
		return result;
		
	}
	/**
	 * 
	 * @param resource
	 * @return
	 */
	public static BufferedImage loadImage(String resource) {
		File folder = new File(ASSET_FOLDER);
		File list[] = folder.listFiles(new ImageFileFilter());
		for (int i = 0; i < list.length; i++) {
			if(list[i].getName().contains(resource.toLowerCase()))
				try {
					return ImageIO.read(list[i]);
				} catch (IOException e) {
					e.printStackTrace();
			}
		}
		return null;
	}
		
	public static class ImageFileFilter implements FileFilter
	{
	  private final String[] allowedfileExt = 
	    new String[] {"jpg", "png", "gif"};
	 
	  public boolean accept(File file)
	  {
	    for (String extension : allowedfileExt)
	    {
	      if (file.getName().toLowerCase().endsWith(extension))
	      {
	        return true;
	      }
	    }
	    return false;
	  }
	}
	
}
