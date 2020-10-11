package com.hfocean.platform.core.po;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table ( name ="sys_user" )
public class SysUserPo{

	/* 用户ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	/* 状态，1正常，0无效 */
	private String status;

	/* 用户名称 */
	private String userName;

	/* 登录名 */
	private String loginName;

	/* 手机号 */
	private String phone;

	/* 邮箱 */
	private String email;

	/* 密码 */
	private String password;

	/* 头像 */
	private String userImage;

	/* 创建时间 */
	private Date createDate;

	/* 操作时间 */
	private Date operDate;

	public Long getUserId() { return this.userId; }

	public void setUserId(Long userId) { this.userId = userId; }

	public String getStatus() { return this.status; }

	public void setStatus(String status) { this.status = status; }

	public String getUserName() { return this.userName; }

	public void setUserName(String userName) { this.userName = userName; }

	public String getLoginName() { return this.loginName; }

	public void setLoginName(String loginName) { this.loginName = loginName; }

	public String getPhone() { return this.phone; }

	public void setPhone(String phone) { this.phone = phone; }

	public String getEmail() { return this.email; }

	public void setEmail(String email) { this.email = email; }

	public String getPassword() { return this.password; }

	public void setPassword(String password) { this.password = password; }

	public String getUserImage() { return this.userImage; }

	public void setUserImage(String userImage) { this.userImage = userImage; }

	public Date getCreateDate() { return this.createDate; }

	public void setCreateDate(Date createDate) { this.createDate = createDate; }

	public Date getOperDate() { return this.operDate; }

	public void setOperDate(Date operDate) { this.operDate = operDate; }

}
