/*
 * Coffin: Credentials manager application
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
package wisedevil.mvc.msg;

import wisedevil.mvc.AbstractView;

/**
 * Represents an update message from the view to the controller.
 *
 * <blockquote>Instances of this class are immutable.</blockquote>
 */
public class ViewMessage extends Message<AbstractView> {

	/**
	 * Initializes a new instance of this class.
	 *
	 * @param src The view source of the message
	 * @param msg An application-dependent integer representation of the performed action
	 * @param arg An optional application-dependent argument of the message
	 *
	 * @throws NullPointerException If the <code>src</code> parameter is null
	 */
	public ViewMessage(AbstractView src, int msg, Object arg) {
		super(src, msg, arg);
	}
}
