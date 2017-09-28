import com.harium.dotenv.Env;

public class Teste {

	public static void main(String[] args) {
		System.out.println(Env.get("DATABASE_CONF_DIR"));

	}

}
