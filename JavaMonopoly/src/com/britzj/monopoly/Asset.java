package com.britzj.monopoly;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.britzj.monopoly.model.persistent.Card;
import com.britzj.monopoly.model.persistent.Property;
import com.britzj.monopoly.util.HibernateUtil;

/**
 * 
 * Retrieves external resources and convert them into Java objects
 * 
 * @author Jean Britz
 * @version 1.0
 * @since 1.0
 */

public class Asset {
	

	private static final String ASSET_FOLDER = System.getProperty("user.dir") + File.separatorChar +"assets";
	
	private static List<Property> propertyRecords = null;
	private static List<Card> chanceCardRecords = null;


	protected Asset() {
				
	}

	/**
	 * Helper function of displaying a dialog with a message
	 */
	public static void showErrorMessage(String text) {
		JOptionPane.showMessageDialog(null, text, Game.getTitle(), JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 */
	@SuppressWarnings("unchecked")
	public static List<Property> getProperties() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		if (propertyRecords == null) {
			Criteria criteria = session.createCriteria(Property.class);
			propertyRecords = criteria.list();
		}
		return propertyRecords;
	}
	
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SQLException
	 */
	public static Vector<Property> getOwnablePropertyCards() throws ClassNotFoundException, NoSuchFieldException, SQLException {
		List<Property> props = getProperties();
		Vector<Property> result = new Vector<Property>(4);
		if (props != null) {
			for (Property prop : props) {
				if (prop.getPtOwnable()) {
					result.addElement(prop);
				}
			}
		}
		return result;
		
	}
	
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SQLException
	 */
	public static List<Card> getChanceCards() {
		/*
		 * try {
		 * 
		 * if (chanceCardRecords == null) { chanceCardRecords =
		 * cardDbModel.getObjectModel(Card.class).getAll(); } } catch
		 * (ClassNotFoundException | NoSuchFieldException | SQLException e) {
		 * e.printStackTrace(); }
		 */

		return chanceCardRecords;
		
	}
	
	public static Property getSingleProperty(long PId) {
		Property found = null;
		// try {
		// getPropertyModel().getObjectModel(Property.class).getFirst("PId = " +
		// PId);
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		return found;
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
			return new Font("Arial", Font.PLAIN, 10);
		} else if(heading.equalsIgnoreCase("body")) {
			return new Font("Arial", Font.PLAIN, 12);
		}
		else if(heading.equalsIgnoreCase("li")) {
			return new Font ("Arial", Font.PLAIN, 20);
		}
		return null;
	}
	
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
