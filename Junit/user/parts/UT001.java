package user.parts;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class UT001 {

	@Test
	public void UT001_001() {
		System.out.print("◆UT001-001:");
		RegInfCheck rc = new RegInfCheck();
		rc.checkName("0123456789");
		assertThat("",is(rc.getErrMsg()));
		System.out.println("\t"+rc.getErrMsg());
	}

	@Test
	public void UT001_002() {
		System.out.print("◆UT001-002:");
		RegInfCheck rc = new RegInfCheck();
		rc.checkName("あいうえおかきくけこ");
		assertThat("",is(rc.getErrMsg()));
		System.out.println("\t"+rc.getErrMsg());
	}

	@Test
	public void UT001_003() {
		System.out.print("◆UT001-003:");
		RegInfCheck rc = new RegInfCheck();
		rc.checkName("01234567890");
		assertThat("名前は10桁以内で入力してください。<br />",is(rc.getErrMsg()));
		System.out.println("\t"+rc.getErrMsg());
	}

	@Test
	public void UT001_004() {
		System.out.print("◆UT001-004:");
		RegInfCheck rc = new RegInfCheck();
		rc.checkName("あいうえおかきくけこさ");
		assertThat("名前は10桁以内で入力してください。<br />",is(rc.getErrMsg()));
		System.out.println("\t"+rc.getErrMsg());
	}

	@Test
	public void UT001_005() {
		System.out.print("◆UT001-005:");
		RegInfCheck rc = new RegInfCheck();
		rc.checkAge("16");
		assertThat("",is(rc.getErrMsg()));
		System.out.println("\t"+rc.getErrMsg());
	}

	@Test
	public void UT001_006() {
		System.out.print("◆UT001-006:");
		RegInfCheck rc = new RegInfCheck();
		rc.checkAge("60");
		assertThat("",is(rc.getErrMsg()));
		System.out.println("\t"+rc.getErrMsg());
	}

	@Test
	public void UT001_007() {
		System.out.print("◆UT001-007:");
		RegInfCheck rc = new RegInfCheck();
		rc.checkAge("15");
		assertThat("年齢は(16-60)の範囲で入力してください。<br />",is(rc.getErrMsg()));
		System.out.println("\t"+rc.getErrMsg());
	}

	@Test
	public void UT001_008() {
		System.out.print("◆UT001-008:");
		RegInfCheck rc = new RegInfCheck();
		rc.checkAge("61");
		assertThat("年齢は(16-60)の範囲で入力してください。<br />",is(rc.getErrMsg()));
		System.out.println("\t"+rc.getErrMsg());
	}

	@Test
	public void UT001_009() {
		System.out.print("◆UT001-009:");
		RegInfCheck rc = new RegInfCheck();
		rc.checkAge("１６");
		assertThat("年齢は数値(半角)で入力してください。<br />",is(rc.getErrMsg()));
		System.out.println("\t"+rc.getErrMsg());
	}

	@Test
	public void UT001_010() {
		System.out.print("◆UT001-010:");
		RegInfCheck rc = new RegInfCheck();
		rc.checkAge("あいうえお");
		assertThat("年齢は数値(半角)で入力してください。<br />年齢は(16-60)の範囲で入力してください。<br />",is(rc.getErrMsg()));
		System.out.println("\t"+rc.getErrMsg());
	}

	@Test
	public void UT001_011() {
		System.out.print("◆UT001-011:");
		RegInfCheck rc = new RegInfCheck();
		rc.checkAge("16あいうえお");
		assertThat("年齢は数値(半角)で入力してください。<br />年齢は(16-60)の範囲で入力してください。<br />",is(rc.getErrMsg()));
		System.out.println("\t"+rc.getErrMsg());
	}

	@Test
	public void UT001_012() {
		System.out.print("◆UT001-012:");
		RegInfCheck rc = new RegInfCheck();
		rc.checkId("999");
		assertThat("",is(rc.getErrMsg()));
		System.out.println("\t"+rc.getErrMsg());
	}

	@Test
	public void UT001_013() {
		System.out.print("◆UT001-013:");
		RegInfCheck rc = new RegInfCheck();
		rc.checkId("1000");
		assertThat("登録可能なID（999）を超えています。管理者に問い合わせてください。<br />",is(rc.getErrMsg()));
		System.out.println("\t"+rc.getErrMsg());
	}
}
