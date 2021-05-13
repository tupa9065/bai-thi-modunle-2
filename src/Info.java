import java.io.Serializable;
import java.util.*;
public class Info  {
    String phoneNumber;
    String groupInfo;
    String name;
    String gender;
    String address;
    String dob;
    String email;

    public Info() {
    }

    public Info(String phoneNumber, String groupInfo, String name, String gender, String address, String dob, String email) {
        this.phoneNumber = phoneNumber;
        this.groupInfo = groupInfo;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        if(phoneNumber.matches("^[0]\\d{8,9}$")){
            this.phoneNumber = phoneNumber;
            return true;
        }
        System.err.println("Input data is incorrect ");
        return false;
    }

    public String getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(String groupInfo) {
        this.groupInfo = groupInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if(email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")){
            this.email = email;
            return true;
        }
        System.err.println("Input data is incorrect ");
        return false;
    }

    @Override
    public String toString() {
        return "Info{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", groupInfo='" + groupInfo + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public void inputInfo(){
        Scanner scanner = new Scanner(System.in);
        String phoneInput;
        do{
            System.out.println("Input phone number (0123456789 or 01234567890)");
            phoneInput = scanner.nextLine();
        }while (!setPhoneNumber(phoneInput));


        System.out.println("Input group");
        groupInfo = scanner.nextLine();

        System.out.println("Input name");
        name = scanner.nextLine();

        System.out.println("Input gender");
        gender = scanner.nextLine();

        System.out.println("Input dob");
        dob = scanner.nextLine();

        String emailInput;
        do{
            System.out.println("Input email (abc@xyz.com)");
            emailInput = scanner.nextLine();
        }while (!setEmail(emailInput));

    }
    public void editInfo(){
        Scanner scanner = new Scanner(System.in);


        System.out.println("Input group");
        groupInfo = scanner.nextLine();

        System.out.println("Input name");
        name = scanner.nextLine();

        System.out.println("Input gender");
        gender = scanner.nextLine();

        System.out.println("Input dob");
        dob = scanner.nextLine();

        String emailInput;
        do{
            System.out.println("Input email (abc@xyz.com)");
            emailInput = scanner.nextLine();
        }while (!setEmail(emailInput));

    }
}
