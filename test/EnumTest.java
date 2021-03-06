/*
 * Copyright (C) 2012 by Eero Laukkanen, Risto Virtanen, Jussi Patana, Juha Viljanen,
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

import models.enums.*;
import org.junit.Test;
import play.test.UnitTest;

/**
 * @author Risto Virtanen
 */
public class EnumTest extends UnitTest {

	@Test
	public void commentTypeTest() {
		assertEquals(CommentType.NEGATIVE, CommentType.valueOf(CommentType.NEGATIVE.value));
		assertNull(CommentType.valueOf(9999));
	}
	
	@Test
	public void companySizeTest() {
		assertEquals(CompanySize.HUNDRED, CompanySize.valueOf(CompanySize.HUNDRED.value));
		assertNull(CompanySize.valueOf(9999));
	}
	
	@Test
	public void rcaCaseTypeTest() {
		assertEquals(RCACaseType.OTHER, RCACaseType.valueOf(RCACaseType.OTHER.value));
		assertNull(RCACaseType.valueOf(9999));
	}

	@Test
	public void statusOfCauseTest() {
		assertEquals(StatusOfCause.WILL_NOT_FIX, StatusOfCause.valueOf(StatusOfCause.WILL_NOT_FIX.value));
		assertNull(StatusOfCause.valueOf(9999));
	}

	@Test
	public void statusOfCorrection() {
		assertEquals(StatusOfCorrection.IMPLEMENTED, StatusOfCorrection.valueOf(StatusOfCorrection.IMPLEMENTED.value));
		assertNull(StatusOfCorrection.valueOf(9999));
	}
}
