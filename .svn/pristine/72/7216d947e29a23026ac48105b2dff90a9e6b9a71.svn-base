package com.ruijie.spl.billingEngine.billing.entity_NoForeignKey;

import com.ruijie.spl.billingEngine.billing.dataEnum.SexEnum;
import com.ruijie.spl.billingEngine.billing.dataEnum.UserStateEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Administrator on 2017/9/12.
 */
@Entity
@Table(name = "Person_NoFK_Table")
public class PersonEntity {
    private UUID person_uuid;
    private String password;
    private Integer personId;
    private String firstName;
    private String lastName;
    private int age;
    private LocalDateTime nextBillingTime;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
    private UserStateEnum userState;
    private SexEnum userSex;

    private UUID personAccountRelationUuid;
    private UUID personTariffRelationUuid;

    /*用户的唯一标识，用户表的主键，自动生成*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_UUID")
    public UUID getPerson_uuid() {
        return person_uuid;
    }

    public void setPerson_uuid(UUID person_uuid) {
        this.person_uuid = person_uuid;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "createTime")
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Column(name = "lastUpdateTime")
    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /*用户的状态，枚举量：正常、暂停*/
    @Column(name = "user_State")
    public UserStateEnum getUserState() {
        return userState;
    }

    public void setUserState(UserStateEnum userState) {
        this.userState = userState;
    }

    /*用户的性别，枚举量：男、女*/
    @Column(name = "user_Sex")
    public SexEnum getUserSex() {
        return userSex;
    }

    public void setUserSex(SexEnum userSex) {
        this.userSex = userSex;
    }

    @Column(name = "person_Id")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Column(name = "first_Name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "nextBilling_Time")
    public LocalDateTime getNextBillingTime() {
        return nextBillingTime;
    }

    public void setNextBillingTime(LocalDateTime nextBillingTime) {
        this.nextBillingTime = nextBillingTime;
    }

    @Column(name = "person_tariff_relation_uuid", unique = true)
    public UUID getPersonTariffRelationUuid() {
        return personTariffRelationUuid;
    }

    public void setPersonTariffRelationUuid(UUID personTariffRelationUuid) {
        this.personTariffRelationUuid = personTariffRelationUuid;
    }

    @Column(name = "person_account_relation_uuid", unique = true)
    public UUID getPersonAccountRelationUuid() {
        return personAccountRelationUuid;
    }

    public void setPersonAccountRelationUuid(UUID personAccountRelationUuid) {
        this.personAccountRelationUuid = personAccountRelationUuid;
    }
}
