package employ;

import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import user.parts.RegInfCheck;
import static org.hamcrest.CoreMatchers.*;
import employ.DateString;

public class UT003 {

	private String str1 ="sample:�T���v��,";
	private int num =12345;
	String file = "C:/test/log/log.txt";
	FileReader fr = null;
	FileWriter fw = null;
	BufferedReader br = null;

	String time = null;
	static String bak = null;

//. S.import����̏o�͗p
//	String test = null;
//. E.import����̏o�͗p

	UT_003_TIME date = new UT_003_TIME();

//. S.import����̏o�͗p
//	DateString day = new DateString();
//. E.import����̏o�͗p

	@Test
	public void UT003_001() {
		OutLog.outLogDmp(str1);
		try{
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			time = date.getDate()+":";
//. S.import����̏o�͗p
//			test = day.getDate14()+":";
//. E.import����̏o�͗p
			String str = br.readLine();
			System.out.println("��UT003_001");
			System.out.println(str);
			System.out.println(time + str1+"\n");
//. S.import����̏o�͗p
//			System.out.println(test+"\n");
//. E.import����̏o�͗p
			assertThat(time + str1,is(str));
			bak = time + str1;
			fw = new FileWriter(file);

		}catch(IOException ioe){
			System.out.println("�ǂݍ��݃G���[");
		}

	}

	@Test
	public void UT003_002() {
		OutLog.outLogDmp(num);
		try{
			fr = new FileReader(file);
			br = new BufferedReader(fr);


			time = date.getDate()+":";
			String str = br.readLine();
			System.out.println("��UT003_002");
//			System.out.println(bak+time+num);
			System.out.println(time+num);
			System.out.println(str);
//			assertThat(bak + time + num,is(str));

			assertThat(time + num,is(str));

			fw = new FileWriter(file);

		}catch(IOException ioe){
			System.out.println("�ǂݍ��݃G���[");
		}

	}


}
