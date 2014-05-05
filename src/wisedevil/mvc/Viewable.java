package wisedevil.mvc;

/**
 * Represents an object that can be represented visually (a web page, a window frame, an applet...).
 */
public interface Viewable {
	
	/**
	 * Sets whether the object is visible or not.
	 *
	 * @param v True if the object should be visible, false otherwise.
	 */
	void isVisible(boolean v);
	
	/**
	 * Returns the visibility state of the object.
	 *
	 * @return true if the object is visible, false otherwise.
	 */
	boolean isVisible();
}

