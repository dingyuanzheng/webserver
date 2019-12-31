package gitlog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LogData implements Serializable {

	public static final Map<String , ArrayList<LogBean>> logs = new HashMap<String , ArrayList<LogBean>>();
	
}
