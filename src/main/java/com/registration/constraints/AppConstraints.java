package com.registration.constraints;

public interface AppConstraints {

	public static final String REGISTRATION = "registration";
	public static final String REG_FORM = "reg_form";
	public static final String SUCESS_RESULT = "susessResult";
	public static final String FAILED_RESULT = "failedResult";
	public static final String REDIRECT_TO_GET = "redirect:/doublePost";

	public static final String USER_ACCOUNT = "unlock_account";
	public static final String UNLOCK_SUCESS_RESULT = "unlkSucessResult";
	public static final String UNLOCK_FAILURE_RESULT = "unlkFailuresResult";

	public static final String USER_REGISTRATION = "unlockUsrRegstion";
	public static final String UNLOCK_ACCOUNT = "unlock_account";

	public static final String EMAIL_SUBJECT = "Register Account Login..";
	public static final String RETRIVE_PAZZWORD_SUBJECT = "Retrive Pazzword..";
	public static final String EMAIL_TXT_FILE = "email-text.txt";
	public static final String FORGET_PAZZWORD_TXT_FILE = "forget-pazzword.txt";

	public static final String TO_NAME = "${toname}";
	public static final String PAZZWORD = "${pazzword}";
	public static final String LOGIN_LINK = "${loginEmail}";

	public static final String DASHBOARD_INFO = "dashboard_info";

	public static final String USER_LOGIN = "userLogin";
	public static final String FORGET_PAZZWORD = "forget_pazzword";
	public static final String RESULT = "result";

	public static final String LOGININFO = "loginInfo";
	public static final String LOGIN_INFO = "login_info";

	public static final String REDIRECT_DASHBOARD = "redirect:/dashboard";
	public static final String ACC_LOCK_MSG = "accLockedMsg";
	public static final String ERROR_MSG = "errorMsg";

}
