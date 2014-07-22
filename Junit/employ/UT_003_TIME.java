package employ;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UT_003_TIME {
	public static String getDate(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(date);
	}

	Date newDate(){
		return new Date();
	}
}
