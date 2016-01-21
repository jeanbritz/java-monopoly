package com.britzj.monopoly.view.dialog;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class CenteredLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_PREFERRED_HEIGHT = 50;

	private int preferredHeight = DEFAULT_PREFERRED_HEIGHT;

	public CenteredLabel() {
		super();

	}

	public CenteredLabel(String text, int preferredHeight) {
		this(text, preferredHeight, null);
	}

	public CenteredLabel(String text, Font font) {
		this(text, 0, font);

	}

	public CenteredLabel(String text, int preferredHeight, Font font) {
		super("<html>" + text + "</html>");
		if (preferredHeight > DEFAULT_PREFERRED_HEIGHT) {
			this.preferredHeight = preferredHeight;
		}
		if (font != null) {
			setFont(font);
		}
		setVerticalAlignment(JLabel.CENTER);
		setHorizontalAlignment(JLabel.CENTER);
	}

	@Override
	public void setText(String text) {
		if (!text.startsWith("<html>")) {
			StringBuilder sb = new StringBuilder(text);

			sb.insert(0, "<html>");
			sb.append("</html>");
			super.setText(sb.toString());
			return;
		}
		super.setText(text);
	}

	protected void adjustToPreferredSize() {
		super.setPreferredSize(new Dimension((int) (getParent().getWidth() * 0.9), preferredHeight));

	}

}
