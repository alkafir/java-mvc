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
package wisedevil.mvc;

/**
 * Represents an update message from the view or model to the controller.
 *
 * <blockquote>Instances of this class are immutable. Subclasses should instantiate immutable objects too.</blockquote>
 */
public abstract class Message {
	/**
	 * The object from which the message originates.
	 */
	private final Object source;
	
	/**
	 * Initializes a new instance of this class.
	 *
	 * @param src The object from which the message originates
	 *
	 * @throws NullPointerException If the <code>src</code> parameter is null
	 */
	protected Message(Object src) {
		if(src == null)
			throw new NullPointerException();
		
		source = src;
	}

	/**
	 * Returns the source of the message.
	 *
	 * @return The object from which the message originates
	 */
	public Object getSource() { return source; }
}
