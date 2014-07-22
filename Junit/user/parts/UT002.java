package user.parts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import user.bean.RegistrantInfo;
import user.parts.RegInfDAO;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UT002 {
	RegInfDAO regDAO;
	RegistrantInfo regI = new RegistrantInfo();
	ArrayList<RegistrantInfo> list;

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	String str;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {


	    System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
	    System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");


	    InitialContext ic = new InitialContext();
	    ic.createSubcontext("java:");
	    ic.createSubcontext("java:comp");
	    ic.createSubcontext("java:comp/env");
	    ic.createSubcontext("java:comp/env/jdbc");

	    MysqlDataSource ds = new MysqlDataSource();
	    ds.setUser("root");
	    ds.setPassword("root");
//	    ds.setPassword("sigeyosi123");
	    ds.setURL("jdbc:mysql://localhost/Task");

	    ic.bind("java:comp/env/jdbc/Task", ds);

	}

	@After
	public void tearDown(){
	    regDAO.close();
	}


	public void Initial_ins(){
    	regDAO.insert("001", "��ؑ��Y", "35");
    	regDAO.insert("002", "tommy", "28");
    	regDAO.insert("003", "�R�c�Ԏq", "30");
	}

	public void Initial_del(){
		regDAO.delete("001");
    	regDAO.delete("002");
    	regDAO.delete("003");
    	regDAO.delete("004");
	}


    @Test
    public void UT002_001() {
    	System.out.println("\n��UT002_001:\n");
        regDAO = new RegInfDAO();
    	//. S.DB������
        Initial_del();
        Initial_ins();
    	//. E.DB������

        String Comparison[] = {"001 ��ؑ��Y 35","002 tommy 28","003 �R�c�Ԏq 30","004 �����H���� 28"};

    	// �ۑ�P:�ǉ�����
        regDAO.insert("004", "�����H����", "28");

        list = regDAO.getReglist();
        for(int i = 0; i < list.size(); i++){
            RegistrantInfo mem = list.get(i);
            str = mem.getrId();
            str = str +" "+ mem.getrName();
            str = str +" "+ mem.getrAge();
            assertThat(Comparison[i],is(str));
            System.out.println(str);
//            System.out.println(Comparison[i]);
        }


    }

    @Test
    public void UT002_002() {
        System.out.println("\n��UT002_002:\n");
        regDAO = new RegInfDAO();

    	//. S.DB������
        Initial_del();
        Initial_ins();
    	//. E.DB������

        String Comparison[] = {"001 ��ؑ��Y 35","002 Micheal 29","003 �R�c�Ԏq 30"};

    	// �ۑ�Q:�ҏW����
        regDAO.update("002", "Micheal", "29");

        list = regDAO.getReglist();
        for(int i = 0; i < list.size(); i++){
            RegistrantInfo mem = list.get(i);
            str = mem.getrId();
            str = str +" "+ mem.getrName();
            str = str +" "+ mem.getrAge();
            assertThat(Comparison[i],is(str));
            System.out.println(str);
//            System.out.println(Comparison[i]);
        }

    }

    @Test
    public void UT002_003() {
        System.out.println("\n��UT002_003:\n");
        regDAO = new RegInfDAO();

    	//. S.DB������
        Initial_del();
        Initial_ins();
   	//. E.DB������

        String Comparison[] = {"002 tommy 28","003 �R�c�Ԏq 30"};

    	// �ۑ�R:�폜����
        regDAO.delete("001");

        list = regDAO.getReglist();
        for(int i = 0; i < list.size(); i++){
            RegistrantInfo mem = list.get(i);
            str = mem.getrId();
            str = str +" "+ mem.getrName();
            str = str +" "+ mem.getrAge();
            assertThat(Comparison[i],is(str));
            System.out.println(str);
 //           System.out.println(Comparison[i]);
        }

    }

    @Test
    public void UT002_004() {
        System.out.println("\n��UT002_004:\n");
        regDAO = new RegInfDAO();
    	//. S.DB������
        Initial_del();
        Initial_ins();
    	//. E.DB������

        String Comparison[] = {"001 ��ؑ��Y 35","002 tommy 28","003 �R�c�Ԏq 30"};

        list = regDAO.getReglist();
        for(int i = 0; i < list.size(); i++){
            RegistrantInfo mem = list.get(i);
            str = mem.getrId();
            str = str +" "+ mem.getrName();
            str = str +" "+ mem.getrAge();
            assertThat(Comparison[i],is(str));
            System.out.println(str);
//            System.out.println(Comparison[i]);
        }

    }

    @Test
    public void UT002_005() {
        System.out.println("\n��UT002_005:\n");
        regDAO = new RegInfDAO();

        //. S.DB������
        Initial_del();
        //. E.DB������

        System.out.println(regDAO.getNextId()+"\n");
    }


}
