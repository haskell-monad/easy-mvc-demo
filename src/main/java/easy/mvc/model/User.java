package easy.mvc.model;

import easy.framework.orm.annotation.Entity;
import easy.framework.orm.annotation.Field;
import easy.framework.orm.annotation.FieldIgnore;
import easy.framework.orm.annotation.Table;

import java.io.Serializable;
import java.util.Date;

/**
 * @author limengyu
 * @date 2017/9/15
 */
@Entity
@Table(name = "system_user")
public class User implements Serializable {
	@Field(name = "USER_NAME")
	private String userName;
	private String userPhone;
	private Integer userStatus;
	private String department;
	private Date createDate;
	private Date updateDate;
	@FieldIgnore
	private Integer ignoreField;

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
