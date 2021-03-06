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

package controllers;

import play.mvc.Controller;
import play.mvc.With;
import models.User;
import models.RCACase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Method to open users personal main page.
 * @author Eero Laukkanen
 */
@With({Secure.class, LanguageController.class})
public class UserController extends Controller {

	/**
	 * Opens the index page of a logged in user.
	 */
	public static void index() {
		User user = SecurityController.getCurrentUser();
		if (user == null) {
			session.remove("username");
			redirect("/");
		}

		Set<RCACase> cases = user.getRCACases();
		List<RCACase> allPublicCases = RCACase.find("byIsCasePublic", true).fetch();
		Set<RCACase> ownCases = new HashSet<RCACase>();
		Set<RCACase> privateCases = new HashSet<RCACase>();
		Set<RCACase> publicCases = new HashSet<RCACase>();

		for(RCACase case1 : cases){
			if (user.id.equals(case1.ownerId)){
				ownCases.add(case1);
			}
			else if (!case1.isCasePublic){
				privateCases.add(case1);
			}
			else {
				publicCases.add(case1);
			}

		}
		render(user, ownCases, privateCases, publicCases, allPublicCases);
	}

}
