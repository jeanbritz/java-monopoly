package com.monopoly;

import java.awt.Font;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.monopoly.models.ChanceCard;
import com.monopoly.models.Property;
import com.monopoly.models.Property.Tariff;
/**
 * 
 * @author Jean Britz
 * @version 1.0
 * @since 1.0
 */

public class AssetLoader {

	static Connection conn;
	private static final String ASSET_FOLDER = System.getProperty("user.dir") + File.separatorChar +"assets";
		
	protected AssetLoader() {
				
	}
	
	/**
	 * Opens the DB connection to the MS Access database
	 * @return Connection object
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
	 * Close the DB connection
	 */
	private static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				showErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Helper function of displaying a dialog with a message
	 */
	public static void showErrorMessage(String text) {
		JOptionPane.showMessageDialog(null, text, "Monopoly", JOptionPane.WARNING_MESSAGE);
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
			showErrorMessage(e.getMessage());
			e.printStackTrace();
		} finally {
			closeConnection();
			try {
				rs.close();
			} catch (SQLException e) {
				showErrorMessage(e.getMessage());
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
		String tariffQuery = "select * from Tariffs where PropId = ?";
		Vector<Property> result = new Vector<Property>();
		String mortage = null;
		Property rec = null;
		ResultSet rsProperty = null;
		ResultSet rsTariff = null;
		Statement stmt = null;
		PreparedStatement prepStmt = null;
		try {
			stmt = conn.createStatement();
			rsProperty = stmt.executeQuery(query);
			while(rsProperty.next()) {
				mortage = rsProperty.getString(Property.P_MORTAGE);
				if(mortage != null) {
					rec = new Property();
					rec.setId(rsProperty.getInt(Property.P_ID));
					rec.setName(rsProperty.getString(Property.P_NAME));
					rec.setCost(rsProperty.getInt(Property.P_COST));
					rec.setType(rsProperty.getString(Property.P_TYPE));
					rec.setHouseCost(rsProperty.getInt(Property.P_HOUSE_COST));
					rec.setMortage(mortage);
					rec.setRgb(rsProperty.getString(Property.P_RGB_COLOUR));
					int x = rsProperty.getInt(Property.P_BOARD_POS_X);
					int y = rsProperty.getInt(Property.P_BOARD_POS_Y);
					rec.setBoardLocation(new Point(x, y));
					prepStmt = conn.prepareStatement(tariffQuery);
					prepStmt.setInt(1, rec.getId());
					rsTariff = prepStmt.executeQuery();
					while(rsTariff.next()) {
						rec.addTariff(rsTariff.getInt(Tariff.P_T_CODE_COL_NAME),
									  rsTariff.getInt(Tariff.P_T_COST_COL_NAME));
					}
					result.add(rec);
				}
			}
		} catch (SQLException e) {
			showErrorMessage(e.getMessage());
			e.printStackTrace();
		} finally {
			closeConnection();
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(prepStmt != null) {
					prepStmt.close();
				}
			} catch (SQLException e) {
				showErrorMessage(e.getMessage());
				e.printStackTrace();
			}
		}
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
			if(list[i].getName().contains(resource.toLowerCase())) {
				try {
					return ImageIO.read(list[i]);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	/**
	 * 
	 * @param resource
	 * @return
	 */
	public static ImageIcon loadImageIcon(String resource) {
		return new ImageIcon (loadImage(resource));
	}
	
	
	/**
	 * 
	 * @param heading
	 * @return
	 */
	public static Font loadFont(String heading) {
		if(heading.equalsIgnoreCase("h1")) {
			return new Font ("Arial", Font.BOLD, 50);
		} else if(heading.equalsIgnoreCase("h2")) {
			return new Font("Arial", Font.BOLD, 25);
		} else if(heading.equalsIgnoreCase("h3")) {
			
		} else if(heading.equalsIgnoreCase("body")) {
			return new Font("Arial", Font.PLAIN, 12);
		}
		else if(heading.equalsIgnoreCase("li")) {
			return new Font ("Arial", Font.PLAIN, 20);
		}
		return null;
	}
	/**
	 * 
	 * @author BritzJ
	 *
	 */
	public static class ImageFileFilter implements FileFilter {
	  private static final String[] allowedfileExt = 
	    new String[] {"jpg", "png", "gif"};
	 
	  public boolean accept(File file) {
	    for (String extension : allowedfileExt) {
	      if (file.getName().toLowerCase().endsWith(extension)) {
	        return true;
	      }
	    }
	    return false;
	  }
	}
	
}
