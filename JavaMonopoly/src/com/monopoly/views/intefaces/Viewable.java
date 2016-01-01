package com.monopoly.views.intefaces;

/**
 * 
 * @author Jean
 * @version 1.0
 * @since 1.0
 */
public interface Viewable {
	
	/**
	 * Called when any view is being created on the frontend.
	 */
	public void initView();
	
	/**
	 * Called when a view needs to be updated on the frontend. Typically used for
	 * any animations done on the frontend
	 */
	public void updateView();
}
