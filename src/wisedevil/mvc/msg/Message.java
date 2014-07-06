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

/**
 * Represents an update message from the view or model to the controller.
 *
 * <blockquote>Instances of this class are immutable.</blockquote>
 *
 * @param <T> The message source type (view or model)
 */
public class Message<T> {
	/**
	 * The object from which the message originates.
	 */
	private final T source;
	
	/**
	 * An application-dependent integer representation of the performed action.
	 */
	private final int message;
	
	/**
	 * An optional application-dependent argument of the message.
	 */
	private final Object argument;
	
	/**
	 * Initializes a new instance of this class.
	 *
	 * @param src The object from which the message originates
	 * @param msg An application-dependent integer representation of the performed action
	 * @param arg An optional application-dependent argument of the message
	 *
	 * @throws NullPointerException If the <code>src</code> parameter is null
	 */
	public Message(T src, int msg, Object arg) {
		source = src;
		message = msg;
		argument = arg;
	}

	/**
	 * Returns the source of the message.
	 *
	 * @return The object from which the message originates
	 */
	public T getSource() { return source; }
	
	/**
	 * Returns the message.
	 *
	 * @return The application-dependent message ID
	 */
	public int getMessage() { return message; }
	
	/**
	 * Returns the message argument.
	 *
	 * @return The optional application-dependent message argument
	 */
	public Object getArgument() { return argument; }
}
