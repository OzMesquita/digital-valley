package util;

import java.util.Map;

import com.github.shyiko.dotenv.DotEnv;

public class Constantes {

	private static String APP_URL;
	private static String ADM_URL;
	private static String APP_ASSETS_URL;
	private static String APP_JS_URL;
	private static String APP_IMG_URL;
	private static String APP_CSS_URL;
	private static Integer NUMBER_OF_ROWS_PER_PAGE;
	private static String SESSION_MSG;
	private static String DATABASE_CONF_DIR;
	private static String EMAIL_CONF_DIR;
	private static String MODULES_IMAGES_DIR;
	private static String USER_PROFILE_IMAGES_DIR;
	private static String USER_PROFILE_NONE_IMAGE_DIR;
	private static String APP_IMG_USER_DIR;
	private static String PRE_URL;
	private static Integer MAX_USER_PROFILE_IMAGE_SIZE_BYTES;
	private static String SESSION_MSG_ERROR;
	private static String GUARDIAO_VERSION;
	
	/**
	 * Classe de constrantes da aplicação
	 * São carregadas de arquivo .env localizado na 
	 * pasta /digital-valley/src/main/resources
	 * 
	 */
	private Constantes() {
		//
	}

	static {
		Map<String, String> dotEnv = DotEnv.load();
		DATABASE_CONF_DIR = dotEnv.get("DATABASE_CONF_DIR");
		EMAIL_CONF_DIR = dotEnv.get("EMAIL_CONF_DIR");
		APP_URL = dotEnv.get("APP_URL");
		ADM_URL = dotEnv.get("ADM_URL");
		APP_ASSETS_URL = dotEnv.get("APP_ASSETS_URL");
		APP_JS_URL = dotEnv.get("APP_JS_URL");
		APP_IMG_URL = dotEnv.get("APP_IMG_URL");
		APP_CSS_URL = dotEnv.get("APP_CSS_URL");
		MAX_USER_PROFILE_IMAGE_SIZE_BYTES = Integer.valueOf(dotEnv.get("MAX_USER_PROFILE_IMAGE_SIZE_BYTES"));
		NUMBER_OF_ROWS_PER_PAGE = Integer.valueOf(dotEnv.get("NUMBER_OF_ROWS_PER_PAGE"));
		SESSION_MSG = dotEnv.get("SESSION_MSG");
		MODULES_IMAGES_DIR = dotEnv.get("MODULES_IMAGES_DIR");
		USER_PROFILE_IMAGES_DIR = dotEnv.get("USER_PROFILE_IMAGES_DIR");
		USER_PROFILE_NONE_IMAGE_DIR = dotEnv.get("USER_PROFILE_NONE_IMAGE_DIR");
		PRE_URL = dotEnv.get("PRE_URL");
		SESSION_MSG_ERROR = dotEnv.get("SESSION_MSG_ERROR");
		GUARDIAO_VERSION = dotEnv.get("GUARDIAO_VERSION");
	}

	/**
	 * @return the appUrl
	 */
	public static String getAppUrl() {
		return APP_URL;
	}
	/**
	 * @return the appUrl
	 */
	public static String getPreUrl() {
		return PRE_URL;
	}

	/**
	 * @return the admUrl
	 */
	public static String getAdmUrl() {
		return ADM_URL;
	}

	/**
	 * @return the appAssetsUrl
	 */
	public static String getAppAssetsUrl() {
		return APP_ASSETS_URL;
	}

	/**
	 * @return the appJsUrl
	 */
	public static String getAppJsUrl() {
		return APP_JS_URL;
	}

	/**
	 * @return the appImgUrl
	 */
	public static String getAppImgUrl() {
		return APP_IMG_URL;
	}

	/**
	 * @return the appCssUrl
	 */
	public static String getAppCssUrl() {
		return APP_CSS_URL;
	}

