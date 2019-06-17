package iist.training.hrm.dto.request;

public class ChangeAccountRoleDto {
	private int accountId;
	private int[] roleId;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int[] getRoleId() {
		return roleId;
	}
	public void setRoleId(int[] roleId) {
		this.roleId = roleId;
	}
	
}
