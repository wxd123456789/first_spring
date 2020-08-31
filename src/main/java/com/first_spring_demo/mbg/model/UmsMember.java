package com.first_spring_demo.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class UmsMember implements Serializable {
    private Long id;

    private Long memberLevelId;

    @ApiModelProperty(value = "ç”¨æˆ·å")
    private String username;

    @ApiModelProperty(value = "å¯†ç ")
    private String password;

    @ApiModelProperty(value = "æ˜µç§°")
    private String nickname;

    @ApiModelProperty(value = "æ‰‹æœºå·ç ")
    private String phone;

    @ApiModelProperty(value = "å¸å·å¯ç”¨çŠ¶æ€:0->ç¦ç”¨ï¼›1->å¯ç”¨")
    private Integer status;

    @ApiModelProperty(value = "æ³¨å†Œæ—¶é—´")
    private Date createTime;

    @ApiModelProperty(value = "å¤´åƒ")
    private String icon;

    @ApiModelProperty(value = "æ€§åˆ«ï¼š0->æœªçŸ¥ï¼›1->ç”·ï¼›2->å¥³")
    private Integer gender;

    @ApiModelProperty(value = "ç”Ÿæ—¥")
    private Date birthday;

    @ApiModelProperty(value = "æ‰€åšåŸŽå¸‚")
    private String city;

    @ApiModelProperty(value = "èŒä¸š")
    private String job;

    @ApiModelProperty(value = "ä¸ªæ€§ç­¾å")
    private String personalizedSignature;

    @ApiModelProperty(value = "ç”¨æˆ·æ¥æº")
    private Integer sourceType;

    @ApiModelProperty(value = "ç§¯åˆ†")
    private Integer integration;

    @ApiModelProperty(value = "æˆé•¿å€¼")
    private Integer growth;

    @ApiModelProperty(value = "å‰©ä½™æŠ½å¥–æ¬¡æ•°")
    private Integer luckeyCount;

    @ApiModelProperty(value = "åŽ†å²ç§¯åˆ†æ•°é‡")
    private Integer historyIntegration;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(Long memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPersonalizedSignature() {
        return personalizedSignature;
    }

    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Integer getLuckeyCount() {
        return luckeyCount;
    }

    public void setLuckeyCount(Integer luckeyCount) {
        this.luckeyCount = luckeyCount;
    }

    public Integer getHistoryIntegration() {
        return historyIntegration;
    }

    public void setHistoryIntegration(Integer historyIntegration) {
        this.historyIntegration = historyIntegration;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberLevelId=").append(memberLevelId);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickname=").append(nickname);
        sb.append(", phone=").append(phone);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", icon=").append(icon);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", city=").append(city);
        sb.append(", job=").append(job);
        sb.append(", personalizedSignature=").append(personalizedSignature);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", integration=").append(integration);
        sb.append(", growth=").append(growth);
        sb.append(", luckeyCount=").append(luckeyCount);
        sb.append(", historyIntegration=").append(historyIntegration);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}