	/**
	 * @return the numberOfRowsPerPage
	 */
	public static Integer getNumberOfRowsPerPage() {
		return NUMBER_OF_ROWS_PER_PAGE;
	}

	/**
	 * @return the sessionMsg
	 */
	public static String getSessionMsg() {
		return SESSION_MSG;
	}
	/**
	 * @return the sessionMsgError
	 */
	public static String getSessionMsgError() {
		return SESSION_MSG_ERROR;
	}


	/**
	 * @return the databaseConfDir
	 */
	public static String getDatabaseConfDir() {
		return DATABASE_CONF_DIR;
	}

	/**
	 * @return the emailConfDir
	 */
	public static String getEmailConfDir() {
		return EMAIL_CONF_DIR;
	}

	/**
	 * @return the mODULES_IMAGES_DIR
	 */
	public static String getMODULES_IMAGES_DIR() {
		return MODULES_IMAGES_DIR;
	}

	/**
	 * @param mODULES_IMAGES_DIR
	 *            the mODULES_IMAGES_DIR to set
	 */
	public static void setMODULES_IMAGES_DIR(String mODULES_IMAGES_DIR) {
		MODULES_IMAGES_DIR = mODULES_IMAGES_DIR;
	}

	/**
	 * @return the uSER_PROFILE_IMAGES_DIR
	 */
	public static String getUSER_PROFILE_IMAGES_DIR() {
		return USER_PROFILE_IMAGES_DIR;
	}

	/**
	 * @param uSER_PROFILE_IMAGES_DIR
	 *            the uSER_PROFILE_IMAGES_DIR to set
	 */
	public static void setUSER_PROFILE_IMAGES_DIR(String uSER_PROFILE_IMAGES_DIR) {
		USER_PROFILE_IMAGES_DIR = uSER_PROFILE_IMAGES_DIR;
	}

	/**
	 * @return the uSER_PROFILE_NONE_IMAGE_DIR
	 */
	public static String getUSER_PROFILE_NONE_IMAGE_DIR() {
		return USER_PROFILE_NONE_IMAGE_DIR;
	}

	/**
	 * @param uSER_PROFILE_NONE_IMAGE_DIR
	 *            the uSER_PROFILE_NONE_IMAGE_DIR to set
	 */
	public static void setUSER_PROFILE_NONE_IMAGE_DIR(String uSER_PROFILE_NONE_IMAGE_DIR) {
		USER_PROFILE_NONE_IMAGE_DIR = uSER_PROFILE_NONE_IMAGE_DIR;
	}

	public static String getAppImgUserDir() {
		return APP_IMG_USER_DIR;
	}

	public static void setAppImgUserDir(String aPP_IMG_USER_DIR) {
		APP_IMG_USER_DIR = aPP_IMG_USER_DIR;
	}

	/**
	 * @return the mAX_REQUEST_SIZE_BYTES
	 */
	public static Integer getMAX_USER_PROFILE_IMAGE_SIZE_BYTES() {
		return MAX_USER_PROFILE_IMAGE_SIZE_BYTES;
	}

	/**
	 * @param mAX_USER_PROFILE_IMAGE_SIZE_BYTES the mAX_REQUEST_SIZE_BYTES to set
	 */
	public static void setMAX_USER_PROFILE_IMAGE_SIZE_BYTES(Integer mAX_USER_PROFILE_IMAGE_SIZE_BYTES) {
		MAX_USER_PROFILE_IMAGE_SIZE_BYTES = mAX_USER_PROFILE_IMAGE_SIZE_BYTES;
	}
	/**
	 * @return the gUARDIAO_VERSION
	 */
	public static String getGUARDIAO_VERSION() {
		return GUARDIAO_VERSION;
	}
	/**
	 * @param gUARDIAO_VERSION the gUARDIAO_VERSION to set
	 */
	public static void setGUARDIAO_VERSION(String gUARDIAO_VERSION) {
		GUARDIAO_VERSION = gUARDIAO_VERSION;
	}
	
}
