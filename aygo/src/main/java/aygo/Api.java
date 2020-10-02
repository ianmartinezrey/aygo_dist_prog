package aygo;

import static spark.Spark.get;
import static spark.Spark.post;
import com.google.gson.Gson;

public class Api {
	
public static LogService logService = new LogService();
	
	public static void main(String[] args){
		
		Gson gson = new Gson();
		post("/add", (req, res) -> {
				res.type("application/json");
				Log log = gson.fromJson(req.body(), Log.class);
				return logService.addProduct(log);
		}, gson ::toJson);

		get("/", (req, res) -> {
			res.type("application/json");
			return logService.getAllLog();
		}, gson ::toJson);
	}
	

}
