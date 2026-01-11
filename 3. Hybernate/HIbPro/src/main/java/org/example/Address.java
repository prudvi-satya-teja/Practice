package org.example;


import jakarta.persistence.*;


@Entity
@Cacheable(value=true)
public class Address {

    @Id
    int addressId;
    String village;
    String city;
    String state;


//    @ManyToMany(mappedBy = "addresses")
//    List<Student> students = new ArrayList<>();
//
//    @ManyToOne
//    Student student;
//    List<Student> students =  new ArrayList();

    Address() {}

    Address(String village, String city, String state, int addressId) {
        this.village = village;
        this.city = city;
        this.state = state;
        this.addressId = addressId;
    }


    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", village='" + village + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +

                '}';
    }


}
