package util;

import com.harium.dotenv.Env;

public class Constantes {

	public final static String APP_URL;
	public final static String ADM_URL;
	public final static String APP_ASSETS_URL;
	public final static String APP_JS_URL;
	public final static String APP_IMG_URL;
	public final static String APP_CSS_URL;
	public final static String APP_IMG_USER_DIR;
	public final static Integer NUMBER_OF_ROWS_PER_PAGE;	
	public final static String SESSION_MSG;
	private Constantes() {
		//
	}

	static {
		APP_URL = Env.get("APP_URL");		
		ADM_URL = APP_URL + "/view/adm";
		APP_ASSETS_URL = APP_URL + "/assets2";
		APP_JS_URL = APP_ASSETS_URL + "/js";
		APP_IMG_URL = APP_ASSETS_URL + "/img";
		APP_IMG_USER_DIR = APP_URL + "/img";
		APP_CSS_URL = APP_ASSETS_URL + "/css";
		NUMBER_OF_ROWS_PER_PAGE = 20;
		SESSION_MSG = "msg";
	}

}
