package com.example.lab4.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.*;  // ✅ đúng


public class Staff {

    @NotBlank(message = "Chưa nhập email")
    @Email(message = "Email không đúng định dạng")
    private String id;

    @NotBlank(message = "Chưa nhập họ và tên")
    private String fullname;

    private String photo = "photo.jpg";

    @NotNull(message = "Chưa chọn giới tính")
    private Boolean gender;

    @NotNull(message = "Chưa nhập ngày sinh")
    @Past(message = "Ngày sinh phải ở quá khứ")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthday;

    @NotNull(message = "Chưa nhập lương")
    @DecimalMin(value = "1000.0", message = "Lương tối thiểu phải là 1000")
    private Double salary;

    private Integer level = 0;

    public Staff() {}

    // Getter & Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public Boolean getGender() { return gender; }
    public void setGender(Boolean gender) { this.gender = gender; }

    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public Integer getLevel() { return level; }
    public void setLevel(Integer level) { this.level = level; }
}
