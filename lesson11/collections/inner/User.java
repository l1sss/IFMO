package lesson11.collections.inner;

import java.util.Comparator;

/**
 * Created by xmitya on 20.10.16.
 */
public class User implements Comparable<User> {
    private String name;
    private int age;
    private int salary;
    private String company;

    public User() {
    }

    public User(String name, int age, int salary, String company) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (salary != user.salary) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return company != null ? company.equals(user.company) : user.company == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + salary;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(User o) {
        return getName().compareTo(o.getName());
    }

    public static Comparator<User> companyAndNameComparator = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            if (o1.getCompany().compareTo(o2.getCompany()) == 0)
                return o1.getName().compareTo(o2.getName());
            else
                return o1.getCompany().compareTo(o2.getCompany());
        }
    };

    public static Comparator<User> salaryAndNameComparator = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            if (Integer.compare(o1.getSalary(), o2.getSalary()) == 0)
                return o1.getName().compareTo(o2.getName());
            else
                return Integer.compare(o1.getSalary(), o2.getSalary());
        }
    };

    public static Comparator<User> salaryAgeCompanyAndNameComparator = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            int result = o1.getSalary() - o2.getSalary();
            if (result == 0) {
                result = Integer.compare(o1.age, o2.age);
                if (result == 0) {
                    result = o1.getCompany().compareTo(o2.getCompany());
                    if (result == 0) {
                        result = o1.getName().compareTo(o2.getName());
                    }
                }
            }
            return result;
        }
    };
}
