package vo;  //계층간의 데이터 전달에 사용되는 데이터 객체들을 말한다 DTO와 VO는 같은개념이지만 VO는 read only

public class ManagerVo {
	private int classnum;
	private String managerid;
	private String password;
	private String name;
	private String birthdate;
	private String buildingname;

	public int getClassnum() {
		return classnum;
	}

	public void setClassnum(int classnum) {
		this.classnum = classnum;
	}

	public void setManagerid(String mi) { // 관리인 ID 셋겟
		this.managerid = mi;
	}

	public String getManagerid() {
		return managerid;
	}

	public void setPassword(String password) { // 비밀번호 셋겟
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) { // 관리인 이름 셋겟
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setBirthdate(String bd) { // 생년월일 셋겟
		this.birthdate = bd;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBuildingname(String bn) { // 건물이름 셋겟
		this.buildingname = bn;
	}

	public String getBuildingname() {
		return buildingname;
	}

}
