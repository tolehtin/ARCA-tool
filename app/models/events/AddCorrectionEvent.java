/*
 * Copyright (C) 2011 by Eero Laukkanen, Risto Virtanen, Jussi Patana, Juha Viljanen,
 * Joona Koistinen, Pekka Rihtniemi, Mika Kekäle, Roope Hovi, Mikko Valjus,
 * Timo Lehtinen, Jaakko Harjuhahto
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package models.events;

import models.Cause;

/**
* Add corrective action to cause event
*/
public class AddCorrectionEvent extends Event {

	/**
	* the name of the corrective action
	*/
	public final String name;
	/**
	* the description if the corrective action
	*/
	public final String description;
	/**
	* the id of the cause to add the corrective action
	*/
	public final String correctionTo;

	/**
	* Basic constructor
	*/
	public AddCorrectionEvent(Cause cause, String name, String description) {
		super("addcorrectionevent");
		this.correctionTo = Long.toString(cause.id);
		this.name = name;
		this.description = description;
	}

}



