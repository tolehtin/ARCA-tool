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

import controllers.RCACaseController;
import models.RCACase;
import models.User;
import models.enums.CompanySize;
import models.enums.RCACaseType;
import org.junit.*;
import play.test.UnitTest;

/**
 * @author: Mikko Valjus
 */
public class RCACaseTest extends UnitTest {
	@Test
    public void createRCACaseTest(){
		User user = User.find("byEmail", "admin@arcatool.fi").first();
		RCACaseType rcaCaseType = RCACaseType.valueOf(2);
		CompanySize size = CompanySize.valueOf(2);
		RCACase testCase = user.addRCACase("TestRCACase", rcaCaseType, true, "Keijon Kaapeli ja Kaivanto Oy", size,
		                                   false);
		assertTrue(user.caseIDs.contains(testCase.id));
		RCACase comparisonCase =  RCACase.find("byID",testCase.id).first();
		assertEquals(comparisonCase.companyName, "Keijon Kaapeli ja Kaivanto Oy");
		assertEquals(testCase.caseType, RCACaseType.valueOf(2));
		assertNotSame(testCase.companySize, CompanySize.valueOf(3));
		assertEquals(testCase.owner_id, user.id);
		assertFalse(testCase.isCasePublic);
		assertTrue(testCase.isMultinational);
		assertEquals(comparisonCase.name, "TestRCACase");
	}
}