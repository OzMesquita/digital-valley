package util;

public class Constantes {

	public final static String APP_URL;
	public final static String ADM_URL;
	public final static String APP_ASSETS_URL;
	public final static String APP_JS_URL;
	public final static String APP_IMG_URL;
	public final static String APP_CSS_URL;

	private Constantes() {
		//
	}

	static {
		APP_URL = "/Controle_de_Acesso";
		ADM_URL = APP_URL + "/view/adm";
		APP_ASSETS_URL = APP_URL + "/assets2";
		APP_JS_URL = APP_ASSETS_URL + "/js";
		APP_IMG_URL = APP_ASSETS_URL + "/img";
		APP_CSS_URL = APP_ASSETS_URL + "/css";
	}

}
