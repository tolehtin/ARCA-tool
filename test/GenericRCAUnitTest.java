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

import job.Bootstrap;
import models.*;
import models.enums.CompanySize;
import models.enums.RCACaseType;
import org.junit.Before;
import play.test.Fixtures;
import play.test.UnitTest;

/**
 * @author Eero Laukkanen
 */
public abstract class GenericRCAUnitTest extends UnitTest {

	protected User user;
	protected RCACaseType rcaCaseType;
	protected CompanySize size;
	protected RCACase testCase;

	@Before
	public void setUp() {
		Fixtures.delete(RCACase.class, Invitation.class, Cause.class, Correction.class, Relation.class, User.class);
		new Bootstrap().doJob();
		user = User.find("byEmail", "admin@local").first();
		rcaCaseType = RCACaseType.valueOf(2);
		size = CompanySize.valueOf(2);
		RCACase rcaCase = new RCACase("TestRCACase", rcaCaseType.value, "Kaapelissa ei vikaa", "Kaapelissa vikaa",
		                              true, "Keijon Kaapeli ja Kaivanto Oy", size.value, "Kaapelit ja johtimet",
		                              false, user).save();
		testCase = user.addRCACase(rcaCase);
	}

}
