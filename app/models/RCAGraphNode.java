/*
 * Copyright (C) 2011 by Eero Laukkanen, Risto Virtanen, Jussi Patana, Juha Viljanen, Joona Koistinen, Pekka Rihtniemi, Mika Kekäle, Roope Hovi, Mikko Valjus
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

package models;

import play.db.jpa.Model;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: eero
 * Date: 10.10.2011
 * Time: 17:24
 * To change this template use File | Settings | File Templates.
 */
public abstract class RCAGraphNode extends Model {

	@ManyToMany(mappedBy = "nodes")
	Set<RCAGraphRelation> relations = new HashSet<RCAGraphRelation>();

		public void addCause(RCAGraphNode cause) {
			RCAGraphRelation relation = new RCAGraphRelation();
			relation.cause = cause;
			relation.effect = this;
			this.relations.add(relation);
			cause.relations.add(relation);
	}

	public boolean isCauseOf(RCAGraphNode cause) {
		for (RCAGraphRelation relation : relations) {
			if (relation.effect.equals(cause)) {
				return true;
			}
		}
		return false;
	}
}