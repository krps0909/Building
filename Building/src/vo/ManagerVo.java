package vo;  //�������� ������ ���޿� ���Ǵ� ������ ��ü���� ���Ѵ� DTO�� VO�� �������������� VO�� read only

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

	public void setManagerid(String mi) { // ������ ID �°�
		this.managerid = mi;
	}

	public String getManagerid() {
		return managerid;
	}

	public void setPassword(String password) { // ��й�ȣ �°�
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) { // ������ �̸� �°�
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setBirthdate(String bd) { // ������� �°�
		this.birthdate = bd;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBuildingname(String bn) { // �ǹ��̸� �°�
		this.buildingname = bn;
	}

	public String getBuildingname() {
		return buildingname;
	}

}
