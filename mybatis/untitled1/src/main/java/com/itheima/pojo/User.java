package com.itheima.pojo;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String gender;
    private String addr;


    /**
     * ��ȡ
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * ����
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * ��ȡ
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * ����
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * ��ȡ
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * ����
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ��ȡ
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * ����
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * ��ȡ
     * @return addr
     */
    public String getAddr() {
        return addr;
    }

    /**
     * ����
     * @param addr
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String toString() {
        return "User{id = " + id + ", username = " + username + ", password = " + password + ", gender = " + gender + ", addr = " + addr + "}";
    }
}
