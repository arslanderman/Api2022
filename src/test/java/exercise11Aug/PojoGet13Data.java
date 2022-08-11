package exercise11Aug;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PojoGet13Data {
/*
  {
    "meta": null,
    "data": {
        "id": 13,
        "name": "Deb Namboothiri DC",
        "email": "dc_deb_namboothiri@barrows.info",
        "gender": "female",
        "status": "inactive"
    }

 */
    private Integer id;
    private String name;
    private String email;
    private String gender;
    private String status;

    public PojoGet13Data(Integer id, String name, String email, String gender, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

    public PojoGet13Data() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PojoGet13Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
