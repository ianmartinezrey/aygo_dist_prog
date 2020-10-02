package aygo;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class LogService {
	
	MongoClient client = new MongoClient(new ServerAddress("dbmongo", 27017)); //connect to mongodb
	Datastore datastore = new Morphia().createDatastore(client, "logsbd"); //select shop collection
	
	public List<Log> addProduct(Log log){
		datastore.save(log);
		
		return this.getAllLog();
		//return "log added";
	}
	
	public List<Log> getAllLog(){

		List<Log> list = datastore.find(Log.class).limit(50).asList();
		//List<Log> list = datastore.find(Log.class).limit(50).sort({_id:1}).asList();
		
		//datastore.find(Log.class).limit(50);
				
		if(list != null){
			return list;
		}
		return null;
	}

}
