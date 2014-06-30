/*
 * Wisedevil's MVC: MVC library for the Java platform
 *    Copyright (C) 2014  Alfredo Mungo
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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

